/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.dao;

import com.farmacia.view.excel.subirExcelBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion c = new Conexion();

            Connection con = c.conectar();
        try {
            
            
            CallableStatement ps;
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();
            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                ps = con.prepareCall("{CALL ingreso_pro_excel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//20
                ps.setString(1, String.valueOf(fila.getCell(0).getNumericCellValue()));
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setString(3, fila.getCell(2).getStringCellValue());
                ps.setDouble(4, fila.getCell(3).getNumericCellValue());
                ps.setDouble(5, fila.getCell(4).getNumericCellValue());
                ps.setString(6, fila.getCell(5).getStringCellValue());
                ps.setString(7, fila.getCell(6).getStringCellValue());
                ps.setString(8, fila.getCell(7).getStringCellValue());
                ps.setString(9, fila.getCell(8).getStringCellValue());
                ps.setString(10, fila.getCell(9).getStringCellValue());                
                ps.setDouble(11, fila.getCell(10).getNumericCellValue());
                ps.setString(12, fila.getCell(11).getStringCellValue());
                ps.setDouble(13, fila.getCell(12).getNumericCellValue());
                ps.setDouble(14, fila.getCell(13).getNumericCellValue());
                ps.setDouble(15, fila.getCell(14).getNumericCellValue());
                ps.setDouble(16, fila.getCell(15).getNumericCellValue());
                ps.setDouble(17, fila.getCell(16).getNumericCellValue());
                ps.setDouble(18, fila.getCell(17).getNumericCellValue());
                ps.setString(19, fila.getCell(18).getStringCellValue());
                ps.setDouble(20, fila.getCell(19).getNumericCellValue());
                ps.setString(21, fila.getCell(20).getStringCellValue());
                ps.execute();
                 System.out.println("Correcto");
                
            }
           
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");

        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(conexion_Excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(conexion_Excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problema en base. Error al procesar:" + ex);
        }catch (IOException ex) {
            Logger.getLogger(subirExcelBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problema en datos. Error al procesar:" + ex);
        }
        finally{
            con.close();
        }

    }
    
    public static void subirArchivosProductos_solo(String ruta) throws IOException, SQLException, ClassNotFoundException {
        Conexion c = new Conexion();

            Connection con = c.conectar();
        try {
            
            
            CallableStatement ps;
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();
            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                ps = con.prepareCall("{CALL ingresar_productos_excel_solo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//18
                ps.setString(1, String.valueOf(fila.getCell(0).getNumericCellValue()));
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setString(3, fila.getCell(2).getStringCellValue());
                ps.setDouble(4, fila.getCell(3).getNumericCellValue());
                ps.setDouble(5, fila.getCell(4).getNumericCellValue());
                ps.setString(6, fila.getCell(5).getStringCellValue());
                ps.setString(7, fila.getCell(6).getStringCellValue());
                ps.setString(8, fila.getCell(7).getStringCellValue());
                ps.setString(9, fila.getCell(8).getStringCellValue());
                ps.setString(10, fila.getCell(9).getStringCellValue());                
                ps.setDouble(11, fila.getCell(10).getNumericCellValue());
                ps.setString(12, fila.getCell(11).getStringCellValue());
                ps.setDouble(13, fila.getCell(12).getNumericCellValue());
                ps.setDouble(14, fila.getCell(13).getNumericCellValue());
                ps.setDouble(15, fila.getCell(14).getNumericCellValue());
                ps.setDouble(16, fila.getCell(15).getNumericCellValue());
                ps.setDouble(17, fila.getCell(16).getNumericCellValue());
                ps.setString(18, fila.getCell(17).getStringCellValue());
                ps.execute();
                 System.out.println("Correcto");
                
            }
           
            JOptionPane.showMessageDialog(null, "Productos guardados correctamente");

        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(conexion_Excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al procesar:" + ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(conexion_Excel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problema en base. Error al procesar:" + ex);
        }catch (IOException ex) {
            Logger.getLogger(subirExcelBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problema en datos. Error al procesar:" + ex);
        }
        finally{
            con.close();
        }

    }

}
