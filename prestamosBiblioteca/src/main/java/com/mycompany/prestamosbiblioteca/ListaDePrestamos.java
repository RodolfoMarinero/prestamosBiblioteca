/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import java.util.LinkedList;


public class ListaDePrestamos {
    private LinkedList<Prestamo> prestamos;

    public ListaDePrestamos() {
        prestamos=new LinkedList();
    }
    
    public void agregar(Prestamo prestamo){  
        prestamos.add(prestamo);            
    }
    
    public void eliminar(int indice){
        prestamos.remove(indice);        
    }
       
       
    public int total(){
        return prestamos.size();
    }
    
    public Prestamo obtener(int indice){
        return prestamos.get(indice);
    }
    
    public void cargarDesdeBD(){
        BDPrestamoMYSQL bd=new BDPrestamoMYSQL();
        prestamos=bd.obtenerTodos();
    }
}
