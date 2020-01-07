package edu.dlnu.oa.aff.service.AffServiceImpl;

import edu.dlnu.oa.aff.mapper.AffMapper;
import edu.dlnu.oa.aff.pojo.Aff;
import edu.dlnu.oa.aff.service.AffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公告
 */
@Service
public class AffServiceImpl implements AffService {

    @Resource
    private AffMapper affMapper;


    @Override
    public int insertAff(Aff aff) {
        return affMapper.insertAff(aff);
    }

    @Override
    public List<Aff> queryAff() {
        return affMapper.queryAff();
    }

    @Override
    public int deleteAffById(int affId) {
        return affMapper.deleteAffById(affId);
    }

    @Override
    public int updateAff(Aff aff) {
        return affMapper.updateAff(aff);
    }

    @Override
    public List<Aff> queryById(int affId) {
        return affMapper.queryAffById(affId);
    }

}
