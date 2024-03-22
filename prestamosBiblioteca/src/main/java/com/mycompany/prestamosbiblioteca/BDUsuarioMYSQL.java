/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class BDUsuarioMYSQL {
    public Usuario obtener(String id) {        
        return null;
    }
    public boolean eliminar(String id) { 
        String sql="delete from  usuarios where id="
                + id;
        System.out.println(sql);        
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);       
    }

    public boolean actualizar(Usuario usuario) {
        String sql="UPDATE usuarios SET nombre='"
                + usuario.getNombre() + "', correo='"
                + usuario.getCorreo() +"' WHERE id="
                + usuario.getId();
        System.out.println(sql);        
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);        
    }    
    public LinkedList<Usuario> obtenerTodos() {
        String sql="SELECT * FROM usuarios";
        LinkedList<Usuario> lista=null;
        MYSQL mysql=new MYSQL();
        ResultSet r=mysql.ejecutarQuery(sql);
        if(r!=null){
            try {
                lista=new LinkedList<>();
                while(r.next()){
                   int id= r.getInt("id");
                   String nombre=r.getString("nombre");
                   String correo=r.getString("correo");              
                   lista.add(new Usuario(id, nombre, correo));
                }                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
                
        return lista;
    }
    public boolean registrar(Usuario usuario) {
        String sql="insert into usuarios(nombre,correo) values('" 
                + usuario.getNombre()+"','"
                + usuario.getCorreo()+"');";
        System.out.println(sql);        
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);        
    }
}
