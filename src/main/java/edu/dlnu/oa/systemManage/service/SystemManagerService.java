package edu.dlnu.oa.systemManage.service;

import java.util.List;
import java.util.Map;

public interface SystemManagerService {
    List<Map<String, Object>> getDeptManagerLeaveRequest(int id);

    int updateALeaveRequest(Map<String, Object> info);

    String getLeaveStaffName(Map<String, Object> info);

    String getLeaveStaffEmail(Map<String, Object> info);
}
