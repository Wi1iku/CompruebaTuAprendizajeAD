package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File departamentos = new File("Departamentos.dat");
        DataOutputStream datosbin = new
                DataOutputStream(new FileOutputStream(departamentos));

        //Declaracion departamentos
        int[] numerodeps = {10,20,30,40,50,60};
        String [] nombredeps ={"Contabilidad","Finanzas","Recursos Humanos","Departamento 4","Departamento5","Departamento6"};
        String [] localidaddeps ={"Madrid","Barcelona","Mentrida","Merida","Jerez de la frontera","Cadiz"};

        for (int i = 0; i <numerodeps.length ; i++) {
            datosbin.writeInt(numerodeps[i]);
            datosbin.writeUTF(nombredeps[i]);
            datosbin.writeUTF(localidaddeps[i]);
        }//
        System.out.println("Archivo dat creado/actualizado");
        datosbin.close();

    }
}
