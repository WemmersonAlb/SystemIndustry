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

import com.industryaudit.industryaudit.entities.Setor;
import com.industryaudit.industryaudit.repositories.SetorRepository;

@CrossOrigin(origins = "*")
@RequestMapping("/api/setor")
@RestController
public class SetorController {


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Setor setor) {
        try {
            SetorRepository.current.create(setor);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Setor criado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar o setor: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> read(@PathVariable Integer id) {
        try {
            Setor setor = SetorRepository.current.read(id);
            if (setor != null) {
                return ResponseEntity.ok(setor);
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
    public ResponseEntity<List<Setor>> readAll() {
        try {
            List<Setor> setores = SetorRepository.current.readAll();
            return ResponseEntity.ok(setores);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Setor setor) {
        try {
            setor.setId_setor(id);
            SetorRepository.current.update(setor);
            return ResponseEntity.ok("Setor atualizado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao atualizar o setor: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            SetorRepository.current.delete(id);
            return ResponseEntity.ok("Setor deletado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao deletar o setor: " + e.getMessage());
        }
    }
}
