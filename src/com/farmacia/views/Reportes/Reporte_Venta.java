/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.Reportes;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.conponentes.Formulario;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.dao.Conexion;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.join_entidades.JoinListarCabeceraVenta;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ineval
 */
public class Reporte_Venta extends javax.swing.JDialog {

    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    CRUD crud = new CRUD();
    int x, y;
    String buscar = "";
    Formulario F = new Formulario();
    ArrayList<JoinListarCabeceraVenta> lista = null;
    JoinListarCabeceraVenta objeto = null;
    Calendar c1 = Calendar.getInstance();
    int dia = (c1.get(Calendar.DATE));
    int mes = (c1.get(Calendar.MONTH));
    int ano = (c1.get(Calendar.YEAR));

    /**
     * Creates new form Reporte_Venta
     */
    public Reporte_Venta(java.awt.Frame parent, boolean modal) {
        super(parent, modal = false);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        lista = crud.ListarCabeceraVentas(1);
        Tablas.CargarJoinListaCabeceraVenta(tbaCabeceraVenta, lista);
        /*        lista = crud.ListarCabeceraVentas(1);
         Tablas.CargarJoinListaCabeceraVenta(tbaCabeceraVenta, lista);*/
        TotalPro();
        TotalUti();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnSalir2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tblProduc = new javax.swing.JScrollPane();
        tbaCabeceraVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JButton();
        Chooser1 = new com.toedter.calendar.JDateChooser();
        Chooser2 = new com.toedter.calendar.JDateChooser();
        buscar1 = new javax.swing.JTextField();
        Txt_Total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Txt_Utilidad = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VENTAS");
        jLabel7.setOpaque(true);
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel7MouseDragged(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        btnSalir2.setBackground(new java.awt.Color(153, 0, 51));
        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir2.setText("SALIR");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbaCabeceraVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbaCabeceraVenta.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        tbaCabeceraVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbaCabeceraVenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbaCabeceraVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbaCabeceraVentaMousePressed(evt);
            }
        });
        tblProduc.setViewportView(tbaCabeceraVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ENTRE");

        BtnBuscar.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        BtnBuscar.setText("BUSCAR");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        Chooser1.setDateFormatString("yyyy/MM/dd");
        Chooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        Chooser2.setDateFormatString("yyyy/MM/dd");
        Chooser2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        buscar1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        buscar1.setPreferredSize(new java.awt.Dimension(6, 28));
        buscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar1KeyReleased(evt);
            }
        });

        Txt_Total.setEditable(false);
        Txt_Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Txt_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_TotalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TOTAL VENTAS:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/flechas-de-progreso.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TOTAL UTILIDAD:");

        Txt_Utilidad.setEditable(false);
        Txt_Utilidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Utilidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton2.setText("EXCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("IMPRIMIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Chooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Chooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248)
                        .addComponent(buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_Utilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jButton2)
                .addGap(66, 66, 66)
                .addComponent(jButton3)
                .addGap(85, 85, 85)
                .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Utilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void TotalPro() {
        Double total1 = 0.0;
        BigDecimal Suma = new BigDecimal("0.00");
        for (int i = 0; i < tbaCabeceraVenta.getRowCount(); i++) {
            total1 = total1 + Double.parseDouble("" + lista.get(i).getTotal());
        }
        Txt_Total.setText(Formato_Numeros.formatoNumero(total1.toString()));
    }

    public void TotalUti() {
        Double total1 = 0.0;
        BigDecimal Suma = new BigDecimal("0.00");
        for (int i = 0; i < tbaCabeceraVenta.getRowCount(); i++) {
            total1 = total1 + Double.parseDouble("" + lista.get(i).getUtilidad());
        }
        Txt_Utilidad.setText(Formato_Numeros.formatoNumero(total1.toString()));
    }

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_btnSalir2ActionPerformed
    public JoinListarCabeceraVenta devuelveObjeto(String datos, ArrayList<JoinListarCabeceraVenta> listarobj) {
        JoinListarCabeceraVenta objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getMun_venta())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;

    }
    private void tbaCabeceraVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaCabeceraVentaMousePressed
        int i = 0;

        if (evt.getClickCount() == 2) {
            i = tbaCabeceraVenta.getSelectedRow();
            lista = crud.ListarCabeceraVentas(1);
            objeto = devuelveObjeto(tbaCabeceraVenta.getValueAt(i, 0).toString(), lista);

            //System.out.println("ventas " + objeto.getNombre_completo_cliente());
            if (objeto != null) {
                Reporte_DetalleVenta Rdv = new Reporte_DetalleVenta(new javax.swing.JFrame(), true, objeto);
                Rdv.setVisible(true);
            }
        }

    }//GEN-LAST:event_tbaCabeceraVentaMousePressed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        JoinListarCabeceraVenta dc = new JoinListarCabeceraVenta();
        String F1 = F.getFecha(Chooser1);
        String F2 = F.getFecha(Chooser2);
        dc.setFecha1(F1);
        dc.setFecha2(F2);
        try {
            if (F1 == null) {
                JOptionPane.showMessageDialog(this, "INGRESE UNA FECHA");
            }

            if (F1 != null && F2 == null) {

                dc.setFecha1(F1);
                dc.setFecha2((F1) + " 23:59:59");
                lista = crud.RangoFechaVenta(1, dc);
                Tablas.CargarJoinListaCabeceraVenta(tbaCabeceraVenta, lista);
                TotalPro();
                TotalUti();
            }
            if (F1 != null && F2 != null) {

                dc.setFecha1(F.getFecha(Chooser1));
                dc.setFecha2(F.getFecha(Chooser2) + " 23:59:59");
                lista = crud.RangoFechaVenta(1, dc);
                Tablas.CargarJoinListaCabeceraVenta(tbaCabeceraVenta, lista);
                TotalPro();
                TotalUti();
            }
            TotalPro();
            TotalUti();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error del tipo " + e + ", se recomienda cerrar esta ventana y reabrirla.");
        }
        
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void buscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar1KeyReleased

        try {
            buscar = buscar1.getText();
            Tablas.filtro(buscar, tbaCabeceraVenta);
            TotalPro();
            TotalUti();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error del tipo " + e + ", se recomienda cerrar esta ventana y reabrirla.");
        }
        TotalPro();
        TotalUti();
    }//GEN-LAST:event_buscar1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            lista = crud.ListarCabeceraVentas(1);
            Tablas.CargarJoinListaCabeceraVenta(tbaCabeceraVenta, lista);
            TotalPro();
            TotalUti();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error del tipo " + e + ", se recomienda cerrar esta ventana y reabrirla.");
        }
        TotalPro();
        TotalUti();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reporte();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (Chooser1.getDate() != null || Chooser2.getDate() != null) {
            String dia = Integer.toString(Chooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(Chooser1.getCalendar().get(Calendar.MONTH));
            String año = Integer.toString(Chooser1.getCalendar().get(Calendar.YEAR));
            String fecha = (dia + "-" + mes + "-" + año);
            String dia2 = Integer.toString(Chooser2.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes2 = Integer.toString(Chooser2.getCalendar().get(Calendar.MONTH));
            String año2 = Integer.toString(Chooser2.getCalendar().get(Calendar.YEAR));
            String fecha2 = (dia2 + "-" + mes2 + "-" + año2);
            ArrayList lista = new ArrayList();

            for (int i = 0; i < tbaCabeceraVenta.getRowCount(); i++) {
                ClaseReporte creporte = new ClaseReporte(
                        tbaCabeceraVenta.getValueAt(i, 0).toString(),
                        //tbaCabeceraVenta.getValueAt(i, 1).toString(),
                        tbaCabeceraVenta.getValueAt(i, 2).toString(),
                        tbaCabeceraVenta.getValueAt(i, 3).toString(),
                        tbaCabeceraVenta.getValueAt(i, 4).toString(),
                        tbaCabeceraVenta.getValueAt(i, 5).toString(),
                        tbaCabeceraVenta.getValueAt(i, 6).toString(),
                        tbaCabeceraVenta.getValueAt(i, 7).toString(),
                        tbaCabeceraVenta.getValueAt(i, 8).toString(),
                        tbaCabeceraVenta.getValueAt(i, 9).toString(),
                        tbaCabeceraVenta.getValueAt(i, 10).toString(),
                        tbaCabeceraVenta.getValueAt(i, 11).toString(),
                        tbaCabeceraVenta.getValueAt(i, 12).toString(),
                        fecha,
                        fecha2,
                        Txt_Total.getText().toString(),
                        Txt_Utilidad.getText().toString());
                lista.add(creporte);
            }

            try {
                JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("ventaSinDate.jasper"));
                JasperPrint jprint = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                JDialog ventana = new JDialog();

//            JRViewer jviewer = new JRViewer(jprint);
                JRViewer jviewer = new net.sf.jasperreports.view.JRViewer(jprint);
                ventana.add(jviewer);
                ventana.setSize(new Dimension(ancho / 2, alto / 2));
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                jviewer.setFitWidthZoomRatio();

            } catch (JRException ex) {
                Logger.getLogger(Reporte_Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ArrayList lista = new ArrayList();

            for (int i = 0; i < tbaCabeceraVenta.getRowCount(); i++) {
                ClaseReporte creporte = new ClaseReporte(
                        tbaCabeceraVenta.getValueAt(i, 0).toString(),
                        tbaCabeceraVenta.getValueAt(i, 2).toString(),
                        tbaCabeceraVenta.getValueAt(i, 3).toString(),
                        tbaCabeceraVenta.getValueAt(i, 4).toString(),
                        tbaCabeceraVenta.getValueAt(i, 5).toString(),
                        tbaCabeceraVenta.getValueAt(i, 6).toString(),
                        tbaCabeceraVenta.getValueAt(i, 7).toString(),
                        tbaCabeceraVenta.getValueAt(i, 8).toString(),
                        tbaCabeceraVenta.getValueAt(i, 9).toString(),
                        tbaCabeceraVenta.getValueAt(i, 10).toString(),
                        tbaCabeceraVenta.getValueAt(i, 11).toString(),
                        tbaCabeceraVenta.getValueAt(i, 12).toString(),
                        Txt_Total.getText().toString(),
                        Txt_Utilidad.getText().toString());
                lista.add(creporte);
            }

            try {
                JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("Venta.jasper"));
                JasperPrint jprint = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                //JDialog ventana = new JDialog();
                JDialog ventana = new JDialog();

//            JRViewer jviewer = new JRViewer(jprint);
                JRViewer jviewer = new net.sf.jasperreports.view.JRViewer(jprint);
                ventana.add(jviewer);
                ventana.setSize(new Dimension(ancho / 2, alto / 2));
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                jviewer.setFitWidthZoomRatio();

            } catch (JRException ex) {
                Logger.getLogger(Reporte_Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Txt_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_TotalActionPerformed

    public void reporte() {

        int r = JOptionPane.showConfirmDialog(null, "¿Generar Reporte?", "", JOptionPane.YES_NO_OPTION);

        try {
            if (r == JOptionPane.YES_OPTION) {
                Workbook book = new XSSFWorkbook();
                Sheet sheet = book.createSheet("REPORTE");
                InputStream is = new FileInputStream("src\\img\\asofarLite.png");
                byte[] bytes = IOUtils.toByteArray(is);
                int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
                is.close();

                CreationHelper help = book.getCreationHelper();
                Drawing draw = sheet.createDrawingPatriarch();

                ClientAnchor anchor = help.createClientAnchor();
                anchor.setCol1(0);
                anchor.setRow1(1);
                Picture pict = draw.createPicture(anchor, imgIndex);
                pict.resize(2, 5);

                CellStyle tituloEstilo = book.createCellStyle();
                tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
                tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
                Font fuenteTitulo = book.createFont();
                fuenteTitulo.setFontName("Arial");
                fuenteTitulo.setBold(true);
                fuenteTitulo.setFontHeightInPoints((short) 14);
                tituloEstilo.setFont(fuenteTitulo);

                Row filaTitulo = sheet.createRow(3);
                Cell celdaTitulo = filaTitulo.createCell(2);
                celdaTitulo.setCellStyle(tituloEstilo);
                celdaTitulo.setCellValue("Reporte de Ventas");

                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));

                String[] cabecera = new String[]{"NUMERO DE VENTA", "SUCURSAL", "FECHA", "CLIENTE", "CEDULA CLIENTE", "USUARIO", "TIPO DE PAGO", "TIPO DE VENTA", "SUBTOTAL", "IVA", "DESCUENTO", "TOTAL", "UTILIDAD", "ESTADO"};

                CellStyle headerStyle = book.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                headerStyle.setBorderLeft(BorderStyle.THIN);
                headerStyle.setBorderRight(BorderStyle.THIN);
                headerStyle.setBorderBottom(BorderStyle.THIN);

                Font font = book.createFont();
                font.setFontName("Arial");
                font.setBold(true);
                font.setColor(IndexedColors.WHITE.getIndex());
                font.setFontHeightInPoints((short) 12);
                headerStyle.setFont(font);

                Row filaEncabezados = sheet.createRow(6);

                for (int i = 0; i < cabecera.length; i++) {
                    Cell celdaEnzabezado = filaEncabezados.createCell(i);
                    celdaEnzabezado.setCellStyle(headerStyle);
                    celdaEnzabezado.setCellValue(cabecera[i]);
                }

                Conexion con = new Conexion();
                PreparedStatement ps;
                ResultSet rs;
                java.sql.Connection conn = con.conectar();

                int numFilaDatos = 7;

                CellStyle datosEstilo = book.createCellStyle();
                datosEstilo.setBorderBottom(BorderStyle.THIN);
                datosEstilo.setBorderLeft(BorderStyle.THIN);
                datosEstilo.setBorderRight(BorderStyle.THIN);
                datosEstilo.setBorderBottom(BorderStyle.THIN);

                ps = conn.prepareStatement("SELECT `cabecera_venta`.`num_venta`,`sucursal`.`nombre` AS 'Sucursal',cabecera_venta.`fecha_creacion` AS 'Fecha',\n"
                        + "CONCAT (`clientes`.`Nombre`,\" \",`clientes`.`Apellido`)AS 'Cliente',\n"
                        + "`clientes`.`Cedula` AS 'Cedula_cliente',\n"
                        + "CONCAT (`fc_usuario`.`nombres`,\" \",`fc_usuario`.`apellidos`)AS 'Usuario',\n"
                        + "`cabecera_venta`.`tipo_pago`,`cabecera_venta`.`tipo_venta`,\n"
                        + "ROUND ((`cabecera_venta`.`subtotal_con_iva` + cabecera_venta.`subtotal_sin_iva`),2)  AS 'Subtotal',\n"
                        + "ROUND (cabecera_venta.`iva_total`,2) AS 'Iva',\n"
                        + "ROUND (cabecera_venta.`descuento_total`,2) AS 'Descuento',\n"
                        + "ROUND (cabecera_venta.`total`,2)AS 'Total',\n"
                        + "ROUND (`cabecera_venta`.`utilidad`,2) AS 'Utilidad',\n"
                        + "(`cabecera_venta`.`estado`) AS 'Estado'\n"
                        + "FROM `cabecera_venta` \n"
                        + "INNER JOIN `clientes` \n"
                        + "ON cabecera_venta.`id_cliente` = `clientes`.`id_Clientes` \n"
                        + "INNER JOIN `sucursal`\n"
                        + "ON cabecera_venta.`id_sucursal` = `sucursal`.`id_sucursal` \n"
                        + "INNER JOIN `fc_session`\n"
                        + "ON `fc_session`.`id_sesion` = `cabecera_venta`.`id_usuario` \n"
                        + "INNER JOIN `fc_usuario`\n"
                        + "ON `fc_session`.`id_usuario` = `fc_usuario`.`id_usuario`;");
                rs = ps.executeQuery();

                int numCol = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    Row filaDatos = sheet.createRow(numFilaDatos);

                    for (int a = 0; a < numCol; a++) {

                        Cell CeldaDatos = filaDatos.createCell(a);
                        CeldaDatos.setCellStyle(datosEstilo);

                        if (a == 0) {
                            CeldaDatos.setCellValue(rs.getInt(a + 1));
                        } else {
                            CeldaDatos.setCellValue(rs.getString(a + 1));
                        }
                    }

                    numFilaDatos++;

                }

                conn.close();
                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);
                sheet.autoSizeColumn(2);
                sheet.autoSizeColumn(3);
                sheet.autoSizeColumn(4);
                sheet.autoSizeColumn(5);
                sheet.autoSizeColumn(6);
                sheet.autoSizeColumn(7);
                sheet.autoSizeColumn(8);
                sheet.autoSizeColumn(9);
                sheet.autoSizeColumn(10);
                sheet.autoSizeColumn(11);
                sheet.autoSizeColumn(12);
                sheet.autoSizeColumn(13);

                sheet.setZoom(120);

                String dir = System.getProperty("user.home");
                FileOutputStream fileout = new FileOutputStream(dir + "\\Documents\\reporteExcel\\reporteVenta\\reporte" + dia + "-" + mes + "-" + ano + ".xlsx");
                book.write(fileout);
                fileout.close();

                JOptionPane.showMessageDialog(null, "Generado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al generar el reporte");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reporte_Venta dialog = new Reporte_Venta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private com.toedter.calendar.JDateChooser Chooser1;
    private com.toedter.calendar.JDateChooser Chooser2;
    private javax.swing.JTextField Txt_Total;
    private javax.swing.JTextField Txt_Utilidad;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JTextField buscar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tbaCabeceraVenta;
    private javax.swing.JScrollPane tblProduc;
    // End of variables declaration//GEN-END:variables
}
