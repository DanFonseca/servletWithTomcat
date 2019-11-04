package br.com.webApp.servletpt1.controler;

import java.util.Date;
import java.util.Random;

public class Nome {
    private String nome;
    private int id;

    Date data;
    public Nome (String nome, Date data){
        this.nome = nome;
        this.data = data;
        Random random =new Random();
        id = random.nextInt(1000);
    }


    public String getNome() {
        return nome;
    }
    public Date getData(){
        return this.data;
    }
    public int getId() {
        return id;
    }
}
