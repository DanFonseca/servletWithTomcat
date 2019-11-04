package br.com.webApp.servletpt1.controler;

public class Usuario {

    private String nome;
    private String password;

    public Usuario (String nome, String password){
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }
}
