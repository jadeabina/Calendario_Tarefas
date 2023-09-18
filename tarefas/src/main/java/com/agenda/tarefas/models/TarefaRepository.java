package com.agenda.tarefas.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {


}

