package com.industryaudit.industryaudit.entities;

import java.util.Date;

public class Ocorrencias {
   private int id_ocorrencia;
   private TipoFalha tipoFalha_ocorrencia;
   private Date dataOcorrido_ocorrencia;
   private Setor setor_ocorrencia;


    public Ocorrencias() {
    }

    public Ocorrencias(TipoFalha tipoFalha, Date dataOcorrido, Setor setor) {        
        this.tipoFalha_ocorrencia = tipoFalha;
        this.dataOcorrido_ocorrencia = dataOcorrido;
        this.setor_ocorrencia = setor;
    }


    public int getId() {
        return this.id_ocorrencia;
    }
    public void setId(int id){
        this.id_ocorrencia = id;
    }

    public TipoFalha getTipoFalha() {
        return this.tipoFalha_ocorrencia;
    }

    public void setTipoFalha(TipoFalha tipoFalha) {
        this.tipoFalha_ocorrencia = tipoFalha;
    }

    public Date getDataOcorrido() {
        return this.dataOcorrido_ocorrencia;
    }

    public void setDataOcorrido(Date dataOcorrido) {
        this.dataOcorrido_ocorrencia = dataOcorrido;
    }

    public Setor getSetor() {
        return this.setor_ocorrencia;
    }

    public void setSetor(Setor setor) {
        this.setor_ocorrencia = setor;
    }
}
