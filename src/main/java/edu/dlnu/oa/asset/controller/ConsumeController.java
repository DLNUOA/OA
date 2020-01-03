package edu.dlnu.oa.asset.controller;

import edu.dlnu.oa.asset.pojo.Consume;
import edu.dlnu.oa.asset.service.ConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class ConsumeController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConsumeService service;

    @RequestMapping(value = "/consume/add", method = POST)
    public int add(@RequestBody Consume consume ){
        return service.addConsume(consume);
    }

    @RequestMapping(value = "/consume/query", method=POST)
    public List<Consume> query() {
        List<Consume> list=service.queryConsume();
        return list;
    }

}



