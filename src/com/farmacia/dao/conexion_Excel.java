/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
public class conexion_Excel {

    public static void subirArchivosProductos(String ruta) throws IOException, SQLException, ClassNotFoundException {
        Conexion c = new Conexion();

        Connection con = c.conectar();
        PreparedStatement ps;
        FileInputStream file = new FileInputStream(new File(ruta));

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        int numFilas = sheet.getLastRowNum();
        for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                
        }

    }

}
