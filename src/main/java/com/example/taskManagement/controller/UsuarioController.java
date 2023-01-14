package com.example.taskManagement.controller;

import com.example.taskManagement.model.Usuario;
import com.example.taskManagement.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public Usuario salvar (@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public Usuario excluir (@PathVariable Long id){
        return usuarioService.excluir(id);
    }

    @PatchMapping("/{id}")
    public Usuario atualizar (@RequestBody Usuario usuario, @PathVariable Long id){
        return usuarioService.update(id,usuario);
    }
}
