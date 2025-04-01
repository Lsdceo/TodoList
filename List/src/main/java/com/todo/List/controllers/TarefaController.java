package com.todo.List.controllers;

import com.todo.List.dtos.TarefaDTO;
import com.todo.List.entities.Tarefa;
import com.todo.List.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Informa ao Spring que esta classe trata requisições HTTP como um controlador REST
@RequestMapping("/tarefas") // Define a URL base para os endpoints deste controlador
public class TarefaController {

    @Autowired
    TarefaService tarefaService; // Serviço responsável pela lógica de negócios de Tarefa

    @PostMapping(value = "/criar") // Define o método HTTP POST para o endpoint "/tarefas/criar"
    public ResponseEntity<TarefaDTO> criarUsuario(@Valid @RequestBody TarefaDTO dto) {
        // Chama o serviço para criar a tarefa com os dados fornecidos no DTO
        dto = tarefaService.criarTarefa(dto);
        // Retorna a tarefa criada no corpo da resposta
        return ResponseEntity.ok(dto);
    }

    @GetMapping // Define o método HTTP GET para o endpoint "/tarefas"
    public ResponseEntity<List<Tarefa>> buscarTarefa() {
        // Chama o serviço para obter todas as tarefas cadastradas
        return ResponseEntity.ok(tarefaService.mostrarTarefa());
    }

}