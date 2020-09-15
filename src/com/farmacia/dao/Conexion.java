  package com.farmacia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection conectar() throws ClassNotFoundException {
        Connection conn = null;
        String ip = "172.10.180.234";
        String iplocal = "localhost";
        String claves = "*ISTG.2007!";
        String clavel = "itsgg";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://"+iplocal+":3306/moduloprueba", "root", "rootpassword");

            conn = DriverManager.getConnection("jdbc:mysql://mysql-asofar.alwaysdata.net:3306/asofar_moduloprueba", "asofar", "asofarLITEbase");

            System.out.println("Conectado");

        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
        }

        return conn;
    }
}
