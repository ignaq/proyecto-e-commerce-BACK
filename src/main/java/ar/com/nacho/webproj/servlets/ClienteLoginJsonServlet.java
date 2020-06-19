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
@WebServlet(name = "ClienteLoginJsonServlet", urlPatterns = {"/clienteslogin"})
public class ClienteLoginJsonServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
       
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String userEmail = (request.getParameter("useremail")); 
        String userPass  = (request.getParameter("userpass")); 
       
     
        UsuarioDAO usuarioDAO = new UsuarioDAO(); 
        
        Usuario usuarioLogin = new Usuario();
        
        usuarioLogin.setEmail(userEmail);
        usuarioLogin.setPass(userPass);
        
         ArrayList listaUsuarios;
        
         listaUsuarios = new ArrayList();
       
        
        Usuario usuarioDB = new Usuario();
        usuarioDB = usuarioDAO.getUserLogin(userEmail, userPass);
        
        listaUsuarios.add(usuarioDB);
         
      
          
        Gson gson = new Gson();
       
        RespuestaJson res = new RespuestaJson("ok","",listaUsuarios);
        out.print (gson.toJson(res)); // Deserializacion
        out.flush();
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
