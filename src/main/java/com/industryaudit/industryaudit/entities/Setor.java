package com.industryaudit.industryaudit.entities;

public class Setor {
    private int id_setor;
    private String nome_setor;

    public Setor() {
    }
    public Setor(String nome) {
        
        this.nome_setor = nome;
    }


    public int getId_setor() {
        return this.id_setor;
    }
    public void setId_setor(int id){
        this.id_setor = id;
    }

    public String getNome_setor() {
        return this.nome_setor;
    }

    public void setNome_setor(String nome) {
        this.nome_setor = nome;
    }
}
