package com.company;

import java.io.File;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String parametro;
        System.out.println("Borrador de archivos 3000");
        try{
        parametro=args[0];}
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Introduce el nombre del directorio a borrar");
            Scanner teclao = new Scanner(System.in);
            parametro = teclao.next();
        }

        try {
            File archivo = new File(parametro);
            if(archivo.delete()){
                System.out.println("El archivo "+archivo.getName()+" ha sido eliminado");
            }else{
                System.out.println("No se ha podido eliminar el archivo");
            }
        }
        catch (NullPointerException e){
            System.out.println("Error, archivo no encontrado");
        }catch (Exception e){
            System.out.println("Error inesperado");
        }

    }
}
