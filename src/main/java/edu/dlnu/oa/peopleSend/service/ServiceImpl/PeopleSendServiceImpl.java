package edu.dlnu.oa.peopleSend.service.ServiceImpl;

import edu.dlnu.oa.peopleSend.mapper.PeopleSendMapper;
import edu.dlnu.oa.peopleSend.pojo.ComSendPeople;
import edu.dlnu.oa.peopleSend.service.PeopleSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * service接口实现类
 */
@Service
public class PeopleSendServiceImpl implements PeopleSendService {

    @Resource
    private PeopleSendMapper mapper;

    @Override
    public List<ComSendPeople> queryCsp() { return mapper.query(); }

    @Override
    public int addCsp(ComSendPeople csp) { return mapper.insert(csp); }

    @Override
    public int deleteCsp(int spId) { return mapper.delete(spId); }

    @Override
    public int updateCsp(Map<String,Object> csp) {return mapper.update(csp);}

    @Override
    public ComSendPeople queryCspId(int spId) { return mapper.queryById(spId);}

    @Override
    public List<ComSendPeople> queryCspName(String spName) { return mapper.queryByName(spName); }


}
