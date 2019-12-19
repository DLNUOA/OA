package edu.dlnu.oa;

import edu.dlnu.oa.mapper.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OaApplicationTests {

    @Resource
    Index index;
    @Test
    void contextLoads() {
    }
    @Test
    void get(){
        System.out.printf("-----------"+index.getRankList().size());
    }

}
