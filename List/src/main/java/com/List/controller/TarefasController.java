package com.List.controller;

import com.List.entity.Tarefas;
import com.List.service.TarefasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    public TarefasService tarefasService;

    public TarefasController(TarefasService tarefaService) {
        this.tarefasService = tarefaService;
    }

    @GetMapping
    public List<Tarefas> listarTarefas() {
        return tarefasService.listarTarefas();
    }

    @GetMapping("/{id}")
    public Tarefas buscarTarefaPorId(@PathVariable Long id) {
        return tarefasService.buscarTarefaPorId(id);
    }


    @PostMapping
    public Tarefas criarTarefa(@RequestBody Tarefas tarefa) {
        return tarefasService.salvarTarefa(tarefa);
    }
}

