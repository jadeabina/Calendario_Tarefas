package com.agenda.tarefas.models;


import com.agenda.tarefas.validation.ValidaCampos;
import jakarta.persistence.Entity;
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
        if( ValidaCampos.validaTamanhoString(tarefa.getNome(),30) &&
            ValidaCampos.validaTamanhoString(tarefa.getAutor(),30)  ){
            tarefaRepository.save(tarefa);
        }else{
            return new ResponseEntity("Por favor, preencha o nome corretamente. Máx. 30 caracteres.", HttpStatus.NOT_ACCEPTABLE);
        }


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
        }catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Tarefa>>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping(path = "/{id}")//{}-declaração de varialvel de caminho
    public ResponseEntity<HttpStatus> deletById(@PathVariable Integer id){
        try {
            tarefaRepository.deleteById(id);
            return new  ResponseEntity(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Integer id, @RequestBody Tarefa newTarefa){
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(newTarefa.getNome() == null ? tarefa.getNome():newTarefa.getNome());
                    tarefa.setAutor(newTarefa.getAutor() == null ? tarefa.getAutor(): newTarefa.getAutor());
                    tarefa.setTempo(newTarefa.getTempo() == null ?tarefa.getTempo(): newTarefa.getTempo());
                    tarefa.setRecorrencia(newTarefa.getRecorrencia()== null ?tarefa.getRecorrencia(): newTarefa.getRecorrencia());
                    tarefa.setAtribuirPara(newTarefa.getAtribuir_para() ==null? tarefa.getAtribuir_para(): newTarefa.getAtribuir_para());
                    tarefa.setHorarioDia(newTarefa.getHorario_dia() == null? tarefa.getHorario_dia(): newTarefa.getHorario_dia());
                    tarefaRepository.saveAndFlush(tarefa);

                    return ResponseEntity.ok().body(tarefa);
                }).orElse(ResponseEntity.notFound().build());


    }
}
