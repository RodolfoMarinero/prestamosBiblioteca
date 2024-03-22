/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import java.util.LinkedList;


public class ListaDeLibros {
    private LinkedList<Libro> libros;

    public ListaDeLibros() {
        libros=new LinkedList();
    }
    
    public void agregar(Libro libro){  
        libros.add(libro);            
    }
    
    public void eliminar(int indice){
        libros.remove(indice);        
    }
       
       
    public int total(){
        return libros.size();
    }
    
    public Libro obtener(int indice){
        return libros.get(indice);
    }
    
    public void cargarDesdeBD(){
        BDLibroMYSQL bd=new BDLibroMYSQL();
        libros=bd.obtenerTodos();
    }
}
