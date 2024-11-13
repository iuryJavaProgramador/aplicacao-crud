package com.targetsolutions.iurydev.crud_application.services;

import com.targetsolutions.iurydev.crud_application.model.Tarefa;
import com.targetsolutions.iurydev.crud_application.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void deletarTarefa(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            tarefaRepository.delete(tarefa.get());
        } else {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }
    }
}
