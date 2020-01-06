package edu.dlnu.oa.peopleSend.service;

import edu.dlnu.oa.peopleSend.pojo.Compantion;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

/**
 * 合作公司的Service接口
 */
@Primary
public interface CompantionService {

    //查询所有合作公司信息
    List<Compantion> queryCom();

    //修改合作公司信息
    int updateCom(Compantion com);

    //根据id查找合作公司需求信息
    List<Map<String,Object>> queryComById(int comId);

    //添加新的合作公司
    int addCom(Compantion com);

    //删除合作公司
    int deleteCom(int comId);

    //查看公司的所有需求
    List<Map<String, Object>> queryDem();

    //添加新的需求
    int addDem(Map<String,Object> dem);

    //按照公司名称查找id
    int selectId(String comName);

    //修改公司需求
    int updateDem(Map<String,Object> dem);

    //根据Id查找需求
    Map<String,Object> queryDemById(int demId);

    //删除公司需求
    int deleteDem(int demId);

    //按名字查找公司是否存在
    String selectComName(String comName);
}
