package com.mycompany.prestamosbiblioteca;

import java.sql.*;

public class MYSQL {

    private java.sql.Connection conexion = null;

    public MYSQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
        } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
        }
    }

    public Connection abrir() {
        try {
            if (conexion == null || conexion.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/biblioteca?user=root&password=root&serverTimezone=UTC&useSSL=false";
                conexion = DriverManager.getConnection(url);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conexion;
    }

    public void cerrar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //DELETE INSERT UPDATE
    public boolean ejecutarUpdate(String querySQL) {
        try {
            abrir();
            Statement r = conexion.createStatement();
            if (r.executeUpdate(querySQL) != 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cerrar();
        }
        return false;
    }

    //SELECT
    public ResultSet ejecutarQuery(String querySQL) {
        try {
            abrir();
            Statement r = conexion.createStatement();
            return r.executeQuery(querySQL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
