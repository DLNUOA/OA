package edu.dlnu.oa.peopleSend.service.ServiceImpl;


import edu.dlnu.oa.peopleSend.mapper.ComSendListMapper;
import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import edu.dlnu.oa.peopleSend.service.ComSendListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 外派service接口实现类
 */
@Service
public class ComSendListServiceImpl implements ComSendListService {
    @Resource
    private ComSendListMapper mapper;

    @Override
    public List<ComSendList> querySList() { return mapper.query();}

    @Override
    public int addList(ComSendList csl) { return mapper.insert(csl);}

    @Override
    public int deleteList(int sendId) { return mapper.delete(sendId);}
}
