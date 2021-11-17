package com.company;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File archivoEscribir = new File("Departamentos.dat");
        RandomAccessFile archivoacesso = new RandomAccessFile(archivoEscribir, "rw");
        StringBuffer stringBuffer;
        //comentar desde aqui con /* has el final para dehabilitar creacion deun dat original
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
        ///////////////////////////////////////////////////////////// */ Borrar lineas de comentario para comentar creacion de dat original
        File archivoLeer= new File("Departamentos.dat");
        archivoacesso = new RandomAccessFile(archivoLeer, "rw");
        int depsleer;
        char[] nombreLeer= new char[15];
        char[] localidadLeer= new char[15];
        int posicionfich=0;
        while (true){
            archivoacesso.seek(posicionfich);
            //System.out.println(archivoacesso.getFilePointer()+"aaaaaaaaaaaaaaaaaaasasafafsawarewa21");
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
            if(archivoacesso.getFilePointer()==archivoacesso.length()){break;}
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
        archivoacesso.close();
        int depsuser=0;
        for(;;) {
            try {
                System.out.println("Introduce el numero de departamento a modificar(multiplos de 10, de 1 a 6)");
                depsuser = teclao.nextInt();
            } catch (Exception e) {
                teclao.nextLine();
            }

            if (depsuser < 10 || depsuser > 60 || (depsuser%10)!=0) {
                System.out.println("El numero de departamento introducido no es valido");
            }else {break;
              }
        }
        File archivouser= new File("Departamentos.dat");
        archivoacesso = new RandomAccessFile(archivouser, "rw");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        posicionfich=((depsuser/10)-1)*64;
        archivoacesso.seek(posicionfich);
        char[] nombreUseranti= new char[15];
        char[] localidadUseranti= new char[15];
        for (int i = 0; i < 15; i++) {
            nombreUseranti[i]=archivoacesso.readChar();
        }
        for (int i = 0; i < 15; i++) {
            localidadUseranti[i]= archivoacesso.readChar();
        }
        String nombreuserantistring = new String(nombreUseranti);
        String localidaduserantistring= new String(localidadUseranti);





        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
       // System.out.println(archivoacesso.getFilePointer() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("Has seleccionado el departamento "+depsuser);
        posicionfich=((depsuser/10)-1)*64;
        //System.out.println(posicionfich);
        teclao.nextLine();
        archivoacesso.seek(posicionfich);
        //System.out.println(archivoacesso.getFilePointer() + "llllllllllllllllllllll");

        archivoacesso.writeInt(depsuser);
        //System.out.println(archivoacesso.getFilePointer() + "llllllllllllllllllllll");

        System.out.println("Introduce nombre nuevo: ");
        stringBuffer=new StringBuffer(teclao.nextLine());
        stringBuffer.setLength(15);

        archivoacesso.writeChars(stringBuffer.toString());//nombre

        //System.out.println(archivoacesso.getFilePointer() + "aaaaaaaaaaaaaaaaaaasaaaaaaaaaaaaaaaaaaaaaaaa2222222222222222222222222222aaaaaaaaaaaaaaaaaaaaaaaa");

        System.out.println("Introduce localidad nueva");
        stringBuffer=new StringBuffer(teclao.nextLine());
        stringBuffer.setLength(15);
        archivoacesso.writeChars(stringBuffer.toString());
        //localidad
        archivoacesso.seek(posicionfich);
        //System.out.println(archivoacesso.getFilePointer() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //System.out.println(archivoacesso.getFilePointer() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(archivoacesso.readInt());
        char[] nombreUser= new char[15];
        char[] localidadUser= new char[15];
        for (int i = 0; i < 15; i++) {
            nombreUser[i]=archivoacesso.readChar();
        }
        for (int i = 0; i < 15; i++) {
           localidadUser[i]= archivoacesso.readChar();
        }
        String nombreusersenial= new String(nombreUser);
        String localidaduserenial= new String(localidadUser);
        System.out.println(nombreusersenial);
        System.out.println(localidaduserenial);
        System.out.println("Has modificado la entrada de deparmamento "+depsuser+"\n" +
                "Entrada antigua:\n"+
                "Nombre: "+nombreuserantistring+"\n"+
                "Localidad: "+localidaduserantistring+"\n" +
                "Por la entrada actualizada\n" +
                "Nombre: "+nombreusersenial+"\n" +
                "Localidad: "+localidaduserenial);








    }
}
