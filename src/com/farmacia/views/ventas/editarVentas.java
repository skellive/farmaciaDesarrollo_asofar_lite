/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.ventas;

import com.farmacia.dao.CRUD;
import com.farmacia.dao.Conexion;
import java.awt.MouseInfo;
import java.awt.Point;
import static java.lang.Integer.parseInt;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class editarVentas extends javax.swing.JFrame {

    /**
     * Creates new form editarVentas
     */
    CRUD crud = new CRUD();
    int x, y;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

    public editarVentas(String numVenta) {
        initComponents();
        this.setLocationRelativeTo(this);
        txtVentaNumero.setText(numVenta);
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            jtbNumeroVenta.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.conectar();
            CallableStatement listVent;

            String sql = "{call listarVentaUnico('" + numVenta + "', 1) }";
            ps = con.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();

            modelo.addColumn("Id");
            modelo.addColumn("Detalle");
            modelo.addColumn("Id producto");
            modelo.addColumn("Producto");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Control");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio");
            modelo.addColumn("Subtotal con IVA");
            modelo.addColumn("Subtotal sin IVA");
            modelo.addColumn("IVA total");
            modelo.addColumn("Descuento");
            modelo.addColumn("Total");

            int[] anchos = {10, 10, 20, 10, 50, 20, 20, 20, 20, 30, 30, 30, 20, 30};

            for (int x = 0; x < cantidadColumnas; x++) {

                jtbNumeroVenta.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

            }

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al traer datos: " + e);
        }
    }

    private editarVentas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        txtVentaNumero = new javax.swing.JLabel();
        lblCerrar4 = new javax.swing.JLabel();
        txtVentaNum1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDatos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNumeroVenta = new javax.swing.JTable();
        btnEliminarProducto = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObProducto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel7.setOpaque(false);

        txtVentaNumero.setBackground(new java.awt.Color(2, 184, 184));
        txtVentaNumero.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtVentaNumero.setForeground(new java.awt.Color(0, 27, 134));
        txtVentaNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVentaNumero.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txtVentaNumerojLabel7MouseDragged(evt);
            }
        });
        txtVentaNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtVentaNumerojLabel7MousePressed(evt);
            }
        });

        lblCerrar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        lblCerrar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrar4lblCerrarMouseClicked(evt);
            }
        });

        txtVentaNum1.setBackground(new java.awt.Color(2, 184, 184));
        txtVentaNum1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtVentaNum1.setForeground(new java.awt.Color(0, 27, 134));
        txtVentaNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVentaNum1.setText("VENTA Nº");
        txtVentaNum1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txtVentaNum1jLabel7MouseDragged(evt);
            }
        });
        txtVentaNum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtVentaNum1jLabel7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtVentaNum1)
                .addGap(27, 27, 27)
                .addComponent(txtVentaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270)
                .addComponent(lblCerrar4)
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVentaNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVentaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCerrar4))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("PRODUCTO DE VENTA A ELIMINAR");

        jtbNumeroVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbNumeroVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNumeroVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNumeroVenta);

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/eliminar.png"))); // NOI18N
        btnEliminarProducto.setText("ELIMINAR PRODUCTO");
        btnEliminarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProductoMouseClicked(evt);
            }
        });

        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icono/eliminar1.png"))); // NOI18N
        btnEliminarVenta.setText("ELIMINAR VENTA");
        btnEliminarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarVentaMouseClicked(evt);
            }
        });

        txtObProducto.setColumns(20);
        txtObProducto.setRows(5);
        jScrollPane2.setViewportView(txtObProducto);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("OBSERVACION DE PRODUCTO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnEliminarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarVenta)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDatos, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarProducto)
                    .addComponent(btnEliminarVenta))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVentaNumerojLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVentaNumerojLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_txtVentaNumerojLabel7MouseDragged

    private void txtVentaNumerojLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVentaNumerojLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_txtVentaNumerojLabel7MousePressed

    private void lblCerrar4lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar4lblCerrarMouseClicked
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_lblCerrar4lblCerrarMouseClicked

    private void jtbNumeroVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNumeroVentaMouseClicked
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.conectar();
            int Filas = jtbNumeroVenta.getSelectedRow();
            String codigo = jtbNumeroVenta.getValueAt(Filas, 1).toString();
            String codigo_pro = jtbNumeroVenta.getValueAt(Filas, 2).toString();
            String producto = jtbNumeroVenta.getValueAt(Filas, 3).toString();
            ps = con.prepareStatement("SELECT id FROM detalle_venta WHERE id = ? ");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtDatos.setText(rs.getString("id") + ": " + producto);

            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_jtbNumeroVentaMouseClicked

    private void btnEliminarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProductoMouseClicked
        int Filas = jtbNumeroVenta.getSelectedRow();
        String codigo = jtbNumeroVenta.getValueAt(Filas, 1).toString();
        String obse = txtObProducto.getText();
        if (txtObProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese observacion de producto para continuar ");
        } else {
            crud.eliminarProDetalleVenta(parseInt(codigo), obse);
            JOptionPane.showMessageDialog(null, "Producto eliminado " + codigo);
            setVisible(false);
        }

    }//GEN-LAST:event_btnEliminarProductoMouseClicked

    private void btnEliminarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarVentaMouseClicked
        
        int Filas = jtbNumeroVenta.getSelectedRow();
            String codigo = jtbNumeroVenta.getValueAt(Filas, 0).toString();
        int r = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar venta?" + codigo, "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            setVisible(false);
            observacionVenta obsV = new observacionVenta(codigo);
            obsV.setVisible(true);
        }


    }//GEN-LAST:event_btnEliminarVentaMouseClicked

    private void txtVentaNum1jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVentaNum1jLabel7MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentaNum1jLabel7MouseDragged

    private void txtVentaNum1jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVentaNum1jLabel7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentaNum1jLabel7MousePressed

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
            java.util.logging.Logger.getLogger(editarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEliminarProducto;
    private javax.swing.JLabel btnEliminarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbNumeroVenta;
    private javax.swing.JLabel lblCerrar4;
    private javax.swing.JTextField txtDatos;
    private javax.swing.JTextArea txtObProducto;
    private javax.swing.JLabel txtVentaNum1;
    private javax.swing.JLabel txtVentaNumero;
    // End of variables declaration//GEN-END:variables
}
