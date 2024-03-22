/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private boolean disponibilidad;

    public Libro(int id, String titulo, String autor, String editorial, boolean disponibilidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        String disponibilidad = isDisponibilidad() ? "Disponible" : "Prestado";
        return "<tr><td>" + getId() + "</td><td>" + getTitulo() + "</td><td>" + getAutor() + "</td><td>" + getEditorial() + "</td><td>" + disponibilidad + "</td></tr>";
    }
}
