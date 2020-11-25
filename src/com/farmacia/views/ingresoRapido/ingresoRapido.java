/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.ingresoRapido;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.conponentes.Tablas;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.Cabecera_compra;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.filtros.filtrosProductos;
import com.farmacia.join_entidades.JoinListarCabeceraVenta;
import com.farmacia.join_entidades.JoinListarDetalleNotaPedido;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.joinProductoParaNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import com.farmacia.validaciones.ComponentesFaltantes;
import com.farmacia.views.contentPane.ContentPanel;
import com.farmacia.views.pedidos.AgregarProductoNotaPedido;
import com.farmacia.views.pedidos.Consulta_proveedor_Nota;
import static com.farmacia.views.pedidos.EditarNotaPedido.txtNumero;
import com.farmacia.views.pedidos.NotePedidos;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class ingresoRapido extends javax.swing.JFrame {

    /**
     * Creates new form ingresoRapido
     */
    int x, y;
    CRUD crud = new CRUD();
    String buscar = "";
    BigDecimal VGiva = null, VGtotal = null, VGdescuento = null;
    filtrosProductos fil = new filtrosProductos();
    ListarJoinProveedorNotaPedido proveedorC = null;
    static ArrayList<listarJoinProductosNotaPedidos> listar = null;
    joinProductoParaNotaPedido objetoActual = null;
    ArrayList<joinProductoParaNotaPedido> listaPNP = crud.listarProductoParaNotaPedido(1);
    ArrayList<joinProductoParaNotaPedido> listaPNP1 = new ArrayList<joinProductoParaNotaPedido>();
    joinProductoParaNotaPedido Objx = new joinProductoParaNotaPedido();
    ArrayList<JoinListarDetalleNotaPedido> lista3 = null;
    Listar_usuario objUsuario = null;
    String codigocabecera = "";
    /*java.util.Date sistHora = new java.util.Date();
     String pmAm = "HH:mm:ss";
     SimpleDateFormat format = new SimpleDateFormat(pmAm);
     Calendar hoy = Calendar.getInstance();*/
    Calendar c1 = Calendar.getInstance();
    int dia = (c1.get(Calendar.DATE));
    int mes = (c1.get(Calendar.MONTH));
    int ano = (c1.get(Calendar.YEAR));

    ContentPanel fondo = new ContentPanel();

    public ingresoRapido() {
        setContentPane(fondo);
        initComponents();
        /*txtFecha.setText(String.format(format.format(sistHora), hoy));*/
        txtFecha.setText(dia + "-" + (mes+1) + "-" + ano);
        //filtroProducto.setEnabled(false);
        tabla_para_productos.setEnabled(false);
        tbaListaFaltantes.setEnabled(false);
        btnGuardar.setEnabled(false);
        tipofiltro1.setEnabled(false);
        TxtFiltro.setEnabled(false);
        txtFecha.setEnabled(false);
        btnBuscar.setEnabled(false);
        this.setLocationRelativeTo(null);
        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        Reiniciar();
        TotalDescuento2();
        TotalPro();
        TotalIVA2();
    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }

    public void TotalPro() {
        BigDecimal TotalPro = new BigDecimal("0.00");
        for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
            Integer Cant = listaPNP1.get(i).getCantidad();
            BigDecimal Cantidad = new BigDecimal(Cant);
            BigDecimal Precio = listaPNP1.get(i).getPrecios();
            BigDecimal Subtotal = Cantidad.multiply(Precio);
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
            BigDecimal Precio = listaPNP1.get(i).getPrecios();
            Integer Cant = listaPNP1.get(i).getCantidad();
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
            BigDecimal Precio = listaPNP1.get(i).getPrecios();
            BigDecimal PorcDesc = listaPNP1.get(i).getPorcentaje_descuento();
            Integer Cant = listaPNP1.get(i).getCantidad();
            BigDecimal Cantidad = new BigDecimal(Cant);
            BigDecimal Subtotal = Cantidad.multiply(Precio);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxFormaP = new javax.swing.JComboBox<String>();
        jLabel16 = new javax.swing.JLabel();
        cbxPlazo = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbaListaFaltantes = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_para_productos = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TxtFiltro = new javax.swing.JTextField();
        tipofiltro1 = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(222, 222, 222));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel1.setOpaque(false);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("INGRESO RAPIDO");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(399, 399, 399)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel3.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setText("DIRECCION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("CORREO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("NOMBRE:");

        txtDireccion1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtDireccion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtCorreo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtCorreo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtRuc1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtRuc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("RUC :");

        txtNombre1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 27, 134));
        jLabel11.setText("REPRESENTANTE:");

        txtRepresentante.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtRepresentante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepresentanteKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 27, 134));
        jLabel12.setText("TIPO:");

        txtTipo1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtTipo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 27, 134));
        jLabel13.setText("CODIGO:");

        txtCodigoProveedor.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtCodigoProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setText("TELEFONO:");

        txtTelefono1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        txtTelefono1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 27, 134));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DATOS DEL PROVEEDOR");

        jButton2.setBackground(new java.awt.Color(0, 27, 134));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PROVEEDOR");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTelefono1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(58, 58, 58)
                                            .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(58, 58, 58)
                                .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel4.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PLAZO:");

        cbxFormaP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxFormaP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Credito" }));
        cbxFormaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFormaPActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("FORMA DE PAGO:");

        cbxPlazo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxPlazo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inmediato", "3 Meses", "6 Meses", "9 Meses", "12 Meses", "24 Meses" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("FECHA:");

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(37, 37, 37)
                        .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tbaListaFaltantes.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        tbaListaFaltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " CODIGO", "       MARCA", "      TIPO", "     PRODUCTO", "   PRESENTACION", "   MEDIDA", "  CANTIDAD", "   PRECIO", " DESCUENTO", "      IVA", "    TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("DESCUENTO:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("IVA:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("TOTAL:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("$");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("$");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("$");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        tabla_para_productos.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, null));
        tabla_para_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " CODIGO", "       MARCA", "      TIPO", "     PRODUCTO", "   PRESENTACION", "   MEDIDA", "  CANTIDAD", "   PRECIO", " DESCUENTO", "      IVA", "    TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(tabla_para_productos);

        jLabel22.setText("ESCOGER PRODUCTO");

        jLabel23.setText("LISTA DE PRODUCTOS PARA EL PEDIDO");

        TxtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFiltroActionPerformed(evt);
            }
        });

        tipofiltro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO", "CODIGO", "NOMBRE", "TIPO", "MEDIDA", "ENVASE", "MARCA" }));
        tipofiltro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipofiltro1ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(67, 67, 67)
                        .addComponent(tipofiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipofiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x - x, p.y - y);
    }//GEN-LAST:event_jPanel1MouseDragged

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
        TxtFiltro.setText("");
        tipofiltro1.setEnabled(false);
        TxtFiltro.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnGuardar.setEnabled(false);
        tabla_para_productos.setEnabled(false);
        tbaListaFaltantes.setEnabled(false);
        btnGuardar.setEnabled(false);
        ArrayList<joinProductoParaNotaPedido> listaPNP = crud.listarProductoParaNotaPedido(1);
        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        listaPNP1.clear();
        Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);
        tbaListaFaltantes.clearSelection();
    }

    public joinProductoParaNotaPedido calcularValores(joinProductoParaNotaPedido lista) {
        //joinProductoParaNotaPedido
        joinProductoParaNotaPedido objd = new joinProductoParaNotaPedido();
        objd = lista;
        BigDecimal PrecioBono = new BigDecimal("0.00");

        BigDecimal Cantidad = BigDecimal.valueOf(lista.getCantidad());
        BigDecimal Precio = lista.getPrecios();
        BigDecimal Subtotal = Cantidad.multiply(Precio);
        BigDecimal Bono1 = BigDecimal.valueOf(lista.getBono())/*new BigDecimal(Bono)*/;
        BigDecimal CantidadTotal = Cantidad.add(Bono1);
        PrecioBono = Subtotal.divide(CantidadTotal, 7, RoundingMode.HALF_UP);
        objd.setPrecioBono(PrecioBono);
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
    private void txtRepresentanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepresentanteKeyReleased

    }//GEN-LAST:event_txtRepresentanteKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Consulta_proveedor_Nota Prov = new Consulta_proveedor_Nota(new javax.swing.JFrame(), true);
            Prov.setVisible(true);

            proveedorC = Prov.getProveedor();
            if (proveedorC != null) {

                txtCodigoProveedor.setText(proveedorC.getId_proveedor().toString());
                txtRuc1.setText(proveedorC.getCedula_ruc());
                txtNombre1.setText(proveedorC.getEntidad());
                txtCorreo1.setText(proveedorC.getMail());
                txtRepresentante.setText(proveedorC.getRepresentante());
                txtTipo1.setText(proveedorC.getClase());
                txtTelefono1.setText(proveedorC.getTelefono());
                txtDireccion1.setText(proveedorC.getDireccion());
                tabla_para_productos.setEnabled(true);
                tbaListaFaltantes.setEnabled(true);
                tipofiltro1.setEnabled(true);
                TxtFiltro.setEnabled(true);
                btnBuscar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, " Elija un Proveedor  ");
            }
        } catch (Exception e) {
            Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!"0,00".equals(txtTotal.getText())) {
            try {
                for (int i = 0; i < tbaListaFaltantes.getRowCount(); i++) {
                    crud.ingresoRapido(
                            Integer.parseInt(txtCodigoProveedor.getText()),
                            Integer.parseInt(tbaListaFaltantes.getValueAt(i, 0).toString()),
                            cbxPlazo.getSelectedItem().toString(),
                            cbxFormaP.getSelectedItem().toString(),
                            Float.parseFloat(txtIva.getText().replaceAll(",", ".")),
                            Float.parseFloat(txtDescuento.getText().replaceAll(",", ".")),
                            Float.parseFloat(txtTotal.getText().replaceAll(",", ".")),
                            Integer.parseInt(listaPNP1.get(i).getId_precios().toString()),
                            Float.parseFloat(tbaListaFaltantes.getValueAt(i, 11).toString().replaceAll(",", ".")),
                            Integer.parseInt(tbaListaFaltantes.getValueAt(i, 7).toString()),
                            Integer.parseInt(0 + ""),
                            2);
                    //Float.parseFloat(tbaListaFaltantes.getValueAt(i, 8).toString().replaceAll(",", ".")),

                }
                JOptionPane.showMessageDialog(null, " Guardado con Exito ");
                Reiniciar();
                //}  
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Error en Insertar --> " + e);
                Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "INGRESE DATOS");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void tabla_para_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_para_productosMousePressed
        int i = 0;
        String msg = null;
        String id_pro = null;
        try {
            if (evt.getClickCount() == 2) {
                i = tabla_para_productos.getSelectedRow();
                objetoActual = devuelveProducto(tabla_para_productos.getValueAt(i, 0).toString(), listaPNP);
                System.out.println(objetoActual);
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
                        //System.out.println(" PASO EL NULL");
                        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
                        //filtroProducto.removeAll();
                        if (np.getObjf().getCantidad() > 0) {
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

                            btnGuardar.setEnabled(true);
                            TotalDescuento2();
                            TotalPro();
                            TotalIVA2();
                        } else {
                            JOptionPane.showMessageDialog(this, "getCantidad() ->" + np.getObjf().getCantidad());
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, msg);
                    }
                }
            }
        } catch (Exception e) {
            //Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_tabla_para_productosMousePressed

    private void cbxFormaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFormaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFormaPActionPerformed

    private void TxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFiltroActionPerformed

    public void Filtro() {
        //TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+TxtFiltro.getText()));
    }

    /*    private void TxtFiltroKeyTyped(java.awt.event.KeyEvent evt) {                                   
     TxtFiltro.addKeyListener(new KeyAdapter() {

     public void keyReleased(final KeyEvent e) {
     String Cadena = TxtFiltro.getText();
     System.out.println(Cadena);
     if (Cadena != "" || Cadena == null) {
     TxtFiltro.setText(Cadena);
     Filtro();
     } else {
     Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
     }

     }
     });
     TRSFiltro = new TableRowSorter(tabla_para_productos.getModel());
     tabla_para_productos.setRowSorter(TRSFiltro);
     }   */

    private void tipofiltro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipofiltro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipofiltro1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    public void Buscar() {
        String query = "";

        query = TxtFiltro.getText() + "%";

        int pos = tipofiltro1.getSelectedIndex();
        if (pos == 0) {
            listaPNP = crud.FiltrosIngresoRapido(query, "TODO");
        }
        if (pos == 1) {
            listaPNP = crud.FiltrosIngresoRapido(query, "CODIGO");
        }
        if (pos == 2) {
            listaPNP = crud.FiltrosIngresoRapido(query, "NOMBRE");
        }
        if (pos == 3) {
            listaPNP = crud.FiltrosIngresoRapido(query, "TIPO");
        }
        if (pos == 4) {
            listaPNP = crud.FiltrosIngresoRapido(query, "MEDIDA");
        }
        if (pos == 5) {
            listaPNP = crud.FiltrosIngresoRapido(query, "PRESENTACIONES");
        }
        if (pos == 6) {
            listaPNP = crud.FiltrosIngresoRapido(query, "MARCA");
        }
        //TxtFiltro.setText("");

        //Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
        //Tablas.cargarFiltroProductosNota(tblaProducto, lista);
        query = "";
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
            java.util.logging.Logger.getLogger(ingresoRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingresoRapido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_para_productos;
    private javax.swing.JTable tbaListaFaltantes;
    private javax.swing.JComboBox tipofiltro1;
    public static javax.swing.JLabel txtCodigoProveedor;
    public static javax.swing.JTextField txtCorreo1;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtNombre1;
    public static javax.swing.JTextField txtRepresentante;
    public static javax.swing.JTextField txtRuc1;
    public static javax.swing.JTextField txtTelefono1;
    public static javax.swing.JTextField txtTipo1;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
