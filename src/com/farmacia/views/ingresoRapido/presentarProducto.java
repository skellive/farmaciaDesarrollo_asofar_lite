/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.ingresoRapido;

import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.conponentes.Tablas;
import static com.farmacia.conponentes.Tablas.filtro;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.Listar_usuario;
import com.farmacia.filtros.filtrosProductos;
import com.farmacia.join_entidades.ListarJoinProveedorNotaPedido;
import com.farmacia.join_entidades.joinProductoParaNotaPedido;
import com.farmacia.join_entidades.listarJoinProductosNotaPedidos;
import com.farmacia.validaciones.ComponentesFaltantes;
//import static com.farmacia.views.ingresoRapido.ingresoRapido.tabla_para_productos;
import com.farmacia.views.pedidos.AgregarProductoNotaPedido;
import static com.farmacia.views.pedidos.NotePedidos.txtCodigoProveedor;
import static com.farmacia.views.pedidos.NotePedidos.txtCorreo1;
import static com.farmacia.views.pedidos.NotePedidos.txtDescuento;
import static com.farmacia.views.pedidos.NotePedidos.txtDireccion1;
import static com.farmacia.views.pedidos.NotePedidos.txtIva;
import static com.farmacia.views.pedidos.NotePedidos.txtNombre1;
import static com.farmacia.views.pedidos.NotePedidos.txtRepresentante;
import static com.farmacia.views.pedidos.NotePedidos.txtRuc1;
import static com.farmacia.views.pedidos.NotePedidos.txtTelefono1;
import static com.farmacia.views.pedidos.NotePedidos.txtTipo1;
import static com.farmacia.views.pedidos.NotePedidos.txtTotal;
import com.farmacia.views.producto.MantenimientoProducto;
import com.farmacia.views.producto.Products;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Table;

/**
 *
 * @author User
 */
public class presentarProducto extends javax.swing.JFrame {

    /**
     * Creates new form presentarProducto
     */
    int x, y;
    CRUD crud = new CRUD();
    BigDecimal VGiva = null, VGtotal = null, VGdescuento = null;
    filtrosProductos fil = new filtrosProductos();
    //joinProductoDetallesFaltantes objeto = null;
    ListarJoinProveedorNotaPedido proveedorC = null;
    
    //public static JTable tbaListaFaltantes = new ingresoRapido().tabla_para_productos;   
    
    static ArrayList<listarJoinProductosNotaPedidos> listar = null;
    //ArrayList<joinProductoDetallesFaltantes> lista = crud.listarFaltantesDetalles(1);
    //ArrayList<joinProductoDetallesFaltantes> lista1 = new ArrayList<joinProductoDetallesFaltantes>();
    //PRODUCTOS
    //ArrayList<listarJoinProductosCompras> listapro = crud.listarTodoJoinProductos(1);
    //NUEVO
    joinProductoParaNotaPedido objetoActual = null;
    ArrayList<joinProductoParaNotaPedido> listaPNP = crud.listarProductoParaNotaPedido(1);
    ArrayList<joinProductoParaNotaPedido> listaPNP1 = new ArrayList<joinProductoParaNotaPedido>();
    
    joinProductoParaNotaPedido Objx = new joinProductoParaNotaPedido();
    //usuario
    Listar_usuario objUsuario = null;
    public presentarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
      //  TotalDescuento2();
        //TotalPro();
        //TotalIVA2();
    }
    
    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            txtHora.setText(String.format(format.format(sistHora), hoy));

        }
    }

  /*  public void TotalPro() {
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
    }*/

  /*  public void TotalIVA2() {
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
    }*/

   /* public void TotalDescuento2() {
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
    }*/

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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tblProduc = new javax.swing.JScrollPane();
        tabla_para_productos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        lblImprimir = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxFormaP = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxPlazo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        PanelSec = new javax.swing.JPanel();
        tipofiltro = new javax.swing.JComboBox<>();
        TxtFiltro = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel2.setOpaque(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_para_productosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_para_productosMousePressed(evt);
            }
        });
        tblProduc.setViewportView(tabla_para_productos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblProduc, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel3.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGREGAR PRODUCTO");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(342, 342, 342)
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

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel4.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PLAZO:");

        cbxFormaP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxFormaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("FORMA DE PAGO:");

        cbxPlazo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxPlazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inmediato", "3 Meses", "6 Meses", "9 Meses", "12 Meses", "24 Meses" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("FECHA:");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("HORA:");

        txtHora.setEditable(false);
        txtHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(37, 37, 37)
                        .addComponent(cbxPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFormaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );

        PanelSec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));

        tipofiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipofiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "CODIGO", "NOMBRE", "TIPO", "MEDIDA", "PRESENTACION", "MARCA" }));

        TxtFiltro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("PRODUCTOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelSecLayout = new javax.swing.GroupLayout(PanelSec);
        PanelSec.setLayout(PanelSecLayout);
        PanelSecLayout.setHorizontalGroup(
            PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSecLayout.setVerticalGroup(
            PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNuevo)
                .addGap(267, 267, 267))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(PanelSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImprimir)
                    .addComponent(lblNuevo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public joinProductoParaNotaPedido calcularValores(joinProductoParaNotaPedido lista) {
        //joinProductoParaNotaPedido
        joinProductoParaNotaPedido objd = new joinProductoParaNotaPedido();
        objd = lista;
        BigDecimal PrecioBono = new BigDecimal("0.00");

        BigDecimal Cantidad = BigDecimal.valueOf(lista.getCantidad());
        BigDecimal Precio = lista.getPrecios_presentacion();
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
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        Buscar();
    }//GEN-LAST:event_btnBuscarMouseClicked

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
    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_lblCerrarMouseClicked

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
      
     
    public joinProductoParaNotaPedido getProducto(String datos, ArrayList<joinProductoParaNotaPedido> listarobj) {
                joinProductoParaNotaPedido objeto1 = null;

        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getId_producto().toString())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        
        return objeto1;
    }

    public void setProducto(joinProductoParaNotaPedido objetoActual) {
        this.objetoActual = objetoActual;
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
        //Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);
        //tbaListaFaltantes.clearSelection();
    }

    private void lblNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoMouseClicked
        
    }//GEN-LAST:event_lblNuevoMouseClicked

    private void lblImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimirMouseClicked
        
    }//GEN-LAST:event_lblImprimirMouseClicked

    private void tabla_para_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_para_productosMouseClicked

    }//GEN-LAST:event_tabla_para_productosMouseClicked

    private void tabla_para_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_para_productosMousePressed

        //OPERACION PARA LISTAR TABLA DE ABAJO
        int i = 0;
        String msg = null;
        //Nuevo variable para saber si esta el producto en la lista
        String id_pro = null;
        Integer cantidatabla = 0;//ni idea porq si solo la guarda una vez pero no la utiliza
        try {
            if (evt.getClickCount() == 2) {
                i = tabla_para_productos.getSelectedRow();
                //                objeto = devuelveObjeto(lista.get(i).getId_precios().toString(), lista);
                objetoActual = devuelveProducto(tabla_para_productos.getValueAt(i, 0).toString(), listaPNP);

                cantidatabla = objetoActual.getCantidad();
                System.out.println("holaaa");
                //valida que el objeto no este vacio
                if (objetoActual != null) {

                    id_pro = objetoActual.getId_producto().toString();
                    System.out.println(id_pro + " <-- Este es el id Producto");
                    //VALIDA SI EL PRODUCTO ESTA AGREGADO
                    msg = ComponentesFaltantes.validarProductoParaAgregar(listaPNP1, id_pro);
                    System.out.println(msg);
                    //valida el mensaje
                    if (msg == null) {

                        System.out.println("hello");
                        AgregarProductoNotaPedido np = new AgregarProductoNotaPedido(new javax.swing.JFrame(), true, objetoActual);
                        np.setVisible(true);

                        //np.objf.getId_precios();
                        np.getObjf().getId_precios();
                        //System.out.println(" id precio " + np.getObjf().getId_precios());
                        //np.objf.getId_precios();
                        //System.out.println(" id producto " + np.objf.getId_producto());
                        //System.out.println(" cantidad " + np.getObjf().getCantidad());

                        //VER DESDE AQUI
                        //joinProductoParaNotaPedido
                        //compara si tiene el mismo precio para saber si el producto esta dentro
                        //msg = ComponentesFaltantes.validarListaFaltantesNota(listaPNP1, np.objf.getId_precios().toString());
                        //msg = ComponentesFaltantes.validarProductoParaAgregar(listaPNP1,np.objf.getId_producto().toString());
                        System.out.println(" PASO EL NULL");
                        //nada nuevo
                        Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);
                        if (np.getObjf().getCantidad() > 0) {
                            //////

                            //resta y setea la cantidad en 1r array
                            //Integer Resta = Integer.parseInt(tabla_para_productos.getValueAt(i, 6).toString()) - np.getObjf().getCantidad();
                            //getPosicion(objetoActual.getId_producto(), Resta);
                            //////
                            Objx = calcularValores(np.getObjf());
                            ///////
                            listaPNP1.add(Objx);
                            for (joinProductoParaNotaPedido p : listaPNP1) {
                                System.out.println("idddddd " + listaPNP1.get(0).getId_precios());
                            }
                            Tablas.cargarJoinProductosNotaPedido(tabla_para_productos, listaPNP);

                            try {
                                //Tablas.cargarJoinProductoIngresoNotas(tbaListaFaltantes, listaPNP1);
                            } catch (Exception e) {
                                System.out.println("error en tabla2" + e);
                            }

//                            TotalDescuento2();
  //                          TotalPro();
    //                        TotalIVA2();
                        } else {
                            JOptionPane.showMessageDialog(this, "getCantidad() ->" + np.getObjf().getCantidad());
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, msg);
                        // System.out.println(msg);
                    }

                } else {
                }

            }
        } catch (Exception e) {
            // Logger.getLogger(NotePedidos.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_tabla_para_productosMousePressed

    private void TxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFiltroActionPerformed

    }//GEN-LAST:event_TxtFiltroActionPerformed

    private void TxtFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Buscar();
        }
    }//GEN-LAST:event_TxtFiltroKeyPressed

    private void TxtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroKeyReleased
        //        String buscar = filtro.getText();
        //        Tablas.filtro(buscar, t_Nota_faltantes);
    }//GEN-LAST:event_TxtFiltroKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MantenimientoProducto Prod = new MantenimientoProducto(new javax.swing.JFrame(), true, objUsuario);
        Prod.setVisible(true);
        //listapro.clear();
        //listapro = crud.listarTodoJoinProductos(1);
    }//GEN-LAST:event_jButton3ActionPerformed
    
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
            java.util.logging.Logger.getLogger(presentarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(presentarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(presentarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(presentarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new presentarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSec;
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JComboBox<String> cbxFormaP;
    private javax.swing.JComboBox<String> cbxPlazo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JLabel lblNuevo;
    public javax.swing.JTable tabla_para_productos;
    private javax.swing.JScrollPane tblProduc;
    private javax.swing.JComboBox<String> tipofiltro;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
