package com.agenda.tarefas.models;


import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity //@Entity anotação indica que a classe é uma classe Java persistente.
@Table(name = "tarefa") // @Table a anotação fornece a tabela que mapeia esta entidade.
public class Tarefa {

    Tarefa(){}
    @Id //@Ida anotação é para a chave primária.
    private int id;

    @Column(name = "nome") //@Columna anotação é usada para definir a coluna no banco de dados que mapeia o campo anotado.
    private String nome;

    @Column(name="autor")
    private String autor;


    @Column(name="tempo")
    private Time tempo;

    @Column(name="recorrencia")
    private int recorrencia;

    @Column(name="atribuir_para")
    private String atribuirPara;


    @Column(name="horario_dia")
    private LocalDateTime horarioDia;


    public Tarefa(String nome, String autor, Time tempo,int recorrencia,String atribuirPara,LocalDateTime horarioDia ){
        this.nome=nome;
        this.autor= autor;
        this.tempo= tempo;
        this.recorrencia=recorrencia;
        this.atribuirPara=atribuirPara;
        this.horarioDia=horarioDia;
    }



    //GERAÇÃO GET
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public Time getTempo() {
        return tempo;
    }

    public int getRecorrencia() {
        return recorrencia;
    }

    public String getAtribuir_para() {
        return atribuirPara;
    }

    public LocalDateTime getHorario_dia() {
        return horarioDia;
    }


    //GERAÇÃO SET
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTempo(Time tempo) {
        this.tempo = tempo;
    }

    public void setRecorrencia(int recorrencia) {
        this.recorrencia = recorrencia;
    }

    public void setAtribuirPara(String atribuir_para) {
        this.atribuirPara = atribuir_para;
    }

    public void setHorarioDia(LocalDateTime horario_dia) {
        this.horarioDia = horario_dia;
    }
}

