/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

/**
 *
 * @author santi
 */
public class BdProfessor {
    
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdProfessor() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----CLIENTE-> */
    
    // CREATE - Adiciona um registro
    public void adicionaProfessor(Professor c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO professor(nomeProfessor, disciplinaProfessor)"
                + "VALUES(?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, c.getNomeProfessor());
        stmt.setString(2, c.getDisciplina());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Professor> getLista(String nomeProfessor) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM professor WHERE nomeProfessor like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nomeProfessor);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Professor> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Professor c = new Professor();
            
            // "c" -> Professor novo - .setNome recebe o campo do banco de String "nome" 
            c.setIdProfessor(Integer.valueOf(rs.getString("idProfessor")));
            c.setNomeProfessor(rs.getString("nomeProfessor"));
            c.setDisciplina(rs.getString("DisciplinaProfessor"));
            
            // Adiciona o registro na lista
            lista.add(c);            
        }
        
        
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Professor> getListaIdProfessor(int mat) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM professor WHERE idProfessor = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, mat);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Professor> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Professor c = new Professor();
            
            // "c" -> Professor novo - .setNome recebe o campo do banco de String "nome" 
            c.setIdProfessor(Integer.valueOf(rs.getString("idProfessor")));
            c.setNomeProfessor(rs.getString("nomeProfessor"));
            c.setDisciplina(rs.getString("disciplinaProfessor"));
            
            // Adiciona o registro na lista
            lista.add(c);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;  
    }
       
    // UPDATE - Atualiza registros
    public void altera(Professor c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE professor set nomeProfessor=?, disciplinaProfessor=? "
                + "WHERE idProfessor=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setInt(3, c.getIdProfessor());
        stmt.setString(1, c.getNomeProfessor());
        stmt.setString(2, c.getDisciplina());
   
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
    
    // DELETE - Apaga registros
    public void remove(int idProfessor) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM professor WHERE idProfessor=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, idProfessor);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }

    
}
