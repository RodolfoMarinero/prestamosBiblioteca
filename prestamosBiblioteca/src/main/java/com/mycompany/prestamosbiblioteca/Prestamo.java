/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;



public class Prestamo {
    private int id;
    private int id_libro;
    private int id_usuario;
    private String fecha_prestamo;
    private String fecha_devolucion;

    public Prestamo(int id, int id_libro, int id_usuario, String fecha_prestamo, String fecha_devolucion) {
        this.id = id;
        this.id_libro = id_libro;
        this.id_usuario = id_usuario;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
    
@Override
public String toString() {
    if ("xxx".equals(getFecha_devolucion())) {
        // Si la fecha de devolución es nula, agregamos un botón para registrar la devolución
        return "<tr><td>" + getId() + "</td><td>" + getId_libro() + "</td><td>" + getId_usuario() + "</td><td>" + getFecha_prestamo() + "</td><td><form method='post' action='registrarDevolucionPage.jsp'><input type='hidden' id='txtID' name='txtID' value="+getId()+"><input type='submit' value='Restrigrar Devolucion'></form></td></tr>";
    } else {
        // Si la fecha de devolución no es nula, imprimimos la fecha
        return "<tr><td>" + getId() + "</td><td>" + getId_libro() + "</td><td>" + getId_usuario() + "</td><td>" + getFecha_prestamo() + "</td><td>" + getFecha_devolucion() + "</td></tr>";
    }
}


}
