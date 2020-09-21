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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;

/**
 *
 * @author paulojp
 */
public class BdEmprestimoProfessor {
    
    /* ----CONEXÃO COM O BD-> */
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdEmprestimoProfessor() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----EMPRESTIMO-> */
    
    // CREATE - Adiciona um registro
    public void adicionaEmprestimo(Emprestimo e) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO emprestimoprofessor(idEmprestimo, idProfessor, registro, dataDoEmprestimo, dataDeEntrega) VALUES(NULL, ?, ?, ?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setInt(1, e.getIdProfessor());
        stmt.setInt(2, e.getRegistro());
        stmt.setString(3, e.getData_emprestimo());
        stmt.setString(4, e.getData_devolucao());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Emprestimo> getLista(int id) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM emprestimoprofessor WHERE idEmprestimo like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo e = new Emprestimo();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            e.setId_emprestimo(Integer.valueOf(rs.getString("idEmprestimo")));
            e.setIdProfessor(Integer.valueOf(rs.getString("idProfessor")));
            e.setRegistro(Integer.valueOf(rs.getString("registro")));
            e.setData_emprestimo(rs.getString("dataDoEmprestimo"));
            e.setData_devolucao(rs.getString("dataDeEntrega"));
            
            // Adiciona o registro na lista
            lista.add(e);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Emprestimo> getListaCompleta() throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM emprestimoprofessor";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo e = new Emprestimo();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            e.setId_emprestimo(Integer.valueOf(rs.getString("idEmprestimo")));
            e.setIdProfessor(Integer.valueOf(rs.getString("idProfessor")));
            e.setRegistro(Integer.valueOf(rs.getString("registro")));
            e.setData_emprestimo(rs.getString("dataDoEmprestimo"));
            e.setData_devolucao(rs.getString("dataDeEntrega"));
            
            // Adiciona o registro na lista
            lista.add(e);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com todos os empréstimos atrasados
    public List<Emprestimo> getListaAtrasado() throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM emprestimoprofessor";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //Verifica se existe diferença entre a data atual e a data de entrega do emprétimo
            LocalDate atual = LocalDate.now();
            LocalDate dataDevolucao = LocalDate.parse(rs.getString("dataDeEntrega")); 
            long diferenca = 0;
            
            //se tiver atrasado passa o resultado para a lista
            if (dataDevolucao.compareTo(atual) < 0) {    
                //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
                Emprestimo e = new Emprestimo();
            
                // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
                e.setId_emprestimo(Integer.valueOf(rs.getString("idEmprestimo")));
                e.setIdProfessor(Integer.valueOf(rs.getString("idProfessor")));
                e.setRegistro(Integer.valueOf(rs.getString("registro")));
                e.setData_emprestimo(rs.getString("dataDoEmprestimo"));
                e.setData_devolucao(rs.getString("dataDeEntrega"));
            
                // Adiciona o registro na lista
                lista.add(e);
            }            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com as multas de um clientes epecífico
    public List<Emprestimo> getListaPorCliente(String idProfessor) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT emprestimoprofessor.idEmprestimo, emprestimoprofessor.idProfessor, emprestimoprofessor.registro, emprestimoprofessor.dataDoEmprestimo, emprestimoprofessor.dataDeEntrega" +
                    " FROM emprestimoprofessor" +
                    " INNER JOIN professor" +
                    " ON emprestimoprofessor.idProfessor = professor.idProfessor" +
                    " WHERE emprestimoprofessor.idProfessor = ?;";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, Integer.valueOf(idProfessor));
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo e = new Emprestimo();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            e.setId_emprestimo(Integer.valueOf(rs.getString("emprestimoprofessor.idEmprestimo")));
            e.setIdProfessor(Integer.valueOf(rs.getString("emprestimoprofessor.idProfessor")));
            e.setRegistro(Integer.valueOf(rs.getString("emprestimoprofessor.registro")));
            e.setData_emprestimo(rs.getString("emprestimoprofessor.dataDoEmprestimo"));
            e.setData_devolucao(rs.getString("emprestimoprofessor.dataDeEntrega"));
            
            // Adiciona o registro na lista
            lista.add(e);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com o emprestimo do livro
    public List<Emprestimo> getListaPorLivro(int registro) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT emprestimoprofessor.idEmprestimo, emprestimoprofessor.idProfessor, emprestimoprofessor.registro, emprestimoprofessor.dataDoEmprestimo, emprestimoprofessor.dataDeEntrega" +
                    " FROM emprestimoprofessor" +
                    " INNER JOIN livro" +
                    " ON emprestimoprofessor.registro = livro.registro" +
                    " WHERE emprestimoprofessor.registro = ?;";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, registro);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo e = new Emprestimo();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            e.setId_emprestimo(Integer.valueOf(rs.getString("emprestimoprofessor.idEmprestimo")));
            e.setIdProfessor(Integer.valueOf(rs.getString("emprestimoprofessor.idProfessor")));
            e.setRegistro(Integer.valueOf(rs.getString("emprestimoprofessor.registro")));
            e.setData_emprestimo(rs.getString("emprestimoprofessor.dataDoEmprestimo"));
            e.setData_devolucao(rs.getString("emprestimoprofessor.dataDeEntrega"));
            
            // Adiciona o registro na lista
            lista.add(e);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Verifica se o cliente tem alguma multa
    public List<Emprestimo> verificaEmprestimoProfessor(int mat) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM emprestimoprofessor "
                + "WHERE idProfessor=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
       
        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(1, mat);
        // Recebe o resultado da consulta SQL
        
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
  
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Emprestimo e = new Emprestimo();
            
            e.setRegistro(rs.getInt("registro"));
            // Adiciona o registro na lista
            lista.add(e);
            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;   
    }
    
    
    // DELETE - Apaga registros
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM emprestimoprofessor WHERE idEmprestimo=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, id);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }
    /* <-EMPRESTIMO---- */
}
