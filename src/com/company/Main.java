package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	String ruta;
	String ruta2;
	Scanner teclao = new Scanner(System.in);
        System.out.println("Copiador de ficheros 3000");
        try{
            ruta=args[0];
            ruta2= args[1];
        }catch (Exception e){

            System.out.println("Introduce el nombre del fichero, origen y destino separado por % ");
            ruta=teclao.nextLine();
            System.out.println("Introduce la nombre del fichero 2, origen y destino separado por % ");
            ruta2=teclao.nextLine();
        }

        String[] archivo1info =sacarcosetes(ruta);
        String[] archivo2info =sacarcosetes(ruta2);
        File origen1=null;
        File origen2 = null;
        File destino1 = null;
        File destino2 = null;

        //System.out.println(archivo1info[2]);
        try {
            if (archivo1info[1].endsWith("\\")){
                origen1 = new File(archivo1info[1]+archivo1info[0]);
            }else {
                origen1 = new File(archivo1info[1]+"\\"+archivo1info[0]);
            }
            if (archivo2info[1].endsWith("\\")){
                origen2 = new File(archivo2info[1]+archivo2info[0]);
            }else {
                origen2 = new File(archivo2info[1]+"\\"+archivo2info[0]);
            }
        }
        catch (Exception e){
            System.out.println("error a la hora de pasear origenes");
        }
        try {
            if (archivo1info[2].endsWith("\\")){
                destino1 = new File(archivo1info[2]+archivo1info[0]);
            }else {
                destino1 = new File(archivo1info[2]+"\\"+archivo1info[0]);
            }

            if (archivo2info[2].endsWith("\\")){
                destino2 = new File(archivo2info[2]+archivo2info[0]);
            }else {
                destino2 = new File(archivo2info[2]+"\\"+archivo2info[0]);
            }

        }
        catch (Exception e){            System.out.println("error a la hora de pasear destinos");
        }
        

        try {
            Files.copy(origen1.toPath(), destino1.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo1 copiados con exito");
        }catch (Exception e){
            System.out.println("Error inesperado a la hora de copiar el archivo");
            System.out.println(e);
        }

        try {
            Files.copy(origen2.toPath(), destino2.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo2 copiados con exito");
        }catch (Exception e){
            System.out.println("Error inesperado a la hora de copiar el archivo");
            System.out.println(e);
        }

    }

    static String[] sacarcosetes(String ruta){
        return ruta.split("%");
    }


}
