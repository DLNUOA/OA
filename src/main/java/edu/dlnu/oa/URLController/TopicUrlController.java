package edu.dlnu.oa.URLController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicUrlController {
    @RequestMapping("/topic")
    public String topic(){
        return "topic/topic";
    }

    @RequestMapping("/upTopic")
    public String updatatopic()
    {
        return "topic/upTopic";
    }

    @RequestMapping("/addTopic")
    public String addTopic()
    {
        return "topic/addTopic";
    }

    @RequestMapping("/quTopic")
    public String queryByIdTopic()
    {
        return "topic/quTopic";
    }
}
