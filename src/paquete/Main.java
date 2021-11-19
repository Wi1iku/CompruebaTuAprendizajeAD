package paquete;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
public class Main {
    public static void main(String[] args) {
        try {
            TransformerFactory optimusprime = TransformerFactory.newInstance();
            Transformer optimus= optimusprime.newTransformer(new StreamSource(new File("Empleado-array.xslt")));
            StreamSource streamSource = new StreamSource(new File("Empleado-array.xml"));
            StreamResult streamResult = new StreamResult(new File("Empleado.html"));
            optimus.transform(streamSource,streamResult);
            System.out.println("Html creado");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
