/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nacho.webproj.model.dao;


import ar.com.nacho.webproj.model.entities.Stock;
import ar.com.nacho.webproj.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class StockDAO {
    /*
  public ArrayList<Stock> getListado(){
      
      
      
      ArrayList<Stock> stockProductos = new ArrayList<>();
      
      
      try{
      ConnectionManager connectionManager = new ConnectionManager();
        
      Connection con = connectionManager.getConnection();
      
          PreparedStatement ps;
          ResultSet rs;
          String sql;
        
          //sql = "SELECT stock.stock_id, productos.prod_nombre, talles.talle_nombre, colores.color_nombre , cantidad FROM stock, productos, talles, colores WHERE stock.producto_id = productos.prod_id AND stock.talle_id = talles.talle_id AND stock.color_id = colores.color_id";
   

 sql ="SELECT producto_id, prod_nombre, stock.talle_id, stock.color_id, stock.cantidad FROM productos, stock WHERE prod_id = stock.producto_id";                  
          ps=con.prepareStatement(sql);

          rs=ps.executeQuery();
          
          while (rs.next()){
      //producto_id talle_id color_id stock
            Stock cantidad=new Stock();
            cantidad.setStockID(rs.getInt("producto_id"));
            cantidad.setNombreProducto(rs.getString("prod_nombre"));
            cantidad.setTalleID(rs.getInt("stock.talle_id"));
            cantidad.setColorID(rs.getInt("stock.color_id"));
            cantidad.setCant(rs.getInt("stock.cantidad"));
            
            stockProductos.add(cantidad);
            
              
          }
      } catch (SQLException ex) {
            System.out.println("Error al obtener stock");
        }
        
        return stockProductos;
    
        
  }  */      
  
    public ArrayList<Stock> getListado(){
      
      
      
      ArrayList<Stock> stockProductos = new ArrayList<>();
      
      
      try{
      ConnectionManager connectionManager = new ConnectionManager();
        
      Connection con = connectionManager.getConnection();
      
          PreparedStatement ps;
          ResultSet rs;
          String sql;
        
          //sql = "SELECT stock.stock_id, productos.prod_nombre, talles.talle_nombre, colores.color_nombre , cantidad FROM stock, productos, talles, colores WHERE stock.producto_id = productos.prod_id AND stock.talle_id = talles.talle_id AND stock.color_id = colores.color_id";
   

 //sql ="SELECT prod_nombre, stock.talle_id, stock.color_id, stock.cantidad FROM productos, stock WHERE stock.producto_id = 1 AND stock.talle_id = 2 ";
       
  sql ="SELECT producto_id, prod_nombre, stock.talle_id, stock.color_id, stock.cantidad FROM productos, stock WHERE prod_id = stock.producto_id AND stock.talle_id = 2 AND stock.color_id = 4 ";         
         
          ps=con.prepareStatement(sql);

          rs=ps.executeQuery();
          
          while (rs.next()){
      //producto_id talle_id color_id stock
            Stock cantidad=new Stock();
            cantidad.setStockID(rs.getInt("producto_id"));
            cantidad.setNombreProducto(rs.getString("prod_nombre"));
            cantidad.setTalleID(rs.getInt("stock.talle_id"));
            cantidad.setColorID(rs.getInt("stock.color_id"));
            cantidad.setCant(rs.getInt("stock.cantidad"));
            
            stockProductos.add(cantidad);
            
              
          }
      } catch (SQLException ex) {
            System.out.println("Error al obtener stock");
        }
        
        return stockProductos;
    
        
  }        
  
    public ArrayList<Stock> getColores( int idTalles , int idColores){
      
      
      
      ArrayList<Stock> cantidades = new ArrayList<>();
      
      
      try{
      ConnectionManager connectionManager = new ConnectionManager();
        
      Connection con = connectionManager.getConnection();
      
          PreparedStatement ps;
          ResultSet rs;
          String sql;
        
   
       
  sql ="SELECT producto_id, prod_nombre, stock.talle_id, stock.color_id, stock.cantidad "
          + " FROM productos, stock "
          + " WHERE prod_id = stock.producto_id "
          + " AND stock.talle_id = " + idTalles + " AND stock.color_id = " + idColores ;         
         
          ps=con.prepareStatement(sql);

          rs=ps.executeQuery();
          
          while (rs.next()){
     
            Stock cantidad=new Stock();
            cantidad.setStockID(rs.getInt("producto_id"));
            cantidad.setNombreProducto(rs.getString("prod_nombre"));
            cantidad.setTalleID(rs.getInt("stock.talle_id"));
            cantidad.setColorID(rs.getInt("stock.color_id"));
            cantidad.setCant(rs.getInt("stock.cantidad"));
            
            cantidades.add(cantidad);
            
              
          }
      } catch (SQLException ex) {
            System.out.println("Error al obtener stock");
        }
        
        return cantidades;
    
        
  } 
  
    // // a partir del talle devuelve los colores 
   public ArrayList<Stock> getTalles( int idproducto ,int idTalles){
      
      
      
      ArrayList<Stock> cantidades = new ArrayList<>();
      
      
      try{
      ConnectionManager connectionManager = new ConnectionManager();
        
      Connection con = connectionManager.getConnection();
      
          PreparedStatement ps;
          ResultSet rs;
          String sql;
        
sql="SELECT producto_id, stock.talle_id, stock.color_id, colores.color_nombre, stock.cantidad FROM stock, colores WHERE " + idproducto + " = stock.producto_id AND stock.talle_id = " + idTalles + " AND stock.color_id = colores.color_id";      
 
 // sql="SELECT producto_id, stock.talle_id, stock.color_id, stock.cantidad FROM stock WHERE " + idproducto + "= stock.producto_id AND stock.talle_id = "+ idTalles;
        
          ps=con.prepareStatement(sql);

          rs=ps.executeQuery();
          
          while (rs.next()){
      
            Stock cantidad=new Stock();
            cantidad.setStockID(rs.getInt("stock.producto_id"));
            cantidad.setTalleID(rs.getInt("stock.talle_id"));
            cantidad.setColorID(rs.getInt("stock.color_id"));
            cantidad.setColor(rs.getString("colores.color_nombre"));
            cantidad.setCant(rs.getInt("stock.cantidad"));
            
            cantidades.add(cantidad);
           
              
          }
      } catch (SQLException ex) {
            System.out.println("Error al obtener el color");
        }
        
        return cantidades;
    
        
  }   
    //devuelve el stock disponible
   public Stock getCantidad( int idproducto ,int idTalles, int idColor){
      
      
      
       Stock cantidad=new Stock();
      
      
      try{
      ConnectionManager connectionManager = new ConnectionManager();
        
      Connection con = connectionManager.getConnection();
      
          PreparedStatement ps;
          ResultSet rs;
          String sql;
        
      
   /*    
  sql ="SELECT producto_id, prod_nombre, stock.talle_id, stock.color_id, stock.cantidad "
          + " FROM productos, stock "
          + "WHERE "+ idproducto + " = stock.producto_id " + " AND stock.talle_id = " + idTalles;        
    */
  //sql="SELECT producto_id, stock.talle_id, stock.color_id, stock.cantidad FROM stock WHERE " + idproducto + "= stock.producto_id AND stock.talle_id = "+ idTalles;
  
  sql ="SELECT  stock.cantidad FROM stock WHERE " + idproducto + " = stock.producto_id AND stock.talle_id = " + idTalles  + " AND stock.color_id = "+ idColor;

          ps=con.prepareStatement(sql);

          rs=ps.executeQuery();
          
          if (rs.next()){
     
            
            
            cantidad.setCant(rs.getInt("stock.cantidad"));
            
            
           } 
            ps.close();
            rs.close();
            con.close();
      } catch (SQLException ex) {
            System.out.println("Error al obtener stock");
        }
        
        return cantidad;
    
        
  }    
   
   
   
   
   public void guardarStock (Stock stock){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            
            sql="INSERT INTO stock (producto_id, talle_id, color_id, cantidad) VALUES (?, ?, ?, ?)";      

            stm = con.prepareStatement(sql);
            
            stm.setInt(1, stock.getStockID());
            stm.setInt(2, stock.getTalleID());
            stm.setInt(3, stock.getColorID());
            stm.setInt(4, stock.getCant());   
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al guardar stock");
        }
    } 
  
     public void eliminarStock (int id){
 
        try {
            ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;
            
            sql = "DELETE FROM stock  WHERE stock_id= ? ";
                   
            
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, id);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el stock");
        }
  
    
    
  }
}
    
    

