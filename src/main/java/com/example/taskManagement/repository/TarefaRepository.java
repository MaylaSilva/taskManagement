package com.example.taskManagement.repository;

import com.example.taskManagement.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    List<Tarefa> localizarResponsavel(Long id);
}
