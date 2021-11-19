package com.company;

public class Empleado {
    int departamento;
    String nombre;
    String localidad;
    public Empleado(int departamento, String nombre, String localidad){
        this.localidad=localidad;
        this.departamento=departamento;
        this.nombre=nombre;
    }

    public int getDepartamento() {
        return departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }
}
