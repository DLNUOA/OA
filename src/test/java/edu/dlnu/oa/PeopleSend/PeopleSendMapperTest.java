package edu.dlnu.oa.PeopleSend;

import edu.dlnu.oa.peopleSend.mapper.PeopleSendMapper;
import edu.dlnu.oa.peopleSend.pojo.ComSendPeople;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

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

    //测试更改
    @Test
    public void  update() {
        ComSendPeople csp = new ComSendPeople(3,"赵六","本科","一年","Java",
                "河北",8000,0);
        mapper.update(csp);
    }
}
