package edu.dlnu.oa.aff.controller;

import java.util.List;
import edu.dlnu.oa.aff.pojo.Aff;
import edu.dlnu.oa.aff.service.AffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 *
 */
@RestController
@RequestMapping("/Aff")
public class AffController {

    @Autowired
    private AffService affService;

    @RequestMapping(value = "/queryById/{affId}", method = GET)
    public List<Aff> queryById(@PathVariable int affId)
    {

        return affService.queryById(affId);
    }
    @RequestMapping(value = "/del/{affId}", method = DELETE)
    public int deleteAffById(@PathVariable int affId)
    {
        return affService.deleteAffById(affId);
    }

    @RequestMapping(value = "/insert" , method = POST)
    public int insertAff(@RequestBody Aff aff)
    {
        return affService.insertAff(aff);
    }

    @RequestMapping(value = "/update" , method = POST)
    public int updateAff(@RequestBody Aff aff)
    {
        return affService.updateAff(aff);
    }

    @RequestMapping(value = "/query", method = GET)
    public List<Aff> queryAff()
    {
        return affService.queryAff();
    }

}
