/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prestamosbiblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class BDPrestamoMYSQL {
    public Prestamo obtener(String id) {        
        return null;
    }
    public boolean eliminar(String id) { 
        String sql="delete from  prestamos where id="
                + id;
        System.out.println(sql);        
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);       
    }

    public boolean actualizar(Prestamo prestamo) {
        String sql="UPDATE prestamos SET id_libro='"
                + prestamo.getId_libro() + "', id_usuario='"
                + prestamo.getId_usuario() + "', fecha_prestamo='"
                + prestamo.getFecha_prestamo() + "', fecha_devolucion='"
                + prestamo.getFecha_devolucion() +"' WHERE id="
                + prestamo.getId();
        System.out.println(sql);        
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);        
    }    
    public LinkedList<Prestamo> obtenerTodos() {
        String sql="SELECT * FROM prestamos";
        LinkedList<Prestamo> lista=null;
        MYSQL mysql=new MYSQL();
        ResultSet r=mysql.ejecutarQuery(sql);
        if(r!=null){
            try {
                lista=new LinkedList<>();
                while(r.next()){
                   int id= r.getInt("id");
                   int id_libro=r.getInt("id_libro");
                   int id_usuario=r.getInt("id_usuario");   
                   String fecha_prestamo=r.getString("fecha_prestamo");  
                   String fecha_devolucion=r.getString("fecha_devolucion");  
                   lista.add(new Prestamo(id, id_libro, id_usuario, fecha_prestamo, fecha_devolucion));
                }                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
                
        return lista;
    }
    public boolean registrar(Prestamo prestamo) {
        String sql="insert into prestamos(id_libro,id_usuario,fecha_prestamo,fecha_devolucion) values('" 
                + prestamo.getId_libro()+"','"
                + prestamo.getId_usuario()+"','"
                + prestamo.getFecha_prestamo()+"','"
                + "xxx"+"');";
        System.out.println(sql);        
        MYSQL mysql = new MYSQL();
        return mysql.ejecutarUpdate(sql);        
    }
    
    public LinkedList<Prestamo> obtenerParaHistorial(int idU) {
    String sql = "SELECT * FROM Prestamos WHERE id_usuario = " + idU;
    LinkedList<Prestamo> lista = new LinkedList<>();
    MYSQL mysql = new MYSQL();
    ResultSet r = mysql.ejecutarQuery(sql);
    if (r != null) {
        try {
            while (r.next()) {
                int id = r.getInt("id");
                int id_libro = r.getInt("id_libro");
                int id_usuario = r.getInt("id_usuario");
                String fecha_prestamo = r.getString("fecha_prestamo");
                String fecha_devolucion = r.getString("fecha_devolucion");
                lista.add(new Prestamo(id, id_libro, id_usuario, fecha_prestamo, fecha_devolucion));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return lista;
}

}
