package com.industryaudit.industryaudit.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.industryaudit.industryaudit.entities.TipoFalha;

public class TipoFalhaRepository implements Repository<TipoFalha, Integer> {

    public static final TipoFalhaRepository current = new TipoFalhaRepository();

    private TipoFalhaRepository() {
    }

    public List<TipoFalha> readAll() throws SQLException {
        String sql = "SELECT * FROM tipo_falha";  // Consulta para buscar todos os registros da tabela

        List<TipoFalha> tiposFalha = new ArrayList<>();  // Lista para armazenar os resultados

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        ResultSet result = pstm.executeQuery();

        while (result.next()) {
            TipoFalha tf = new TipoFalha();
            tf.setId_falha(result.getInt("id_tipo_falha"));  // id_tipo_falha
            tf.setNome_falha(result.getString("nome_falha"));  // nome_falha
            tf.setDescricao_falha(result.getString("descricao_falha"));  // descricao_falha

            tiposFalha.add(tf);  // Adiciona o objeto à lista
        }

        return tiposFalha;  // Retorna a lista de tipos de falha
    }

    @Override
    public void create(TipoFalha c) throws SQLException{
        // TODO
    };
	@Override
    public void update(TipoFalha c) throws SQLException{
        // TODO
    };
	@Override
    public TipoFalha read(Integer k) throws SQLException{
        // TODO
        return new TipoFalha();
    };
	@Override
    public void delete(Integer k) throws SQLException{
        // TODO
    };

}
