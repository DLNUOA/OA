package edu.dlnu.oa.personCenter.controller;

import edu.dlnu.oa.personCenter.dto.SaveUpdateDto;
import edu.dlnu.oa.personCenter.service.PersonCenterService;
import edu.dlnu.oa.utils.MailUtils;
import edu.dlnu.oa.utils.RedisUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author wuhan
 * @date 2019/12/23 22:35
 */
@RestController
@RequestMapping("/api/personCenter")
public class PersonCenterController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonCenterService personCenterService;
    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping(value = "/personInfo/{id}",method = GET)
    public Map<String,Object> getPersonInfo(@PathVariable int id){
        log.info("getPersonInfo被访问了");
        return personCenterService.getPersonInfoById(id);
    }


    @RequestMapping(value = "/personInfo",method = GET)
    public Map<String,Object> getPersonInfoDefault(HttpServletRequest request, HttpServletResponse response){
        log.info("getPersonInfoDefault被访问了");

        /**
         * 下面这一行代码是错误示范，别写可读性这么差的，然后粒度那么大
         * return personCenterService.getPersonInfoById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("empId"))));
         */
//        我要开始写正确的代码了！@！这里涉及登陆权限，只只有登陆的用户才能访问这个api，上面写的没毛病，但是我们还是要进行出错处理
        Object empId =  request.getSession().getAttribute("empId");
        if (empId==null){
            Map<String,Object> errorMsg= new HashMap<>();
            errorMsg.put("errorMsg","未登录");
            return errorMsg;
        }else {
            return personCenterService.getPersonInfoById(Integer.parseInt(String.valueOf(request.getSession().getAttribute("empId"))));

        }

    }

    @PutMapping("/updateMyInfo")
    public int updateMyInfo(HttpServletRequest request, @RequestBody SaveUpdateDto saveUpdateDto){
        //像下面这样写一定要保证用户已经登陆了！！！！！！！！！！请权限管理同学做好准备
        int empId =  Integer.parseInt( request.getSession().getAttribute("empId").toString());
        saveUpdateDto.setEmpId(empId);
        return personCenterService.updatePersonInfo(saveUpdateDto);
    }

    @PostMapping("/sendValidEmail")
    public int sendValidEmail(HttpServletRequest request){
        int empId =  Integer.parseInt( request.getSession().getAttribute("empId").toString());
        Map<String, Object> personInfo = personCenterService.getPersonInfoById(empId);
        String email =  personInfo.get("email").toString();
        int code = personCenterService.sendValidEmail(email);
        request.getSession().setAttribute("code",code);
        return 1;
    }

    @PostMapping("/updatePwd")
    public int updatePwd(@RequestBody Map<String,Object> updatePwdInfo,HttpServletRequest request){
        int empId = Integer.parseInt(request.getSession().getAttribute("empId").toString());
        String oldPwd = updatePwdInfo.get("oldPwd").toString();
        String newPwd = updatePwdInfo.get("newPwd").toString();
        int code = -1;
        //就在后端验证以下用户输入的验证码是不是数字吧。。。。。。QAQ
        try {
             code = Integer.parseInt(updatePwdInfo.get("code").toString());
             //如果从前端接收到的验证码不是数字会报异常，没办法，没写前端，后端处理吧。。。。。

        }catch (NumberFormatException e){
//            直接给他return0吧
            return 0;
        }
        Object obj = request.getSession().getAttribute("code");
        if (obj!=null){
            int validCode = Integer.parseInt(obj.toString());
            if (validCode==code){
                String pwd = personCenterService.getPersonPwdById(empId);
                if (pwd.equals(oldPwd)){
                    return personCenterService.setNewPwd(empId,newPwd);
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @PostMapping("/upMyAvatar")
    public int upMyAvatar(@RequestBody Map<String,String> info,HttpServletRequest request){
        int empId =  Integer.parseInt( request.getSession().getAttribute("empId").toString());
        String avatar = info.get("avatar");
        return personCenterService.upMyAvatar(empId, avatar);
    }

    @GetMapping("/myAvatar")
    public String myAvatar(HttpServletRequest request) throws Exception{


        int  empId =  Integer.parseInt( request.getSession().getAttribute("empId").toString());


        return personCenterService.getMyAvatar(empId);
    }

    /**
     * 获取通讯录
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/getAB")
    public List<Map<String,Object>> getAB(HttpServletRequest request, HttpServletResponse response){
        return personCenterService.getAB();
    }

    /**
     *导出通讯录到excel
     * @author Wuhan
     * @date 2019/10/27
     * @param response 功能是将excel格数据以二进制流输出
     * @param request 得到session，获取教师id，这个导出成绩表的功能是只返回教师所教的学生的信息
     * @throws IOException
     */
    @GetMapping("/getABExcel")
    @ResponseBody
    public void export(HttpServletResponse response,HttpServletRequest request) throws IOException {

        List<Map<String, Object>> ab = personCenterService.getAB();

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("公司通讯录");
        HSSFCellStyle yellowStyle = wb.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle redStyle = wb.createCellStyle();
        redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFRow row = null;
        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short)(20*20));
        row.createCell(0).setCellValue("姓名 ");
        row.createCell(1).setCellValue("登陆名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("赞数");
        row.createCell(4).setCellValue("无语数");
        row.createCell(5).setCellValue("入职日期");
        row.createCell(6).setCellValue("职位");
        row.createCell(7).setCellValue("部门");
        row.createCell(8).setCellValue("电话");
        row.createCell(9).setCellValue("电子邮箱");



        //表格第一行设置完成，接下来就是取数据了
        for(int v=0;v<ab.size();v++) {
            row = sheet.createRow(v + 1);
            Map<String,Object> map = ab.get(v);
            HSSFCell cell = row.createCell(0);
            String s = (String) map.get("NAME");
            cell.setCellValue(s);
            HSSFCell cell1 = row.createCell(1);
            HSSFCell cell2 = row.createCell(2);
            HSSFCell cell3 = row.createCell(3);
            HSSFCell cell4 = row.createCell(4);
            HSSFCell cell5 = row.createCell(5);
            HSSFCell cell6 = row.createCell(6);
            HSSFCell cell7 = row.createCell(7);
            HSSFCell cell8 = row.createCell(8);
            HSSFCell cell9 = row.createCell(9);
            cell1.setCellValue( map.get("login_name").toString());
            cell2.setCellValue( map.get("gender").toString());
            cell3.setCellValue( map.get("like_count").toString());
            cell4.setCellValue( map.get("dislike_count").toString());
            cell5.setCellValue(map.get("hiredate").toString());
            cell6.setCellValue(map.get("job_name").toString());
            cell7.setCellValue(map.get("dept_name").toString());
            cell8.setCellValue(map.get("tel").toString());
            cell9.setCellValue(map.get("email").toString());



            sheet.setDefaultRowHeight((short) (16.5 * 20));
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=AddressBook.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }









    @PostMapping("/leaveRequest")
    public int LaunchALeaveRequest(HttpServletRequest request,@RequestBody Map<String,Object> leaveRequestInfo ){

        int requesterId = (int) request.getSession().getAttribute("empId");
        Map<String, Object> deptManagerInfo = personCenterService.getDeptManagerInfoByApplyRequesterId(requesterId);
        String deptManagerEmail = deptManagerInfo.get("emp_email").toString();
        leaveRequestInfo.put("deptManagerId",deptManagerInfo.get("emp_id"));
        leaveRequestInfo.put("requestStaffId",requesterId);
        String requesterName = request.getSession().getAttribute("empName").toString();
        String content = "您的员工"+requesterName+"发起了新的请假申请，快去查看吧！";
        MailUtils.sendMail(deptManagerEmail,content,"新的请假申请");

        redisUtils.add((Integer) deptManagerInfo.get("emp_id"));

        return personCenterService.launchALeaveRequest(leaveRequestInfo);
    }

    @GetMapping("/leaveRequest")
    public List<Map<String,Object>> getLeaveRequest(HttpServletRequest request){
        int requesterId = (int) request.getSession().getAttribute("empId");
        return personCenterService.getLeaveRequest(requesterId);
    }
    @DeleteMapping("/leaveRequest/{id}")
    public int deleteLeaveRequestById(@PathVariable("id") int id,HttpServletRequest request){
        return personCenterService.deleteLeaveRequestById(id);
    }

    @GetMapping("/deptManagerLeaveRequest")
    public List<Map<String,Object>> getDeptManagerLeaveRequest(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("empId");
        return personCenterService.getDeptManagerLeaveRequest(id);
    }


    @PutMapping("/like/{empId}")
    public int likeEmp(@PathVariable("empId") Integer empId,HttpServletRequest request){
        return personCenterService.likeEmp(empId);
    }

    @PutMapping("/dislike/{empId}")
    public int dislikeEmp(@PathVariable("empId") Integer empId,HttpServletRequest request){
        return personCenterService.dislikeEmp(empId);
    }

    @GetMapping("/evaluate")
    public List<Map<String,Object>> getEvaluate(HttpServletRequest request){
        return personCenterService.getEvaluate();
    }

    /**
     * 用户获取所有报销申请
     * @param request
     * @return
     */
    @GetMapping("/baoXiaoApplyLog")
    public List<Map<String,Object>> getBaoXiaoApplyLog(HttpServletRequest request){
        int empId = (int) request.getSession().getAttribute("empId");

        return personCenterService.getBaoXiaoApplyLogByEmpId(empId);
    }

    /**
     * 用户获取特定的报销申请
     * @param request
     * @param id
     * @return
     */
    @GetMapping("/baoXiaoApplyLogJiLu/{id}")
    public Map<String,Object> getBaoXiaoApplyLogJilu(HttpServletRequest request,@PathVariable("id") int id){
        return personCenterService.getBaoXiaoApplyLogJilu(id);
    }

    /**
     * 用户提交报销申请
     * @param request
     * @param info
     * @return
     */
    @PostMapping("/baoXiaoApply")
    public int postABaoXiaoApply(HttpServletRequest request,@RequestBody Map<String,Object> info){
        int empId = (int) request.getSession().getAttribute("empId");
        String purpose = info.get("purpose").toString();
        String amount = info.get("amount").toString();
        int deptMId =  personCenterService.findDeptMByEmpId(empId);
        int cashId = personCenterService.findCashIdByEmpId(empId);
        personCenterService.postABaoXiaoApply(empId, purpose, amount, deptMId, cashId);
        int claimId = personCenterService.getMaxClaimIdByEmpId(empId);
        personCenterService.postABaoXiaoApplyToLog(claimId);
        return 1;
    }

    /**
     * 部门经理获取所有的报销记录
     * @param request
     * @return
     */
    @GetMapping("/deptBaoXiaoApply")
    public List<Map<String,Object>> getDeptBaoXiaoApply(HttpServletRequest request){
        int empId = (int) request.getSession().getAttribute("empId");
        return personCenterService.getDeptBaoXiaoApply(empId);
    }

    /**
     *采纳获取所有的报销记录
     * @param request
     * @return
     */
    @GetMapping("/cashBaoXiaoApply")
    public List<Map<String,Object>> getCashBaoXiaoApply(HttpServletRequest request){
        int empId = (int) request.getSession().getAttribute("empId");
        return personCenterService.getCashBaoXiaoApply(empId);
    }

    /**
     * 部门经理更新用户报销申请
     * @param request
     * @param info
     * @return
     */
    @PutMapping("/DeptUpdateBaoXiaoLog")
    public int DeptUpdateBaoXiaoLog(HttpServletRequest request,@RequestBody Map<String,Object> info){

        int empId = (int) request.getSession().getAttribute("empId");

        int jobId = personCenterService.getJobIdByEmpId(empId);
        if (jobId==3){
            int i =  personCenterService.DeptUpdateBaoXiaoLog(info);
            personCenterService.setPass(info);
            personCenterService.DeptUpdateBaoXiaoLogToClaim(info);
            return i;
        }else if (jobId==11){
            int i =  personCenterService.CashUpdateBaoXiaoLog(info);
            personCenterService.CashUpdateBaoXiaoLogToClaim(info);
            return i;
        }else {

        }
        return 1;
    }

    /**
     * 出纳更新用户报销申请
     * @param request
     * @param info
     * @return
     */
    @PutMapping("/CashUpdateBaoXiaoLog")
    public int CashUpdateBaoXiaoLog(HttpServletRequest request,@RequestBody Map<String,Object> info){

        int i =  personCenterService.CashUpdateBaoXiaoLog(info);
        personCenterService.CashUpdateBaoXiaoLogToClaim(info);
        return i;
    }

    @PutMapping("/DeptUpdateBaoXiaoLogRefuse")
    public int DeptUpdateBaoXiaoLogRefuse(HttpServletRequest request,@RequestBody Map<String,Object> info){


        int empId = (int) request.getSession().getAttribute("empId");

        int jobId = personCenterService.getJobIdByEmpId(empId);
        if (jobId==3){
            int i =  personCenterService.DeptUpdateBaoXiaoLog(info);
            personCenterService.DeptUpdateBaoXiaoLogToClaim(info);
        }else {

        }
        return 1;

    }

    /**
     * -- 查看特定的报销申请日志记录
     */
    @GetMapping("/loglog/{id}")
    public Map<String,Object> loglog(HttpServletRequest request,@PathVariable("id") int id){
        return personCenterService.loglog(id);
    }


}
