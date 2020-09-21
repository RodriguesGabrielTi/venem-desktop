/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author paulojp
 */
public class CriaConexao {
    
    public static Connection getConexao() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco de dados.");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(null, "Erro na conexão com banco de dados", "Alerta", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("Erro na conexão: ", ex);
        }   
        
    }
    
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CriaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CriaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CriaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
