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
            Class.forName("com.mysql.jdbc.Driver");


            /*local*/     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asofar_moduloprueba", "root", "root");

            /*remota*/ //conn = DriverManager.getConnection("jdbc:mysql://mysql-asofar.alwaysdata.net:3306/asofar_moduloprueba", "asofar", "asofarLITEbase");

            System.out.println("Conectado");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
        }

        return conn;
    }
}
