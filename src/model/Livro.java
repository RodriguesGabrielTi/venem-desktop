/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Leirbag
 */
public class Livro {
    
    private int registro;
    private String cdu;
    private int cdd;
    private int anoTombamento;
    private String autor;
    private String disciplina;
    private String titulo;
    private int serieDidatica;
    private int quantidade;
    private int volume;
    private String local;
    private String editora;
    private int anoPublicacao;
    private boolean disponibilidade;
    private String formaAdquirida;
    private String observacao;
    private String fotoCapa;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getCdu() {
        return cdu;
    }

    public void setCdu(String cdu) {
        this.cdu = cdu;
    }

    public int getCdd() {
        return cdd;
    }

    public void setCdd(int cdd) {
        this.cdd = cdd;
    }

    public int getAnoTombamento() {
        return anoTombamento;
    }

    public void setAnoTombamento(int anoTombamento) {
        this.anoTombamento = anoTombamento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getSerieDidatica() {
        return serieDidatica;
    }

    public void setSerieDidatica(int serieDidatica) {
        this.serieDidatica = serieDidatica;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public String getFormaAdquirida() {
        return formaAdquirida;
    }

    public void setFormaAdquirida(String formaAdquirida) {
        this.formaAdquirida = formaAdquirida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(String fotoCapa) {
        this.fotoCapa = fotoCapa;
    }
    
}
