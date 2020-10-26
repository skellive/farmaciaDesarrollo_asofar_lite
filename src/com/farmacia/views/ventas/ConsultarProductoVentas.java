/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.ventas;

import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jomugue
 */
public class ConsultarProductoVentas extends javax.swing.JDialog {
    int x,y;
    CRUD crud = new CRUD();
    ArrayList<JoinListarProductosVentas> listaProducto = null;
    DefaultTableModel model;
    JoinListarProductosVentas objeto = new JoinListarProductosVentas();

    public ConsultarProductoVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        listaProducto = crud.ListarTodoJoinProductosParaVender();
        Tablas.ListarProductosVENTA(listaProducto,TablaProductoVentas);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductoVentas = new javax.swing.JTable();
        TxtFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 99, 50), 2, true));
        jPanel3.setOpaque(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 99, 50), 2, true));
        jPanel1.setOpaque(false);

        TablaProductoVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaProductoVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaProductoVentasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductoVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TxtFiltro.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        TxtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFiltroActionPerformed(evt);
            }
        });
        TxtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtFiltroKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("BUSCAR");

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel2.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(412, 412, 412)
                .addComponent(lblCerrar)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFiltroActionPerformed

    private void TablaProductoVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductoVentasMousePressed
     String idPro,preCom,preVent,venUni;
        int i = 0;

        if (evt.getClickCount() == 2) {           
            i = TablaProductoVentas.getSelectedRow();
            idPro=TablaProductoVentas.getValueAt(i, 0).toString();
            preVent=TablaProductoVentas.getValueAt(i, 9).toString();
            venUni=TablaProductoVentas.getValueAt(i, 10).toString();
            objeto=null;
            objeto = devuelveObjeto2(idPro,preVent,venUni,listaProducto);
            if (objeto != null) {
                //valida si es caja
                 if(TablaProductoVentas.getValueAt(i,5).toString().equals("CAJA")){
                 String[] colores={"Caja","Unidad"};  
                 String opcion;
                 opcion=(String)JOptionPane.showInputDialog(null,"¿Como quieres vender? ",
                 "Elegir",JOptionPane.QUESTION_MESSAGE,null,colores, colores[0]);
                 //int r = JOptionPane.showConfirmDialog(null, "¿Desea convertir a unidades?", "", JOptionPane.YES_NO_OPTION);
                 //r == JOptionPane.YES_OPTION
                 if(opcion!=null){
                 if(opcion.equals("Unidad")){
                   objeto.setEmpaque(2);
                   objeto.setStock(objeto.getStock_unidad());
                   objeto.setPrecio_venta(objeto.getVenta_unidad());
                   this.setVisible(false); 
                  }else{
                   objeto.setEmpaque(1);
                   this.setVisible(false); 
                   }  
                 }else{
                   
                 }
                  
                 }else{
                     //si no es caja
            objeto.setEmpaque(1);
            this.setVisible(false); 
                 }
                 
                //this.setVisible(false); 
            }else{
               objeto=null; 
            }
        }
        //System.out.println(" select " + objeto.getProducto_nombre());
    }//GEN-LAST:event_TablaProductoVentasMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
       x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void TxtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyReleased
        Tablas.filtro(TxtFiltro.getText(), TablaProductoVentas);
    }//GEN-LAST:event_TxtFiltroKeyReleased

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    public JoinListarProductosVentas getProducto() {
        return objeto;
    }
    
    
    
    public JoinListarProductosVentas devuelveObjeto2(String idproducto,String preVent,String venUni, ArrayList<JoinListarProductosVentas> lista) {
        JoinListarProductosVentas objeto1 = null;
        for (int i = 0; i < lista.size(); i++) {
            if (idproducto.equals(lista.get(i).getId_producto().toString()) && 
                preVent.equals(lista.get(i).getPrecio_venta().toString()) &&
                venUni.equals(lista.get(i).getVenta_unidad().toString()) ) {
                objeto1 = lista.get(i);
                //JOptionPane.showMessageDialog(this,"Encontrado");
                //System.out.println("Encontrado");
                break;
            }
        }
        return objeto1;
    }

    public JoinListarProductosVentas devuelveObjeto(String datos, ArrayList<JoinListarProductosVentas> listarobj) {
        JoinListarProductosVentas objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            
            System.out.println("id " + datos);
            lblId.setText(datos);
            if (datos.equals(listarobj.get(i).getId_producto().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
            
        }
        return objeto1;
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
            java.util.logging.Logger.getLogger(ConsultarProductoVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarProductoVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarProductoVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarProductoVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarProductoVentas dialog = new ConsultarProductoVentas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TablaProductoVentas;
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables
}
