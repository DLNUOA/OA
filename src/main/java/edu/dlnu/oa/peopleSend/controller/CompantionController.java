package edu.dlnu.oa.peopleSend.controller;

import edu.dlnu.oa.peopleSend.pojo.Compantion;
import edu.dlnu.oa.peopleSend.service.CompantionService;
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

    //根据id查找合作公司的需求信息
    @RequestMapping(value = "/com/queryComById/{comId}", method = GET)
    public List<Map<String,Object>> queryComById(@PathVariable int comId) { return service.queryComById(comId); }

    //添加新的合作公司
    @RequestMapping(value = "/com/add", method = POST)
    public int add(@RequestBody  Compantion com) { return service.addCom(com); }

    //删除合作公司
    @RequestMapping(value = "/comC/delete/{comId}", method = DELETE)
    public int delete(@PathVariable int comId) { return service.deleteCom(comId); }

    //需求暂时没写

    //查看公司的所有需求
    @RequestMapping(value = "/dem/query", method = GET)
    public List<Map<String,Object>> queryDem() { return service.queryDem();}

    //修改需求信息
    @RequestMapping(value = "/dem/update", method = PUT)
    public int updateDem(@RequestBody Map<String,Object> dem) {
        Map<String,Object> map = new HashMap<>();
        map.put("demId",dem.get("demId"));
        map.put("demJob",dem.get("demJob"));
        map.put("demJobType",dem.get("demJobType"));
        map.put("demSalay",dem.get("demSalay"));
        return service.updateDem(map);
    }

    //删除需求信息
    @RequestMapping(value = "/dem/delete/{demId}", method = DELETE)
    public int deleteDem(@PathVariable int demId) { return service.deleteDem(demId);}

    //添加新的需求
    @RequestMapping(value = "/dem/add", method = POST)
    public  int addDemand(@RequestBody Map<String,Object> map) {
        String comName = (String)map.get("comName");
        if(service.selectComName(comName) == null ) {
            return 2;
        }else{
            Map<String,Object> dem = new HashMap<>();
            dem.put("demJob",map.get("demJob"));
            dem.put("demJobType",map.get("demJobType"));
            dem.put("demSalay",map.get("demSalay"));
            dem.put("demComId",service.selectId(comName));
            return service.addDem(dem);
        }
    }
}
