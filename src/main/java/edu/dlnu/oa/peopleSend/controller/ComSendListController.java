package edu.dlnu.oa.peopleSend.controller;

import edu.dlnu.oa.peopleSend.pojo.ComSendList;
import edu.dlnu.oa.peopleSend.service.ComSendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * 外派记录controller
 */
@RestController
@RequestMapping("api")
public class ComSendListController {

    @Autowired
    private ComSendListService service;

    //查询所有外派记录
    @RequestMapping(value = "/sendList/query", method = GET)
    public List<ComSendList> query() { return service.querySList(); }

    //删除外派记录
    @RequestMapping(value = "/sendList/delete/{sendId}", method = DELETE)
    public int delete(@PathVariable int sendId) { return service.deleteList(sendId); }

    //添加外派记录
    @RequestMapping(value = "/sendList/add", method = POST)
    public int add(@RequestBody Map<String,Object> map) {
        Map<String,Object> sl = new HashMap<>();
        sl.put("sendSpId",map.get("spId"));
        sl.put("sendComId",map.get("comId"));
        sl.put("sendPeopleName",map.get("spName"));
        sl.put("sendComName",map.get("comName"));
//        更改外派人员状态
        service.updateState((int)map.get("spId"),(int)map.get("spState"));
        return service.addList(sl);
    }
}
