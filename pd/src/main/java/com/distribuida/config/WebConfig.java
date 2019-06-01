package com.distribuida.config;

import com.distribuida.servicios.CrudRemote;
import org.springframework.context.annotation.*;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
@ComponentScan( basePackages="com.distribuida.config")
@Import(ArtemisMqConfig.class)
public class WebConfig {

    @Bean
    @Lazy
    public HttpInvokerProxyFactoryBean servicioPersonas( ) {

        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean( );

        proxy.setServiceUrl( "http://localhost:8080/pd-servidor-1.0-SNAPSHOT/app/borrar" );
        proxy.setServiceInterface( CrudRemote.class );

        return proxy;
    }

}
