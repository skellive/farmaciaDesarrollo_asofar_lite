/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.producto;

import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.filtros.filtrosProductos;

import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author User
 */
public class MantenimientoProducto extends javax.swing.JDialog {

    int x, y;
    filtrosProductos fil = new filtrosProductos();
    CRUD crud = new CRUD();
    listarJoinProductosCompras objeto = null;
    static ArrayList<listarJoinProductosCompras> listar = null;
    ArrayList<joinProductoDetallesFaltantes> lista1 = new ArrayList<joinProductoDetallesFaltantes>();
    ArrayList<listarJoinProductosCompras> lista = crud.listarTodoJoinProductos(1);
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    Listar_usuario objUsuario = null;

    public MantenimientoProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Tablas.cargarJoinProductosMCompra(tbacargarProductos, lista);
    }

    public MantenimientoProducto(java.awt.Frame parent, boolean modal, Listar_usuario obj) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Tablas.cargarJoinProductosMCompra(tbacargarProductos, lista);
        objUsuario = obj;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbacargarProductos = new javax.swing.JTable();
        filtro = new javax.swing.JTextField();
        tipofiltro = new javax.swing.JComboBox<>();
        lblBuscar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        lblImprimir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel2.setOpaque(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

        tbacargarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbacargarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbacargarProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbacargarProductosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbacargarProductosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbacargarProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        filtro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        filtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });
        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        tipofiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipofiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "NOMBRE", "TIPO", "MEDIDA", "PRESENTACIÓN", "MARCA" }));
        tipofiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipofiltroActionPerformed(evt);
            }
        });

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/buscar.png"))); // NOI18N
        lblBuscar.setText("BUSCAR");
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel3.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MANTENIMIENTO");
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

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(lblCerrar)
                .addGap(12, 12, 12))
        );

        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/nuevo.png"))); // NOI18N
        lblNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoMouseClicked(evt);
            }
        });

        lblImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/imprimir.png"))); // NOI18N
        lblImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(lblImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNuevo)
                .addGap(239, 239, 239))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImprimir)
                    .addComponent(lblNuevo))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbacargarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbacargarProductosMouseClicked

        //                AgregarFaltantes nc = new AgregarFaltantes(new javax.swing.JFrame(), true);
        //                nc.setVisible(true);

    }//GEN-LAST:event_tbacargarProductosMouseClicked

    private void tbacargarProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbacargarProductosMousePressed
        int i = 0;

        try {
            if (evt.getClickCount() == 2) {
                i = tbacargarProductos.getSelectedRow();
                objeto = devuelveObjeto(tbacargarProductos.getValueAt(i, 0).toString(), lista);
                if (objeto != null) {
                    System.out.println("holaaaaa");
                    modificarProducto acc = new modificarProducto(new javax.swing.JFrame(), true, objeto);
                    acc.setVisible(true);
                    lista.clear();
                    lista = crud.listarTodoJoinProductos(1);
                    Tablas.cargarJoinProductosMCompra(tbacargarProductos, lista);
//                    if (acc.getObjf().getCantidad() > 0) {
//                        lista1.add(acc.getObjf());
//                        // System.out.println(lista1.size()+" lista "+acc.getObjf().getCantidad());
//                        Tablas.cargarJoinProductoIngresoCompras(tbaListaCompras, lista1);
//
//                    }

                }

            }
        } catch (Exception e) {
            Logger.getLogger(MantenimientoProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_tbacargarProductosMousePressed

    public listarJoinProductosCompras devuelveObjeto(String datos, ArrayList<listarJoinProductosCompras> listarobj) {
        listarJoinProductosCompras objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_productos().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;
    }

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        // TODO add your handling code here:
        //        String dat = Filtro.getText();
        //        Tablas.filtro(dat, Tabla);
    }//GEN-LAST:event_filtroKeyReleased

    private void tipofiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipofiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipofiltroActionPerformed

    private void tbacargarProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbacargarProductosMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbacargarProductosMouseReleased

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        String f = filtro.getText().toUpperCase();
        String query = "";
        int pos = tipofiltro.getSelectedIndex();
        if ("".equals(f)) {
            query = fil.comboProductoTodo();
        }
        if (pos == 0) {
            if ("".equals(f)) {
                Tablas.cargarJoinProductosMCompra(tbacargarProductos, lista);
            } else {
                query = fil.comboProductoCodigo() + f;
                System.out.println(query);
            }
        }
        if (pos == 1) {
            query = fil.comboProductoNombre() + f + "%'";
        }
        if (pos == 2) {
            query = fil.comboProductoTipo() + f + "%'";
        }
        if (pos == 3) {
            query = fil.comboProductoMedida() + f + "%'";
        }
        if (pos == 4) {
            query = fil.comboProductoEnvase() + f + "%'";
        }
        if (pos == 5) {
            query = fil.comboProductoMarca() + f + "%'";
        }
        // System.err.println(query);
        listar = crud.filtroBusquedaProducto(query);
        // System.err.println(query);
        Tablas.cargarFiltroProductos(tbacargarProductos, listar);
        query = "";
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void lblNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoMouseClicked
        Products Prod = new Products(new javax.swing.JFrame(), true, objUsuario);
        Prod.setVisible(true);
        lista.clear();
        lista = crud.listarTodoJoinProductos(1);
        Tablas.cargarJoinProductosMCompra(tbacargarProductos, lista);
    }//GEN-LAST:event_lblNuevoMouseClicked

    private void lblImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimirMouseClicked
        ArrayList tablac = new ArrayList();
        for (int i = 0; i < tbacargarProductos.getRowCount(); i++) {
            ClaseReporte tabla1 = new ClaseReporte(tbacargarProductos.getValueAt(i, 0).toString(), tbacargarProductos.getValueAt(i, 1).toString(), tbacargarProductos.getValueAt(i, 2).toString(), tbacargarProductos.getValueAt(i, 3).toString(), tbacargarProductos.getValueAt(i, 4).toString(), tbacargarProductos.getValueAt(i, 5).toString());
            tablac.add(tabla1);
        }
        try {
//            String dir = System.getProperty("user.dir") + "/Reportes/" + ".jasper";
//            JasperReport reporte = (JasperReport) JRLoader.loadObject(dir);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("MantenimientoProducto.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(tablac));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho / 2, alto / 2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(MantenimientoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblImprimirMouseClicked

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
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MantenimientoProducto dialog = new MantenimientoProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JTable tbacargarProductos;
    private javax.swing.JComboBox<String> tipofiltro;
    // End of variables declaration//GEN-END:variables
}
