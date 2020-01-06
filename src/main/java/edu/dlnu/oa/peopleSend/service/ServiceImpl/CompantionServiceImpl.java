package edu.dlnu.oa.peopleSend.service.ServiceImpl;

import edu.dlnu.oa.peopleSend.mapper.CompantionMapper;
import edu.dlnu.oa.peopleSend.pojo.Compantion;
import edu.dlnu.oa.peopleSend.service.CompantionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * service接口实现类
 */
@Service
public class CompantionServiceImpl implements CompantionService {

    @Resource
    private CompantionMapper mapper;

    //查询所有合作公司信息
    @Override
    public List<Compantion> queryCom() { return mapper.query(); }

    //修改公司信息
    @Override
    public int updateCom(Compantion com) {return mapper.update(com); }

    //按照id查找合作公司需求信息
    @Override
    public List<Map<String,Object>> queryComById(int comId) { return mapper.queryById(comId); }

    //删除公司信息
    @Override
    public int deleteCom(int comId) { return mapper.delete(comId); }

    //添加新的合作公司
    @Override
    public int addCom(Compantion com) { return mapper.add(com); }


    //查看公司的所有需求
    @Override
    public List<Map<String, Object>> queryDem() { return mapper.queryDemand();}

    //添加新的需求
    @Override
    public  int addDem(Map<String,Object> dem) { return mapper.addDemand(dem);}

    //根据名称差id
    @Override
    public int selectId(String comName) { return mapper.selectComId(comName);}

    //修改公司需求
    @Override
    public  int updateDem(Map<String,Object> dem) { return mapper.updateDemand(dem);}

    //根据Id查找需求
    @Override
    public  Map<String,Object> queryDemById(int demId) { return mapper.queryDemById(demId);}

    //删除公司需求
    @Override
    public  int  deleteDem(int demId) { return mapper.deleteDem(demId);}

    //按名字查找公司是否存在
    @Override
    public String selectComName(String comName) { return mapper.selectName(comName); }
}
