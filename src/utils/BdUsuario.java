
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author santi
 */
public class BdUsuario {
    
    public boolean checkLogin(int id, String senha) throws SQLException{
        
        Connection con = CriaConexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM usuarioadm WHERE idUsuario = ? and senha = ?");
            stmt.setInt(1, id);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                check = true;
            }
            
        }catch (SQLException ex) {           
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            CriaConexao.closeConnection(con, stmt, rs);
        }
        
        return check;
    
    }
    
    
    
    
}
