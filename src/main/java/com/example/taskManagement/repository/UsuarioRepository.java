package com.example.taskManagement.repository;

import com.example.taskManagement.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario, Long> {
}
