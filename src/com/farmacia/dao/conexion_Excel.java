/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
public class conexion_Excel {

    public static void subirArchivosProductos(String ruta) throws IOException, SQLException, ClassNotFoundException {
        try{
        Conexion c = new Conexion();

        Connection con = c.conectar();
        PreparedStatement ps;
        FileInputStream file = new FileInputStream(new File(ruta));

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        int numFilas = sheet.getLastRowNum();
        for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                ps = con.prepareStatement("INSERT INTO productos_app (codigo_barras, nombre, descripcion, peso, id_tipo, id_medidas, id_categoria, id_marcas, estado, id_usuario, iva, cantidad_minima, receta, unidades, registro_actualizado, precio_producto_app, id_presentacion) VALUES(?,?,?,?,?,?,?,?,'A',1001,?,?,?,?,'S',?,?)");//17
                ps.setDouble(1, fila.getCell(0).getNumericCellValue());
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setString(3, fila.getCell(2).getStringCellValue());
                ps.setDouble(4, fila.getCell(3).getNumericCellValue());
                ps.setString(5, fila.getCell(4).getStringCellValue());
                ps.setString(6, fila.getCell(5).getStringCellValue());
                ps.setString(7, fila.getCell(6).getStringCellValue());
                ps.setString(8, fila.getCell(7).getStringCellValue());                
                
                ps.setString(11, fila.getCell(8).getStringCellValue());
                ps.setDouble(12, fila.getCell(9).getNumericCellValue());
                ps.setString(13, fila.getCell(10).getStringCellValue());
                ps.setDouble(14, fila.getCell(11).getNumericCellValue());                
                ps.setDouble(16, fila.getCell(12).getNumericCellValue());
                ps.setDouble(17, fila.getCell(13).getNumericCellValue());
                ps.execute();             
        
        }
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        
        }catch(FileNotFoundException ex){
            Logger.getLogger(conexion_Excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }
        
    }

}
