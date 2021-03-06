package com.xns.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xns
 * @Date: 20-1-15 下午5:06
 */
@Configuration
public class DruidConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);
//
//    @Bean
//    public ServletRegistrationBean druidServlet(){
//        logger.info("init Druid Servlet Configuration");
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/");
//        servletRegistrationBean.addInitParameter("allow","*");
//        servletRegistrationBean.addInitParameter("deny","192.168.43.21");
//
//        servletRegistrationBean.addInitParameter("loginUsername","admin");
//        servletRegistrationBean.addInitParameter("loginPassword","admin");
//
//        servletRegistrationBean.addInitParameter("resetEnable","false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.png,*.jpg,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druid(){
//        return new DruidDataSource();
//    }


}
