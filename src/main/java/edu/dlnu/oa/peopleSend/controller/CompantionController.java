package edu.dlnu.oa.peopleSend.controller;

import edu.dlnu.oa.peopleSend.pojo.Compantion;
import edu.dlnu.oa.peopleSend.service.CompantionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * 外派公司Controller
 */
@RestController
@RequestMapping("api")
public class CompantionController {

    @Autowired
    private CompantionService service;

    //查询所有合作公司信息
    @RequestMapping(value = "/com/query", method = GET)
    public List<Compantion> query() { return service.queryCom(); }

    //修改合作公司信息
    @RequestMapping(value = "/com/update", method = PUT)
    public  int update(@RequestBody Compantion com) { return service.updateCom(com); }

    //根据id查找合作信息
    @RequestMapping(value = "/com/queryComById", method = GET)
    public Compantion queryComById(@RequestBody int comId) { return service.queryComById(comId); }

    //添加新的合作公司
    @RequestMapping(value = "/com/add", method = POST)
    public int add(@RequestBody  Compantion com) { return service.addCom(com); }

    //删除合作公司
    @RequestMapping(value = "/com/delete", method = DELETE)
    public int delete(@RequestBody int comId) { return service.deleteCom(comId); }

    //需求暂时没写

}
