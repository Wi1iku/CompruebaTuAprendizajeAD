package com.company;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.parsers.*;
import java.io.*;
import  javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int deps;
        int posicionfich=0;
        char[] nombre= new char[15];
        char [] locali= new char[15];
        File file = new File("Departamentos.dat");
        RandomAccessFile acceso = new RandomAccessFile(file, "r");


        DocumentBuilderFactory granja = DocumentBuilderFactory.newInstance();
        //Document documentoxml = null;
        try {
            DocumentBuilder xmlcrear = granja.newDocumentBuilder();
            DOMImplementation implementacion = xmlcrear.getDOMImplementation();
            Document  documentoxml = implementacion.createDocument(null, "Departamentos", null);
            documentoxml.setXmlVersion("1.0");
            boolean check=true;
            while (check){
                acceso.seek(posicionfich);
                deps=acceso.readInt();
                System.out.println(acceso.getFilePointer()+"departamentp");

                for (int i = 0; i < nombre.length ; i++) {
                    nombre[i]=acceso.readChar();
                }
                String nombreString = new String(nombre);
                System.out.println(acceso.getFilePointer()+"apellido");

                for (int i = 0; i < locali.length ; i++) {

                    locali[i]=acceso.readChar();
                }
                System.out.println(acceso.getFilePointer()+"loclaiad");
                System.out.println(acceso.length()+"totalfichero");
                String localiString = new String(locali);
                if (deps>=1 && deps%10==0){
                    Element raiz = documentoxml.createElement("empleado");
                    documentoxml.getDocumentElement().appendChild(raiz);
                    xmlentrada("id", Integer.toString(deps), raiz, documentoxml);
                    xmlentrada("nombre", nombreString.trim(), raiz, documentoxml);
                    xmlentrada("localidad", localiString.trim(), raiz, documentoxml);

                }
                posicionfich=posicionfich+64;
                if (acceso.getFilePointer() == acceso.length()){
                    check=false;
                }
            }

            Source sauce = new DOMSource(documentoxml);
            Result resultado = new StreamResult(new java.io.File("test.xml"));
            Transformer optimusprime = TransformerFactory.newInstance().newTransformer();
            optimusprime.transform(sauce,resultado);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        acceso.close();










    }
    static void xmlentrada(String dato, String valor,
                           Element raiz, Document document){
        Element entradaXml = document.createElement(dato);
        Text dentroxXml = document.createTextNode(valor);
        raiz.appendChild(entradaXml);
        entradaXml.appendChild(dentroxXml);
    }
}
