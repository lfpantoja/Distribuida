package com.distribuida.servidor.servicios;

import com.distribuida.servidor.dto.Persona;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServicioPersonasImpl implements ServicioPersonas{

    private List<Persona> personas = new ArrayList<>();

    private int nextId;

    @Override
    public void borrar(int id) {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/persona";
        String driver = "org.postgresql.Driver";

        String userName = "postgres";
        String password = "root";

        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url , userName, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("DELETE FROM persona WHERE id = "+id+";");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
