package edu.dlnu.oa.sse;


import edu.dlnu.oa.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhan
 * @date 2019/11/8 20:14
 */
@Controller
@RequestMapping(value = "/getCount")
public class SSEController {

    @Autowired
    private RedisUtils redisUtils;
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @ResponseBody
    @RequestMapping("/clearCount")
    public void clearCount(HttpServletRequest request){
        String empId = request.getSession().getAttribute("empId").toString();
        redisUtils.clearLeaveApplyCount(empId);
    }



    /**
     * 回复消息控制器
     * @param response response
     * @param request request
     * @return 返回用户的被回复次数
     */
    @ResponseBody
    @RequestMapping(value="/push",produces="text/event-stream;charset=UTF-8")
    public String push(HttpServletResponse response, HttpServletRequest request){
        //从session里获取用户id
        String empId = request.getSession().getAttribute("empId").toString();
        Map<String,Object> param = new HashMap<>();
        //SSE要求的头信息如下
        response.setHeader("Access-Control-Allow-Origin","*");
        int count = 0;
        try {
         count= redisUtils.getLeaveApplyCount(Integer.parseInt(empId));


        } catch (Exception e) {
            e.printStackTrace();
        }
//        int atMeCounts = (int) (Math.random()*10);
        log.info("at me count = " + count);
        //这里我再次承认，写的不优雅，只要返回count给前端就好，省流量
        //这里爬了约莫一个小时的坑，提醒个位同学，末尾的\n\n一定要加啊QAQ
        return "data:  "+ count +" \nevent:like\n retry:15000\n\n";

    }
}
