package com.agenda.tarefas.validation;

import com.agenda.tarefas.constantes.ErrorMessages;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;


public class ValidaCampos {
    // Validar strings NOME TAREFA,AUTOR,
    public static  String validaTamanhoString(String text,int tamanho) {
        if (text == null || text.isEmpty() ) return ErrorMessages.VALIDA_STRING_NULL.message();

        if (tamanho <= text.length( )) return ErrorMessages.VALIDA_STRING_TAMANHO.message( );

        return null;

    }
    // Validar campo numérico recorrencia

    public static String validaNumeros(Integer numero) {
    if (numero ==null)return ErrorMessages.VALIDA_NUMERO_NULL.message();

        if ( numero < 0)return ErrorMessages.VALIDA_NUMERO_NEGATIVO.message( );


        return null;
    }

    // Validar horas

    public static String validaHoras(LocalTime hora) {

        if (hora  == null) return ErrorMessages.VALIDA_HORAS_VAZIO.message();
        if(hora.getHour() > 4)return ErrorMessages.VALIDA_HORA_INVALIDA.message( );
        return null;



    }
}
