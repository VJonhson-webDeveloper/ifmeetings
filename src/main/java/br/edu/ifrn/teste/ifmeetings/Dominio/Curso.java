package br.edu.ifrn.teste.ifmeetings.Dominio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Curso {
    
    private int idCurso;

    @NotBlank(message = "Este campo é obrigatório!")
    @Size(min = 5, message = "O titulo deve ter pelo menos 5 letras.")
    private String titulo;

    @NotBlank(message = "Este campo é obrigatório.")
    private String descricao;
    
    /*Getters e Setters dos atributos */
    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /*Codigo para que o ID da Entidade Cursos funcione*/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCurso;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (idCurso != other.idCurso)
            return false;
        return true;
    }
}
