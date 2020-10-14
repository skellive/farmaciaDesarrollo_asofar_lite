/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.producto;

import com.farmacia.conponentes.Formulario;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.CategoriaProducto;
import com.farmacia.entities1.ClaseReporte;
import com.farmacia.entities1.EnvaseProducto;
import com.farmacia.entities1.MarcaProducto;
import com.farmacia.entities1.MedidaProducto;
import com.farmacia.entities1.Productos;
import com.farmacia.entities1.TipoProducto;
import com.farmacia.views.precios.Mantenimiento_Precios_Productos;
import com.farmacia.join_entidades.listarJoinProductosCompras;
import com.farmacia.views.compras.AgregarCategoria;
import com.farmacia.views.compras.AgregarEnvase;
import com.farmacia.views.compras.AgregarMarca;
import com.farmacia.views.compras.AgregarMedida;
import com.farmacia.views.compras.AgregarTipo;
import com.farmacia.views.compras.OrdenCompra;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
public class modificarProducto extends javax.swing.JDialog {

    CRUD crud = new CRUD();
    listarJoinProductosCompras obj1 = null;
    int x, y;
    ArrayList<TipoProducto> lista = null;
    ArrayList<MedidaProducto> listam = null;
    ArrayList<EnvaseProducto> listae = null;
    ArrayList<MarcaProducto> listama = null;
    ArrayList<CategoriaProducto> listacau = null;
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    String FechaActual;
    String str_tipo = null, str_medidas = null, str_envase = null, str_marcas = null, strIva = null, strCategoria = null;
    String error = "", IVA = "";
    Long id_tipo, id_medida, id_envase, id_marca, id_categoria;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

    public modificarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        initComponents();
        setLocationRelativeTo(null);
        //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        //    txtFecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new modificarProducto.horas());
        tiempo.start();
    }

    public modificarProducto(java.awt.Frame parent, boolean modal, listarJoinProductosCompras obj2) {

        super(parent, modal);
        try {
            getContentPane().setBackground(Color.white);
            initComponents();
            obj1 = obj2;
            setLocationRelativeTo(null);
            listarCombos(obj1);
            llenarFormulario(obj1);
            Habilitar(false);
            //FECHA DEL SISTEMA
        java.util.Date sistFecha = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        //    txtFecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new modificarProducto.horas());
        tiempo.start();
        } catch (Exception ex) {
            Logger.getLogger(modificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            //txtHora.setText(String.format(format.format(sistHora), hoy));

        }
    }
    public void listarCombos(listarJoinProductosCompras obj) {

        lista = crud.listarTodoTipoProductos1();
        listam = crud.listarTodoMedidasProductos();
        listae = crud.listarTodoEnvaseProductos();
        listama = crud.listarTodoMarcaProductos();
        listacau = crud.listarTodoCategoriaProductos();

        cbxTipos1.setModel(Formulario.listarComboTipoPro(lista));
        cbxMedida1.setModel(Formulario.listarComboMedidaPro(listam));
        cbxEnvase1.setModel(Formulario.listarComboEnvasePro(listae));
        cbxMarca1.setModel(Formulario.listarComboMarcaPro(listama));
        cbcucategoria.setModel(Formulario.listarComboCategoriaPro(listacau));

        str_tipo = crud.getNombreComboProducto(Long.valueOf("1"), obj.getId_tipo());
        cbxTipos1.setSelectedItem(str_tipo);
        str_medidas = crud.getNombreComboProducto(Long.valueOf("2"), obj.getId_medida());
        cbxMedida1.setSelectedItem(str_medidas);
        str_envase = crud.getNombreComboProducto(Long.valueOf("3"), obj.getId_envase());
        cbxEnvase1.setSelectedItem(str_envase);
        strCategoria = crud.getNombreComboProducto(Long.valueOf("9"), obj.getId_categoria());
        cbcucategoria.setSelectedItem(strCategoria);
        str_marcas = crud.getNombreComboProducto(Long.valueOf("4"), obj.getId_marca());
        cbxMarca1.setSelectedItem(str_marcas);
        id_usuario.setText(obj.getId_usuario().toString());
        strIva = crud.getNombreComboProducto(Long.valueOf("5"), obj.getId_productos());
        cbxIva.setSelectedItem(strIva);

        cbxReceta.setSelectedItem(obj.getReceta());
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
        id_usuario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxMarca1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbxMedida1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtDescripcion1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxTipos1 = new javax.swing.JComboBox<>();
        btnAgregarTipo1 = new javax.swing.JButton();
        btnAgregarMedida1 = new javax.swing.JButton();
        btnAgreMarca1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtPeso1 = new javax.swing.JTextField();
        btnAgreEnvase1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cbxEnvase1 = new javax.swing.JComboBox<>();
        codigo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        producto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtcantMinima = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbxIva = new javax.swing.JComboBox<>();
        editarPrecio = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtUnidades = new javax.swing.JTextField();
        cbxReceta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        codigo2 = new javax.swing.JTextField();
        cbcucategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnagregacategoria = new javax.swing.JButton();
        txtFechaActual1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblImprimir = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel3.setOpaque(false);

        id_usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        id_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_usuarioActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel4.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setText("PRODUCTO:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 27, 134));
        jLabel9.setText("MARCA/LABORATORIO:");

        cbxMarca1.setEditable(true);
        cbxMarca1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarca1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 27, 134));
        jLabel11.setText("UNIDAD DE MEDIDA:");

        cbxMedida1.setEditable(true);
        cbxMedida1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxMedida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedida1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 27, 134));
        jLabel15.setText("DESCRIPCION:");

        txtDescripcion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescripcion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtDescripcion1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcion1FocusLost(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 27, 134));
        jLabel16.setText("TIPO:");

        cbxTipos1.setEditable(true);
        cbxTipos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxTipos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipos1ActionPerformed(evt);
            }
        });

        btnAgregarTipo1.setBackground(new java.awt.Color(0, 27, 134));
        btnAgregarTipo1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarTipo1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarTipo1.setText("AGREGAR");
        btnAgregarTipo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipo1ActionPerformed(evt);
            }
        });

        btnAgregarMedida1.setBackground(new java.awt.Color(0, 27, 134));
        btnAgregarMedida1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarMedida1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMedida1.setText("AGREGAR");
        btnAgregarMedida1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarMedida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedida1ActionPerformed(evt);
            }
        });

        btnAgreMarca1.setBackground(new java.awt.Color(0, 27, 134));
        btnAgreMarca1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgreMarca1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgreMarca1.setText("AGREGAR");
        btnAgreMarca1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgreMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreMarca1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 27, 134));
        jLabel17.setText("PESO:");

        txtPeso1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPeso1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtPeso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeso1ActionPerformed(evt);
            }
        });

        btnAgreEnvase1.setBackground(new java.awt.Color(0, 27, 134));
        btnAgreEnvase1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgreEnvase1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgreEnvase1.setText("AGREGAR");
        btnAgreEnvase1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgreEnvase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreEnvase1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 27, 134));
        jLabel18.setText("PRESENTACION:");

        cbxEnvase1.setEditable(true);
        cbxEnvase1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxEnvase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEnvase1ActionPerformed(evt);
            }
        });

        codigo.setEditable(false);
        codigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 27, 134));
        jLabel19.setText("CODIGO:");

        producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        producto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                productoFocusLost(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 27, 134));
        jLabel22.setText("CANT. MINIMA STOCK:");

        txtcantMinima.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcantMinima.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtcantMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantMinimaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 27, 134));
        jLabel20.setText("IVA:");

        cbxIva.setEditable(true);
        cbxIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        cbxIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxIvaActionPerformed(evt);
            }
        });

        editarPrecio.setBackground(new java.awt.Color(0, 27, 134));
        editarPrecio.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        editarPrecio.setForeground(new java.awt.Color(255, 255, 255));
        editarPrecio.setText("EDITAR PRECIOS");
        editarPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPrecioActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 27, 134));
        jLabel12.setText("UNIDADES:");

        txtUnidades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnidades.setText("0");
        txtUnidades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesActionPerformed(evt);
            }
        });
        txtUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnidadesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidadesKeyTyped(evt);
            }
        });

        cbxReceta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIN RECETA ", "CON RECETA" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("CODIGO DE BARRAS:");

        jButton1.setBackground(new java.awt.Color(0, 27, 134));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MODIFICAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        codigo2.setEditable(false);
        codigo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        cbcucategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbcucategoria.setEnabled(false);
        cbcucategoria.setRequestFocusEnabled(false);
        cbcucategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcucategoriaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setText("CATEGORIA:");

        btnagregacategoria.setBackground(new java.awt.Color(0, 27, 134));
        btnagregacategoria.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnagregacategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnagregacategoria.setText("AGREGAR");
        btnagregacategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregacategoria.setEnabled(false);
        btnagregacategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregacategoriaActionPerformed(evt);
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
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPeso1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel9)
                            .addComponent(jLabel22)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxIva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxReceta, 0, 167, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtcantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxEnvase1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxTipos1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxMarca1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxMedida1, 0, 160, Short.MAX_VALUE)
                                            .addComponent(cbcucategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnAgregarMedida1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(btnAgreEnvase1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(btnAgregarTipo1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(btnAgreMarca1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(btnagregacategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 130, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(codigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel15))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxIva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbcucategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregacategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipos1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEnvase1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgreEnvase1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgreMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        txtFechaActual1.setEditable(false);
        txtFechaActual1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFechaActual1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaActual1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 27, 134));
        jLabel14.setText("FECHA:");

        btnModificar.setBackground(new java.awt.Color(0, 27, 134));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 27, 134));
        jLabel21.setText("USUARIO:");

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/eliminar.png"))); // NOI18N
        lblEliminar.setText("ELIMINAR");
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        lblImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/imprimir.png"))); // NOI18N
        lblImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImprimirMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel1.setOpaque(false);

        jLabel23.setBackground(new java.awt.Color(0, 153, 153));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 27, 134));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("PRODUCTO");
        jLabel23.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel23MouseDragged(evt);
            }
        });
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lblImprimir)
                .addGap(100, 100, 100)
                .addComponent(lblGuardar)
                .addGap(88, 88, 88)
                .addComponent(lblEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addComponent(txtFechaActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGuardar)
                    .addComponent(lblImprimir)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblEliminar))))
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

    
    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }
    
    private void llenarFormulario(listarJoinProductosCompras obj) {
        
        codigo.setText(obj.getId_productos().toString());
        if (obj.getCodigo_barras() == null) {
            codigo2.setText("0000000000000");
        } else {
            codigo2.setText(obj.getCodigo_barras());
        }
        producto.setText(obj.getNombreProductos());
        txtDescripcion1.setText(obj.getDescripcion());
        txtPeso1.setText(obj.getPeso().toString());
        txtFechaActual1.setText(FechaActual);
        txtUnidades.setText(obj.getUnidades().toString());
        txtcantMinima.setText(obj.getCantidad_minima().toString());
        System.out.println(//"id_medida: "+obj.getId_medida()+"/n"+
                "id_tipo:" + id_tipo);
//                            "id_envase"+obj.getNombreEnvase()+"/n"+
//                            "id_marca"+obj.getId_marca());
//        
    }


    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //        String valor="";
        //        if (!"".equals(seleccionId())) {
        //            JOptionPane.showMessageDialog(this, error);
        //
        //        } else {
        //
        //            Productos p = new Productos();
        //            p.setNombre(nombre1.getText());
        //            p.setDescripcion(txtDescripcion.getText());
        //            p.setFecha_registro(Fecha.FechaSql());
        //            p.setPeso(Double.parseDouble(txtPeso.getText()));
        //            p.setId_tipo(id_tipo);
        //            p.setId_medidas(id_medida);
        //            p.setId_envase(id_envase);
        //            p.setId_marcas(id_marca);
        //            valor = crud.insertarProductoNuevo(p);
        //            JOptionPane.showMessageDialog(this, valor);
        //            System.out.println("holaaaa " + nombre1.getText());
        //            System.out.println(id_tipo + " " + id_medida + " " + id_envase + " " + id_marca + " " + " " + p.getNombre() + " " + p.getDescripcion() + " " + p.getFecha_registro() + " " + p.getPeso() + " " + p.getId_tipo());
        //                 //
        //                //            }
        //            setVisible(false);
        //        }      //            if(valor!=null){
        //                //
        //                //            }
        //            setVisible(false);
        //        }
        Habilitar(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void id_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_usuarioActionPerformed

    private void jLabel23MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseDragged

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MousePressed
    public int Confirmacion(String msx) {
        int select = JOptionPane.showConfirmDialog(null, msx, "Confirmar", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
        System.out.println(select);
        return select;
    }
    private void cbxMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarca1ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMarca1ActionPerformed

    private void cbxMedida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedida1ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxMedida1ActionPerformed

    private void txtDescripcion1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcion1FocusLost
        txtDescripcion1.setText(txtDescripcion1.getText().toUpperCase());
    }//GEN-LAST:event_txtDescripcion1FocusLost

    private void cbxTipos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipos1ActionPerformed
        seleccionId();
    }//GEN-LAST:event_cbxTipos1ActionPerformed

    private void btnAgregarTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipo1ActionPerformed
        AgregarTipo nuevotipo = new AgregarTipo(new javax.swing.JFrame(), true);
        nuevotipo.setVisible(true);
        lista = crud.listarTodoTipoProductos1();
        cbxTipos1.setModel(Formulario.listarComboTipoPro(lista));
    }//GEN-LAST:event_btnAgregarTipo1ActionPerformed

    private void btnAgregarMedida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedida1ActionPerformed
        AgregarMedida agremed = new AgregarMedida(new javax.swing.JFrame(), true);
        agremed.setVisible(true);
//        listam.clear();
//        cbxMedida.removeAll();
//        listam = crud.listarTodoMedidasProductos();//     listarTodoTipoProductos1();
//        cbxMedida.setModel(Formulario.listarComboMedidaPro(listam));
        listarCombos(obj1);
    }//GEN-LAST:event_btnAgregarMedida1ActionPerformed

    private void btnAgreMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreMarca1ActionPerformed
        AgregarMarca agremar = new AgregarMarca(new javax.swing.JFrame(), true);
        agremar.setVisible(true);
        listama = crud.listarTodoMarcaProductos();//     listarTodoTipoProductos1();
        cbxMarca1.setModel(Formulario.listarComboMarcaPro(listama));
    }//GEN-LAST:event_btnAgreMarca1ActionPerformed

    private void txtPeso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeso1ActionPerformed

    private void btnAgreEnvase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreEnvase1ActionPerformed
        AgregarEnvase agreenv = new AgregarEnvase(new javax.swing.JFrame(), true);
        agreenv.setVisible(true);
        listae = crud.listarTodoEnvaseProductos();
        cbxEnvase1.setModel(Formulario.listarComboEnvasePro(listae));
    }//GEN-LAST:event_btnAgreEnvase1ActionPerformed

    private void cbxEnvase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEnvase1ActionPerformed
        seleccionId();
        // System.out.println(" " + listae.get(pos_envase).getId_envase() + " " + listae.get(pos_envase).getNombreEnvase());
    }//GEN-LAST:event_cbxEnvase1ActionPerformed

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        txtDescripcion1.setText(txtDescripcion1.getText().toUpperCase());
    }//GEN-LAST:event_codigoFocusLost

    private void productoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productoFocusLost
        producto.setText(producto.getText().toUpperCase());
    }//GEN-LAST:event_productoFocusLost

    private void txtcantMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantMinimaActionPerformed

    private void cbxIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxIvaActionPerformed
        IVA = cbxIva.getSelectedItem().toString();
    }//GEN-LAST:event_cbxIvaActionPerformed

    private void editarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPrecioActionPerformed
        Mantenimiento_Precios_Productos mp = new Mantenimiento_Precios_Productos(new javax.swing.JFrame(), true, Long.valueOf(codigo.getText()), producto.getText());
        mp.setVisible(true);
    }//GEN-LAST:event_editarPrecioActionPerformed

    private void txtUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesActionPerformed

    private void txtUnidadesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesKeyReleased

    private void txtUnidadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadesKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || Character.isSpaceChar(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUnidadesKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        CodigoBarras cod = new CodigoBarras(null, rootPaneCheckingEnabled, 2, codigo2.getText());
        cod.setVisible(true);
        codigo2.setText(cod.getCodigoBarra());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbcucategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcucategoriaActionPerformed
        // TODO add your handling code here:
        seleccionId();
    }//GEN-LAST:event_cbcucategoriaActionPerformed

    private void btnagregacategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregacategoriaActionPerformed
        AgregarCategoria agremed = new AgregarCategoria(new javax.swing.JFrame(), true);
        agremed.setVisible(true);
        listacau = crud.listarTodoCategoriaProductos();
        cbcucategoria.setModel(Formulario.listarComboCategoriaPro(listacau));
    }//GEN-LAST:event_btnagregacategoriaActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        String valor = "";
        int h = Confirmacion("Deseas Eliminar el Producto: " + producto.getText() + " con ID: " + codigo.getText() + " ?");
        if (h == 0) {
            valor = crud.eliminarProducto(Long.valueOf(codigo.getText()));
            JOptionPane.showMessageDialog(this, valor);
            this.setVisible(false);
        }
        // listarJoinProductosCompras cp =new listarJoinProductosCompras();
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        String valor = "";
        FechaActual = hourdateFormat.format(date);
        //        listarJoinProductosCompras cp =new listarJoinProductosCompras();
        //        cp.setNombreProductos(producto.getText());
        //        cp.setDescripcion(txtDescripcion1.getText());
        //        cp.setPeso(Double.valueOf(txtPeso1.getText()));
        //        System.out.println(id_tipo);
        //        cp.setId_tipo(id_tipo);
        //        cp.setId_medida(id_medida);
        //        cp.setId_envase(id_envase);
        //        cp.setId_marca(id_marca);
        //        cp.setId_productos(Long.valueOf(codigo.getText()));
        Productos p = new Productos();
        p.setNombre(producto.getText());
        p.setDescripcion(txtDescripcion1.getText());
        p.setPeso(Double.valueOf(txtPeso1.getText()));
        p.setId_tipo(id_tipo);
        p.setId_medidas(id_medida);
        p.setId_envase(id_envase);
        p.setId_marcas(id_marca);
        p.setId_categoria(id_categoria);
        p.setId_productos(Long.valueOf(codigo.getText()));
        p.setId_usuario(Long.valueOf(id_usuario.getText()));
        p.setIva(IVA);
        p.setFecha_registro(FechaActual);
        p.setCantidad_minima(Long.valueOf(txtcantMinima.getText()));
        p.setReceta(String.valueOf(cbxReceta.getSelectedItem()));
        p.setUnidades(Long.valueOf(txtUnidades.getText()));
        valor = crud.modificarProductos(p);
        JOptionPane.showMessageDialog(this, valor);
        this.setVisible(false);
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void lblImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimirMouseClicked
        ArrayList producto1 = new ArrayList();
        ClaseReporte producto2 = new ClaseReporte(id_usuario.getText(), txtFechaActual1.getText(), codigo.getText(), cbxIva.getSelectedItem().toString(), producto.getText(), txtDescripcion1.getText(), txtPeso1.getText(), cbxMedida1.getSelectedItem().toString(), cbxTipos1.getSelectedItem().toString(), cbxEnvase1.getSelectedItem().toString(), cbxMarca1.getSelectedItem().toString(), txtcantMinima.getText());
        producto1.add(producto2);
        try {
            String dir = System.getProperty("user.dir") + "/Reportes/" + "modificarProducto.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(dir);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(producto1));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho / 2, alto / 2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(modificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblImprimirMouseClicked

    public void Habilitar(boolean valor) {
        codigo.setEnabled(valor);
        producto.setEnabled(valor);
        txtDescripcion1.setEnabled(valor);
        txtPeso1.setEnabled(valor);
        txtFechaActual1.setEnabled(valor);
        cbxTipos1.setEnabled(valor);
        cbxMedida1.setEnabled(valor);
        cbxEnvase1.setEnabled(valor);
        cbxMarca1.setEnabled(valor);
        lblGuardar.setEnabled(valor);
        id_usuario.setEnabled(valor);
        txtcantMinima.setEnabled(valor);
        cbxIva.setEnabled(valor);
        btnAgregarTipo1.setEnabled(valor);
        btnAgregarMedida1.setEnabled(valor);
        btnAgreMarca1.setEnabled(valor);
        btnAgreEnvase1.setEnabled(valor);
        editarPrecio.setEnabled(valor);
        txtUnidades.setEnabled(valor);
        cbcucategoria.setEnabled(valor);
        btnagregacategoria.setEnabled(valor);
    }

    private String seleccionId() {
        error = "";

        if (txtDescripcion1.getText().length() < 5) {
            error = error + "\nNombre invalido!";
        }
        if (txtDescripcion1.getText().length() < 5) {
            error = error + "\nDescripcion invalida!";
        }
        if (txtPeso1.getText() == null || "".equals(txtPeso1.getText())) {
            error = error + "\nCantidad invalida!";
        }
        int pos = (cbxTipos1.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nTipo de producto invalido !";
        } else {
            id_tipo = lista.get(pos).getId_tipo();
            System.err.println(id_tipo);
        }

        pos = (cbxMedida1.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nMedida invalida !";
        } else {
            id_medida = listam.get(pos).getId_medidas();
            System.err.println(id_medida);
        }

        pos = (cbxMarca1.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nMarca invalida !";
        } else {
            id_marca = listama.get(pos).getId_Marcas();
            System.err.println(id_marca);
        }

        pos = (cbxEnvase1.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nEnvase invalido !";
        } else {
            id_envase = listae.get(pos).getId_presentaciones();
            System.err.println(id_envase);
        }

        pos = (cbcucategoria.getSelectedIndex() - 1);
        if (pos < 0) {
            error = error + "\nCategoria invalido !";
        } else {
            id_categoria = listacau.get(pos).getId_categoria();
            System.err.println(id_categoria);
        }
        return error;
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
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                modificarProducto dialog = new modificarProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgreEnvase1;
    private javax.swing.JButton btnAgreMarca1;
    private javax.swing.JButton btnAgregarMedida1;
    private javax.swing.JButton btnAgregarTipo1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnagregacategoria;
    private javax.swing.JComboBox<String> cbcucategoria;
    private javax.swing.JComboBox<String> cbxEnvase1;
    private javax.swing.JComboBox<String> cbxIva;
    private javax.swing.JComboBox<String> cbxMarca1;
    private javax.swing.JComboBox<String> cbxMedida1;
    private javax.swing.JComboBox<String> cbxReceta;
    private javax.swing.JComboBox<String> cbxTipos1;
    private javax.swing.JTextField codigo;
    public javax.swing.JTextField codigo2;
    private javax.swing.JButton editarPrecio;
    public static javax.swing.JTextField id_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JTextField producto;
    public static javax.swing.JTextField txtDescripcion1;
    private javax.swing.JTextField txtFechaActual1;
    public static javax.swing.JTextField txtPeso1;
    public static javax.swing.JTextField txtUnidades;
    public static javax.swing.JTextField txtcantMinima;
    // End of variables declaration//GEN-END:variables
}
