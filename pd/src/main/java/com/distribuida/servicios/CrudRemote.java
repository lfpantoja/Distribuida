package com.distribuida.servicios;

import com.distribuida.entity.Persona;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CrudRemote {
    void Ingresar (Persona persona);
    void Editar (Persona persona);
    void Eliminar (int id);
    Persona Buscar (int id);
    public List<Persona> Listar();
}
