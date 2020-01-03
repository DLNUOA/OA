package edu.dlnu.oa.PeopleSend;

import edu.dlnu.oa.peopleSend.mapper.ComSendListMapper;
import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 外派记录
 */
@SpringBootTest
public class ComSendListMapperTest {

    @Resource
    private ComSendListMapper mapper;

    @Test
    public void query(){
        List<ComSendList> list = mapper.query();
        for(ComSendList csl : list) {
            System.out.println(csl);
        }
    }
    @Test
    public void add() {
        ComSendList csl = new ComSendList(1,1,"张三","中软");
        mapper.insert(csl);

    }
}
