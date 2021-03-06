package com.farmacia.views.pedidos;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.CabeceraNotaPedido;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.filtros.filtrosProductos;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.joinProductoParaNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import com.farmacia.validaciones.ComponentesFaltantes;
import com.farmacia.views.compras.CabeceraCompra;
import com.farmacia.views.compras.ListaDePedidos;
import com.farmacia.views.producto.MantenimientoProducto;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class NotePedidos extends javax.swing.JDialog {

    int x, y;
    CRUD crud = new CRUD();
    BigDecimal VGiva = null, VGtotal = null, VGdescuento = null;
    filtrosProductos fil = new filtrosProductos();
    ListarJoinProveedorNotaPedido proveedorC = null;
    static ArrayList<listarJoinProductosNotaPedidos> listar = null;

    joinProductoParaNotaPedido objetoActual = null;
    ArrayList<joinProductoParaNotaPedido> listaPNP = crud.listarProductoParaNotaPedido(1);
    ArrayList<joinProductoParaNotaPedido> listaPNP1 = new ArrayList<joinProductoParaNotaPedido>();
    joinProductoParaNotaPedido Objx = new joinProductoParaNotaPedido();
    Listar_usuario objUsuario = null;

    public NotePedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        PanelSec.setEnabled(false);
        TxtFiltro.setEnabled(false);
        tabla_para_productos.setEnabled(false);
        tbaListaFaltantes.setEnabled(false);
        btnBuscar.setEnabled(false);
        lblGuardar.setEnabled(false);
        lblNuevo.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        TotalDescuento2();
        TotalPro();
        TotalIVA2();
        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        txtFecha.setText(formato.format(sistFecha));
        Timer tiempo = new Timer(100, new NotePedidos.horas());
        tiempo.start();

    }

    public NotePedidos(java.awt.Frame parent, boolean modal, Listar_usuario obj) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        PanelSec.setEnabled(false);
        TxtFiltro.setEnabled(false);
        tabla_para_productos.setEnabled(false);
        tbaListaFaltantes.setEnabled(false);
        btnBuscar.setEnabled(false);
        lblGuardar.setEnabled(false);
        lblNuevo.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        TotalDescuento2();
        TotalPro();
        TotalIVA2();

        //nuevo
        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        //cargar productos en la tabla
        //Tablas.cargarJoinProductosMCompra(tabla_para_productos, listapro);
        //Tablas.cargarJoinProductoDetallesFaltantes(t_Nota_faltantes, lista);

        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        txtFecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new NotePedidos.horas());
        tiempo.start();
        objUsuario = obj;
    }

    // PROBAR ENLACE A GITHUB
    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            txtHora.setText(String.format(format.format(sistHora), hoy));

        }
    }

    public void TotalPro() {
        BigDecimal TotalPro = new BigDecimal("0.00");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {

            BigDecimal Precio_presentacion = listaPNP1.get(i).getPrecios_presentacion();
            BigDecimal precio_unidad = listaPNP1.get(i).getPrecios_unidad();
            Integer Cantidad = listaPNP1.get(i).getCantidad();
            Integer Unidad = listaPNP1.get(i).getUnidad();
            String Presentacion = listaPNP1.get(i).getEnvase().toString();
            BigDecimal Precio;

            if ("CAJA".equals(Presentacion)) {
                BigDecimal precio_presentacion_total = Precio_presentacion.multiply(BigDecimal.valueOf(Cantidad));
                BigDecimal precio_unidad_total = precio_unidad.multiply(BigDecimal.valueOf(Unidad));
                Precio = precio_presentacion_total.add(precio_unidad_total);
            } else {
                Precio = BigDecimal.valueOf(Cantidad).multiply(Precio_presentacion);
            }
            BigDecimal Subtotal = Precio;
            BigDecimal PorcentajeDesc = listaPNP1.get(i).getPorcentaje_descuento();
            BigDecimal ValorDes = Subtotal.multiply(PorcentajeDesc).divide(new BigDecimal("100"));
            if (listaPNP1.get(i).getIva().equals("NO")) {
                TotalPro = TotalPro.add(Subtotal).subtract(ValorDes);
            }
            if (!"NO".equals(listaPNP1.get(i).getIva())) {
                String ivaget = listaPNP1.get(i).getIva();
                BigDecimal IVA = new BigDecimal(ivaget);
                BigDecimal ValorIVA = IVA.multiply(Subtotal);
                TotalPro = TotalPro.add(Subtotal).subtract(ValorDes).add(ValorIVA);

            }
        }
        VGtotal = BigDecimal.valueOf(Double.parseDouble(Formato_Numeros.removeScientificNotation(TotalPro.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtTotal.setText(Formato_Numeros.formatoNumero(TotalPro.toString()));
    }

    public void TotalIVA2() {
        BigDecimal TotalIva = new BigDecimal("0.00");

        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            BigDecimal ValorIva = new BigDecimal("0.00");
//            BigDecimal Precio = listaPNP1.get(i).getPrecios();
            BigDecimal Precio_presentacion = listaPNP1.get(i).getPrecios_presentacion();
            BigDecimal precio_unidad = listaPNP1.get(i).getPrecios_unidad();
            BigDecimal Precio = Precio_presentacion.add(precio_unidad);
            Integer Cant = listaPNP1.get(i).getCantidad();
            Integer und = listaPNP1.get(i).getUnidad();
            BigDecimal Cantidad = new BigDecimal(Cant);
            BigDecimal Subtotal = Cantidad.multiply(Precio);

            if (!"NO".equals(listaPNP1.get(i).getIva())) {
                String ivaget = listaPNP1.get(i).getIva();
                System.out.println("iva get " + ivaget);
                BigDecimal IVA = new BigDecimal(ivaget);
                ValorIva = Subtotal.multiply(IVA);
                TotalIva = TotalIva.add(ValorIva);
            }
        }
        VGiva = BigDecimal.valueOf(Double.parseDouble(Formato_Numeros.removeScientificNotation(TotalIva.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtIva.setText(Formato_Numeros.formatoNumero(TotalIva.toString()));
    }

    public void TotalDescuento2() {
        BigDecimal TotalDesc = new BigDecimal("0.00");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
//            BigDecimal Precio = listaPNP1.get(i).getPrecios();
//            BigDecimal Precio_presentacion = listaPNP1.get(i).getPrecios_presentacion();
//            BigDecimal precio_unidad = listaPNP1.get(i).getPrecios_unidad();
//            BigDecimal Precio = Precio_presentacion.add(precio_unidad);
//            BigDecimal PorcDesc = listaPNP1.get(i).getPorcentaje_descuento();
//            Integer Cant = listaPNP1.get(i).getCantidad();
//            Integer und = listaPNP1.get(i).getUnidad();
//            BigDecimal Cantidad = new BigDecimal(Cant);

            BigDecimal Precio_presentacion = listaPNP1.get(i).getPrecios_presentacion();
            BigDecimal precio_unidad = listaPNP1.get(i).getPrecios_unidad();
            Integer Cantidad = listaPNP1.get(i).getCantidad();
            Integer Unidad = listaPNP1.get(i).getUnidad();
            String Presentacion = listaPNP1.get(i).getEnvase().toString();
            BigDecimal Precio;

            if ("CAJA".equals(Presentacion)) {
                BigDecimal precio_presentacion_total = Precio_presentacion.multiply(BigDecimal.valueOf(Cantidad));
                BigDecimal precio_unidad_total = precio_unidad.multiply(BigDecimal.valueOf(Unidad));
                Precio = precio_presentacion_total.add(precio_unidad_total);
            } else {
                Precio = BigDecimal.valueOf(Cantidad).multiply(Precio_presentacion);
            }
            BigDecimal PorcDesc = listaPNP1.get(i).getPorcentaje_descuento();
            BigDecimal Subtotal = Precio;
            BigDecimal ValorDesc = Subtotal.multiply(PorcDesc).divide(new BigDecimal("100"));

            TotalDesc = TotalDesc.add(ValorDesc);
        }
        VGdescuento = BigDecimal.valueOf(Double.parseDouble(Formato_Numeros.removeScientificNotation(TotalDesc.setScale(7, BigDecimal.ROUND_HALF_UP).toString())));
        txtDescuento.setText(Formato_Numeros.formatoNumero(TotalDesc.toString()));
    }

    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        return formatoFecha.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion1 = new javax.swing.JTextField();
        txtCorreo1 = new javax.swing.JTextField();
        txtRuc1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTipo1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoProveedor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxFormaP = new javax.swing.JComboBox<String>();
        jLabel15 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxPlazo = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        tblProduc = new javax.swing.JScrollPane();
        tabla_para_productos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbaListaFaltantes = new javax.swing.JTable();
        PanelSec = new javax.swing.JPanel();
        tipofiltro = new javax.swing.JComboBox<String>();
        btnBuscar = new javax.swing.JButton();
        TxtFiltro = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel5.setOpaque(false);
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 27, 134));
        jLabel14.setText("TOTAL:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 27, 134));
        jLabel17.setText("IVA:");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 27, 134));
        jLabel18.setText("DESCUENTO:");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("$");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 27, 134));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("$");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 27, 134));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setText("DIRECCION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("CORREO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("NOMBRE:");

        txtDireccion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtCorreo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtRuc1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRuc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("RUC :");

        txtNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 27, 134));
        jLabel11.setText("REPRESENTANTE:");

        txtRepresentante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRepresentante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 27, 134));
        jLabel12.setText("TIPO:");

        txtTipo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTipo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 27, 134));
        jLabel13.setText("CODIGO:");

        txtCodigoProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("TELEFONO:");

        txtTelefono1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        btnProveedor.setBackground(new java.awt.Color(0, 27, 134));
        btnProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedor.setText("PROVEEDOR");
        btnProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 27, 134));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PEDIDOS REALIZADOS");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel2.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 27, 134));
        jLabel9.setText("FECHA:");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 27, 134));
        jLabel10.setText("PLAZO:");

        cbxFormaP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxFormaP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Credito" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 27, 134));
        jLabel15.setText("HORA:");

        txtHora.setEditable(false);
        txtHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 27, 134));
        jLabel16.setText("FORMA DE PAGO:");

        cbxPlazo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxPlazo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inmediato", "3 Meses", "6 Meses", "9 Meses", "12 Meses", "24 Meses" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel3.setOpaque(false);

        tabla_para_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8 "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_para_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_para_productosMousePressed(evt);
            }
        });
        tblProduc.setViewportView(tabla_para_productos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel4.setOpaque(false);

        tbaListaFaltantes.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        tbaListaFaltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " CODIGO", "       MARCA", "      TIPO", "     PRODUCTO", "   PRESENTACION", "   MEDIDA", "  CANTIDAD", "UNIDAD", "   PRECIO", " DESCUENTO", "      IVA", "    TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbaListaFaltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbaListaFaltantesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbaListaFaltantes);
        if (tbaListaFaltantes.getColumnModel().getColumnCount() > 0) {
            tbaListaFaltantes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbaListaFaltantes.getColumnModel().getColumn(1).setPreferredWidth(75);
            tbaListaFaltantes.getColumnModel().getColumn(2).setPreferredWidth(55);
            tbaListaFaltantes.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbaListaFaltantes.getColumnModel().getColumn(4).setPreferredWidth(55);
            tbaListaFaltantes.getColumnModel().getColumn(5).setPreferredWidth(55);
            tbaListaFaltantes.getColumnModel().getColumn(6).setPreferredWidth(55);
            tbaListaFaltantes.getColumnModel().getColumn(7).setPreferredWidth(55);
            tbaListaFaltantes.getColumnModel().getColumn(8).setPreferredWidth(50);
            tbaListaFaltantes.getColumnModel().getColumn(9).setPreferredWidth(60);
            tbaListaFaltantes.getColumnModel().getColumn(10).setPreferredWidth(50);
            tbaListaFaltantes.getColumnModel().getColumn(11).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        PanelSec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        PanelSec.setOpaque(false);

        tipofiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipofiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO", "CODIGO", "NOMBRE", "TIPO", "MEDIDA", "PRESENTACION", "MARCA" }));

        btnBuscar.setBackground(new java.awt.Color(0, 27, 134));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        TxtFiltro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtFiltro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        TxtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFiltroActionPerformed(evt);
            }
        });
        TxtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtFiltroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtFiltroKeyTyped(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 27, 134));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PRODUCTOS");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSecLayout = new javax.swing.GroupLayout(PanelSec);
        PanelSec.setLayout(PanelSecLayout);
        PanelSecLayout.setHorizontalGroup(
            PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSecLayout.setVerticalGroup(
            PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel6.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NOTA DE PEDIDOS");
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addGap(26, 26, 26))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/agregar.png"))); // NOI18N
        lblNuevo.setText("NUEVO");
        lblNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoMouseClicked(evt);
            }
        });

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelSec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(lblNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGuardar)
                        .addGap(146, 146, 146)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblGuardar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        try {
            Consulta_proveedor_Nota Prov = new Consulta_proveedor_Nota(new javax.swing.JFrame(), true);
            Prov.setVisible(true);

            proveedorC = Prov.getProveedor();
            if (proveedorC != null) {
                PanelSec.setEnabled(true);
                TxtFiltro.setEnabled(true);
                tabla_para_productos.setEnabled(true);
                tbaListaFaltantes.setEnabled(true);
                btnBuscar.setEnabled(true);
                lblGuardar.setEnabled(true);
                txtCodigoProveedor.setText(proveedorC.getId_proveedor().toString());
                txtRuc1.setText(proveedorC.getCedula_ruc());
                txtNombre1.setText(proveedorC.getEntidad());
                txtCorreo1.setText(proveedorC.getMail());
                txtRepresentante.setText(proveedorC.getRepresentante());
                txtTipo1.setText(proveedorC.getClase());
                txtTelefono1.setText(proveedorC.getTelefono());
                txtDireccion1.setText(proveedorC.getDireccion());

            } else {
                JOptionPane.showMessageDialog(null, " Elija un Proveedor  ");
            }
        } catch (Exception e) {
            Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_btnProveedorActionPerformed


    private void tabla_para_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_para_productosMousePressed
        int i = 0;
        String msg = null;
        String id_pro = null;
        Integer cantidatabla = 0;//ni idea porq si solo la guarda una vez pero no la utiliza
        try {
            if (evt.getClickCount() == 2) {
                i = tabla_para_productos.getSelectedRow();
                objetoActual = devuelveProducto(tabla_para_productos.getValueAt(i, 0).toString(), listaPNP);
                cantidatabla = objetoActual.getCantidad();
                if (objetoActual != null) {
                    id_pro = objetoActual.getId_producto().toString();
                    System.out.println(id_pro + " <-- Este es el id Producto");
                    //VALIDA SI EL PRODUCTO ESTA AGREGADO
                    msg = ComponentesFaltantes.validarProductoParaAgregar(listaPNP1, id_pro);
                    System.out.println(msg);
                    //valida el mensaje
                    if (msg == null) {
                        AgregarProductoNotaPedido np = new AgregarProductoNotaPedido(new javax.swing.JFrame(), true, objetoActual);
                        np.setVisible(true);
                        np.objf.getId_precios();
                        System.out.println(" id precio " + np.objf.getId_precios());
                        np.objf.getId_precios();
                        System.out.println(" id producto " + np.objf.getId_producto());
                        System.out.println(" cantidad " + np.getObjf().getCantidad());
                        System.out.println("unidad " + np.getObjf().getUnidad());
                        System.out.println("observacion: " + np.getObjf().getObservacion());
                        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
                        System.out.println(np.getObjf().getCantidad() + " " + np.getObjf().getUnidad());
                        if (np.getObjf().getCantidad() > 0 || np.getObjf().getUnidad() > 0) {
                            Objx = calcularValores(np.getObjf());
                            listaPNP1.add(Objx);
                            for (joinProductoParaNotaPedido p : listaPNP1) {
                                System.out.println("idddddd " + listaPNP1.get(0).getId_precios());
                            }
                            Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
                            try {
                                Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);
                            } catch (Exception e) {
                                System.out.println("error en tabla2" + e);
                            }

                            TotalDescuento2();
                            TotalIVA2();
                            TotalPro();
                        } else {
                            JOptionPane.showMessageDialog(this, "No es posible hacer un pedido del producto " + np.getObjf().getNombre_producto() + " con una cantidad de " + np.getObjf().getCantidad() + " y unidades de " + np.getObjf().getUnidad());
//                            JOptionPane.showMessageDialog(this, "getCantidad() ->" + np.getObjf().getCantidad());
                        }
//                        }
                    } else {
                        JOptionPane.showMessageDialog(this, msg);
                    }

                }
            }
        } catch (Exception e) {
            // Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_tabla_para_productosMousePressed

    public joinProductoParaNotaPedido calcularValores(joinProductoParaNotaPedido lista) {
        //joinProductoParaNotaPedido
        joinProductoParaNotaPedido objd = new joinProductoParaNotaPedido();
        objd = lista;
        BigDecimal PrecioBono = new BigDecimal("0.00");

        BigDecimal Cantidad = BigDecimal.valueOf(lista.getCantidad());
        BigDecimal Precio_presentacion = lista.getPrecios_presentacion();
        BigDecimal precio_unidad = lista.getPrecios_unidad();
        BigDecimal Unidad = BigDecimal.valueOf(lista.getUnidad());
        String Presentacion = lista.getEnvase().toString();
        BigDecimal Precio;

        if ("CAJA".equals(Presentacion)) {
            BigDecimal precio_presentacion_total = Precio_presentacion.multiply(Cantidad);
            BigDecimal precio_unidad_total = precio_unidad.multiply(Unidad);
            Precio = precio_presentacion_total.add(precio_unidad_total);
        } else {
            Precio = Cantidad.multiply(Precio_presentacion);
        }
        BigDecimal Subtotal = Precio;
        BigDecimal Bono1 = BigDecimal.valueOf(lista.getBono());
        BigDecimal CantidadTotal = Cantidad.add(Bono1);

        if (Cantidad.equals(0) || Unidad.equals(0)) {
            PrecioBono = Subtotal.divide(CantidadTotal);
        } else {
            PrecioBono = CantidadTotal.divide(Subtotal, 7, RoundingMode.HALF_UP);
        }
        Integer Unid = lista.getUnidad();
        String obsr = lista.getObservacion();
        System.out.println("Observacion 1: " + obsr);
        System.out.println("un: " + Unid);
        objd.setUnidad(Unid);
        objd.setObservacion(obsr);
//        BigDecimal CantidadTotal = Cantidad.add(Bono1);
//        PrecioBono = Subtotal.divide(CantidadTotal, 7, RoundingMode.HALF_UP);
        objd.setPrecioBono(PrecioBono);
        objd.setPrecio_total(Subtotal);
        BigDecimal PorcentajeDesc = lista.getPorcentaje_descuento();
        BigDecimal ValorDes = Subtotal.multiply(PorcentajeDesc).divide(new BigDecimal("100"));
        objd.setValor_descuento(ValorDes);
        
        if (lista.getIva().equals("NO")) {
            objd.setPrecioiva(new BigDecimal("0.00"));
            BigDecimal importe = Subtotal.subtract(ValorDes);
            objd.setImporte(importe);
        } else {
            String ivaget = lista.getIva();
            BigDecimal IVA = new BigDecimal(ivaget);
            BigDecimal ValorIVA = IVA.multiply(Subtotal);
            objd.setPrecioiva(ValorIVA);
            BigDecimal importe = Subtotal.add(ValorIVA).subtract(ValorDes);
            objd.setImporte(importe);
        }
        return objd;
    }

    private void getPosicion(Long id, int valor) {
        for (int i = 0; i < listaPNP.size(); i++) {
            if (id == listaPNP.get(i).getId_producto()) {
                listaPNP.get(i).setCantidad(valor);
            }
        }

    }

    private void getPosicion2(Long id, int valor) {
        for (int i = 0; i < listaPNP.size(); i++) {
            if (id == listaPNP.get(i).getId_producto()) {
                listaPNP.get(i).setCantidad(valor);
            }
        }

    }

    private void TxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFiltroActionPerformed

    }//GEN-LAST:event_TxtFiltroActionPerformed

    private void TxtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyReleased
//        String buscar = filtro.getText();
//        Tablas.filtro(buscar, t_Nota_faltantes);
    }//GEN-LAST:event_TxtFiltroKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void Buscar() {
        String query = "";

        query = TxtFiltro.getText() + "%";

        int pos = tipofiltro.getSelectedIndex();
        if (pos == 0) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "TODO");

        }
        if (pos == 1) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "CODIGO");

        }
        if (pos == 2) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "NOMBRE");

        }
        if (pos == 3) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "TIPO");

        }
        if (pos == 4) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "MEDIDA");

        }
        if (pos == 5) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "PRESENTACIONES");

        }
        if (pos == 6) {
            listaPNP = crud.FiltrosProductosNotaPedido(query, "MARCA");

        }

        TxtFiltro.setText("");

        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        //Tablas.cargarFiltroProductosNota(tabla_para_productos, lista);
        query = "";
    }

    private void tbaListaFaltantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbaListaFaltantesMousePressed

        BigDecimal iva = new BigDecimal("0.00");
        BigDecimal descuento = new BigDecimal("0.00");
        BigDecimal total = new BigDecimal("0.00");
        Integer SUM = 0;

        try {
            if (evt.getClickCount() == 2) {
                int r = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este producto de la lista?", "", JOptionPane.YES_NO_OPTION);

                if (r == JOptionPane.YES_OPTION) {

                    int i = tbaListaFaltantes.getSelectedRow();

//                    objeto = devuelveObjeto(lista.get(i).getId_precios().toString(), lista);
                    //usa objetoActual suma para devolver la cantidad a array anterior
                    //objetoActual = devuelveProducto(tabla_para_productos.getValueAt(i, 0).toString(), listaPNP);
                    //System.out.println("objetoP cANTIDAD" + objetoActual.getCantidad());
                    //System.out.println("lista1" + listaPNP1.get(i).getCantidad());
                    //SUM = Integer.valueOf(objetoActual.getCantidad()) + listaPNP1.get(i).getCantidad();
                    //getPosicion(objetoActual.getId_producto(), SUM);
                    //System.out.println("suma " + SUM);
                    listaPNP1.remove(i);
                    Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
                    Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);

                    TotalPro();
                    TotalIVA2();
                    TotalDescuento2();
///////////////////////////
                    iva = (BigDecimal) tbaListaFaltantes.getValueAt(i, 9);
                    descuento = (BigDecimal) tbaListaFaltantes.getValueAt(i, 8);
                    total = (BigDecimal) tbaListaFaltantes.getValueAt(i, 10);

                    String iva1 = txtIva.getText();
                    BigDecimal IVA = new BigDecimal(iva1);
                    String descuento1 = txtDescuento.getText();
                    BigDecimal DESCUENTO = new BigDecimal(descuento1);
                    String total1 = txtTotal.getText();
                    BigDecimal TOTAL = new BigDecimal(total1);
                    iva = IVA.subtract(iva);
                    descuento = DESCUENTO.subtract(descuento);
                    total = TOTAL.subtract(total);

                    txtIva.setText(iva.toString());
                    txtDescuento.setText(descuento.toString());
                    txtTotal.setText(total.toString());

//                    lista1.remove(i);
//                    Tablas.cargarJoinProductoDetallesFaltantes(tbaListaFaltantes, lista1);
                    Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);
                    Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
                    TotalPro();
                    TotalIVA2();
                    TotalDescuento2();

                } else {

                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbaListaFaltantesMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MantenimientoNotaPedidos Man = new MantenimientoNotaPedidos(new javax.swing.JFrame(), true);
        Man.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel7MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MantenimientoProducto Prod = new MantenimientoProducto(new javax.swing.JFrame(), true, objUsuario);
        Prod.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TxtFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Buscar();
        }
    }//GEN-LAST:event_TxtFiltroKeyPressed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoMouseClicked
        Reiniciar();
        TxtFiltro.setEnabled(false);
        btnBuscar.setEnabled(false);
        lblGuardar.setEnabled(false);
        tabla_para_productos.setEnabled(false);
    }//GEN-LAST:event_lblNuevoMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        if (!"0,00".equals(txtTotal.getText())) {

            //ArrayList<String> queryL = new ArrayList<String>();
            ArrayList<String> queryL1 = new ArrayList<String>();
            String id_cab = "";
            String cad = "";
            String cad1 = "";
            CabeceraNotaPedido cn = new CabeceraNotaPedido();
            cn.setId_proveedor(Long.parseLong(txtCodigoProveedor.getText()));
            cn.setId_usuario(Long.valueOf("2"));
            cn.setFecha_creacion(txtFecha.getText() + " " + txtHora.getText());
            cn.setPlazo(cbxPlazo.getSelectedItem().toString());
            cn.setForma_pago(cbxFormaP.getSelectedItem().toString());
            cn.setIva(VGiva);
            cn.setDescuento(VGdescuento);
            cn.setTotal(VGtotal);
            
            String hora = txtFecha.getText() + " " + txtHora.getText();
            System.out.println(txtCodigoProveedor.getText() + " " + 2 +" " + hora +" " + cbxPlazo.getSelectedItem().toString() +" " + cbxFormaP.getSelectedItem().toString() +" " + VGiva +" " + VGdescuento+" " + VGtotal);

            try {

                id_cab = crud.insertarCabeceraNotaPedido(cn);

                //String query = "SELECT `id_cabecera_nota_pedidos` FROM `cabecera_nota_pedidos` WHERE `id_proveedor`=" + txtCodigoProveedor.getText() + " AND `fecha_creacion`=" + "'" + txtFecha.getText() + " " + txtHora.getText() + "'" + " AND `total`=" + VGtotal.toString();
                //id_cab = crud.buscarIDCabeceraNotaPedido(query);
                
                if (id_cab.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "id_cabecera esta vacio");
                } else {

                    for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
                        /////////////////////////////
                        System.out.println("Cabecera: " + id_cab);
                        System.out.println("Id_precio: " + listaPNP1.get(i).getId_precios());
                        System.out.println("Cantidad: " + tbaListaFaltantes.getValueAt(i, 7));
                        System.out.println("Precio: " + listaPNP1.get(i).getPrecioBono());
                        System.out.println("Descuento: " + listaPNP1.get(i).getValor_descuento());
                        System.out.println("Total: " + listaPNP1.get(i).getImporte());
                        System.out.println("Iva: " + listaPNP1.get(i).getPrecioiva());
                        System.out.println("Bono" + tbaListaFaltantes.getValueAt(i, 6));
                        System.out.println("Unidad: " + tbaListaFaltantes.getValueAt(i, 8));
                        System.out.println("Observacion: " + listaPNP1.get(i).getObservacion());
                        
                        cad1 = "INSERT INTO detalle_nota_pedidos"
                                + "(`id_cabecera_nota_pedidos`,`id_precio`,`cantidad`,`precio`,`descuento`,`total`,`iva`,`bono`,`unidad`, `observacion`)"
                                + "VALUES(" + id_cab + "," + listaPNP1.get(i).getId_precios() + "," + tbaListaFaltantes.getValueAt(i, 7).toString() + "," + 
                                            listaPNP1.get(i).getPrecioBono() + "," + listaPNP1.get(i).getValor_descuento().toString() + "," + listaPNP1.get(i).getImporte() + "," + listaPNP1.get(i).getPrecioiva().toString() + 
                                "," + tbaListaFaltantes.getValueAt(i, 6).toString() + ","+tbaListaFaltantes.getValueAt(i, 8).toString() + ",'" + listaPNP1.get(i).getObservacion() + "')";
                        queryL1.add(cad1);
//                        System.out.println(" " + cad1);
                    }
                    crud.InsertarDetallesNotaPedidos(queryL1);
                    System.out.println(" " + queryL1);
                    queryL1.clear();
                    JOptionPane.showMessageDialog(null, " Guardado con Exito ");
                    lblGuardar.setEnabled(false);
                    lblNuevo.setEnabled(true);

                    setVisible(false);

                    CabeceraCompra CB = new CabeceraCompra(new javax.swing.JFrame(), true, objUsuario);
                    CB.setVisible(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en Insertar --> " + e);
            }

        } else {

            JOptionPane.showMessageDialog(rootPane, "INGRESE DATOS");
        }
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void TxtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyTyped
        boolean v = crud.ValidarCaracteres(evt);
        if (v == false) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TxtFiltroKeyTyped

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    public joinProductoDetallesFaltantes devuelveObjeto(String datos, ArrayList<joinProductoDetallesFaltantes> listarobj) {

        joinProductoDetallesFaltantes objeto1 = null;

        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_producto().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }

        return objeto1;
    }

    //NUEVO   devolver objeto para mandar abajo 
    public joinProductoParaNotaPedido devuelveProducto(String datos, ArrayList<joinProductoParaNotaPedido> listarobj) {

        joinProductoParaNotaPedido objeto1 = null;

        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_producto().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }

        return objeto1;
    }

    private void Reiniciar() {
        txtCodigoProveedor.setText("");
        txtCorreo1.setText("");
        txtDescuento.setText("");
        txtNombre1.setText("");
        txtRepresentante.setText("");
        txtDireccion1.setText("");
        txtRuc1.setText("");
        txtTipo1.setText("");
        txtTelefono1.setText("");
        txtIva.setText("");
        txtTotal.setText("");
        listaPNP1.clear();
        Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);
        tbaListaFaltantes.clearSelection();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotePedidos dialog = new NotePedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelSec;
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JTable tabla_para_productos;
    private javax.swing.JTable tbaListaFaltantes;
    private javax.swing.JScrollPane tblProduc;
    private javax.swing.JComboBox<String> tipofiltro;
    public static javax.swing.JLabel txtCodigoProveedor;
    public static javax.swing.JTextField txtCorreo1;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNombre1;
    public static javax.swing.JTextField txtRepresentante;
    public static javax.swing.JTextField txtRuc1;
    public static javax.swing.JTextField txtTelefono1;
    public static javax.swing.JTextField txtTipo1;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
