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
        int id;
        int departamento;
        int posicionfich=0;
        char[] aplld= new char[10];
        double salario;
        File file = new File("Empleados.dat");
        RandomAccessFile acceso = new RandomAccessFile(file, "r");


        DocumentBuilderFactory granja = DocumentBuilderFactory.newInstance();
        //Document documentoxml = null;
        try {
            DocumentBuilder xmlcrear = granja.newDocumentBuilder();
            DOMImplementation implementacion = xmlcrear.getDOMImplementation();
            Document  documentoxml = implementacion.createDocument(null, "Empleados", null);
            documentoxml.setXmlVersion("1.0");
            boolean check=true;
            while (check){
                acceso.seek(posicionfich);
                id=acceso.readInt();
                for (int i = 0; i < aplld.length ; i++) {
                    aplld[i]=acceso.readChar();
                }
                String aplldString = new String(aplld);
                departamento = acceso.readInt();
                salario = acceso.readDouble();

                if (id>=1){
                    Element raiz = documentoxml.createElement("empleado");
                    documentoxml.getDocumentElement().appendChild(raiz);

                    xmlentrada("id", Integer.toString(id), raiz, documentoxml);
                    xmlentrada("apellido", aplldString.trim(), raiz, documentoxml);
                    xmlentrada("departamento", Integer.toString(departamento), raiz, documentoxml);
                    xmlentrada("salario", Double.toString(salario), raiz, documentoxml);
                }
                posicionfich=posicionfich+36;
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
