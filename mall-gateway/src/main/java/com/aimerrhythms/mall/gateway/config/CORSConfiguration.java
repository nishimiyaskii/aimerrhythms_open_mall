package com.aimerrhythms.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 配置跨域
 * @author aimerrhythms
 * @data 2020/6/1 14:56
 */
@Configuration
public class CORSConfiguration{

    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //配置允许跨域
        corsConfiguration.addAllowedHeader("*");        //允许所有请求头
        corsConfiguration.addAllowedMethod("*");        //允许所有请求方法
        corsConfiguration.addAllowedOrigin("*");        //允许所有来源
        corsConfiguration.setAllowCredentials(true);    //允许携带cookie

        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }

}
