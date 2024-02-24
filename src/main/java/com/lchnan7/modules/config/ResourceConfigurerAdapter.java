package com.lchnan7.modules.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfigurerAdapter implements WebMvcConfigurer {
    @Value("${file.path}")
    private String filePath;

    /**
     * 配置资源访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源---图片url地址
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + filePath);

    }

}
