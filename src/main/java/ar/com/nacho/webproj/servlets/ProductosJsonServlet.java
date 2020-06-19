/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nacho.webproj.servlets;

import ar.com.nacho.webproj.ajax.RespuestaJson;
import ar.com.nacho.webproj.model.dao.ProductosDAO;
import ar.com.nacho.webproj.model.entities.Producto;
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
@WebServlet(name = "ProductosJsonServlet", urlPatterns = {"/productosjson"})
public class ProductosJsonServlet extends HttpServlet {

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
        
       ProductosDAO prodDAO = new ProductosDAO();
        
        ArrayList listaProductos;
        
        if ( request.getParameter("id") != null ){
                Producto producto = prodDAO.obtenerProducto( Integer.parseInt (request.getParameter("id")) );
                //agrego un producto en el array declarado en el json
             listaProductos = new ArrayList();
             listaProductos.add(producto);
        }else{
          //si no viene con ID devuelve toda la lista de productos   
            listaProductos = prodDAO.getListadoDeProductos();
        }
        
        Gson gson = new Gson();
       
        RespuestaJson res = new RespuestaJson("ok","",listaProductos);
        out.print (gson.toJson(res)); // Deserializacion
        out.flush();
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        
        String nuevoProd = request.getParameter("nombre");
        String descripProd = request.getParameter("descripcion");
        String imgProd = request.getParameter("foto");
        Float precioProd = Float.parseFloat(request.getParameter("precio"));
        
        ProductosDAO productosDao = new ProductosDAO();
        Producto producto = new Producto();
        
        producto.setId(0);
        producto.setNombre(nuevoProd);
        producto.setDescripcion(descripProd);
        producto.setImagen(imgProd);
        producto.setPrecio(precioProd);
        productosDao.guardarProducto(producto);
        
        
        Gson gson = new Gson();
        RespuestaJson res = new RespuestaJson("ok", "El producto ha sido guardado exitosamente ",new ArrayList() );
        out.print(gson.toJson(res));
        out.flush();
    }

      @Override
    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        ProductosDAO productosDao = new ProductosDAO();
        
        productosDao.eliminarProducto( Integer.parseInt (request.getParameter("id")) );
        
        RespuestaJson res = new RespuestaJson("ok", "El producto ha sido eliminado exitosamente ",new ArrayList() );
        
        Gson gson = new Gson();
        
        out.print(gson.toJson(res));
        out.flush();
    }
    
      @Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        ProductosDAO productosDao = new ProductosDAO();
        Producto producto = new Producto();
        
        producto.setId( Integer.parseInt( request.getParameter("id")) );
        producto.setNombre( request.getParameter("nombre")) ;
        producto.setDescripcion( request.getParameter("descripcion")) ;
        producto.setImagen( request.getParameter("foto")) ;
        producto.setPrecio ( Float.parseFloat(request.getParameter("precio")) );
        productosDao.guardarProducto(producto);
       
        
        
        Gson gson = new Gson();
        RespuestaJson res = new RespuestaJson("ok", "El producto ha sido modificado exitosamente ",new ArrayList() );
        out.print(gson.toJson(res));
        out.flush();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
