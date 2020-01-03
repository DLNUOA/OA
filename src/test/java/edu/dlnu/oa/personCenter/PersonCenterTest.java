package edu.dlnu.oa.personCenter;

import edu.dlnu.oa.personCenter.mapper.PersonCenterMapper;
import edu.dlnu.oa.personCenter.service.PersonCenterService;
import edu.dlnu.oa.utils.MailUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/12/23 23:16
 */
@SpringBootTest
public class PersonCenterTest {
    @Resource
    private PersonCenterMapper personCenterMapper;
    @Resource
    private PersonCenterService personCenterService;
    @Test
    public void getInfo(){
        Map<String, Object> empInfo = personCenterService.getPersonInfoById(7);
        System.out.println(empInfo);

    }
    @Test
    public void sendMail(){
        MailUtils.sendMail("1530182931@qq.com","hello_test","Test");
    }
}
