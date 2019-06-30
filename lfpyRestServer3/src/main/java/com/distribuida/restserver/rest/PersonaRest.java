package com.distribuida.restserver.rest;

import com.distribuida.restserver.dto.Persona;
import com.distribuida.restserver.servicios.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UNIVERSIDAD CENTRAL DEL ECUADOR
 * @author Luis Pantoja
 */

@RestController
@RequestMapping(path = "/personas")
public class PersonaRest {

    @Autowired private ServicioPersona servicio;

    //@GET
    //@Path("/{id}")
    //@Produces({MediaType.APPLICATION_JSON})

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscar (@PathVariable("id") int id){
        if(id %2 == 0){
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }

        Persona persona = servicio.buscar(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPersona (){
        List persona = servicio.getAllPersona();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPersona (@RequestBody Persona persona){
        Persona persona1 = servicio.addPersona(persona);
        return new ResponseEntity<>(persona1, HttpStatus.OK);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePersona (@RequestBody Persona persona){
        persona = servicio.updatePersona(persona);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePersona (@PathVariable("id") int id){
        servicio.deletePersona(id);
    }

}
