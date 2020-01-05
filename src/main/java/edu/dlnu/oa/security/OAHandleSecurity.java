package edu.dlnu.oa.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lixu
 * @Time 2019年3月12日 13点47分
 * @Description 自定义拦截器OJHandleSecurity
 */
public class OAHandleSecurity implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    //实现preHandle方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过Sesssion的方式校验当前请求是否已经具有登陆状态
        if(StringUtils.isEmpty(request.getSession().getAttribute("empId"))){
            //若Session中key值为user_id的value为空，则进行拦截，并重定向到登陆界面
            log.warn("Session验证未通过");
            response.sendRedirect("/login/");
            return false;
        }else {
            //若Session中key值为user_id的value不为空，则通过验证
            log.warn("Session验证通过,");
            return true;
        }
    }

}
