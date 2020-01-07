package edu.dlnu.oa.zhanghantest;

import edu.dlnu.oa.asset.pojo.Consume;
import edu.dlnu.oa.asset.service.ConsumeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@SpringBootTest
public class TestConsumeService {

    @Resource
    private ConsumeService service;
    @Test
    public  void testAddConsume()
    {
        Consume consume=new Consume(33,"dianshi","dian",2,"zhang",2, Date.valueOf("2019-12-13"),"info");
        service.addConsume(consume);
    }

    @Test
    public  void testQueryConsume()
    {
        List<Consume> list=service.queryConsume();
        for (Consume consume:list){
            System.out.println(consume);
        }
    }


}