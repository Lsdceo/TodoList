package com.todo.List.services;

import com.todo.List.dtos.TarefaDTO;
import com.todo.List.entities.Prioridade;
import com.todo.List.entities.Status;
import com.todo.List.entities.Tarefa;
import com.todo.List.entities.Usuario;
import com.todo.List.repositories.TarefaRepository;
import com.todo.List.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service // Define esta classe como um componente de Serviço gerenciado pelo Spring
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository; // Repositório para a entidade Tarefa

    @Autowired
    UsuarioRepository usuarioRepository; // Repositório para a entidade Usuario


    public TarefaDTO criarTarefa(TarefaDTO dto) {
        // Cria uma nova instância de Tarefa
        Tarefa t = new Tarefa();

        // Define os atributos da Tarefa com base no objeto DTO recebido
        t.setDescricao(dto.getDescricao());
        t.setDataCadastro(LocalDateTime.now()); // Define a data de cadastro como a data e hora atual
        t.setPrioridade(Prioridade.BAIXA); // Define a prioridade como padrão (BAIXA)
        t.setStatus(Status.A_FAZER); // Define o status inicial como "A_Fazer"
        t.setSetor(dto.getSetor()); // Configura o setor da tarefa com base no DTO

        // Busca o usuário no banco de dados pelo ID fornecido no DTO
        Usuario usuario = usuarioRepository.getReferenceById(dto.getUsuarioId());
        t.setUsuarioId(usuario.getId()); // Associa o usuário (utilizando o ID) à tarefa

        // Salva a nova tarefa no banco de dados
        t = tarefaRepository.save(t);

        // Retorna os dados da tarefa criada na forma de um DTO
        return new TarefaDTO(t);
    }


    public List<Tarefa> mostrarTarefa() {
        // Recupera todas as tarefas salvas no banco de dados
        List<Tarefa> lista = tarefaRepository.findAll();
        return lista; // Retorna a lista recuperada
    }
}