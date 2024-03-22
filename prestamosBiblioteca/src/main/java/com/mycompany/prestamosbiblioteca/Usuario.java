package com.mycompany.prestamosbiblioteca;

import java.util.LinkedList;

public class Usuario {    
    private int id;
    private String nombre;
    private String correo;

    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

        
    @Override
    public String toString() {
        return "<tr><td>" + getId() + "</td><td>" + getNombre() + "</td><td>" + getCorreo() + "</td><td><form method='post' action='historial.jsp'><input type='hidden' id='txtID' name='txtID' value="+getId()+"><input type='submit' value='Ver Historial de Prestamos'></form></td></tr>";
    }

}
