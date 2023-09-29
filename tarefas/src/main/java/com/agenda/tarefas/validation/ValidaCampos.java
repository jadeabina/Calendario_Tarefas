package com.agenda.tarefas.validation;

import org.springframework.stereotype.Component;


public class ValidaCampos {

    public static  boolean validaTamanhoString(String text,int tamanho) {
        if (text == null) return false;

        if (tamanho <= text.length( )) return false;

        return true;

    }

    public boolean validaSomenteM(Object obj) {
        return super.equals(obj);
    }

    //
//   // public static boolean validaSomenteNumeros(String T)
//
//
//    // Validar o nome
//        if (nome.length() > 30) {
//        System.out.println("Por favor, preencha o nome corretamente. Máx. 30 caracteres.");
//    }
//
//    // Validar horas
//        try {
//        int horasInt = Integer.parseInt(horas);
//        if (horasInt > 4) {
//            System.out.println("Preencha o campo de horas. Máx: 4 horas.");
//        }
//    } catch (NumberFormatException e) {
//        System.out.println("O campo de horas deve ser um número.");
//    }
//
//    // Validar dia/horario
//        if (diaHorario.isEmpty()) {
//        System.out.println("Preencha este campo com o dia/horário.");
//    }
//
//    // Validar nome do autor
//        if (nomeAutor.length() > 30) {
//        System.out.println("Por favor, preencha o campo do nome do autor corretamente. Máx. 30 caracteres.");
//    }
//
//    // Validar campo numérico
//        try {
//        Integer.parseInt(recorrencia);
//    } catch (NumberFormatException e) {
//        System.out.println("Preencha este campo com números.");
//    }
//}
//
//
//
//

}
