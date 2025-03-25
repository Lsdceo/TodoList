package com.List.service;

import com.List.entity.Tarefas;
import com.List.repository.TarefasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {

    public TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefaRepository) {
        this.tarefasRepository = tarefaRepository;
    }

    public List<Tarefas> listarTarefas() {
        return tarefasRepository.findAll();
    }

    public Tarefas buscarTarefaPorId(Long id) {
        return tarefasRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }


    public Tarefas salvarTarefa(Tarefas tarefa) {
        return tarefasRepository.save(tarefa);
    }
}
