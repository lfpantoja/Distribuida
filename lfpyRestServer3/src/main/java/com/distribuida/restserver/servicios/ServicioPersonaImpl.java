package com.distribuida.restserver.servicios;

import com.distribuida.restserver.dto.Persona;
import com.distribuida.restserver.dto.PersonaDAO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * UNIVERSIDAD CENTRAL DEL ECUADOR
 * @author Luis Pantoja
 */

@Component
public class ServicioPersonaImpl implements ServicioPersona{

    static HashMap<String, Persona> personaMap = new HashMap<String, Persona>();

    @Override
    public Persona buscar(int id){
        String temp=Integer.toString(id);
        return PersonaDAO.buscar(temp);
    }

    @Override
    public Persona addPersona(Persona persona) {
        return PersonaDAO.addPersona(persona);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        return PersonaDAO.updatePersona(persona);
    }

    @Override
    public void deletePersona(int id) {
        String temp=Integer.toString(id);
        PersonaDAO.deletePersona(temp);
    }

    @Override
    public List<Persona> getAllPersona() {
        List<Persona> listOfPersonas = PersonaDAO.getAllPersonas();
        return listOfPersonas;
    }
}
