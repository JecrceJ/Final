package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String sel;
        Actions act = new Actions();                             //Iniciacion de las clases

        do {
            sel=showMenu();
            switch (sel) {
                case "1" -> act.addDoc();
                case "2" -> act.addPatient();
                case "3" -> act.newDate();
                case "4" -> act.listDoc1();
                case "5" -> act.listPat1();
                case "6" -> act.save();
                case "7" -> act.savePat();
                default  -> act.err();
            }
        } while (!sel.equals("0"));    }
    public static String showMenu() {
        Scanner sc = new Scanner(System.in);
        String a;
        System.out.println("Selecciona una opcion:\n" +
                "1 Agregar Doctor\n" +
                "2 Agregar Paciente\n" +
                "3 Crear cita\n" +
                "4 Listar doctores\n" +
                "5 Listar pacientes\n" +
                "6 Guardar cambios doctores\n" +
                "7 GUardar cambios pacientes\n" +
                "0 Salir");
        a = sc.next();
        return a;
    }
}