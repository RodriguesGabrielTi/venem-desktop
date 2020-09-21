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
import model.Aluno;

/**
 *
 * @author paulojp
 */
public class BdAluno {
    
    /* ----CONEXÃO COM O BD-> */
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdAluno() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----CLIENTE-> */
    
    // CREATE - Adiciona um registro
    public void adicionaAluno(Aluno c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO aluno(matricula, nomeAluno, curso, serie, nivel)"
                + "VALUES(?, ?, ?, ?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setInt(1, c.getMatricula());
        stmt.setString(2, c.getNomeAluno());
        stmt.setString(3, c.getCurso());
        stmt.setInt(4, c.getSerie());
        stmt.setInt(5, c.getNivel());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Aluno> getListaMatricula(int mat) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM aluno WHERE matricula = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, mat);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Aluno> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Aluno c = new Aluno();
            
            // "c" -> Aluno novo - .setNome recebe o campo do banco de String "nome" 
            c.setMatricula(Integer.valueOf(rs.getString("matricula")));
            c.setNomeAluno(rs.getString("nomeAluno"));
            c.setCurso(rs.getString("curso"));
            c.setSerie(Integer.valueOf(rs.getString("serie")));
            c.setNivel(Integer.valueOf(rs.getString("nivel")));
            
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
    public List<Aluno> getLista(String nomeAluno) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM aluno WHERE nomeAluno like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nomeAluno);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Aluno> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Aluno c = new Aluno();
            
            // "c" -> Aluno novo - .setNome recebe o campo do banco de String "nome" 
            c.setMatricula(Integer.valueOf(rs.getString("matricula")));
            c.setNomeAluno(rs.getString("nomeAluno"));
            c.setCurso(rs.getString("curso"));
            c.setSerie(Integer.valueOf(rs.getString("serie")));
            c.setNivel(Integer.valueOf(rs.getString("nivel")));
            
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
    public void altera(Aluno c) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE aluno set nomeAluno=?, curso=?, serie=?, nivel=? "
                + "WHERE matricula=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setInt(5, c.getMatricula());
        stmt.setString(1, c.getNomeAluno());
        stmt.setString(2, c.getCurso());
        stmt.setInt(3, c.getSerie());
        stmt.setInt(4, c.getNivel());
   
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
    
    // DELETE - Apaga registros
    public void remove(int matricula) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM aluno WHERE matricula=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, matricula);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }
    /* <-CLIENTE---- */
}
