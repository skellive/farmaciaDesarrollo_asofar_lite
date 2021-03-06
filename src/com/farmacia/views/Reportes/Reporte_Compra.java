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
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
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
public class Reporte_Compra extends javax.swing.JDialog {

    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    CRUD crud = new CRUD();
    int x, y;
    String buscar = "";
    Formulario F = new Formulario();
    ArrayList<JoinListarNotaPedidosCabecera> lista = null;
    JoinListarNotaPedidosCabecera objeto = null;
    Calendar c1 = Calendar.getInstance();
    int dia = (c1.get(Calendar.DATE));
    int mes = (c1.get(Calendar.MONTH)) + 1;
    int ano = (c1.get(Calendar.YEAR));

    /**
     * Creates new form Reporte_Compra
     * @param parent
     * @param modal
     */
    public Reporte_Compra(java.awt.Frame parent, boolean modal) {
        super(parent, modal = false);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        lista = crud.listarCabeceraNotaPedidoEnCompras(4);
        Tablas.CargarJoinListaCabeceraPedido(tbaCabeceraCompra, lista);
//        Chooser1.getDateFormatString();
//        Chooser2.getDateFormatString();
        TotalPro();
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
        tbaCabeceraCompra = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JButton();
        Chooser1 = new com.toedter.calendar.JDateChooser();
        Chooser2 = new com.toedter.calendar.JDateChooser();
        Txt_Total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COMPRAS");
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

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setText("SALIR");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbaCabeceraCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbaCabeceraCompra.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        tbaCabeceraCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbaCabeceraCompra.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbaCabeceraCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbaCabeceraCompraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbaCabeceraCompraMousePressed(evt);
            }
        });
        tblProduc.setViewportView(tbaCabeceraCompra);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTRE");

        BtnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnBuscar.setText("BUSCAR");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        Chooser1.setDateFormatString("yyyy/MM/dd");
        Chooser1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        Chooser2.setDateFormatString("yyyy/MM/dd");
        Chooser2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        Chooser2.setMaxSelectableDate(new java.util.Date(253370786471000L));

        Txt_Total.setEditable(false);
        Txt_Total.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        Txt_Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Txt_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_TotalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TOTAL:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/flechas-de-progreso.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnimprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnimprimir.setText("IMPRIMIR");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("EXCEL");
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Chooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Chooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(665, 665, 665)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(201, 201, 201)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(67, 67, 67)
                                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        for (int i = 0; i < tbaCabeceraCompra.getRowCount(); i++) {
            total1 = total1 + Double.parseDouble("" + lista.get(i).getTotal());
        }
        Txt_Total.setText(Formato_Numeros.formatoNumero(total1.toString()));
    }
    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed
    public JoinListarNotaPedidosCabecera devuelveObjeto(String datos, ArrayList<JoinListarNotaPedidosCabecera> listarobj) {
        JoinListarNotaPedidosCabecera objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_cabecera_nota_pedidos().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;

    }
    private void tbaCabeceraCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaCabeceraCompraMousePressed
        int i = 0;

        if (evt.getClickCount() == 2) {
            i = tbaCabeceraCompra.getSelectedRow();
            lista = crud.listarCabeceraNotaPedidoEnCompras(4);
            objeto = devuelveObjeto(tbaCabeceraCompra.getValueAt(i, 0).toString(), lista);

            if (objeto != null) {
                Reporte_DetalleCompra Man = new Reporte_DetalleCompra(new javax.swing.JFrame(), true, objeto);

                Man.setVisible(true);

            }
        }

    }//GEN-LAST:event_tbaCabeceraCompraMousePressed

    private void tbaCabeceraCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaCabeceraCompraMouseClicked

    }//GEN-LAST:event_tbaCabeceraCompraMouseClicked

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        JoinListarNotaPedidosCabecera dc = new JoinListarNotaPedidosCabecera();
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
                lista = crud.RangoFechaCompra(1, dc);
                Tablas.CargarJoinListadoCabeceraNotaPedidos(tbaCabeceraCompra, lista);
                TotalPro();
            }
            if (F1 != null && F2 != null) {

                dc.setFecha1(F.getFecha(Chooser1));
                dc.setFecha2(F.getFecha(Chooser2) + " 23:59:59");
                lista = crud.RangoFechaCompra(1, dc);
                Tablas.CargarJoinListaCabeceraPedido(tbaCabeceraCompra, lista);
                TotalPro();
            }
            TotalPro();
        } catch (Exception e) {
            ///JOptionPane.showMessageDialog(null, "Ha ocurrido un error del tipo " + e + ", se recomienda cerrar esta ventana y reabrirla.");
        }
        TotalPro();
    }//GEN-LAST:event_BtnBuscarActionPerformed
//Producto, cantidad, unidad
    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
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

            for (int i = 0; i < tbaCabeceraCompra.getRowCount(); i++) {
                ClaseReporte creporte = new ClaseReporte(
                        fecha,
                        fecha2,
                        tbaCabeceraCompra.getValueAt(i, 0).toString(),
                        tbaCabeceraCompra.getValueAt(i, 1).toString(),
                        tbaCabeceraCompra.getValueAt(i, 2).toString(),
                        tbaCabeceraCompra.getValueAt(i, 3).toString(),
                        tbaCabeceraCompra.getValueAt(i, 4).toString(),
                        tbaCabeceraCompra.getValueAt(i, 5).toString(),
                        tbaCabeceraCompra.getValueAt(i, 6).toString(),
                        Txt_Total.getText().toString());
                lista.add(creporte);
            }

            try {
                JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("Reporte_Compra.jasper"));
                JasperPrint jprint = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
                JDialog ventana = new JDialog();
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

            for (int i = 0; i < tbaCabeceraCompra.getRowCount(); i++) {
                ClaseReporte creporte = new ClaseReporte(
                        tbaCabeceraCompra.getValueAt(i, 0).toString(),
                        tbaCabeceraCompra.getValueAt(i, 1).toString(),
                        tbaCabeceraCompra.getValueAt(i, 2).toString(),
                        tbaCabeceraCompra.getValueAt(i, 3).toString(),
                        tbaCabeceraCompra.getValueAt(i, 4).toString(),
                        tbaCabeceraCompra.getValueAt(i, 5).toString(),
                        tbaCabeceraCompra.getValueAt(i, 6).toString(),
                        Txt_Total.getText().toString());
                lista.add(creporte);
            }

            try {
                JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("Reporte_ComprasinDate.jasper"));
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
        }
    }//GEN-LAST:event_btnimprimirActionPerformed

    /*
     buscar = buscar1.getText();
     Tablas.filtro(buscar, tbaCabeceraCompra);
     TotalPro();
     } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "Ha ocurrido un error del tipo " + e + ", se recomienda cerrar esta ventana y reabrirla.");
     }
     TotalPro();
     */

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reporteExcel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Txt_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_TotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        lista = crud.listarCabeceraNotaPedidoEnCompras(4);
        Tablas.CargarJoinListaCabeceraPedido(tbaCabeceraCompra, lista);
//            Tablas.CargarJoinListaCabeceraPedido(tbaCabeceraCompra, lista);
            TotalPro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error del tipo " + e + ", se recomienda cerrar esta ventana y reabrirla.");
        }
        TotalPro();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void reporteExcel() {

        int r = JOptionPane.showConfirmDialog(null, "¿Generar Reporte?", "", JOptionPane.YES_NO_OPTION);
        String dir = System.getProperty("user.home");
        //dir + "\\Documents\\

        try {
            if (r == JOptionPane.YES_OPTION) {
                Workbook book = new XSSFWorkbook();
                Sheet sheet = book.createSheet("REPORTE");
                InputStream is = new FileInputStream(dir + "\\Documents\\reporteExcel\\img\\asofar.jpg");
                byte[] bytes = IOUtils.toByteArray(is);
                int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
                is.close();

                CreationHelper help = book.getCreationHelper();
                Drawing draw = sheet.createDrawingPatriarch();

                ClientAnchor anchor = help.createClientAnchor();
                anchor.setCol1(0);
                anchor.setRow1(1);
                Picture pict = draw.createPicture(anchor, imgIndex);
                pict.resize(3, 5);

                CellStyle tituloEstilo = book.createCellStyle();
                tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
                tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
                org.apache.poi.ss.usermodel.Font fuenteTitulo = book.createFont();
                fuenteTitulo.setFontName("Arial");
                fuenteTitulo.setBold(true);
                fuenteTitulo.setFontHeightInPoints((short) 14);
                tituloEstilo.setFont(fuenteTitulo);

                Row filaTitulo = sheet.createRow(3);
                Cell celdaTitulo = filaTitulo.createCell(3);
                celdaTitulo.setCellStyle(tituloEstilo);
                celdaTitulo.setCellValue("Reporte de Compras");

                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));

                String[] cabecera = new String[]{"Nº", "CODIGO", "PROVEEDOR", "REPRESENTANTE", "TELEFONO", "FECHA DE CREACION", "PLAZO", "TOTAL"};

                CellStyle headerStyle = book.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                headerStyle.setBorderLeft(BorderStyle.THIN);
                headerStyle.setBorderRight(BorderStyle.THIN);
                headerStyle.setBorderBottom(BorderStyle.THIN);

                org.apache.poi.ss.usermodel.Font font = book.createFont();
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

                ps = conn.prepareStatement("call reporteExcelCompra()");
                String F1 = F.getFecha(Chooser1) + " 23:59:59";
                String F2 = F.getFecha(Chooser2) + " 23:59:59";
                if (Chooser1.getDate() != null || Chooser2.getDate() != null) {
                    ps = conn.prepareStatement("call reporteExcelCompraFiltroFecha(?, ?)");
                    ps.setString(1, F1);
                    ps.setString(2, F2);
                }

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

                sheet.setZoom(120);

                //System.out.println(dir);
                FileOutputStream fileout = new FileOutputStream(dir + "\\Documents\\reporteExcel\\reporteCompra\\reporteCompra" + dia + "-" + mes + "-" + ano + ".xlsx");
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
            java.util.logging.Logger.getLogger(Reporte_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reporte_Compra dialog = new Reporte_Compra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tbaCabeceraCompra;
    private javax.swing.JScrollPane tblProduc;
    // End of variables declaration//GEN-END:variables
}
