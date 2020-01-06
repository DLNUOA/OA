package edu.dlnu.oa.asset.service.serviceImpl;
import edu.dlnu.oa.asset.mapper.ConsumeMapper;
import edu.dlnu.oa.asset.pojo.Consume;
import edu.dlnu.oa.asset.service.ConsumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;




@Service
public class consumeServiceImpl implements ConsumeService {
    @Resource
    private ConsumeMapper mapper;

    @Override
    public int addConsume(Consume consume) {//具体的方法  与  AssetService  I  接口对应
        return mapper.insert(consume);//与AssetMapper对应
    }


    @Override
    public List<Consume> queryConsume()
    {
        return mapper.query();
    }


}



