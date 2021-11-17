package com.company;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclao = new Scanner(System.in);
        //////////////////////////////////////////////////////////////////
        ////parte que genera .dat

        File archivoEscribir = new File("Departamentos.dat");
        RandomAccessFile archivoacesso = new RandomAccessFile(archivoEscribir, "rw");
        StringBuffer stringBuffer;
        //comentar desde aqui con /* has el final para dehabilitar creacion deun dat original
        int[] depsEscribir ={1,2,3,4,5,6};
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
        /////////////////////////////////////////////////////////////////
        int depsuser=0;
        int check=1;
        try{
            depsuser=Integer.parseInt(args[0]);
        }catch (Exception e){
            check=-1;
        }
        File archivouser= new File("Departamentos.dat");
        archivoacesso = new RandomAccessFile(archivouser, "rw");
        if(check==-1) {
            do {
                check = -1;
                try {
                    System.out.println("Introduce el numero de departamento a modificar");
                    depsuser = teclao.nextInt();
                } catch (Exception e) {
                    teclao.nextLine();
                    System.out.println("No has introducido un numero");
                    check = 0;
                }
            } while (check != -1);
            int posicionfich = depsuser - 1;
            archivoacesso.seek(posicionfich);
            archivoacesso.writeInt(0);
            stringBuffer = new StringBuffer("               ");
            stringBuffer.setLength(15);
            archivoacesso.writeChars(stringBuffer.toString());
            System.out.println(archivoacesso.getFilePointer());
            archivoacesso.writeChars(stringBuffer.toString());
            System.out.println(archivoacesso.getFilePointer());
            int cont = 0;
            int cont2 = 0;

            /*//archivoacesso.seek(0);
            posicionfich=0;
            do {
                check=420;
                archivoacesso.seek(cont2*64);
                System.out.println("asd");
                if (archivoacesso.readInt()>0){
                    cont++;
                }
                if(archivoacesso.getFilePointer()==archivoacesso.length()){
                    check=-1;
                }
                cont2++;
            }while (check!=-1);
            System.out.println("Numero de registros restante");
        }*/
            ArrayList<Integer>depts=new ArrayList<>();

            posicionfich=0;
            archivoacesso.seek(posicionfich);
            //System.out.println(archivoacesso.getFilePointer());
            //System.out.println(archivoacesso.length()+"aaaaaaaaaaaaaa");
            try {
                while (true) {
                    posicionfich = (64 * cont);
                    archivoacesso.seek(posicionfich);
                   // System.out.println(archivoacesso.getFilePointer());
                    int depnumba=archivoacesso.readInt();
                    ////////////////////
                    if (!depts.contains(depnumba) && depnumba!=0){
                        depts.add(depnumba);

                    }
                    archivoacesso.getFilePointer();
                    cont++;
                }
            }catch (EOFException e){
                //isobum
                //System.out.println("bucle finalizado");
            }
            System.out.println("Hay "+depts.size()+" distintos departamentos");

        }
    }
}
