package com.todo.List.entities;


import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;
    private String descricao;
    private String setor;
    private Prioridade prioridade;
    private Status status;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tb_usuario")
    private Usuario usuario;

    public Tarefa() {

    }

    public Tarefa(Long id, Long usuarioId, String descricao, String setor,
                  Prioridade prioridade, Status status, LocalDateTime dataCadastro) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.setor = setor;
        this.prioridade = prioridade;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}