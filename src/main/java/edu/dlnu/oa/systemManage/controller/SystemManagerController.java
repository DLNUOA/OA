package edu.dlnu.oa.systemManage.controller;

import edu.dlnu.oa.systemManage.service.SystemManagerService;
import edu.dlnu.oa.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2020/1/3 9:31
 */
@RestController
@RequestMapping("/api/sm")
public class SystemManagerController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SystemManagerService systemManagerService;
    @GetMapping("/leaveRequest")
    public List<Map<String,Object>> getDeptManagerLeaveRequest(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("empId");
        return systemManagerService.getDeptManagerLeaveRequest(id);
    }

    @PutMapping("/leaveRequest")
    public int updateALeaveRequest(@RequestBody Map<String,Object> info,HttpServletRequest request){
        String leaveStaffName =  systemManagerService.getLeaveStaffName(info);
        String leaveStaffEmail = systemManagerService.getLeaveStaffEmail(info);
        String content = leaveStaffName+"同学，你的部门经理回复了你的请假请求，快去OA查看吧！";
        MailUtils.sendMail(leaveStaffEmail,content,"OA请假回复");

        return systemManagerService.updateALeaveRequest(info);
    }

}
