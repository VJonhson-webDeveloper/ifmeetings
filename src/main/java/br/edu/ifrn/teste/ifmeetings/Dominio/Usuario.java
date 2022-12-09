package br.edu.ifrn.teste.ifmeetings.Dominio;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Usuario {
    
    private int id;

    @NotBlank(message = "O campo nome é obrigatório!")
    private String nome;

    @NotBlank(message = "O campo cpf é obrigatório!")
    @Pattern(regexp = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}", message = "O CPF digitado não está no formato correto!")
    private String cpf;

    @NotBlank(message = "O campo email é obrigatório!")
    @Email(message = "O Email digitado não está no formato correto!")
    private String email;

    @NotBlank(message = "O campo telefone é obrigatório!")
    @Pattern(regexp = "[0-9]{2} [0-9]{5}-[0-9]{4}", message = "O telefone digitado não está no formato correto!")
    private String fone;

    private String foto;

    @NotBlank(message = "O campo cidade é obrigatório!")
    private String cidade;

    @NotBlank(message = "O campo estado é obrigatório!")
    private String estado;

    @NotBlank(message = "O campo senha é obrigatório!")
    private String senha;

    @NotBlank(message = "O campo perfil é obrigatório!")
    private String perfil;

    @NotBlank(message = "O campo escolaridade é obrigatório!")
    private String escolaridade;

    @NotBlank(message = "O campo idade é obrigatório!")
    private String idade;

    
    /* Código utilizado para que o id funcione corretamente */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        // TODO Auto-generated method stub
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
            Usuario other = (Usuario) obj;

        if (id != other.id) 
            return false;
            return true;
    }

    /* Getters e Setters dos atributos */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String getEscolaridade() {
        return escolaridade;
    }
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
}
