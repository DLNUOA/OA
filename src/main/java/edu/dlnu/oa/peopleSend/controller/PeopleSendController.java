package edu.dlnu.oa.peopleSend.controller;

import edu.dlnu.oa.peopleSend.pojo.ComSendPeople;
import edu.dlnu.oa.peopleSend.service.PeopleSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * 外派人才管理
 */
@RestController
@RequestMapping("api")
public class PeopleSendController {

    @Autowired
    private PeopleSendService service;

    //查询所有外派人员信息
    @RequestMapping(value = "/send/query", method = GET)
    public List<ComSendPeople> query() { return service.queryCsp(); }

    //添加外派人员信息
    @RequestMapping(value = "/send/add", method = POST)
    public int add(@RequestBody ComSendPeople csp) { return service.addCsp(csp); }

    //根据ID查人员信息
    @RequestMapping(value = "/send/queryById/{spId}", method = GET)
    public ComSendPeople queryById(@PathVariable int spId) { return service.queryCspId(spId); }

    //根据姓名模糊查询人员信息
    @RequestMapping(value = "/send/queryByName", method = POST)
    public  List<ComSendPeople> queryByName(@RequestBody Map<String,String> map) { return service.queryCspName(map.get("spName")); }

    //删除人员信息
    @RequestMapping(value = "/send/delete/{spId}", method = DELETE)
    public int delete(@PathVariable  int spId) { return service.deleteCsp(spId); }

    //更改人员信息
    @RequestMapping(value = "/send/update", method = POST)
    public int update(@RequestBody Map<String,Object> csp) { return service.updateCsp(csp); }
}
