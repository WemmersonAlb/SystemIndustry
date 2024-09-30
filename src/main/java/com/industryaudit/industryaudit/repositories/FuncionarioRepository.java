package com.industryaudit.industryaudit.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.industryaudit.industryaudit.entities.Funcionario;
import com.industryaudit.industryaudit.entities.Setor;

public class FuncionarioRepository implements Repository<Funcionario, Integer> {

    public static final FuncionarioRepository current = new FuncionarioRepository();

    private FuncionarioRepository() {
    }

    @Override
    public void create(Funcionario f) throws SQLException {

        String sql = "insert into funcionario(nome_funcionario, matricula_funcionario, email_funcionario, setor_id_funcionario) values (?, ?, ?, ?)";

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setString(1, f.getNome_funcionario());  // nome_funcionario
        pstm.setString(2, f.getMatricula_funcionario());  // matricula_funcionario
        pstm.setString(3, f.getEmail_funcionario());  // email_funcionario
        pstm.setInt(4, f.getSetor_funcionario().getId_setor());  // setor_id_funcionario

        pstm.execute();
    }

    @Override
    public Funcionario read(Integer id) throws SQLException {

        String sql = "SELECT f.*, s.nome_setor AS setor_nome FROM funcionario f "
                + "LEFT JOIN setor s ON f.setor_id_funcionario = s.id_setor WHERE f.id_funcionario = ?";

        Funcionario f = null;

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet result = pstm.executeQuery();

        if (result.next()) {
            f = new Funcionario();
            f.setId_funcionario(result.getInt("id_funcionario"));  // id_funcionario
            f.setNome_funcionario(result.getString("nome_funcionario"));  // nome_funcionario
            f.setMatricula_funcionario(result.getString("matricula_funcionario"));  // matricula_funcionario
            f.setEmail_funcionario(result.getString("email_funcionario"));  // email_funcionario

            Setor s = new Setor();
            s.setNome_setor(result.getString("setor_nome"));  // nome do setor
            s.setId_setor(result.getInt("setor_id_funcionario"));  // setor_id_funcionario

            f.setSetor_funcionario(s);
        }

        return f;
    }

    public List<Funcionario> readAll() throws SQLException {

        String sql = "SELECT f.*, s.nome_setor AS setor_nome FROM funcionario f "
                + "LEFT JOIN setor s ON f.setor_id_funcionario = s.id_setor";

        List<Funcionario> funcionarios = new ArrayList<>();

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        ResultSet result = pstm.executeQuery();

        while (result.next()) {
            Funcionario f = new Funcionario();
            f.setId_funcionario(result.getInt("id_funcionario"));  // id_funcionario
            f.setNome_funcionario(result.getString("nome_funcionario"));  // nome_funcionario
            f.setMatricula_funcionario(result.getString("matricula_funcionario"));  // matricula_funcionario
            f.setEmail_funcionario(result.getString("email_funcionario"));  // email_funcionario

            Setor s = new Setor();
            s.setNome_setor(result.getString("setor_nome"));  // nome do setor
            s.setId_setor(result.getInt("setor_id_funcionario"));  // setor_id_funcionario

            f.setSetor_funcionario(s);
            funcionarios.add(f);
        }

        return funcionarios;
    }

    @Override
    public void update(Funcionario f) throws SQLException {

        String sql = "UPDATE funcionario SET nome_funcionario = ?, matricula_funcionario = ?, email_funcionario = ?, "
                + "setor_id_funcionario = ? WHERE id_funcionario = ?";

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setString(1, f.getNome_funcionario());  // Atualiza nome_funcionario
        pstm.setString(2, f.getMatricula_funcionario());  // Atualiza matricula_funcionario
        pstm.setString(3, f.getEmail_funcionario());  // Atualiza email_funcionario
        pstm.setInt(4, f.getSetor_funcionario().getId_setor());  // Atualiza setor_id_funcionario
        pstm.setInt(5, f.getId_funcionario());  // Condição id_funcionario

        pstm.execute();
    }
    @Override
    public void delete(Integer id) throws SQLException {
    
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
    
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
    
        pstm.setInt(1, id);  // Condição id_funcionario
    
        pstm.execute();
    }
    
}
