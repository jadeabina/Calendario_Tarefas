package com.agenda.tarefas.models;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaResource {

    private TarefaRepository tarefaRepository;

    public TarefaResource(TarefaRepository tarefaRepository){
        super();
        this.tarefaRepository= tarefaRepository;
    }

    @PostMapping
    public ResponseEntity<Tarefa> save(@RequestBody Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Tarefa>> getAll(){
    List<Tarefa> tarefa = new ArrayList<>(  );
    tarefa= tarefaRepository.findAll();
    return new ResponseEntity<>(tarefa,HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Tarefa>> getById(@PathVariable Integer id){
        Optional<Tarefa> tarefa;
        try {
            tarefa= tarefaRepository.findById(id);
            return new ResponseEntity<Optional<Tarefa>>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional <Tarefa>>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Integer id, @RequestBody Tarefa newTarefa){
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setId(newTarefa.getId());
                    tarefa.setNome(newTarefa.getNome());
                    tarefa.setAutor(newTarefa.getAutor());
                    tarefa.setTempo(newTarefa.getTempo());
                    tarefa.setRecorrencia(newTarefa.getRecorrencia());
                    tarefa.setAtribuirPara(newTarefa.getAtribuir_para());
                    tarefa.setHorarioDia(newTarefa.getHorario_dia());
                    return ResponseEntity.ok().body(tarefa);
                }).orElse(ResponseEntity.notFound().build());
    }
}
