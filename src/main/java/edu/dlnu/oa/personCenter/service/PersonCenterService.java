package edu.dlnu.oa.personCenter.service;

import java.util.List;
import java.util.Map;

public interface PersonCenterService {
    public List<Map<String,Object>> getPersonInfoById(int empId);
}
