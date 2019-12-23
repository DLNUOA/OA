package edu.dlnu.oa;

import edu.dlnu.oa.dept.pojo.Dept;
import edu.dlnu.oa.dept.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OaApplicationTests {
    @Autowired
    private DeptService deptService;

    @Test
    void contextLoads() {
    }
    @Test
    void get(){
        Dept dept = new Dept("客服部","大连市","客服小姐姐");
        int i = deptService.insertDept(dept);
        System.out.print(i);
    }
    @Test
    void findAllDept(){
        List<Dept> allDept = deptService.findAllDept();
        for (Dept dept : allDept) {
            System.out.printf(dept.toString());
        }
    }
    @Test
    void deleteDeptById(){
        int i = 1;
        int i1 = deptService.deleteDeptById(i);
        System.out.println(i1);
    }

}
