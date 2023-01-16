package com.example.taskManagement.service;

import com.example.taskManagement.model.Tarefa;
import com.example.taskManagement.model.Usuario;
import com.example.taskManagement.repository.TarefaRepository;
import com.example.taskManagement.repository.UsuarioRepository;

import java.util.List;

public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar (Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
    public Tarefa excluir (Long tarefaId){
        Tarefa tarefa = tarefaRepository.findById(tarefaId).orElseThrow(IllegalArgumentException::new);
        tarefaRepository.delete(tarefa);
        return tarefa;
    }
    public Tarefa update (Long tarefaId, Tarefa tarefa){
        Tarefa tarefa1 = tarefaRepository.findById(tarefaId).orElseThrow(IllegalArgumentException::new);

        tarefa1.setDescricao(tarefa.getDescricao());
        tarefa1.setStatus(tarefa.getStatus());
        tarefa1.setDataCriacao(tarefa.getDataCriacao());
        tarefa1.setDataVencimento(tarefa.getDataVencimento());
        tarefa1.setPrioridade(tarefa.getPrioridade());
        tarefa1.setCategoria(tarefa.getCategoria());
        tarefa1.setEtiquetas(tarefa.getEtiquetas());
        tarefa1.setUsuarioResponsavel(tarefa.getUsuarioResponsavel());

        tarefaRepository.save(tarefa1);

        return tarefa1;
    }
    public Tarefa localizarId (Long id){
        return tarefaRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    public List<Tarefa> listarTodos(){
        return (List<Tarefa>) tarefaRepository.findAll();
    }

    public List<Tarefa> listarPorResponsavel(Long id){
        return tarefaRepository.localizarResponsavel(id);
    }
}
