package com.sg.mq.config;

import com.sg.mq.domain.constant.SecurityConstant;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

/**
 * SanGang
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private InterceptorToken tokenInterceptor;

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludeUrls = ArrayUtils.addAll(SecurityConstant.PATTERN_URLS, ignoreUrlsConfig.getUrls());
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns(excludeUrls);
        //registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(excludeUrls);

    }

}
