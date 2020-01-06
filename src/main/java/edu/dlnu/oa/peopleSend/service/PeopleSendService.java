package edu.dlnu.oa.peopleSend.service;

import edu.dlnu.oa.peopleSend.pojo.ComSendPeople;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

/**
 * 外派人员的service接口
 */
@Primary
public interface PeopleSendService {

    //查找所有外派人员列表
    List<ComSendPeople> queryCsp();

    //添加外派人员信息
    int addCsp(ComSendPeople csp);

    //删除外派人员信息
    int deleteCsp(int cspId);

    //修改外派人员信息
    int updateCsp(Map<String,Object> csp);

    //根据ID搜索员工信息
    ComSendPeople queryCspId(int spId);

    //根据姓名搜素人员信息
    List<ComSendPeople> queryCspName(String spName);

}
