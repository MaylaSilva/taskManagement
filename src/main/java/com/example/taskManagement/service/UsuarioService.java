package com.example.taskManagement.service;

import com.example.taskManagement.model.Usuario;
import com.example.taskManagement.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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
        Usuario usuario1 = usuarioRepository.findById(usuarioId).orElseThrow(IllegalArgumentException::new);

        usuario1.setNomeUsuario(usuario.getNomeUsuario());
        usuario1.setNomeCompleto(usuario.getNomeCompleto());
        usuario1.setSenha(usuario.getSenha());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setGenero(usuario.getGenero());
        usuario1.setNascimento(usuario.getNascimento());
        usuario1.setTelefone(usuario.getTelefone());
        usuario1.setEndereco(usuario.getEndereco());

        usuarioRepository.save(usuario1);

        return usuario1;
    }
    public Usuario localizarId (Long id){
        return usuarioRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    public List<Usuario> listarTodos(){
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
