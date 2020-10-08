package com.farmacia.views.stock;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.Productos_Stock;
import com.farmacia.join_entidades.ListarKardex;
import com.farmacia.views.covertidor.covertidor;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
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


public class Kardex_Productos extends javax.swing.JDialog {

    int x, y;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    CRUD crud = new CRUD();
    //ListarKardex
    ArrayList<ListarKardex> listaKardex = null;
   static ArrayList<ListarKardex> listaPrueba = new ArrayList<ListarKardex>();
    //static ArrayList<ListarKardex> listaPrueba2 = new ArrayList<ListarKardex>();
    ArrayList<ListarKardex> listaStock = null;
    //ArrayList<Productos_Stock> listaStock = null;
    String Buscar = "";
    String mensaje = null;
    ListarKardex objet = null;

    public Kardex_Productos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        //listaKardex = crud.listarKardex();
        //probar();
        listaStock = crud.ListarKardexStock();
        //listarStock();
        Tablas.ListarKardexStockProductos(listaStock, tabla_stock);
        this.sumarTotalStock();
    }

    public void sumarTotalStock() {
        Double total = 0.00;
        for (int i = 0; i < tabla_stock.getRowCount(); i++) {
            String ao = tabla_stock.getValueAt(i, 7).toString();
            String cadenaDeDecimales = ao;
            String resultado = cadenaDeDecimales.replace(',', '.');
            total = total + Double.valueOf(resultado);
        }
        txtTotal.setText(Formato_Numeros.formatoNumero(total.toString()));
    }

    public void probar() {
        ListarKardex obj ;
        Iterator<ListarKardex> it = listaKardex.iterator();
        String id_pro,msj,precio,valor=null;
        Double cant;
        int can = 0;
        Double tot,tota=null;
            
        while (it.hasNext()) {
            msj=null;
            obj = it.next();
            
            id_pro = obj.getId_producto().toString();
            precio = obj.getId_precio().toString();
            cant = Double.parseDouble(obj.getCantidad().toString());
            if(cant.toString().isEmpty()){
            }else{
            tot = obj.getTotal();
            System.out.println(precio);
            Iterator<ListarKardex> ita = listaPrueba.iterator();//id_pro.equals(ita.next().getId_producto().toString())
                while (ita.hasNext()) {//it.next()  //&& precio.equals(ita.next().getId_precio().toString())
                    if (precio.equals(ita.next().getId_precio().toString())) {
                        msj = "El producto ya esta agregado";
                        if(ita.next().getCantidad().toString().isEmpty()){
                        }else{
                            can = (int)((cant)+(ita.next().getCantidad()));
                        }
                         //tota = tot+(ita.next().getTotal());
                        ita.next().setCantidad(Long.parseLong(cant+""));
                        break; 
                        
                    }
                }  
            }
            
            //System.out.println(""+preC);
            if(msj==null){
            System.out.println(""+obj.getNombre_Producto());
            listaPrueba.add(obj);
            }
        }

          
    }

    public void listarStock() {
        try {
            Iterator<ListarKardex> it = listaKardex.iterator();
            while (it.hasNext()) {//it.next()
                objet = it.next();
                mensaje = buscarProduct(objet);
                if (mensaje == null) {
                    listaStock.add(objet);
                }
            }

//            for (int i = 0; i < listaKardex.size(); i++) {
//                objet = listaKardex.get(i);
//                mensaje = buscarProduct(objet);
//                if (mensaje == null) {
//                    listaStock.add(objet);
//                }
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en : " + e);
        }

    }

    public String buscarProduct(ListarKardex obj) {

        String id_pro, preC, msj = null;
        id_pro = obj.getId_producto().toString();
        preC = obj.getPrecio_compra().toString();
        //preV=obj.getPrecio_venta().toString();

        try {
            if (listaStock != null) {
                Iterator<ListarKardex> ita = listaStock.iterator();
                while (ita.hasNext()) {//it.next()
                    if (id_pro.equals(ita.next().getId_producto().toString())) {
                        msj = "El producto ya esta agregado";
                        break;
                    }
                }

//                for (int i = 0; i < listaStock.size(); i++) {
//                    if (id_pro.equals(listaStock.get(i).getId_producto().toString())) {
//                        msj = "El producto ya esta agregado";
//                        break;
//                    }
//                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en : " + e);
        }

        return msj;

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
        jLabel1 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_stock = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS EN STOCK");
        jLabel1.setOpaque(true);
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

        txtbusqueda.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("FILTRO:");

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/farmacia/icon/action_exit_close_remove_13915.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tabla_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_stock.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla_stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_stockMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_stock);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton2.setText("IMPRIMIR");
        jButton2.setMaximumSize(new java.awt.Dimension(213, 137));
        jButton2.setMinimumSize(new java.awt.Dimension(213, 137));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setText("TOTAL:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
        Buscar = txtbusqueda.getText();
        Tablas.filtro(Buscar, tabla_stock);
        sumarTotalStock();
    }//GEN-LAST:event_txtbusquedaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        listaPrueba.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList tabla = new ArrayList();
        for (int i = 0; i < tabla_stock.getRowCount(); i++) {
            ClaseReporte tabla1 = new ClaseReporte(tabla_stock.getValueAt(i, 0).toString(), tabla_stock.getValueAt(i, 1).toString(), tabla_stock.getValueAt(i, 2).toString(), tabla_stock.getValueAt(i, 3).toString(), tabla_stock.getValueAt(i, 4).toString(), tabla_stock.getValueAt(i, 5).toString(), txtTotal.getText());
            tabla.add(tabla1);
        }
        try {
            String dir = System.getProperty("user.dir") + "/Reportes/" + "Stock_Productos.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(dir);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(tabla));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho / 2, alto / 2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(Kardex_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabla_stockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_stockMousePressed
//        int i = 0;
//        try {
//            if (evt.getClickCount() == 2) {
//                i = tabla_stock.getSelectedRow();
//                    covertidor acc = new covertidor(new javax.swing.JFrame(), true, tabla_stock.getValueAt(i, 0).toString());
//                    acc.setVisible(true);
//            }
//        } catch (Exception e) {
//            Logger.getLogger(Stock_Productos.class.getName()).log(Level.SEVERE, null, e);
//        }
    }//GEN-LAST:event_tabla_stockMousePressed

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
            java.util.logging.Logger.getLogger(Kardex_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kardex_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kardex_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kardex_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Kardex_Productos dialog = new Kardex_Productos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_stock;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}
