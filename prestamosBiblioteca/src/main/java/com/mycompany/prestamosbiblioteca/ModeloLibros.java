/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import javax.swing.table.AbstractTableModel;


public class ModeloLibros extends AbstractTableModel{
    private  ListaDeLibros libros;
    public ModeloLibros() {
        libros=new ListaDeLibros();    
        libros.cargarDesdeBD();
    }
    
    
    @Override
    public int getRowCount() {
        return libros.total();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro aux=libros.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getId();
            case 1: return aux.getTitulo();
            case 2: return aux.getAutor();
            case 3: return aux.getEditorial();
            default: return aux.isDisponibilidad();
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0: return "ID";
            case 1: return "TITULO";
            case 2: return "AUTOR";
            case 3: return "EDITORIAL";
            default: return "DISPONIBILIDAD";
        }
    }
    
    @Override
    public Class getColumnClass(int col) {
        switch(col){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            default: return Boolean.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if(col!=0)
            return true;        
        return false;
    }
  
    @Override
    public void setValueAt(Object value, int fila, int columna) {
        Libro libro=libros.obtener(fila);
        switch(columna){
            case 0: libro.setId((int)value);
                    break;
            case 1: libro.setTitulo((String)value);
                    break;
            case 2: libro.setAutor((String)value);
                    break;
            case 3: libro.setEditorial((String)value);
                    break;
            default: libro.setDisponibilidad((boolean)value);
        }  
        BDLibroMYSQL bd=new BDLibroMYSQL();
        bd.actualizar(libro);
        fireTableCellUpdated(fila, columna);
    }
    
    public void agregarLibro(Libro libro){
        libros.agregar(libro);
        this.fireTableDataChanged();   
    }
    
    public void eliminarLibro(int indice){
        libros.eliminar(indice);
        this.fireTableDataChanged(); 
    }
    
    public Libro getLibro(int indice){
        return libros.obtener(indice);
    }
    
}
