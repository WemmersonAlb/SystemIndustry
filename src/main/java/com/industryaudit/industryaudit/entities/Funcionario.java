package com.industryaudit.industryaudit.entities;

public class Funcionario {
    private int id_funcionario;   
    private String nome_funcionario;
    private String matricula_funcionario;
    private String email_funcionario;
    private Setor setor_funcionario;


    
    public Funcionario(){}

    public Funcionario(String nome_funcionario, String matricula_funcionario, String email_funcionario, Setor setor_funcionario) {
        
        this.nome_funcionario = nome_funcionario;
        this.matricula_funcionario = matricula_funcionario;
        this.email_funcionario = email_funcionario;
        this.setor_funcionario = setor_funcionario;
    }

    public int getId_funcionario() {
        return this.id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_funcionario() {
        return this.nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getMatricula_funcionario() {
        return this.matricula_funcionario;
    }

    public void setMatricula_funcionario(String matricula_funcionario) {
        this.matricula_funcionario = matricula_funcionario;
    }

    public String getEmail_funcionario() {
        return this.email_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

    public Setor getSetor_funcionario() {
        return this.setor_funcionario;
    }

    public void setSetor_funcionario(Setor setor_funcionario) {
        this.setor_funcionario = setor_funcionario;
    }


    

}
