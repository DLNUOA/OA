package edu.dlnu.oa.carCenter.controller;

import edu.dlnu.oa.carCenter.pojo.CarCenter;
import edu.dlnu.oa.carCenter.service.CarRentService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.hibernate.validator.internal.metadata.aggregated.rule.OverridingMethodMustNotAlterParameterConstraints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * 派车相关Controller
 */

@RestController
@RequestMapping("/api")
public class CarRentController {

    //设置日志
    private Logger log = LoggerFactory.getLogger(this.getClass());

    //注入
    @Autowired
    private CarRentService service;

    //查询派车记录
    @RequestMapping(value = "/car/queryCarRent", method = GET)
    public List<Map<String,Object>> query() { return service.queryCarRent(); }

    //查询派车代办列表
    @RequestMapping(value = "/car/queryRentList", method = GET)
    public List<Map<String,Object>> queryRentList() { return service.queryCarRentList(); }

    //查询可派车辆信息
    @RequestMapping(value = "/car/queryPlan", method = GET)
    public  List<Map<String,Object>> queryPlanCar() { return service.queryCarPlan(); }

    //改变车辆派车状态，改变可派车列表里的car_id
    @RequestMapping(value = "/car/updateState", method = PUT)
    public int updateState(@RequestBody Map<String,Integer> map) { return service.updateAndAddRent(map); }

    //根据ID查询车辆信息
    @RequestMapping(value = "/car/queryByPlanId/{carId}", method = GET)
    public CarCenter queryByPlanId(@PathVariable int carId) { return service.queryByPlanIdCar(carId); }

    //获取行政主管信息
    @RequestMapping(value = "/car/getJobList", method = GET)
    public Map<String,Object> getJobList() { return service.queryJobList("行政主管"); }

    //提交用车申请
    @RequestMapping(value = "/emp/carApply", method = POST)
    public int add(@RequestBody Map<String, Object> apply, HttpServletRequest request) {
        Integer applyId = (Integer) request.getSession().getAttribute("empId");
        Map<String, Object> map = service.queryJobList("行政主管");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       // new Date()为获取当前系统时间
        Map<String, Object> list = new HashMap<>();
        list.put("carRentLine", apply.get("carRentLine"));
        list.put("carRentInfo", apply.get("carRentInfo"));
        list.put("carApplyTime",  df.format(new Date()));
        list.put("carRentStime", apply.get("carRentStime"));
        list.put("carRentOtime", apply.get("carRentOtime"));
        list.put("carId",1);
        list.put("carRentState",0);
        list.put("empApplyId", applyId);
        list.put("empCheckmanId", map.get("emp_id"));
        return service.addApply(list);
    }

    //查询自己所有的车辆申请
    @RequestMapping(value = "/emp/querySelf", method = GET)
    public List<Map<String,Object>> querySelf(HttpServletRequest request) {
        Integer applyId = (Integer) request.getSession().getAttribute("empId");
        List<Map<String,Object>> list = service.querySelf(applyId);
        return list;
    }

    //查看自己的用车申请
    @RequestMapping(value = "/emp/queryMyRent", method = GET)
    public List<Map<String,Object>> queryMyRent(HttpServletRequest request) {
//        SimpleDateFormat timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String applyName= (String) request.getSession().getAttribute("empName");
        Integer applyId = (Integer) request.getSession().getAttribute("empId");
        List<Map<String,Object>> list = service.queryMyRentList(applyId);
        for(int i = 0; i < list.size(); i++){
            list.get(i).put("emp_apply_name",applyName);
            if((int)list.get(i).get("car_rent_state") == 0) {
                list.get(i).put("apply_state_name","派车中");
            } else if((int)list.get(i).get("car_rent_state") == 1){
                list.get(i).put("apply_state_name","行政部审批中");
            } else {
                list.get(i).put("apply_state_name","已派车");
            }
        }
        return list;
    }

    @GetMapping("/car/getExcel")
    @ResponseBody
    public void export(HttpServletResponse response, HttpServletRequest request) throws IOException {

        List<Map<String, Object>> rentList = service.queryCarRent();

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("公司派车记录");
        HSSFCellStyle yellowStyle = wb.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle redStyle = wb.createCellStyle();
        redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFRow row = null;
        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short)(20*20));
        row.createCell(0).setCellValue("员工编号");
        row.createCell(1).setCellValue("员工姓名");
        row.createCell(2).setCellValue("车辆编号");
        row.createCell(3).setCellValue("车辆牌照");
        row.createCell(4).setCellValue("路    线");
        row.createCell(5).setCellValue("开始时间");
        row.createCell(6).setCellValue("结束时间");



        //表格第一行设置完成，接下来就是取数据了
        for(int v=0;v<rentList.size();v++) {
            row = sheet.createRow(v + 1);
            Map<String,Object> map = rentList.get(v);
            HSSFCell cell = row.createCell(0);
            int s = (int) map.get("rent_emp_id");
            cell.setCellValue(s);
            HSSFCell cell1 = row.createCell(1);
            HSSFCell cell2 = row.createCell(2);
            HSSFCell cell3 = row.createCell(3);
            HSSFCell cell4 = row.createCell(4);
            HSSFCell cell5 = row.createCell(5);
            HSSFCell cell6 = row.createCell(6);
            cell1.setCellValue( map.get("emp_name").toString());
            cell2.setCellValue( map.get("car_id").toString());
            cell3.setCellValue( map.get("car_num").toString());
            cell4.setCellValue( map.get("rent_line").toString());
            cell5.setCellValue(map.get("rent_stime").toString());
            cell6.setCellValue(map.get("rent_otime").toString());


            sheet.setDefaultRowHeight((short) (16.5 * 20));
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=RentList.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    //查询所有行政审批的用车信息
    @RequestMapping(value = "/emp/queryXing", method = GET)
    public List<Map<String,Object>> queryXZ(HttpServletRequest request) {
        Integer checkmanId = (Integer) request.getSession().getAttribute("empId");
        return service.queryXingList(6);
    }

    //审批通过
    @RequestMapping(value = "/emp/updateXZ/{carRentId}", method = PUT)
    public int updateXing(@PathVariable int carRentId, HttpServletRequest request) {
        Integer checkmanId = (Integer) request.getSession().getAttribute("empId");
        if(checkmanId!=6){
            return 2;
        }else{
            return service.updateXZ(carRentId);
        }
    }
}
