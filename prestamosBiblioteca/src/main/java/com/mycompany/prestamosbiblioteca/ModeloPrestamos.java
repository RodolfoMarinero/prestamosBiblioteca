/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import javax.swing.table.AbstractTableModel;


public class ModeloPrestamos extends AbstractTableModel{
    private  ListaDePrestamos prestamos;
    public ModeloPrestamos() {
        prestamos=new ListaDePrestamos();    
        prestamos.cargarDesdeBD();
    }
    
    
    @Override
    public int getRowCount() {
        return prestamos.total();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prestamo aux=prestamos.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getId();
            case 1: return aux.getId_libro();
            case 2: return aux.getId_usuario();
            case 3: return aux.getFecha_prestamo();
            default: return aux.getFecha_devolucion();
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0: return "ID";
            case 1: return "ID_LIBRO";
            case 2: return "ID_USUARIO";
            case 3: return "FECHA_PRESTAMO";
            default: return "FECHA_DEVOLUCION";
        }
    }
    
    @Override
    public Class getColumnClass(int col) {
        switch(col){
            case 0: return Integer.class;
            case 1: return Integer.class;
            case 2: return Integer.class;
            case 3: return String.class;
            default: return String.class;
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
        Prestamo prestamo=prestamos.obtener(fila);
        switch(columna){
            case 0: prestamo.setId((int)value);
                    break;
            case 1: prestamo.setId_libro((int)value);
                    break;
            case 2: prestamo.setId_usuario((int)value);
                    break;
            case 3: prestamo.setFecha_prestamo((String)value);
                    break;
            default: prestamo.setFecha_devolucion((String)value);
        }  
        BDPrestamoMYSQL bd=new BDPrestamoMYSQL();
        bd.actualizar(prestamo);
        fireTableCellUpdated(fila, columna);
    }
    
    public void agregarPrestamo(Prestamo prestamo){
        prestamos.agregar(prestamo);
        this.fireTableDataChanged();   
    }
    
    public void eliminarPrestamo(int indice){
        prestamos.eliminar(indice);
        this.fireTableDataChanged(); 
    }
    
    public Prestamo getPrestamo(int indice){
        return prestamos.obtener(indice);
    }
}
