package com.industryaudit.industryaudit.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industryaudit.industryaudit.entities.Funcionario;
import com.industryaudit.industryaudit.repositories.FuncionarioRepository;

@CrossOrigin(origins="*")
@RequestMapping("/api/funcionario")
@RestController
public class FuncionarioController {
    

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Funcionario funcionario) {
        try {
            FuncionarioRepository.current.create(funcionario);  
            return ResponseEntity.status(HttpStatus.CREATED)  
                                 .body("Funcionário criado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  
                                 .body("Erro ao criar o funcionário: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> read(@PathVariable Integer id) {
        try {
            Funcionario funcionario = FuncionarioRepository.current.read(id);
            if (funcionario != null) {
                return ResponseEntity.ok(funcionario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                     .body(null);
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Funcionario>> readAll() {
        try {
            List<Funcionario> funcionarios = FuncionarioRepository.current.readAll();
            return ResponseEntity.ok(funcionarios);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        try {
            
            funcionario.setId_funcionario(id); 
            FuncionarioRepository.current.update(funcionario);
            return ResponseEntity.ok("Funcionário atualizado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao atualizar o funcionário: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            FuncionarioRepository.current.delete(id);
            return ResponseEntity.ok("Funcionário deletado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao deletar o funcionário: " + e.getMessage());
        }
    }
}
