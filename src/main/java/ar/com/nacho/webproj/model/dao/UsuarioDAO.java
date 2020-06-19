
package ar.com.nacho.webproj.model.dao;

import ar.com.nacho.webproj.model.entities.Usuario;
import ar.com.nacho.webproj.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class UsuarioDAO {
    
   ConnectionManager connectionManager = new ConnectionManager();
        
        Connection con = connectionManager.getConnection();
        
        Statement stm;
        ResultSet rs;
        String sql;
    
    
    
    
    public ArrayList<Usuario> getListado (){
        
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
       
        
        try {
        
        
        sql ="SELECT * FROM usuarios";
        
        
        stm = con.createStatement();
        
        
        rs = stm.executeQuery(sql);
        
        
       while( rs.next() ){
                


              

            Usuario user = new Usuario();
                
            user.setId( rs.getInt("user_id") );       
            user.setNombre(rs.getString("user_nombre"));
            user.setApellido(rs.getString("user_apellido"));
            user.setEmail(rs.getString("user_email") );
            user.setPass(rs.getString("user_pass") );
                
                
            listaUsuarios.add(user);                
        }
            
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado usuarios");
        }
        
        return listaUsuarios;
}
  
 public Usuario getUsuario (int id){
        
        Usuario user = new Usuario();
       
        
        try {
        
        sql ="SELECT * FROM usuarios WHERE user_id = " + id;
        stm = con.createStatement();
        rs = stm.executeQuery(sql);
        
        if( rs.next() ){    

            user.setId( rs.getInt("user_id") );       
            user.setNombre(rs.getString("user_nombre"));
            user.setApellido(rs.getString("user_apellido"));
            user.setEmail(rs.getString("user_email") );
            user.setPass(rs.getString("user_pass") );
        }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los datos del usuarios");
        }
        
        return user;
}
  

    


  public Usuario getUserLogin (String email, String pass) {
        
        Usuario usuario = new Usuario();
        
        try {
            
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();

            PreparedStatement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM usuarios WHERE user_email =? "
                    + " and user_pass=? ";

            stm = con.prepareStatement(sql);
            
            stm.setString(1, email);
            stm.setString(2, pass);
            
            rs = stm.executeQuery();

            if(rs.next()) {
                
                    usuario.setNombre(rs.getString("user_nombre"));
                    usuario.setApellido(rs.getString("user_apellido"));
                    usuario.setEmail(rs.getString("user_email"));
                   
                
             
            }
            
            stm.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener el usuario");
            System.out.println(ex);
        }
        
        return usuario;
        
    }
    
    
    
 public ArrayList buscar (String texto){
     ArrayList<Usuario> lista = new ArrayList<>();
     String sql;
     sql = "SELECT * FROM usuarios WHERE user_id like '%"+texto+"%' or user_nombre like '%"+texto+"%' or user_apellido like '%"+texto+"%' ";
      
        try {
        
        stm = con.createStatement();
        rs = stm.executeQuery(sql);

              while (rs.next()){
                
                Usuario user = new Usuario();
                
                user.setId( rs.getInt("user_id") );       
                user.setNombre(rs.getString("user_nombre"));
                user.setApellido(rs.getString("user_apellido"));
                user.setEmail(rs.getString("user_email") );
                user.setPass(rs.getString("user_pass") );
                
                lista.add(user);
              }
 
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al realizar la busqueda");
        }
        return lista;
 }
    
  public void crearUsuario (Usuario usuario){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "INSERT INTO usuarios (user_nombre, user_apellido, user_email, user_pass ) VALUES (?,?,?,?) ";
                  

            stm = con.prepareStatement(sql);
            
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getApellido());
            stm.setString(3, usuario.getEmail());
            stm.setString(4, usuario.getPass());   
            
      
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al registrarse");
        }
    }     
    


  
}
