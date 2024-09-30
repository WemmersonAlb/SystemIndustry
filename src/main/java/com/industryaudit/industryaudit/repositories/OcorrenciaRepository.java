package com.industryaudit.industryaudit.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.industryaudit.industryaudit.entities.Ocorrencias;
import com.industryaudit.industryaudit.entities.Setor;
import com.industryaudit.industryaudit.entities.TipoFalha;

public class OcorrenciaRepository implements Repository<Ocorrencias, Integer> {

    public static final OcorrenciaRepository current = new OcorrenciaRepository();

    private OcorrenciaRepository() {
    }

    @Override
    public void create(Ocorrencias ocorrencia) throws SQLException {
        String sql = "INSERT INTO ocorrencia (tipo_falha_id_ocorrencia, data_ocorrido, setor_id_ocorrencia) VALUES (?, ?, ?)";

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setInt(1, ocorrencia.getTipoFalha().getId_falha());  // Mapeia o tipo_falha_id_ocorrencia
        pstm.setDate(2, new java.sql.Date(ocorrencia.getDataOcorrido().getTime()));  // Mapeia a data_ocorrido
        pstm.setInt(3, ocorrencia.getSetor().getId_setor());  // Mapeia o setor_id_ocorrencia

        pstm.execute();  // Executa a inserção
    }

    public List<Ocorrencias> readAll() throws SQLException {
        String sql = "SELECT o.*, tf.nome_falha AS tipo_falha_nome, s.nome_setor AS setor_nome FROM ocorrencia o "
                + "LEFT JOIN tipo_falha tf ON o.tipo_falha_id_ocorrencia = tf.id_tipo_falha "
                + "LEFT JOIN setor s ON o.setor_id_ocorrencia = s.id_setor";  // Consulta para buscar todos os registros

        List<Ocorrencias> ocorrencias = new ArrayList<>();  // Lista para armazenar os resultados

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        ResultSet result = pstm.executeQuery();

        while (result.next()) {
            Ocorrencias o = new Ocorrencias();
            o.setId(result.getInt("id_ocorrencia"));  // id_ocorrencia
            o.setDataOcorrido(result.getDate("data_ocorrido"));  // data_ocorrido

            // Mapear os dados de tipo_falha
            TipoFalha tf = new TipoFalha();
            tf.setId_falha(result.getInt("tipo_falha_id_ocorrencia"));  // id_tipo_falha
            tf.setNome_falha(result.getString("tipo_falha_nome"));  // nome da falha

            o.setTipoFalha(tf);  // Adiciona o objeto TipoFalha à ocorrência

            // Mapear os dados de setor
            Setor s = new Setor();
            s.setId_setor(result.getInt("setor_id_ocorrencia"));  // id_setor
            s.setNome_setor(result.getString("setor_nome"));  // nome do setor

            o.setSetor(s);  // Adiciona o objeto Setor à ocorrência

            ocorrencias.add(o);  // Adiciona a ocorrência à lista
        }

        return ocorrencias;  // Retorna a lista de ocorrências
    }

    @Override
    public void update(Ocorrencias c) throws SQLException{
        // TODO
    }
	@Override
    public Ocorrencias read(Integer k) throws SQLException{
        // TODO
        return new Ocorrencias();
    }
	@Override
    public void delete(Integer k) throws SQLException{
        // TODO
    }



}
