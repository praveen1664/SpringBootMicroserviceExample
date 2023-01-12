package com.jat.UserService.component;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import springfox.documentation.spring.web.PropertySourcedRequestMappingHandlerMapping;

import java.util.LinkedHashMap;
import java.util.*;

@Component
public class SwaggerPostProccesor implements BeanPostProcessor {
    private static final String SWAGGER_BEAN_NAME = "swagger2ControllerMapping";
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (SWAGGER_BEAN_NAME.equals(beanName)) {
            Map<String, CorsConfiguration> configs = new LinkedHashMap<>();
            CorsConfiguration corsConfiguration = (new CorsConfiguration()).applyPermitDefaultValues();
            corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
            corsConfiguration.setAllowedMethods(ImmutableList.of("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"));
            configs.put("/**", corsConfiguration);
            PropertySourcedRequestMappingHandlerMapping.class.cast(bean).setCorsConfigurations(configs);
        }
        return bean;
    }

}
