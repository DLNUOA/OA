package edu.dlnu.oa.PeopleSend;

import edu.dlnu.oa.peopleSend.mapper.CompantionMapper;
import edu.dlnu.oa.peopleSend.pojo.Compantion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 合作公司Mapper测试
 */
@SpringBootTest
public class CompantionMapperTest {

    @Resource
    private CompantionMapper mapper;

    //查询所有合作公司信息
    @Test
    public void queryAll(){
        List<Compantion> list = mapper.query();
        for(Compantion com : list) {
            System.out.println(com);
        }
    }

    //修改合作公司信息
    @Test
    public void update() {
        Compantion com = new Compantion(3,"腾讯","王五","13236659887","7897897548","改成功了");
        mapper.update(com);
    }

    //根据id查找合作信息
    @Test
    public void queryById() {
        mapper.queryById(2);
        System.out.println(mapper.queryById(2));
    }

    //添加新的合作公司
    @Test
    public void add() {
        Compantion com = new Compantion("京东","赵恬恬","18745454646","9898985687","撒娇地从v");
        mapper.add(com);
    }

    //删除合作公司
    @Test
    public void delete(){
        mapper.delete(2);
    }

    //查看所有公司需求
    @Test
    public void quueryCom() {
        List<Map<String,Object>> list = mapper.queryDemand();
        for(Map map : list) {
            System.out.println(map);
        }
    }

    //添加新的需求
    @Test
    public void addDen() {
        Map<String,Object> map = new HashMap<>();
        map.put("demJob", "Golang");
        map.put("demJobType","web开发");
        map.put("demSalay",9000);
        map.put("demComId",3);
        mapper.addDemand(map);
    }

    //修改需求
    @Test
    public void updateDem() {
        Map<String,Object> map = new HashMap<>();
        map.put("demId",5);
        map.put("demJob", "Golang");
        map.put("demJobType","web开发");
        map.put("demSalay",9000);
        map.put("demComId",3);
        mapper.updateDemand(map);
    }

    //根据Id查找需求
    @Test
    public  void queryDemById() {
        Map<String,Object> map = mapper.queryDemById(5);
        System.out.println(map);
    }

    //删除需求
    @Test
    public void deleteDem() {
        mapper.deleteDem(4);
    }

}
