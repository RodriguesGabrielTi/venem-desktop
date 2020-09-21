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
import model.Livro;

/**
 *
 * @author paulojp
 */
public class BdLivro {
    
    /* ----CONEXÃO COM O BD-> */
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdLivro() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----LIVRO-> */
    
    // CREATE - Adiciona um registro
    public void adicionaLivro(Livro l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO livro(registro, cdu, cdd, anoTombamento, autor, disciplina, titulo, serieDidatica, quantidade, volume, local, editora, anoPublicacao"
                + ", formaAdquirida, observacao) "        
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";       
        PreparedStatement stmt;
        // stmt recebe o comando SQL
        stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setInt(1, l.getRegistro());
        stmt.setString(2, l.getCdu());
        stmt.setInt(3, l.getCdd());
        stmt.setInt(4, l.getAnoTombamento());
        stmt.setString(5, l.getAutor());
        stmt.setString(6, l.getDisciplina());
        stmt.setString(7, l.getTitulo());
        stmt.setInt(8, l.getSerieDidatica());
        stmt.setInt(9, l.getQuantidade());
        stmt.setInt(10, l.getVolume());
        stmt.setString(11, l.getLocal());
        stmt.setString(12, l.getEditora());
        stmt.setInt(13, l.getAnoPublicacao());
        stmt.setString(14, l.getFormaAdquirida());
        stmt.setString(15, l.getObservacao());

        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Livro> getLista(String titulo) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM livro WHERE titulo LIKE ? ORDER BY `livro`.`titulo` ASC";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, titulo);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        System.out.println(rs);
        
        List<Livro> lista = new ArrayList<>();
        
  
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Livro l = new Livro();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            l.setRegistro(Integer.valueOf(rs.getString("registro")));
            l.setCdu(rs.getString("cdu"));
            l.setCdd(rs.getInt("cdd"));
            l.setAnoTombamento(rs.getInt("anoTombamento"));
            l.setAutor(rs.getString("autor"));
            l.setDisciplina(rs.getString("disciplina"));
            l.setTitulo(rs.getString("titulo"));
            l.setSerieDidatica(rs.getInt("serieDidatica"));
            l.setQuantidade(rs.getInt("quantidade"));
            l.setVolume(rs.getInt("volume"));
            l.setLocal(rs.getString("local"));
            l.setEditora(rs.getString("editora"));
            l.setAnoPublicacao(rs.getInt("anoPublicacao"));
            l.setDisponibilidade(rs.getBoolean("disponibilidade"));
            l.setFormaAdquirida(rs.getString("formaAdquirida"));
            l.setObservacao(rs.getString("observacao"));
            // Adiciona o registro na lista
            lista.add(l);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta de livros emprestados
    public List<Livro> getListaEmprestados(String titulo) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM livro WHERE titulo LIKE ? AND disponibilidade=false";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, titulo);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        System.out.println(rs);
        
        List<Livro> lista = new ArrayList<>();
        
  
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Livro l = new Livro();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            l.setRegistro(Integer.valueOf(rs.getString("registro")));
            l.setCdu(rs.getString("cdu"));
            l.setCdd(rs.getInt("cdd"));
            l.setAnoTombamento(rs.getInt("anoTombamento"));
            l.setAutor(rs.getString("autor"));
            l.setDisciplina(rs.getString("disciplina"));
            l.setTitulo(rs.getString("titulo"));
            l.setSerieDidatica(rs.getInt("serieDidatica"));
            l.setQuantidade(rs.getInt("quantidade"));
            l.setVolume(rs.getInt("volume"));
            l.setLocal(rs.getString("local"));
            l.setEditora(rs.getString("editora"));
            l.setAnoPublicacao(rs.getInt("anoPublicacao"));
            l.setDisponibilidade(rs.getBoolean("disponibilidade"));
            l.setFormaAdquirida(rs.getString("formaAdquirida"));
            l.setObservacao(rs.getString("observacao"));
            // Adiciona o registro na lista
            lista.add(l);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Seleciona um registro
    public List<Livro> select(int r) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM livro "
                + "WHERE registro = ?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setInt(1, r);
        
        ResultSet rs = stmt.executeQuery();

        
        List<Livro> lista = new ArrayList<>();
        
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Livro l = new Livro();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            l.setRegistro(Integer.valueOf(rs.getString("registro")));
            l.setCdu(rs.getString("cdu"));
            l.setCdd(rs.getInt("cdd"));
            l.setAnoTombamento(rs.getInt("anoTombamento"));
            l.setAutor(rs.getString("autor"));
            l.setDisciplina(rs.getString("disciplina"));
            l.setTitulo(rs.getString("titulo"));
            l.setSerieDidatica(rs.getInt("serieDidatica"));
            l.setQuantidade(rs.getInt("quantidade"));
            l.setVolume(rs.getInt("volume"));
            l.setLocal(rs.getString("local"));
            l.setEditora(rs.getString("editora"));
            l.setAnoPublicacao(rs.getInt("anoPublicacao"));
            l.setDisponibilidade(rs.getBoolean("disponibilidade"));
            l.setFormaAdquirida(rs.getString("formaAdquirida"));
            l.setObservacao(rs.getString("observacao"));
            // Adiciona o registro na lista
            lista.add(l);

        }
          

        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        return lista;
    }
    
    
    // UPDATE - Atualiza registros
    public void altera(Livro l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE livro SET cdu = ?, cdd = ?, anoTombamento = ?, autor = ?, disciplina = ?, titulo = ?, serieDidatica = ?, quantidade = ?, volume = ?, local =?, editora = ?, anoPublicacao = ?"
                + ", formaAdquirida = ?, observacao = ? "
                + "WHERE registro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setString(1, l.getCdu());
        stmt.setInt(2, l.getCdd());
        stmt.setInt(3, l.getAnoTombamento());
        stmt.setString(4, l.getAutor());
        stmt.setString(5, l.getDisciplina());
        stmt.setString(6, l.getTitulo());
        stmt.setInt(7, l.getSerieDidatica());
        stmt.setInt(8, l.getQuantidade());
        stmt.setInt(9, l.getVolume());
        stmt.setString(10, l.getLocal());
        stmt.setString(11, l.getEditora());
        stmt.setInt(12, l.getAnoPublicacao());
        stmt.setString(13, l.getFormaAdquirida());
        stmt.setString(14, l.getObservacao());
        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(15, l.getRegistro());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
    
    // UPDATE - Altera a disponibilidade do livro
    public void alteraDisponibilidadeLivro(Livro l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE livro set disponibilidade = ?  "
                + "WHERE registro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setBoolean(1, l.getDisponibilidade());
        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(2, l.getRegistro());
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
    }
    
    public List<Livro> verificaDisponibilidade(int reg) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT disponibilidade FROM livro "
                + "WHERE registro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
       
        // Usa o ID como parâmetro de comparação no SQL
        stmt.setInt(1, reg);
        // Recebe o resultado da consulta SQL
        
        ResultSet rs = stmt.executeQuery();
        
        List<Livro> lista = new ArrayList<>();
        
  
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Livro l = new Livro();
            
            l.setDisponibilidade(rs.getBoolean("disponibilidade"));
            // Adiciona o registro na lista
            lista.add(l);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;   
    }
    
    // DELETE - Apaga registros
    public void remove(int registro) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM livro WHERE registro=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, registro);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();
        
    }
    /* <-LIVRO---- */
}
