package com.targetsolutions.iurydev.crud_application.repository;

import com.targetsolutions.iurydev.crud_application.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
