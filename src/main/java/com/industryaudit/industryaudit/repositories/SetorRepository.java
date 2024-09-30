package com.industryaudit.industryaudit.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.industryaudit.industryaudit.entities.Setor;

public class SetorRepository implements Repository<Setor, Integer> {

    public static final SetorRepository current = new SetorRepository();

    private SetorRepository() {
    }

    @Override
    public void create(Setor s) throws SQLException {

        String sql = "INSERT INTO setor (nome_setor) VALUES (?)";

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setString(1, s.getNome_setor());  // nome_setor

        pstm.execute();
    }

    @Override
    public Setor read(Integer id) throws SQLException {

        String sql = "SELECT * FROM setor WHERE id_setor = ?";

        Setor s = null;

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setInt(1, id);  // id_setor

        ResultSet result = pstm.executeQuery();

        if (result.next()) {
            s = new Setor();
            s.setId_setor(result.getInt("id_setor"));  // id_setor
            s.setNome_setor(result.getString("nome_setor"));  // nome_setor
        }

        return s;
    }

    public List<Setor> readAll() throws SQLException {

        String sql = "SELECT * FROM setor";

        List<Setor> setores = new ArrayList<>();

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        ResultSet result = pstm.executeQuery();

        while (result.next()) {
            Setor s = new Setor();
            s.setId_setor(result.getInt("id_setor"));  // id_setor
            s.setNome_setor(result.getString("nome_setor"));  // nome_setor

            setores.add(s);
        }

        return setores;
    }

    @Override
    public void update(Setor s) throws SQLException {

        String sql = "UPDATE setor SET nome_setor = ? WHERE id_setor = ?";

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setString(1, s.getNome_setor());  // Atualiza nome_setor
        pstm.setInt(2, s.getId_setor());  // Condição id_setor

        pstm.execute();
    }

    @Override
    public void delete(Integer id) throws SQLException {

        String sql = "DELETE FROM setor WHERE id_setor = ?";

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setInt(1, id);  // Condição id_setor

        pstm.execute();
    }

}
