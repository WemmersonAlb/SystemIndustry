package com.industryaudit.industryaudit.entities;

public class TipoFalha {

    private int id_falha;
    private String nome_falha;
    private String descricao_falha;

    public int getId_falha() {
        return this.id_falha;
    }

    public void setId_falha(int id_falha) {
        this.id_falha = id_falha;
    }

    public String getNome_falha() {
        return this.nome_falha;
    }

    public void setNome_falha(String nome_falha) {
        this.nome_falha = nome_falha;
    }

    public String getDescricao_falha() {
        return this.descricao_falha;
    }

    public void setDescricao_falha(String descricao_falha) {
        this.descricao_falha = descricao_falha;
    }

}
