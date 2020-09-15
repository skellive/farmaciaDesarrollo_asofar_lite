package com.farmacia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public Connection conectar() {
        Connection conn = null;
        String ip = "172.10.180.234";
        String iplocal = "localhost";
        String claves = "*ISTG.2007!";
        String clavel = "itsgg";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //conn = DriverManager.getConnection("jdbc:mysql://"+iplocal+":3306/moduloprueba", "root", "rootpassword");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/moduloprueba", "root", "");
                System.out.println("Conectado");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
        }

        return conn;
    }
}
