package com.List.repository;

import ch.qos.logback.core.status.Status;
import com.List.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
    List<Tarefas> findByStatus(Status status);
}