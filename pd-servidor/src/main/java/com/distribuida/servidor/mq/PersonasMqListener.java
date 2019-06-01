package com.distribuida.servidor.mq;

import com.distribuida.servidor.servicios.ServicioPersonas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PersonasMqListener {
    @Autowired
    private ServicioPersonas servicio;

    @JmsListener(destination="/queue/personas.borrar", containerFactory="jmsListenerContainerFactory")
    public void deletePersona( Integer personaId ) {

        System.out.println( "DELETE persona" );

        servicio.borrar( personaId );
    }
}
