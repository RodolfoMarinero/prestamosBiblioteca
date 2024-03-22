package com.mycompany.prestamosbiblioteca;

import java.util.LinkedList;


public class ListaDeUsuarios {
    private LinkedList<Usuario> usuarios;

    public ListaDeUsuarios() {
        usuarios=new LinkedList();
    }
    
    public void agregar(Usuario usuario){  
        usuarios.add(usuario);            
    }
    
    public void eliminar(int indice){
        usuarios.remove(indice);        
    }
       
       
    public int total(){
        return usuarios.size();
    }
    
    public Usuario obtener(int indice){
        return usuarios.get(indice);
    }
    
    public void cargarDesdeBD(){
        BDUsuarioMYSQL bd=new BDUsuarioMYSQL();
        usuarios=bd.obtenerTodos();
    }
}
