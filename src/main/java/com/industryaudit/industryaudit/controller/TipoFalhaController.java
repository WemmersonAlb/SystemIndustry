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

import com.industryaudit.industryaudit.entities.TipoFalha;
import com.industryaudit.industryaudit.repositories.TipoFalhaRepository;

@CrossOrigin(origins = "*")
@RequestMapping("/api/tipo-falha")
@RestController
public class TipoFalhaController {

   

    @GetMapping("/all")
    public ResponseEntity<List<TipoFalha>> readAll() {
        try {
            List<TipoFalha> tiposFalha = TipoFalhaRepository.current.readAll();
            return ResponseEntity.ok(tiposFalha);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TipoFalha tipoFalha) {
        try {
            TipoFalhaRepository.current.create(tipoFalha);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Tipo de falha criado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar o tipo de falha: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFalha> read(@PathVariable Integer id) {
        try {
            TipoFalha tipoFalha = TipoFalhaRepository.current.read(id);
            if (tipoFalha != null) {
                return ResponseEntity.ok(tipoFalha);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                     .body(null);
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody TipoFalha tipoFalha) {
        try {
            tipoFalha.setId_falha(id);
            TipoFalhaRepository.current.update(tipoFalha);
            return ResponseEntity.ok("Tipo de falha atualizado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao atualizar o tipo de falha: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            TipoFalhaRepository.current.delete(id);
            return ResponseEntity.ok("Tipo de falha deletado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao deletar o tipo de falha: " + e.getMessage());
        }
    }
}
