package com.distribuida.servicios;

import com.distribuida.entity.Persona;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class Crud  implements CrudRemote {

    public Crud (){
    }

    @Override
    public void Ingresar(Persona persona) {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/persona";
        String driver = "org.postgresql.Driver";

        String userName = "postgres";
        String password = "root";
        List<Persona> personas = new ArrayList<Persona>();
        try {

            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url , userName, password);

            PreparedStatement st =
                    con.prepareStatement("insert into persona(id,nombre,direccion,identificacion,fechanacimiento) values(?,?,?,?,?)");
            st.setInt(1,persona.getId());
            st.setString(2,persona.getNombre());
            st.setString(3,persona.getDireccion());
            st.setInt(4,persona.getIdentificacion());
            st.setDate(5,Date.valueOf(persona.getFechanacimiento()));
            System.out.println(persona.getId()+" - " + persona.getIdentificacion()+" - " + persona.getFechanacimiento());
            int result = st.executeUpdate();

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
    @Override
    public void Editar(Persona persona){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/persona";
        String driver = "org.postgresql.Driver";

        String userName = "postgres";
        String password = "root";

        Integer idd = persona.getId();
        String nombre = persona.getNombre();
        String direccion = persona.getDireccion();
        int identificacion = persona.getIdentificacion();
        String fechanacimiento = persona.getFechanacimiento();
        System.out.println(fechanacimiento);
        //String fechanacimiento = persona.getFechanacimiento();

        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url , userName, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("UPDATE persona SET nombre = '"+nombre+"', direccion ='" + direccion+"', identificacion = "+identificacion +", fechanacimiento= '"+fechanacimiento+"' WHERE id = "+idd+";");

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
    @Override
    public void Eliminar (int id){
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
    @Override
    public Persona Buscar (int id){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/persona";
        String driver = "org.postgresql.Driver";

        String userName = "postgres";
        String password = "root";
        Persona persona = null;
        try {

            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url , userName, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from persona where id = " + id);


            while (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setDireccion(rs.getString(3));
                persona.setIdentificacion(rs.getInt(4));
                persona.setFechanacimiento(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return persona;
    }
    @Override
    public List<Persona> Listar (){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/persona";
        String driver = "org.postgresql.Driver";

        String userName = "postgres";
        String password = "root";
        List<Persona> personas = new ArrayList<Persona>();
        try {

            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url , userName, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from persona order by id");

            Persona persona;
            while (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setDireccion(rs.getString(3));
                persona.setIdentificacion(rs.getInt(4));
                persona.setFechanacimiento(rs.getString(5));
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return personas;
    }

}

