package com.example.taskManagement.service;

import com.example.taskManagement.model.Usuario;
import com.example.taskManagement.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar (Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public Usuario excluir (Long usuarioId){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(IllegalArgumentException::new);
        usuarioRepository.delete(usuario);
        return usuario;
    }
    public Usuario update (Long usuarioId, Usuario usuario){
//        Usuario usuario1 = usuarioRepository.findById(usuarioId).orElseThrow(IllegalArgumentException::new);
//        .map(atualizar ->{
//            atualizar.setNomeUsuario(atualizar.getNomeUsuario());
//            atualizar.setNomeCompleto(atualizar.getNomeCompleto());
//            atualizar.setSenha(atualizar.getSenha());
//            atualizar.setEmail(atualizar.getEmail());
//            atualizar.setGenero(atualizar.getGenero());
//            atualizar.setNascimento(atualizar.getNascimento());
//            atualizar.setTelefone(atualizar.getTelefone());
//            atualizar.setEndereco(atualizar.getEndereco());
//        }
//        );
        return usuarioRepository.save(usuario);
    }
}
