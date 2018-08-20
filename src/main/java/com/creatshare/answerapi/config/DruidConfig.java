package com.creatshare.answerapi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

//    @Bean
//    public ServletRegistrationBean registrationBean(){
//        ServletRegistrationBean registrationBean =
//                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        Map<String,String> map = new HashMap<>();
//        map.put("loginUsername","root");
//        map.put("loginPassword","root");
//        map.put("allow","");
//        registrationBean.setInitParameters(map);
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new WebStatFilter());
//        bean.setUrlPatterns(Arrays.asList("/*"));
//
//        Map<String,String> map = new HashMap<>();
//        map.put("exclusions","*.js,*.jpg,*.png,*.gif,*.ico,*.css,/druid/*");
//        bean.setInitParameters(map);
//
//        return bean;
//    }

}
