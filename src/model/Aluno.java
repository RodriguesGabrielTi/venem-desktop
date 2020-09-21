/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author paulojp
 */
public class Aluno {
    
    private int matricula;
    private String nomeAluno;
    private String curso;
    private int serie;
    private int nivel;

    public Aluno(int matricula, String nomeAluno, String curso, int serie, int nivel) {
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.curso = curso;
        this.serie = serie;
        this.nivel = nivel;
    }
    
     public Aluno() {
    }  

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
 
    
}
