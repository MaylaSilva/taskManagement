package com.example.taskManagement.controller;

import com.example.taskManagement.model.Tarefa;
import com.example.taskManagement.model.Usuario;
import com.example.taskManagement.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController (TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa salvar (@RequestBody Tarefa tarefa) {

        return tarefaService.salvar(tarefa);
    }
    @DeleteMapping("/{id}")
    public Tarefa excluir (@PathVariable Long id){

        return tarefaService.excluir(id);
    }
    @PutMapping("/{id}")
    public Tarefa atualizar (@RequestBody Tarefa tarefa, @PathVariable Long id){
        return tarefaService.update(id, tarefa);
    }
    @GetMapping("/{id}")
    public Tarefa localizar (@PathVariable Long id){
        return tarefaService.localizarId(id);
    }
    @GetMapping
    public List<Tarefa> listarTodos(){
        return tarefaService.listarTodos();
    }
}
