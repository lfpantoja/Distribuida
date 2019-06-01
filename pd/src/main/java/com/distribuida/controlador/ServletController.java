package com.distribuida.controlador;

import com.distribuida.entity.Persona;
import com.distribuida.servicios.Crud;
import com.distribuida.servicios.CrudRemote;
import org.springframework.jms.core.JmsTemplate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/servletController")
public class ServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    Persona persona = new Persona();

    CrudRemote crudL = new Crud();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);

        //int idX = Integer.parseInt(request.getParameter("id"));

        try {
            switch (action) {
                case "guardar":
                    guardar(request,response);
                    break;
                case "editar":
                    editar(request,response);
                    break;
                case "borrar":
                    borrar(request,response);
                    break;
                case "buscar":
                    buscar(request,response);
                    break;
                case "listar":
                    listar(request,response);
                    break;
                case "listar1":
                    listar1(request,response);
                    break;
                case "listar2":
                    listar2(request,response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    private void guardar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        persona.setId(Integer.parseInt(request.getParameter("id")));
        persona.setNombre(request.getParameter("nombre"));
        persona.setDireccion(request.getParameter("direccion"));
        persona.setIdentificacion(Integer.parseInt(request.getParameter("identificacion")));
        persona.setFechanacimiento(request.getParameter("fechanacimiento"));
        System.out.println(persona.getNombre());
        crudL.Ingresar(persona);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private void editar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        persona.setId(Integer.parseInt(request.getParameter("id")));
        persona.setNombre(request.getParameter("nombre"));
        persona.setDireccion(request.getParameter("direccion"));
        persona.setIdentificacion(Integer.parseInt(request.getParameter("identificacion")));
        persona.setFechanacimiento(request.getParameter("fechanacimiento"));
        crudL.Editar(persona);
        listar1(request,response);
    }


    //--------------------------------------------------------------------

    //sincronico
//    private void borrar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
//        int id = Integer.parseInt(request.getParameter("id"));
//        crudL.Eliminar(id);
//        RequestDispatcher dispatcher= request.getRequestDispatcher("/listar.jsp");
//        dispatcher.forward(request, response);
//    }
    //asincronico
    private void borrar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        jmsTemplate.convertAndSend( "/queue/personas.borrar", id  );
    }


    private void buscar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        int id = Integer.parseInt(request.getParameter("idB"));
        persona = crudL.Buscar(id);
        request.setAttribute("persona", persona);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/buscar.jsp");
        listar_Buscar(request,response);
    }

    public void listar_Buscar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        List< Persona > listaPersona = crudL.Listar();
        request.setAttribute("listaPersona",listaPersona);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
        dispatcher.forward(request, response);
    }

    public void listar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        List< Persona > listaPersona = crudL.Listar();
        request.setAttribute("listaPersona",listaPersona);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
        dispatcher.forward(request, response);
    }

    public void listar1 (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        List< Persona > listaPersona = crudL.Listar();
        request.setAttribute("listaPersona",listaPersona);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar.jsp");
        dispatcher.forward(request, response);
    }

    public void listar2 (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        //sincronico
        List< Persona > listaPersona = crudL.Listar();
        request.setAttribute("listaPersona",listaPersona);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/eliminar.jsp");
        dispatcher.forward(request, response);
    }
}
