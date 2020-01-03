package edu.dlnu.oa.peopleSend.service;

import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * 外派人员的接口
 */
@Primary
public interface ComSendListService {

    //查询所有外派记录
    List<ComSendList> querySList();

    //添加外派记录
    int addList(ComSendList csl);

    //删除外派记录
    int deleteList(int sendId);
}
