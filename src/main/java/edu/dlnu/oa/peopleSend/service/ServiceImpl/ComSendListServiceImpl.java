package edu.dlnu.oa.peopleSend.service.ServiceImpl;


import edu.dlnu.oa.peopleSend.mapper.ComSendListMapper;
import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import edu.dlnu.oa.peopleSend.service.ComSendListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 外派service接口实现类
 */
@Service
public class ComSendListServiceImpl implements ComSendListService {
    @Resource
    private ComSendListMapper mapper;

    @Override
    public List<Map<String,Object>> querySList() { return mapper.query();}

    @Override
    public int addList(Map<String,Object> csl) { return mapper.insert(csl);}

    @Override
    public int deleteList(int sendId) { return mapper.delete(sendId);}

    //根据id修改外派人员状态
    @Override
    public int updateState(int spId,int spState) { return mapper.update(spId,spState);}
}
