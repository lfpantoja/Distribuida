package com.distribuida.restserver.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * UNIVERSIDAD CENTRAL DEL ECUADOR
 * @author Luis Pantoja
 */
public class PersonaDAO {

    static HashMap<String, Persona> personaMap = new HashMap<String, Persona>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Persona emp1 = new Persona();
        Persona emp2 = new Persona();
        Persona emp3 = new Persona();

        emp1.setId(1);
        emp1.setNombre("A");
        emp2.setId(2);
        emp2.setNombre("B");
        emp3.setId(3);
        emp3.setNombre("C");

        personaMap.put(Integer.toString(emp1.getId()), emp1);
        personaMap.put(Integer.toString(emp2.getId()), emp2);
        personaMap.put(Integer.toString(emp3.getId()), emp3);
    }

    public static Persona buscar(String personaNo) {
        return personaMap.get(personaNo);
    }

    public static Persona addPersona(Persona persona) {
        personaMap.put(Integer.toString(persona.getId()), persona);
        return persona;
    }

    public static Persona updatePersona(Persona persona) {
        personaMap.put(Integer.toString(persona.getId()), persona);
        return persona;
    }

    public static void deletePersona(String personaNo) {
        personaMap.remove(personaNo);
    }

    public static List<Persona> getAllPersonas() {
        Collection<Persona> c = personaMap.values();
        List<Persona> list = new ArrayList<Persona>();
        list.addAll(c);
        return list;
    }

    List<Persona> list;
}