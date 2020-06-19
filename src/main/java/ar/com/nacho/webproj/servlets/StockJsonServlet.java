/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nacho.webproj.servlets;

import ar.com.nacho.webproj.ajax.RespuestaJson;
import ar.com.nacho.webproj.model.dao.StockDAO;
import ar.com.nacho.webproj.model.entities.Stock;
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
@WebServlet(name = "StockJsonServlet", urlPatterns = {"/stockjson"})
public class StockJsonServlet extends HttpServlet {

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

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
      
       
     String idproducto = (request.getParameter("producto"));
     String idtalle =(request.getParameter("talle"));
       
       
        
       int val = Integer.parseInt(idproducto.trim());
       int val2 = Integer.parseInt(idtalle.trim());
      
    
        String idColor = (request.getParameter("color"));
      
       
        StockDAO stockDAO = new StockDAO();
        ArrayList stockProductos;
          
        if (idColor != null && !idColor.equals("")) {
          int val3 = Integer.parseInt(idColor.trim());
            Stock stock = stockDAO.getCantidad( val , val2 , val3) ;
          
         
             stockProductos = new ArrayList();
             stockProductos.add(stock);
              
        }else{
             stockProductos = stockDAO.getTalles(val , val2 );
        
        }
        
       
        Gson gson = new Gson();
        RespuestaJson res = new RespuestaJson("ok","",stockProductos);
        
        out.print (gson.toJson(res)); // Deserializacion
      
        out.flush(); 
        
     
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
