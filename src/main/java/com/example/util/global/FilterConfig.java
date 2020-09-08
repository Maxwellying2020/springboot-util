package com.example.util.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * <b>Class name</b>: FilterConfig
 * </p>
 * <p>
 * <b>Class description</b>: Class description goes here.
 * </p>
 * <p>
 * <b>Author</b>: zhang ying
 * </p>
 * <b>Change History</b>:<br/>
 * <p>
 *
 * <pre>
 * Date          Author       Revision     Comments
 * ----------    ----------   --------     ------------------
 * 2019-06-12    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-06-12
 * </p>
 */
@Configuration
@ComponentScan
public class FilterConfig {

    @Autowired
    private CommonFilter commonFilter;

    /**
     * 拦截器注册
     *
     * @return
     */

    @Bean
    public FilterRegistrationBean myOncePerRequestFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(commonFilter);
        registration.addUrlPatterns("/*");// 拦截路径
        registration.setName("CommonFilter");// 拦截器名称
        registration.setOrder(1);// 顺序
        return registration;
    }
}
