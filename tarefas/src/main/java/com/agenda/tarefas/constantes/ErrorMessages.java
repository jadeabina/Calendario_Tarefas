package com.agenda.tarefas.constantes;

import org.apache.naming.StringManager;

public enum ErrorMessages {


    VALIDA_STRING_NULL("O nome é obrigatorio"),
    VALIDA_STRING_TAMANHO("Preencha o nome corretamente. Máx.30 caracteres."),
    VALIDA_NUMERO_NULL("Preencha esse campo com numeros"),
    VALIDA_NUMERO_NEGATIVO("Numero invalido"),
    VALIDA_HORAS_VAZIO("A hora é obrigatória!"),
    VALIDA_HORA_INVALIDA("Preencha o campo de horas. Máx: 4 horas.")
    ;
    private  String message;

    ErrorMessages( String e) {
        message = e;
    }


   public String message(){
        return message;
    }











}
