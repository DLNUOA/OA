package edu.dlnu.oa.PeopleSend;

import edu.dlnu.oa.peopleSend.mapper.PeopleSendMapper;
import edu.dlnu.oa.peopleSend.pojo.ComSendPeople;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * 外派人员mapper测试
 */
@SpringBootTest
public class PeopleSendMapperTest {

    @Resource
    private PeopleSendMapper mapper;

    //测试查询所有信息
    @Test
    public void queryall() {
        List<ComSendPeople> list = mapper.query();
        for(ComSendPeople csp : list) {
            System.out.println(csp);
        }
    }

    //测试根据id找外派人员
    @Test
    public  void queryId() {
        ComSendPeople csp = mapper.queryById(4);
        System.out.println(csp);
    }

    //测试按照姓名模糊查询
    @Test
    public void queryName() {
        List<ComSendPeople> list = mapper.queryByName("张");
        for(ComSendPeople csp : list) {
            System.out.println(csp);
        }
    }

    //测试删除
    @Test
    public void  delete(){

        mapper.delete(2);
    }
//
    //测试更改
    @Test
    public void  update(){
        Map<String,Object> send = new HashMap<>();
        send.put("spId",5);
        send.put("spName","王张张");
        send.put("spEdu","高中");
        send.put("spWork","一年");
        send.put("spAbility","ds");
        send.put("spLoc","dcv");
        send.put("spSalay",9000);
        send.put("spState",1);
        mapper.update(send);
    }

}
