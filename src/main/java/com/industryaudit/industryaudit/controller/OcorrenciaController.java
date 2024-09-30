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

import com.industryaudit.industryaudit.entities.Ocorrencias;
import com.industryaudit.industryaudit.repositories.OcorrenciaRepository;

@CrossOrigin(origins = "*")
@RequestMapping("/api/ocorrencias")
@RestController
public class OcorrenciaController {

   
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Ocorrencias ocorrencia) {
        try {
            OcorrenciaRepository.current.create(ocorrencia);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Ocorrência criada com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar a ocorrência: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ocorrencias>> readAll() {
        try {
            List<Ocorrencias> ocorrencias = OcorrenciaRepository.current.readAll();
            return ResponseEntity.ok(ocorrencias);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Ocorrencias> read(@PathVariable Integer id) {
        try {
            Ocorrencias ocorrencia = OcorrenciaRepository.current.read(id);
            if (ocorrencia != null) {
                return ResponseEntity.ok(ocorrencia);
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
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Ocorrencias ocorrencia) {
        try {
            ocorrencia.setId(id);
            OcorrenciaRepository.current.update(ocorrencia);
            return ResponseEntity.ok("Ocorrência atualizada com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao atualizar a ocorrência: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            OcorrenciaRepository.current.delete(id);
            return ResponseEntity.ok("Ocorrência deletada com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao deletar a ocorrência: " + e.getMessage());
        }
    }
}
