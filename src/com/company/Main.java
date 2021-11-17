package com.company;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File archivoEscribir = new File("Departamentos.dat");
        RandomAccessFile archivoacesso = new RandomAccessFile(archivoEscribir, "rw");
        StringBuffer stringBuffer;
        int[] depsEscribir ={10,20,30,40,50,60};
        String[] nombreEscribir ={"Manuel","Rosa","Gema","Jaime","Chema","Alvaro"};
        String[] localidadEscribir ={"Sevilla","Madrid","Jerez","Barcelona","Mérida","Bilbao"};
        for (int i = 0; i < depsEscribir.length ; i++) {
            archivoacesso.writeInt(depsEscribir[i]);
            stringBuffer=new StringBuffer(nombreEscribir[i]);
            stringBuffer.setLength(15);
            archivoacesso.writeChars(stringBuffer.toString());
            stringBuffer=new StringBuffer(localidadEscribir[i]);
            stringBuffer.setLength(15);
            archivoacesso.writeChars(stringBuffer.toString());
        }
        archivoacesso.close();

        File archivoLeer= new File("Departamentos.dat");
        archivoacesso = new RandomAccessFile(archivoLeer, "r");
        int depsleer;
        char[] nombreLeer= new char[15];
        char[] localidadLeer= new char[15];
        int posicionfich=0;
        while (true){
            archivoacesso.seek(posicionfich);
            depsleer=archivoacesso.readInt();
           // System.out.println(archivoacesso.getFilePointer());

            for (int i = 0; i < nombreLeer.length ; i++) {
                nombreLeer[i]= archivoacesso.readChar();
            }
            //System.out.println(archivoacesso.getFilePointer());
            String nombreLeerString=new String(nombreLeer);
            //testSystem.out.println(nombreLeerString);
            for (int i = 0; i < localidadLeer.length ; i++) {
                localidadLeer[i]= archivoacesso.readChar();
            }
            String localidadLeerString=new String(localidadLeer);
            //testSystem.out.println(localidadLeerString);
            if(depsleer>0 && depsleer%10==0){
                System.out.println("Numero departamento: "+depsleer+" Nombre: "+nombreLeerString.trim()+
                        " Localidad: "+localidadLeerString.trim());
            }
           // System.out.println(archivoacesso.getFilePointer());

            posicionfich=posicionfich+64;
            if(archivoacesso.getFilePointer()==archivoacesso.length()){break;};
        }
        Scanner teclao = new Scanner(System.in);
        while (true){
            System.out.println("Has llegado a la mitad del programa, para cerrar el programa introducce 0, si deseas continuar introduce 1");
            char intro=teclao.next().charAt(0);
            if (intro=='1'){
                break;
            }else if (intro=='0'){
                System.exit(30);
            }else {
                System.out.println("Error, introduce o 0 o 1");
            }
        }

        int depsuser;
        for(;;){
        try{
            System.out.println("Introduce el numero de departamento a modificar(multiplos de 10, de 1 a 6)");
           depsuser= teclao.nextInt();
           break;
        }catch (Exception e){
            System.out.println("Introduce un numero, multiplo de 10, de 1 a 6");
            teclao.nextLine();
        }
    }






    }
}
