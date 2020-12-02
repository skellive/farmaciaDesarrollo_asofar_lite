/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.pedidos;

import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.dao.Consultas;
import com.farmacia.entities1.Precios;
import com.farmacia.join_entidades.ListarJoinPrecioNotaPedido;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.views.precios.Agregar_Precios_Productos;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author alumno
 */
public class PrecioNotaPedido extends javax.swing.JDialog {

    int x, y;
    CRUD crud = new CRUD();
    Consultas llamar = new Consultas();
//    ListarJoinPrecioNotaPedido objf = null;
    ListarJoinPrecioNotaPedido objIdProd = null;
    ListarJoinPrecioNotaPedido PrecioN = null;
    ArrayList<ListarJoinPrecioNotaPedido> lista = null;
    joinProductoDetallesFaltantes objf = null;
    String id_pro;
    ArrayList<Precios> listaPrecios = null;

    public PrecioNotaPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        initComponents();
        setLocationRelativeTo(null);
        System.out.println("HOLA g ");
        System.out.println(" fdgfg" + id_pro);

    }

    public PrecioNotaPedido(java.awt.Frame parent, boolean modal, String idproducto,String nombre) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        initComponents();
        setLocationRelativeTo(null);
        id_pro = idproducto;
        llenarFormulario(idproducto,nombre);
//        System.out.println("obe "+obj1.getId_producto().toString());
        lista = crud.listarPrecioNota(1, id_pro.toString());
        Tablas.cargarJoinPrecioNotaPedido(tbaPrecioProd, lista);
    }

    private void llenarFormulario(String idproducto,String nombre) {

        objf = new joinProductoDetallesFaltantes();

        txtCodigo.setText(idproducto);
        txtProducto.setText(nombre);
        /////////
//        objf.setId_producto(obj.getId_producto());
//        objf.setNombre_producto(obj.getNombre_producto());

    }

    public ListarJoinPrecioNotaPedido buscarObjeto(String cedula, ArrayList<ListarJoinPrecioNotaPedido> lis) {
        ListarJoinPrecioNotaPedido pro = new ListarJoinPrecioNotaPedido();
        pro = null;
        //int ced = Integer.valueOf(cedula);
        for (int i = 0; i < lis.size(); i++) {
            if (cedula.equals(lis.get(i).getId_precio().toString())) {
                pro = lis.get(i);
            }
        }
        return pro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregarCompra = new javax.swing.JButton();
        txtProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbaPrecioProd = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

        agregarCompra.setBackground(new java.awt.Color(0, 27, 134));
        agregarCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        agregarCompra.setForeground(new java.awt.Color(255, 255, 255));
        agregarCompra.setText("+");
        agregarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCompraActionPerformed(evt);
            }
        });

        txtProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setText("PRODUCTO: ");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setBorder(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel2.setOpaque(false);

        tbaPrecioProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbaPrecioProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbaPrecioProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbaPrecioProdMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbaPrecioProdMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbaPrecioProd);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel3.setOpaque(false);

        jLabel10.setBackground(new java.awt.Color(0, 153, 153));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 27, 134));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PRECIO");
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
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
                .addGap(268, 268, 268)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(agregarCompra))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(lblGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCompraActionPerformed
        Agregar_Precios_Productos ic = new Agregar_Precios_Productos(new javax.swing.JFrame(), true, Long.valueOf(id_pro));
        ic.setVisible(true);
        
        //id_precio = ic.getId_precio();
        lista.clear();
        lista = crud.listarPrecioNota(1, id_pro.toString());
        Tablas.cargarJoinPrecioNotaPedido(tbaPrecioProd, lista);
    }//GEN-LAST:event_agregarCompraActionPerformed

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseDragged

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void tbaPrecioProdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaPrecioProdMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbaPrecioProdMouseReleased

    private void tbaPrecioProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaPrecioProdMousePressed
        int id = 0;

        if (evt.getClickCount() == 2) {
            id = tbaPrecioProd.getSelectedRow();
            lista = crud.listarPrecioNota(1, id_pro.toString());
            PrecioN = buscarObjeto(tbaPrecioProd.getValueAt(id, 0).toString(), lista);
            System.out.println(PrecioN.getId_precio());
            lista.clear();
            setVisible(false);
        }
    }//GEN-LAST:event_tbaPrecioProdMousePressed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        PrecioN=null;
        setVisible(false);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGuardarMouseClicked
    public ListarJoinPrecioNotaPedido getPrecio() {
        return PrecioN;
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
            java.util.logging.Logger.getLogger(PrecioNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrecioNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrecioNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrecioNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrecioNotaPedido dialog = new PrecioNotaPedido(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton agregarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JTable tbaPrecioProd;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtProducto;
    // End of variables declaration//GEN-END:variables
}
