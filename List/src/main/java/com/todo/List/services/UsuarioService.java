package com.todo.List.services;

import com.todo.List.dtos.UsuarioDTO;
import com.todo.List.entities.Usuario;
import com.todo.List.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDTO criarUsuario(UsuarioDTO dto){
        Usuario us = new Usuario();
        us.setNome(dto.getNome());
        us.setEmail(dto.getEmail());

        us = usuarioRepository.save(us);
        return new UsuarioDTO(us);
    }



}
