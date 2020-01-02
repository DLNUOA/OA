package edu.dlnu.oa.common.service;

import edu.dlnu.oa.emp.pojo.Emp;

import java.util.List;
import java.util.Map;

public interface LoginValidService {
    public List<Emp> loginValid(Map<String,String> loginInfo);

    int userSignUp(String loginName, String password);
}
