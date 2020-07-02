package com.example.mybatisplus.config;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis-plus配置
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     * https://mp.baomidou.com/guide/page.html
     *
     * @return PaginationInterceptor
     */

    @Bean
    PageInterceptor getPageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean
    PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
