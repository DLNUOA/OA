package edu.dlnu.oa.zhanghantest;


import edu.dlnu.oa.asset.mapper.ConsumeMapper;
import edu.dlnu.oa.asset.pojo.Consume;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@SpringBootTest

public class TestConsumeMapper {

    @Resource
    private ConsumeMapper mapper;


    @Test
    public  void testInsert()
    {

        Consume consume=new Consume(1,"dianshi","dian",2,"zhang",2,Date.valueOf("2019-12-13"),"info");
        mapper.insert(consume);
    }

    @Test
    public  void testQuery()
    {
        List<Consume> list=mapper.query();
        for (Consume consume:list){
            System.out.println(consume);
        }
    }



}
