/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.ventas;

import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.join_entidades.JoinListarProductosVentas;
import com.farmacia.join_entidades.ListarKardex;
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
        lblId = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        tipofiltro = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        txt_filtro_inventario = new javax.swing.JTextField();

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
                .addGap(430, 430, 430)
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

        tipofiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipofiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.BARRAS", "NOMBRE", "PRESENTACIÓN" }));

        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

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
                        .addGap(323, 323, 323)
                        .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_filtro_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar))
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
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(txt_filtro_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void TablaProductoVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductoVentasMousePressed
     String idPro,preCom,preVent,venUni,Presentacion;
     int Unidades = 0;
     int i = 0;
      ListarKardex objetoInv = null ;
     
        if (evt.getClickCount() == 2) {           
            i = TablaProductoVentas.getSelectedRow();
            idPro=TablaProductoVentas.getValueAt(i, 0).toString();
            
            preVent=TablaProductoVentas.getValueAt(i, 9).toString();
            venUni=TablaProductoVentas.getValueAt(i, 10).toString();
            Presentacion=TablaProductoVentas.getValueAt(i,5).toString();
            Unidades=Integer.parseInt(crud.BuscarUnidadesProducto(Long.parseLong(idPro))) ;
            objeto=null;
            objeto = devuelveObjeto2(idPro,preVent,venUni,listaProducto);
            if (objeto != null) {
                 //valida si tiene mas unidades
                 if(Unidades>1){
                 //PREGUNTA VENDER`POR EMPAQUE O UNIDAD    
                 String[] opciones={Presentacion,"UNIDAD"};  
                 String opcion;
                 opcion=(String)JOptionPane.showInputDialog(null,"¿COMO DESEAS VENDER? ",
                 "Elegir",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
                  if(opcion!=null){
                   if(opcion.equals("UNIDAD")){
                      if(objeto.getStock_unidad()>0){
                      objeto.setEmpaque(2);
                      objeto.setStock(objeto.getStock_unidad());
                      objeto.setPrecio_venta(objeto.getVenta_unidad());
                      this.setVisible(false);   
                      }else{
                      //PREGUNTAR SI DESEA CONVERTIR A UNIDADES
                      if(objeto.getStock()>0){
                      int m = JOptionPane.showConfirmDialog(null, "No tienes Unidades! \n ¿Deseas convertir 1 " + Presentacion + " en " + Unidades + " unidades ?", "Eligir", JOptionPane.YES_NO_OPTION);
                      if (m == JOptionPane.YES_OPTION){
                      String mostar = "idproducto:" + objeto.getId_producto() + "\n"
                                                        + "idprecio:" + objeto.getId_precio() + "\n"
                                                        + "cantidad en caja:" + Long.parseLong(""+1) + "\n"
                                                        + "unidades: " + Long.parseLong(""+Unidades);
                                                //JOptionPane.showMessageDialog(null,mostar);
                      //JOptionPane.showMessageDialog(this,"Conversion realizada");
                      String msje = crud.accionesInventarioVenta(objeto.getId_producto(),objeto.getId_precio(),Long.parseLong(""+1),Long.parseLong(""+Unidades),2);
                      JOptionPane.showMessageDialog(null, msje);
                      listaProducto = crud.ListarTodoJoinProductosParaVender();
                      Tablas.ListarProductosVENTA(listaProducto,TablaProductoVentas);
                      }
                      }else{
                          JOptionPane.showMessageDialog(this,"NO TIENES "+Presentacion+" PARA CONVERTIR A UNIDADES");
                      }
                      } 
                   }else{
                   objeto.setEmpaque(1);
                   this.setVisible(false); 
                   }  
                  }else{/*CANCELÓ*/}
                 }else{
                 //si no es EMPAQUE
                  objeto.setEmpaque(1);
                  this.setVisible(false); 
                 }
            }else{
               //NO IDENTIFICO NINGUN OBJETO(PRODUCTO)
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

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        //BUSCAR
        String f = txt_filtro_inventario.getText().toUpperCase();
        int pos = tipofiltro.getSelectedIndex();
        //listaStock = crud.ListarKardexStock();
        if ("".equals(f) || f.isEmpty()) {
            listaProducto = crud.ListarTodoJoinProductosParaVender();
        } else {
            if (pos == 0) {
                listaProducto = crud.ListarFiltroProductosParaVender(1, "%" + f + "%");
            }
            if (pos == 1) {
                listaProducto = crud.ListarFiltroProductosParaVender(2, "%" + f + "%");
            }
            if (pos == 2) {
                listaProducto = crud.ListarFiltroProductosParaVender(3, "%" + f + "%");
            }

        }
        Tablas.ListarProductosVENTA(listaProducto,TablaProductoVentas);
    }//GEN-LAST:event_btn_buscarActionPerformed

    public JoinListarProductosVentas getProducto() {
        return objeto;
    }
    
    public ListarKardex devuelveObjeto(String idproducto, String preCompra, String preVenta, ArrayList<ListarKardex> lista) {
        ListarKardex objeto1 = null;
        for (int i = 0; i < lista.size(); i++) {
            if (idproducto.equals(lista.get(i).getId_producto().toString())
                    && preCompra.equals(lista.get(i).getPrecio_compra().toString())
                    && preVenta.equals(lista.get(i).getPrecio_venta().toString())) {
                objeto1 = lista.get(i);
                //JOptionPane.showMessageDialog(this,"Encontrado");
                System.out.println("Encontrado");
                break;
            }
        }
        return objeto1;
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
    private javax.swing.JButton btn_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblId;
    private javax.swing.JComboBox<String> tipofiltro;
    private javax.swing.JTextField txt_filtro_inventario;
    // End of variables declaration//GEN-END:variables
}
