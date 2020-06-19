
package ar.com.nacho.webproj.model.dao;

import ar.com.nacho.webproj.model.entities.Producto;
import ar.com.nacho.webproj.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductosDAO {


    
    
    public ArrayList<Producto> getListadoDeProductos(){
        
        ArrayList<Producto> listaProductos = new ArrayList<>();       
        
        
             try {  
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            PreparedStatement ps;
            ResultSet rs;
            String sql;
                 
        
            sql = "SELECT * FROM productos";
            
            stm = con.createStatement();
            
            rs = stm.executeQuery( sql );
            
        while( rs.next() ){
                
    

                
            Producto producto = new Producto();
                
            producto.setId( rs.getInt("prod_id") );
            producto.setNombre(rs.getString("prod_nombre") );
            producto.setDescripcion(rs.getString("prod_descripcion"));
            producto.setPrecio(rs.getFloat("prod_precio") );
            producto.setImagen(rs.getString("prod_img") );    
                
            listaProductos.add(producto);                
        }
            
            
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de productos");
        }
        
        return listaProductos;
    }

  
  public  Producto obtenerProducto(int codigo){
      
      
      Producto p = new Producto();
      
       
       try{
           ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            Statement stm;
            ResultSet rs;
            String sql; 
           
           sql = "SELECT * FROM productos WHERE prod_id = " + codigo;
             
            stm = con.createStatement();
            
            rs = stm.executeQuery( sql );
            
            
              
             if ( rs.next() ){
            
             p.setId(rs.getInt("prod_id"));
             p.setNombre(rs.getString("prod_nombre"));
             p.setDescripcion(rs.getString("prod_descripcion"));
             p.setPrecio(rs.getFloat("prod_precio"));
             p.setImagen(rs.getString("prod_img") );   
          
             
            } 
            stm.close();
            rs.close();
            con.close();
             } catch (SQLException ex) {
            System.out.println("Error al obtener el id");
        }
      
      
    return p;
    }

 
    public void guardarProducto (Producto producto){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            String sql;
            
            
            
            if (producto.getId() == 0 ){
             
             sql = "INSERT INTO productos (prod_nombre, prod_descripcion, prod_precio, prod_img ) VALUES (?,?,?,?) ";   
                
            }else{
                sql = "UPDATE productos SET prod_nombre=?, prod_descripcion=?, prod_precio=?, prod_img=?"  
                       + " WHERE prod_id=?";
            }
           
            stm = con.prepareStatement(sql);
            
            stm.setString(1, producto.getNombre());
            stm.setString(2, producto.getDescripcion() );
            stm.setFloat(3, producto.getPrecio());
            stm.setString(4, producto.getImagen() );   
            
            
            
            if (producto.getId() != 0 ){
                stm.setInt(5, producto.getId());
            }
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("error de modificacion");
        }
    }  
  
 public void eliminarProducto(int id){
      
      
       
       try{
           
           ConnectionManager connectionManager = new ConnectionManager();
            
            Connection con = connectionManager.getConnection();
                        
            PreparedStatement stm;
            String sql;  
           
            sql = "DELETE FROM productos WHERE prod_id = ?";
             
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, id);
            
            stm.executeUpdate();
            
             
            stm.close();
            con.close();
             } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente");
        }
      
     
    
}

}