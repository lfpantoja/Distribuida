package com.distribuida.restserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * UNIVERSIDAD CENTRAL DEL ECUADOR
 * @author Luis Pantoja
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.distribuida.restserver.rest"})
public class WebConfig implements WebMvcConfigurer {

}
