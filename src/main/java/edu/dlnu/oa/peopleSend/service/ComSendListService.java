package edu.dlnu.oa.peopleSend.service;

import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

/**
 * 外派人员的接口
 */
@Primary
public interface ComSendListService {

    //查询所有外派记录
    List<Map<String,Object>> querySList();

    //添加外派记录
    int addList(Map<String,Object> csl);

    //删除外派记录
    int deleteList(int sendId);

    //根据id修改外派人员状态
    int updateState(int spId,int spState);
}
