package com.company;

import java.io.*;
import java.util.*;

public class Actions {

    Scanner sc = new Scanner(System.in);
    BufferedWriter bw=null;
    BufferedReader br=null;
    FileWriter fw;
    Iterator iterator;
    Map.Entry mIn;
    List<List<String>> Doctores = new ArrayList<>();
    List<List<String>> Pacientes = new ArrayList<>();
    File file= new File("Doc.csv");
    File file1= new File("Patient.csv");

    public void loadPat(){
        Scanner inputStream;
        try{
            inputStream = new Scanner(file1);
            while(inputStream.hasNext()){
                String line= inputStream.nextLine();
                String[] values = line.split(",");
                Pacientes.add(Arrays.asList(values));
            }
            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadDoc() {
        Scanner inputStream;
        try{
            inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String line= inputStream.nextLine();
                String[] values = line.split(",");
                Doctores.add(Arrays.asList(values));
            }
            inputStream.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        }

    public void listDoc1(){
        loadDoc();
        listDoc();
        delCsv();
    }
    public void listPat1(){
        loadPat();
        listPat();
        delCsvPat();
    }
    public void listPat(){
        for(List<String> line: Pacientes)
            for (String value: line) {
                System.out.println(value);
            }
    }

    public void listDoc(){
        for(List<String> line: Doctores)
            for (String value: line) {
                System.out.println(value);
            }
    }
    public void delCsvPat(){
        try {
            fw = new FileWriter(file1.getAbsoluteFile(), true);
            fw.write(" ");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delCsv(){
        try {
            fw = new FileWriter(file.getAbsoluteFile(), true);
            fw.write(" ");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addDoc(){
        String nameTemp;
        System.out.println("Cual es el nombre del doctor?");
        nameTemp=sc.nextLine();
        Doctores.add(Arrays.asList(nameTemp));
        save();
    }
    public void addPatient(){
        String nameTemp;
        System.out.println("Cual es el nombre del paciente?");
        nameTemp=sc.nextLine();
        Pacientes.add(Arrays.asList(nameTemp));
        save();
    }
    public void newDate(){

    }
    public void err(){
        System.out.println("Indique una opcion de la lista");
    }
    public void savePat(){
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(new FileWriter("Patient.csv"));
            fw.write(Pacientes.toString());
            bw.close();
            fw.close();
            Pacientes.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        try {
        fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(new FileWriter("Doc.csv"));
        fw.write(Doctores.toString());
        bw.close();
        fw.close();
        Doctores.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
