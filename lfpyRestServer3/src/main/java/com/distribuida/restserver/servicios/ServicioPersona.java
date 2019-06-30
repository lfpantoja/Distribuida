package com.distribuida.restserver.servicios;

import com.distribuida.restserver.dto.Persona;
import java.util.List;

public interface ServicioPersona {
    Persona buscar(int id);
    Persona addPersona(Persona persona);
    Persona updatePersona(Persona persona);
    void deletePersona(int id);
    List<Persona> getAllPersona();
}
