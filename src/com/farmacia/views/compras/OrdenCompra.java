/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.compras;

import com.farmacia.join_entidades.ListarJoinProveedor;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.validaciones.ComponentesFaltantes;
import com.farmacia.dao.CRUD;
import com.farmacia.conponentes.Tablas;
import com.farmacia.entities1.CabeceraNotaPedido;
import com.farmacia.entities1.Cabecera_compra;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.Detalle_compra;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.JoinListarNotaPedidosCabecera;
import com.farmacia.views.pedidos.EditarNotaPedido;
import com.farmacia.views.producto.MantenimientoProducto;
import com.farmacia.views.producto.Products;
import com.farmacia.views.proveedor.Consulta_Proveedor_Compra;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class OrdenCompra extends javax.swing.JDialog {

    int x, y;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private Date fecha_nacimiento = null;
    CRUD crud = new CRUD();
    DefaultTableModel model;
    joinProductoDetallesFaltantes objeto = null;//<--
    JoinListarNotaPedidosCabecera objCabecera = null;
    ListarJoinProveedor proveedor = null;
    List list12 = new ArrayList();
    JoinListarDetalleNotaPedido detalle = null;
    ArrayList<joinProductoDetallesFaltantes> lista1 = new ArrayList<joinProductoDetallesFaltantes>();//<--
    ArrayList<listarJoinProductosCompras> listapro = crud.listarTodoJoinProductos(1);
    ArrayList<JoinListarDetalleNotaPedido> lista3 = null;
    //ArrayList<joinProductoDetallesFaltantes> listaCompra = crud.listarFaltantesDetalles(1);//<--
    int id_tipopago = 0;
    String id_cab = "";
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    String FechaActual;
    BigDecimal VGiva = null, VGtotal = null, VGdescuento = null;
    Listar_usuario objUsuario=null;

    public OrdenCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    public OrdenCompra(java.awt.Frame parent, boolean modal, JoinListarNotaPedidosCabecera Obj) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        objCabecera = Obj;
        
        llenarProveedor();
        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new OrdenCompra.horas());
        tiempo.start();        
        String id_cab = txt_Numero.getText().toString();
        list12.add(lista3);
        Iterator itr = list12.iterator();
        while (itr.hasNext()){
           System.out.println(itr.next()); 
        }
        lista3 = crud.listarDetalleNotaPedido(1, id_cab);
        Tablas.cargarJoinRegistroDetalleCompras(tbaListaComprasB, lista3);
        Total();
        TotalIVA();
        TotalDescuento();
        
    }
    public OrdenCompra(java.awt.Frame parent, boolean modal, JoinListarNotaPedidosCabecera Obj,Listar_usuario obj) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        setLayout(null);
        objCabecera = Obj;
        //txtFecha.setText(FechaActual());
        llenarProveedor();
        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        //    txtFecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new OrdenCompra.horas());
        tiempo.start();
        // Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, listaCompra);
        // Tablas.cargarJoinProductosMCompra(tbacargarProductosA, lista);
        String id_cab = txt_Numero.getText().toString();
        lista3 = crud.listarDetalleNotaPedido(1, id_cab);
        Tablas.cargarJoinRegistroDetalleCompras(tbaListaComprasB, lista3);
        Total();
        TotalIVA();
        TotalDescuento();
        // t_Nota_faltantes.setEnabled(false);
         objUsuario =obj;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            //txtHora.setText(String.format(format.format(sistHora), hoy));

        }
    }

    @SuppressWarnings("unchecked")
    public void TotalIVA() {
        BigDecimal Total1Iva = new BigDecimal("0.0000");

        for (int i = 0; i < tbaListaComprasB.getRowCount(); i++) {
            BigDecimal Iva1 = lista3.get(i).getIva();
            Total1Iva = Total1Iva.add(Iva1);
//            totalIva = redondearDecimales(totalIva, 2);
        }
        VGiva = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(Total1Iva.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtIva.setText(removeScientificNotation(Total1Iva.setScale(2, BigDecimal.ROUND_HALF_UP).toString()));

    }

    public void TotalDescuento() {
        BigDecimal TotalDescuento = new BigDecimal("0.0000");
        for (int i = 0; i < tbaListaComprasB.getRowCount(); i++) {
            BigDecimal descuento = lista3.get(i).getDescuento();
            TotalDescuento = TotalDescuento.add(descuento);
//            TotalDescuento = redondearDecimales(TotalDescuento, 2);
        }
        VGdescuento = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(TotalDescuento.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtDescuento.setText(removeScientificNotation(TotalDescuento.setScale(2, BigDecimal.ROUND_HALF_UP).toString()));
    }

    public void Total() {
        BigDecimal Total_ = new BigDecimal("0.0000");
        for (int i = 0; i < tbaListaComprasB.getRowCount(); i++) {
            BigDecimal total = lista3.get(i).getTotal();
            Total_ = Total_.add(total);

        }
        VGtotal = BigDecimal.valueOf(Double.parseDouble(removeScientificNotation(Total_.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtTotal.setText(Total_.setScale(2, BigDecimal.ROUND_HALF_UP).toString());

    }

    public static String removeScientificNotation(String value) {
        return new BigDecimal(value).toPlainString();
    }

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoProveedor = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cbxPlazo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxFormaP = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtFechaCreacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Numero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnProducto = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbaListaComprasB = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblImprimir = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel3.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 27, 134));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("$");

        jButton1.setBackground(new java.awt.Color(0, 27, 134));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AGREGAR DETALLES");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("CORREO:");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 27, 134));
        jLabel13.setText("CODIGO:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setText("DIRECCION:");

        txtTipo.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 27, 134));
        jLabel12.setText("TIPO:");

        txtRepresentante.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtRepresentante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepresentanteKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 27, 134));
        jLabel14.setText("REPRESENTANTE:");

        txtNombre.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("RUC :");

        txtRuc.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 27, 134));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DATOS DEL PROVEEDOR");

        txtCorreo.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtTelefono.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtDireccion.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("TELEFONO:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("NOMBRE:");

        txtCodigoProveedor.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 27, 134));
        jLabel17.setText("IVA:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 27, 134));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("$");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 27, 134));
        jLabel21.setText("TOTAL:");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 27, 134));
        jLabel18.setText("DESCUENTO:");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel2.setOpaque(false);

        cbxPlazo.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxPlazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inmediato", "3 Meses", "6 Meses", "9 Meses", "12 Meses", "24 Meses" }));

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 27, 134));
        jLabel16.setText("FORMA DE PAGO:");

        cbxFormaP.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbxFormaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        cbxFormaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFormaPActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 27, 134));
        jLabel11.setText("PLAZO:");

        txtFechaCreacion.setEditable(false);
        txtFechaCreacion.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtFechaCreacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 27, 134));
        jLabel9.setText("FECHA:");

        txt_Numero.setEditable(false);
        txt_Numero.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txt_Numero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 27, 134));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("#");

        btnProducto.setBackground(new java.awt.Color(0, 27, 134));
        btnProducto.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnProducto.setText("PRODUCTO");
        btnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxPlazo, 0, 115, Short.MAX_VALUE)
                            .addComponent(txtFechaCreacion)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFormaP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel4.setOpaque(false);

        jScrollPane2.setOpaque(false);

        tbaListaComprasB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "      CODIGO", "           PRODUCTO", "                 MARCA", "                  TIPO", "             MEDIDA", "       CANTIDAD"
            }
        ));
        tbaListaComprasB.setOpaque(false);
        tbaListaComprasB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbaListaComprasBMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbaListaComprasB);
        if (tbaListaComprasB.getColumnModel().getColumnCount() > 0) {
            tbaListaComprasB.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbaListaComprasB.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbaListaComprasB.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbaListaComprasB.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbaListaComprasB.getColumnModel().getColumn(4).setPreferredWidth(60);
            tbaListaComprasB.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel5.setOpaque(false);

        jLabel10.setBackground(new java.awt.Color(0, 153, 153));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 27, 134));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("INGRESO COMPRAS");
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(241, 241, 241)
                .addComponent(lblCerrar)
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(lblCerrar)
                .addGap(12, 12, 12))
        );

        lblImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/imprimir.png"))); // NOI18N
        lblImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImprimirMouseClicked(evt);
            }
        });

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(lblGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImprimir)
                                .addGap(154, 154, 154)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImprimir)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblGuardar))
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }
    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        Products Prod = new Products(new javax.swing.JFrame(), true,objUsuario);
        Prod.setVisible(true);
        listapro.clear();
        listapro = crud.listarTodoJoinProductos(1);
        // Tablas.cargarJoinProductosMCompra(tbacargarProductosA, listapro);
    }//GEN-LAST:event_btnProductoActionPerformed

    public void llenarProveedor() {
        ArrayList<ListarJoinProveedor> listaPro = crud.listarProveedores(Long.valueOf("1"));
        proveedor = buscarObjeto(objCabecera.getCedula_ruc(), listaPro);
        if (proveedor != null) {
            System.out.println(" " + proveedor.getCedula_ruc() + proveedor.getEntidad());
            txtCodigoProveedor.setText(proveedor.getId_proveedor().toString());
            txtRuc.setText(proveedor.getCedula_ruc());
            txtNombre.setText(proveedor.getEntidad());
            txtCorreo.setText(proveedor.getMail());
            txtTelefono.setText(proveedor.getTelefono());
            txtDireccion.setText(proveedor.getDireccion());
            txtRepresentante.setText(proveedor.getRepresentante());
            txtTipo.setText(proveedor.getClase());
            txtFechaCreacion.setText(objCabecera.getFecha_creacion());
            cbxPlazo.setSelectedItem(objCabecera.getPlazo());
            cbxFormaP.setSelectedItem(objCabecera.getForma_pago());
            txt_Numero.setText(objCabecera.getId_cabecera_nota_pedidos().toString());
        } else {
        }
    }

    public ListarJoinProveedor buscarObjeto(String cedula, ArrayList<ListarJoinProveedor> lis) {
        ListarJoinProveedor pro = new ListarJoinProveedor();
        pro = null;
        //int ced = Integer.valueOf(cedula);
        for (int i = 0; i < lis.size(); i++) {
            if (cedula.equals(lis.get(i).getCedula_ruc())) {
                pro = lis.get(i);
            }
        }
        return pro;
    }

    public joinProductoDetallesFaltantes devuelveObjeto(String datos, ArrayList<joinProductoDetallesFaltantes> listarobj) {
        joinProductoDetallesFaltantes objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_precios().toString())) {
                objeto1 = listarobj.get(i);
                System.out.println("iva " + listarobj.get(i).getIva() + " " + listarobj.get(i).getPorcentaje_descuento());
                break;
            }
        }
        return objeto1;

    }
    private void ListaIngresoProductos() {
        try {
            FechaActual = hourdateFormat.format(date);
//        ArrayList<String> queryL = new ArrayList<String>();
//        ArrayList<String> queryL1 = new ArrayList<String>();
            
            String id_cab = "";
            
            Cabecera_compra cc = new Cabecera_compra();
            cc.setId_proveedor(Long.valueOf(txtCodigoProveedor.getText()));
            cc.setId_usuario(Long.valueOf("2"));
            cc.setFecha_creacion(FechaActual);
            cc.setPlazo(cbxPlazo.getSelectedItem().toString());
            cc.setId_sucursal(Long.valueOf("2"));
            cc.setId_tipoPago(cbxFormaP.getSelectedItem().toString());
            cc.setIva(VGiva);
            cc.setDescuento(VGdescuento);
            cc.setTotal(VGtotal);
            cc.setIdcabecerapedido(Long.valueOf(txt_Numero.getText()));
            id_cab = crud.insertarCabeceraCompras(cc);

            
            
            lista3 = crud.listarDetalleNotaPedido(1, txt_Numero.getText().toString());

              for (int i = 0; i < lista3.size(); i++) {
                  Detalle_compra obj = new Detalle_compra();
                  obj.setId_producto(lista3.get(i).getId_producto());
                  obj.setId_cabecera_compra(Long.valueOf(id_cab));
                  obj.setId_precio(lista3.get(i).getId_precio());
                  obj.setCantidad(lista3.get(i).getCantidad());
                  obj.setUnidad(lista3.get(i).getUnidad());
                  obj.setPrecio(lista3.get(i).getPrecio());
                  obj.setDescuento(lista3.get(i).getDescuento());
                  obj.setIva(lista3.get(i).getIva());
                  obj.setTotal(lista3.get(i).getTotal());
                  obj.setBono(lista3.get(i).getBono());
                  crud.insertarDetalleProductoCompra(obj);
              }
              JOptionPane.showMessageDialog(null, " Guardado con Exito ");
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(OrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
//////////////////////////////////////////////////////////////////////////////////  
    }
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

    private void txtRepresentanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepresentanteKeyReleased

    }//GEN-LAST:event_txtRepresentanteKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void tbaListaComprasBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaListaComprasBMousePressed
        int i = 0;

        if (evt.getClickCount() == 2) {
            int sele = confirmarAccion();
            i = tbaListaComprasB.getSelectedRow();
            detalle = devuelveObjetoDetalle(tbaListaComprasB.getValueAt(i, 0).toString(), lista3);
            if(sele ==0){
                FechaCaducidad fc = new FechaCaducidad(new javax.swing.JFrame(), true,detalle);
                fc.setVisible(true);            
            }else if (sele == 1) {
                // System.out.println("id detalle nota pedido"+detalle.getId_detalle_nota_pedido()+detalle.getCantidad()+detalle.getPrecio()+detalle.getTotal()+" "+detalle.getId_precio()+detalle.getId_cabecera_nota_pedido());
                String valor = crud.eliminardetalleCompra(detalle);
                if (valor != null) {
                    JOptionPane.showMessageDialog(this, valor);
                    actualizarTabla2();
                   // actualizarcabeceraNota();
                    lblCerrar.setEnabled(false);
                }
            } else {
                EditarProductoEnCompras1 epc = new EditarProductoEnCompras1(new javax.swing.JFrame(), true, detalle);
                epc.setVisible(true);
                actualizarTabla2();
                actualizarcabeceraNota();
            }
        }
    }//GEN-LAST:event_tbaListaComprasBMousePressed
    public void actualizarcabeceraNota(){
        String valor="";
        CabeceraNotaPedido cn = new CabeceraNotaPedido();
            cn.setPlazo(cbxPlazo.getSelectedItem().toString());
            cn.setForma_pago(cbxFormaP.getSelectedItem().toString());
            cn.setIva(VGiva);
            cn.setDescuento(VGdescuento);
            cn.setTotal(VGtotal);
            cn.setId_cabecera_nota_pedidos(Long.valueOf(txt_Numero.getText()));
            valor = crud.ActualizarNotaPedidosCabecera(cn);
            System.out.println("que paso? "+valor);
    }
    private void cbxFormaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFormaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFormaPActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EditarNotaPedido NP = new EditarNotaPedido(new javax.swing.JFrame(), true, objCabecera, 1);
        NP.setVisible(true);
        actualizarTabla2();
        //actualizarcabeceraNota();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.setVisible(false);
        CabeceraCompra Man = new CabeceraCompra(new javax.swing.JFrame(), true);
        Man.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimirMouseClicked
        ArrayList tablac = new ArrayList();
        for (int i = 0; i < tbaListaComprasB.getRowCount(); i++) {
            ClaseReporte tabla1 = new ClaseReporte(txtNombre.getText(),
                    txtCodigoProveedor.getText(),
                    txtNombre.getText(),
                    txtRepresentante.getText(),
                    txtTelefono.getText(),
                    txtRuc.getText(),
                    txtCorreo.getText(),
                    txtDireccion.getText(),
                    txtTipo.getText(),
                    txtFechaCreacion.getText(),
                    cbxPlazo.getSelectedItem().toString(),
                    cbxFormaP.getSelectedItem().toString(),
                    tbaListaComprasB.getValueAt(i, 0).toString(),
                    tbaListaComprasB.getValueAt(i, 1).toString(),
                    tbaListaComprasB.getValueAt(i, 2).toString(),
                    tbaListaComprasB.getValueAt(i, 3).toString(),
                    tbaListaComprasB.getValueAt(i, 4).toString(),
                    tbaListaComprasB.getValueAt(i, 5).toString(),
                    tbaListaComprasB.getValueAt(i, 6).toString(),
                    tbaListaComprasB.getValueAt(i, 7).toString(),
                    tbaListaComprasB.getValueAt(i, 8).toString(),
                    tbaListaComprasB.getValueAt(i, 9).toString(),
                    tbaListaComprasB.getValueAt(i, 10).toString(),
                    tbaListaComprasB.getValueAt(i, 11).toString(),
                    txtDescuento.getText(),
                    txtIva.getText(),
                    txtTotal.getText(),
                    txt_Numero.getText());
            tablac.add(tabla1);
        }
        try {
            String dir = System.getProperty("user.dir") + "/Reportes/" +"Compra.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(dir);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(tablac));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho / 2, alto / 2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(OrdenCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblImprimirMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        ListaIngresoProductos();
    }//GEN-LAST:event_lblGuardarMouseClicked
    public int getvariablecerrar() {
        int variablex = 1;
        return variablex;
    }

//    private void getPosicion(Long id, int valor) {
//        for (int i = 0; i < listaCompra.size(); i++) {
//            if (id == listaCompra.get(i).getId_producto()) {
//                listaCompra.get(i).setCantidad(valor);
//            }
//        }
//
//    }

    public int confirmarAccion() {
        String[] options = {"Colocar Fecha Caducidad","Eliminar", "Editar"};
        int seleccion = JOptionPane.showOptionDialog(null, "Desea Añadir Fecha de Caducidad,Editar  ,Eliminar o Editar?", "Colocar Fecha Caducidad", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        System.out.println("la eleccion es " + seleccion);
        return seleccion;
    }

    //
    public JoinListarDetalleNotaPedido devuelveObjetoDetalle(String datos, ArrayList<JoinListarDetalleNotaPedido> listarobj) {
        JoinListarDetalleNotaPedido objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_detalle_nota_pedido().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }

        return objeto1;
    }

    public void actualizarTabla2() {
        lista3.clear();
        String id = txt_Numero.getText().toString();
        lista3 = crud.listarDetalleNotaPedido(1, id);
        Tablas.cargarJoinRegistroDetalleCompras(tbaListaComprasB, lista3);
        Total();
        TotalIVA();
        TotalDescuento();
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
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrdenCompra dialog = new OrdenCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnProducto;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JTable tbaListaComprasB;
    public static javax.swing.JLabel txtCodigoProveedor;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaCreacion;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtRepresentante;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txtTipo;
    public static javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txt_Numero;
    // End of variables declaration//GEN-END:variables
}
