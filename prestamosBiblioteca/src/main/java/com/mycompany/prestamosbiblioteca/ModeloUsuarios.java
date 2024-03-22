package com.mycompany.prestamosbiblioteca;
import javax.swing.table.AbstractTableModel;


public class ModeloUsuarios extends AbstractTableModel{
    private  ListaDeUsuarios usuarios;
    public ModeloUsuarios() {
        usuarios=new ListaDeUsuarios();    
        usuarios.cargarDesdeBD();
    }
    
    
    @Override
    public int getRowCount() {
        return usuarios.total();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario aux=usuarios.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getId();
            case 1: return aux.getNombre();
            default: return aux.getCorreo();
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0: return "ID";
            case 1: return "USUARIO";
            default: return "CORREO";
        }
    }
    
    @Override
    public Class getColumnClass(int col) {
        switch(col){
            case 0: return Integer.class;
            case 1: return String.class;
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
        Usuario usuario=usuarios.obtener(fila);
        switch(columna){
            case 0: usuario.setId((int)value);
                    break;
            case 1: usuario.setNombre((String)value);
                    break;
            default: usuario.setCorreo((String)value);
        }  
        BDUsuarioMYSQL bd=new BDUsuarioMYSQL();
        bd.actualizar(usuario);
        fireTableCellUpdated(fila, columna);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.agregar(usuario);
        this.fireTableDataChanged();   
    }
    
    public void eliminarUsuario(int indice){
        usuarios.eliminar(indice);
        this.fireTableDataChanged(); 
    }
    
    public Usuario getUsuario(int indice){
        return usuarios.obtener(indice);
    }
    
}
