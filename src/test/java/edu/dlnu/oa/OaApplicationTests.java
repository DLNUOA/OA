package edu.dlnu.oa;

import edu.dlnu.oa.dept.pojo.Dept;
import edu.dlnu.oa.mapper.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class OaApplicationTests {

    @Resource
    Index index;
    @Test
    void contextLoads() {
    }
    @Test
    void get(){
//        System.out.print("-----------" + index.getCount());
        List<Dept> allDept = index.getAllDept();
        for (Dept dept : allDept) {
            System.out.println(dept.toString());
        }
    }

}
