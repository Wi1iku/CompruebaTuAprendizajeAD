
package com.company;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.*;
import java.util.ArrayList;


public class Main {
    static ArrayList<Integer>deps = new ArrayList<>();
    static ArrayList<String>nombres = new ArrayList<>();
    static ArrayList<String>localidads= new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File xml= new File("xml.xml");

        DataOutputStream xmlwrite = new DataOutputStream(new FileOutputStream(xml));
        File fichero = new File("Departamentos.dat");
        RandomAccessFile acceso= new RandomAccessFile(fichero, "r");
        XStream xStream= new XStream(new StaxDriver());
        acceso.seek(0);

        char[] nombre = new char[15];
        char[] localidad = new char[15];
        xStream.alias("Empleado",Empleado.class);
        xStream.alias("Empleados",Empleados.class);
        int cont = 0;
        while (true){
            deps.add(acceso.readInt());
            for (int i = 0; i < nombre.length ; i++) {
                nombre[i]= acceso.readChar();
            }
            nombres.add(new String(nombre).trim());
            for (int i = 0; i <localidad.length ; i++) {
                localidad[i]= acceso.readChar();
            }
            localidads.add(new String(localidad).trim());
            if (acceso.getFilePointer()==acceso.length()){
                break;
            }
        }
        Empleado[] arrayemps= new Empleado[deps.size()];
        Empleados empleados = new Empleados(arrayemps);
        for (int i = 0; i < deps.size(); i++) {
            arrayemps[i]= new Empleado(deps.get(i),nombres.get(i),localidads.get(i) );
        }

        String xmls= xStream.toXML(empleados);
        xmlwrite.writeUTF(xmls);


 }
}
