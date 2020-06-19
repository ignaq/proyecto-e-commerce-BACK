/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nacho.webproj.servlets;

import ar.com.nacho.webproj.ajax.RespuestaJson;
import ar.com.nacho.webproj.model.dao.UsuarioDAO;
import ar.com.nacho.webproj.model.entities.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nacho
 */
@WebServlet(name = "ClientesjsonServlet", urlPatterns = {"/clientesjson"})
public class ClientesjsonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
       
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("useremail")); 
        System.out.println(request.getParameter("userpass")); 
       
       UsuarioDAO userdao = new UsuarioDAO();
       
       ArrayList listaUsuarios;
       
       //Si existe el usuario
       if( request.getParameter("id") != null ){
           Usuario usuario = userdao.getUsuario(Integer.parseInt(request.getParameter("id")) );
       
           listaUsuarios = new ArrayList();
           listaUsuarios.add(usuario);
           
           //METO EL USUARIO EN UN ARRAYLIST PORQUE SE DECLARO UN ARRAYLIST COMO RESPUESTA
       }else{
           listaUsuarios = userdao.getListado();
       }
     
       
        Gson gson = new Gson();
       
        RespuestaJson res = new RespuestaJson("ok","",listaUsuarios);
        out.print (gson.toJson(res)); // Deserializacion
        out.flush();
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("nameNewUser")); 
        System.out.println(request.getParameter("lastNameNewUser")); 
        System.out.println(request.getParameter("emailNewUser")); 
        System.out.println(request.getParameter("pass1")); 
     
       
    }

   
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
