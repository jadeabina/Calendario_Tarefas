package com.agenda.tarefas.models;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Main {

    @GetMapping
    public String getHello(){
        return "está funcionando!";
    }

}
