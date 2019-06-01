package com.distribuida.servidor.config;

import com.distribuida.servidor.servicios.ServicioPersonas;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
@ComponentScan( basePackages= {"com.distribuida.servidor.servicios", "com.distribuida.servidor.mq"})
@Import(ArtemisMqConfig.class)
public class ServerConfig {

    @Bean(name="/borrar")
    public HttpInvokerServiceExporter httpPersonas(ServicioPersonas servicio ) {

        HttpInvokerServiceExporter ret = new HttpInvokerServiceExporter();

        ret.setService( servicio );
        ret.setServiceInterface( ServicioPersonas.class );

        return ret;
    }
}
