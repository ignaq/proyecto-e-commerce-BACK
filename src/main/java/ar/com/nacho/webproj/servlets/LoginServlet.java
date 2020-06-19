/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nacho.webproj.servlets;

import ar.com.nacho.webproj.model.dao.UsuarioDAO;
import ar.com.nacho.webproj.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nacho
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

      
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
       
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
    
        
        
        
       /*
        
         HttpSession sesion = request.getSession(); //pido sesión para chequear si está logueado
        
        if ( sesion.getAttribute("user") != null ){ // si está logueado lo envió al index
        
            request.getRequestDispatcher("productos").forward(request, response);
        
        }else {
           
        request.getRequestDispatcher("login.jsp").forward(request, response);
    
        
    }*/
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession sesion = request.getSession();
           /*
            String emailUser = request.getParameter("emailUser");
            
            String passUser = request.getParameter ("passUser");
                    
             if (emailUser.equals("asd@com") && passUser.equals("123") ){
        
            sesion.setAttribute("user", emailUser);
            request.getRequestDispatcher("productos").forward(request, response);
            }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            */
            
            
            
     /*   String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("ingresar")){
        ;
            user=userdao.validar(emailUser, passUser);
            if(user.getEmail()!=null){
                request.getRequestDispatcher("Controlador?accion=productos").forward(request, response);
        }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
        
        }
        }*/
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
