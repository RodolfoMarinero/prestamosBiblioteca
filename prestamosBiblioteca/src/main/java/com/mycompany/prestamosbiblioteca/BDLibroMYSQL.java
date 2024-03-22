/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class BDLibroMYSQL {

    public Libro obtener(String id) {
        return null;
    }

    public boolean eliminar(String id) {
        String sql = "delete from  libros where id="
                + id;
        System.out.println(sql);
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);
    }

    public boolean actualizar(Libro libro) {
        String sql = "UPDATE libros SET titulo='"
                + libro.getTitulo() + "', autor='"
                + libro.getAutor() + "', editorial='"
                + libro.getEditorial() + "', disponibilidad="
                + libro.isDisponibilidad() + " WHERE id="
                + libro.getId();
        System.out.println(sql);
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);
    }

    public LinkedList<Libro> obtenerTodos() {
        String sql = "SELECT * FROM libros";
        LinkedList<Libro> lista = null;
        MYSQL mysql = new MYSQL();
        ResultSet r = mysql.ejecutarQuery(sql);
        if (r != null) {
            try {
                lista = new LinkedList<>();
                while (r.next()) {
                    int id = r.getInt("id");
                    String titulo = r.getString("titulo");
                    String autor = r.getString("autor");
                    String editorial = r.getString("editorial");
                    boolean disponibilidad = r.getBoolean("disponibilidad");
                    lista.add(new Libro(id, titulo, autor, editorial, disponibilidad));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }

    public boolean registrar(Libro libro) {
        String sql = "insert into libros(titulo,autor,editorial) values('"
                + libro.getTitulo() + "','"
                + libro.getAutor() + "','"
                + libro.getEditorial() + "');";
        System.out.println(sql);
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);
    }

    public LinkedList<Libro> obtenerLibrosDisponibles() {
        String sql = "SELECT * FROM libros WHERE disponibilidad = true"; // Asumiendo que 'disponibilidad' es un campo booleano en tu tabla
        LinkedList<Libro> lista = null;
        MYSQL mysql = new MYSQL();
        ResultSet r = mysql.ejecutarQuery(sql);
        if (r != null) {
            try {
                lista = new LinkedList<>();
                while (r.next()) {
                    int id = r.getInt("id");
                    String titulo = r.getString("titulo");
                    String autor = r.getString("autor");
                    String editorial = r.getString("editorial");
                    boolean disponibilidad = r.getBoolean("disponibilidad");
                    lista.add(new Libro(id, titulo, autor, editorial, disponibilidad));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
    
    public LinkedList<Libro> obtenerLibrosPrestados() {
        String sql = "SELECT * FROM libros WHERE disponibilidad = false"; // Asumiendo que 'disponibilidad' es un campo booleano en tu tabla
        LinkedList<Libro> lista = null;
        MYSQL mysql = new MYSQL();
        ResultSet r = mysql.ejecutarQuery(sql);
        if (r != null) {
            try {
                lista = new LinkedList<>();
                while (r.next()) {
                    int id = r.getInt("id");
                    String titulo = r.getString("titulo");
                    String autor = r.getString("autor");
                    String editorial = r.getString("editorial");
                    boolean disponibilidad = r.getBoolean("disponibilidad");
                    lista.add(new Libro(id, titulo, autor, editorial, disponibilidad));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
}
