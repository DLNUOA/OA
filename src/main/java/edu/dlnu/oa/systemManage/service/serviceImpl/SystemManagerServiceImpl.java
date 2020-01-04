package edu.dlnu.oa.systemManage.service.serviceImpl;

import edu.dlnu.oa.systemManage.mapper.SystemManagerMapper;
import edu.dlnu.oa.systemManage.service.SystemManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2020/1/3 9:33
 */
@Service
public class SystemManagerServiceImpl implements SystemManagerService {
    @Resource
    private SystemManagerMapper systemManagerMapper;
    @Override
    public List<Map<String, Object>> getDeptManagerLeaveRequest(int id) {
        return systemManagerMapper.getDeptManagerLeaveRequest(id);
    }

    @Override
    public int updateALeaveRequest(Map<String, Object> info) {
        return systemManagerMapper.updateALeaveRequest(info);
    }

    @Override
    public String getLeaveStaffName(Map<String, Object> info) {
        return systemManagerMapper.getLeaveStaffName(info);
    }

    @Override
    public String getLeaveStaffEmail(Map<String, Object> info) {
        return systemManagerMapper.getLeaveStaffEmail(info);
    }
}
