package com.todo.List.dtos;

import com.todo.List.entities.Prioridade;
import com.todo.List.entities.Status;
import com.todo.List.entities.Tarefa;

import java.time.LocalDateTime;


public class TarefaDTO {

    // Identificador único da tarefa
    private Long id;

    // Identificador do usuario relacionado à tarefa
    private Long usuarioId;

    // Descrição da tarefa
    private String descricao;

    // Setor associado à tarefa
    private String setor;

    // Prioridade da tarefa (por exemplo, ALTA, MÉDIA, BAIXA)
    private Prioridade prioridade;

    // Status da tarefa (por exemplo, PENDENTE, EM ANDAMENTO, FINALIZADA)
    private Status status;

    // Data de cadastro da tarefa no sistema
    private LocalDateTime dataCadastro = LocalDateTime.now();

    //Construtor padrão sem argumentos.
    // Necessário para que o objeto possa ser inicializado sem passar valores.



    public TarefaDTO() {

    }


    public TarefaDTO(Long id, Long usuarioId, String descricao, String setor,
                     Prioridade prioridade, Status status, LocalDateTime dataCadastro) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.setor = setor;
        this.prioridade = prioridade;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }


    public TarefaDTO(Tarefa entity) {
        id = entity.getId(); // ID da tarefa
        usuarioId = entity.getUsuario().getId(); // ID do usuário relacionado (extraído do objeto relacionado)
        descricao = entity.getDescricao(); // Descrição da tarefa
        setor = entity.getSetor(); // Setor da tarefa
        prioridade = entity.getPrioridade(); // Prioridade da tarefa
        status = entity.getStatus(); // Status da tarefa
        dataCadastro = entity.getDataCadastro(); // Data de criação da tarefa
    }

    // Getter e Setter para o ID da tarefa
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter para o ID do usuário relacionado à tarefa
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    // Getter e Setter para a descrição da tarefa
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para o setor associado à tarefa
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    // Getter e Setter para a prioridade da tarefa
    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    // Getter e Setter para o status da tarefa
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter e Setter para a data de cadastro da tarefa
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}