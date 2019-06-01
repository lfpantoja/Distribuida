package com.distribuida.servidor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class PdWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ServerConfig.class);
        context.refresh();

        //Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet( context );
        ServletRegistration.Dynamic registration = servletContext.addServlet("/app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");

        servletContext.addListener( new ContextLoaderListener(context) );
    }
}
