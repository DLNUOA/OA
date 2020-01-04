package edu.dlnu.oa.configration;

import edu.dlnu.oa.security.OJHandleSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wuhan
 * @Time 2020/1/5/ 1:02
 * @Description 自定义拦截器OAHandleSecurity配置类
 */

@Configuration
public class OAHandleSecurityConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{"/Vue/**", "/login/**", "/", "/css/**", "/js/**", "/fonts/**", "/error/**", "/static/**", "/index/**", "/vendor/**", "/upload/**","/userLogin","/contactUs"};
        registry.addInterceptor(new OJHandleSecurity()).addPathPatterns("/**").excludePathPatterns(excludes);
    }
}
