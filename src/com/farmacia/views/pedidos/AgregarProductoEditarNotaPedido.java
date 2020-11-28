/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.pedidos;

import com.farmacia.dao.CRUD;
import com.farmacia.entities1.DetalleNotaPedido;
import com.farmacia.join_entidades.FaltantesCabeceraDetalles;
import com.farmacia.join_entidades.joinProductoDetallesFaltantes;
import com.farmacia.join_entidades.joinProductoParaNotaPedido;
import com.farmacia.validaciones.Validacion;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author guest-qzjm76
 */
public class AgregarProductoEditarNotaPedido extends javax.swing.JDialog {

    int x, y;
    joinProductoParaNotaPedido objf = new joinProductoParaNotaPedido();
    DetalleNotaPedido obj2 = null;
    Validacion v = new Validacion();
    CRUD crud = new CRUD();

    public AgregarProductoEditarNotaPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void Descuento() {

    }

    public AgregarProductoEditarNotaPedido(java.awt.Frame parent, boolean modal, joinProductoParaNotaPedido obj1) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        //joinProductoParaNotaPedido
        llenarFormulario(obj1);
        txtBono.setEnabled(false);
        txtcantidadpro.setEnabled(false);
        txtporcentajeDescuento.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valorDescuento = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        marca = new javax.swing.JTextField();
        txtcantidadpro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAnadir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        producto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Medida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEnvase3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtporcentajeDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel3.setOpaque(false);
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        marca.setEditable(false);
        marca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        txtcantidadpro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcantidadpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadproActionPerformed(evt);
            }
        });
        txtcantidadpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadproKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("MARCA:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAnadir.setBackground(new java.awt.Color(0, 27, 134));
        btnAnadir.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnAnadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAnadir.setText("AÑADIR");
        btnAnadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("CODIGO:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("PRODUCTO:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        codigo.setEditable(false);
        codigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        producto.setEditable(false);
        producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        producto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 27, 134));
        jLabel14.setText("CANTIDAD:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Medida.setEditable(false);
        Medida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Medida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        Medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedidaActionPerformed(evt);
            }
        });
        Medida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MedidaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 27, 134));
        jLabel9.setText("MEDIDA:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 27, 134));
        jLabel10.setText("ENVASE:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtEnvase3.setEditable(false);
        txtEnvase3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEnvase3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtEnvase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnvase3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 27, 134));
        jLabel15.setText("TIPO:");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtTipo.setEditable(false);
        txtTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 27, 134));
        jLabel16.setText("PRECIO:");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 27, 134));
        jLabel17.setText("IVA:");

        txtIva.setEditable(false);
        txtIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("DESCUENTO:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtporcentajeDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtporcentajeDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtporcentajeDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtporcentajeDescuentoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setText("%");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 27, 134));
        jLabel18.setText("BONO:");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtBono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBonoActionPerformed(evt);
            }
        });
        txtBono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBonoKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 27, 134));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ELEGIR PRECIO");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel1.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AÑADIR CANTIDAD ");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar)
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblCerrar)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtBono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtporcentajeDescuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1))
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Medida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtcantidadpro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnvase3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtporcentajeDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidadpro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcantidadproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadproActionPerformed
    private void llenarFormulario(joinProductoParaNotaPedido obj) {
        codigo.setText(obj.getId_producto().toString());
        producto.setText(obj.getNombre_producto());
        Medida.setText(obj.getMedida());
        marca.setText(obj.getMarca());
        txtEnvase3.setText(obj.getEnvase());
        txtTipo.setText(obj.getNombre_tipo());
//        txtPrecio.setText(obj.getPrecios().toString());
        System.out.println("ddddd" + obj.getPrecios());
        txtIva.setText(obj.getIva());
        //
        objf.setId_producto(obj.getId_producto());
        objf.setNombre_producto(obj.getNombre_producto());
        objf.setMedida(obj.getMedida());
        objf.setMarca(obj.getMarca());
        objf.setEnvase(obj.getEnvase());
        objf.setNombre_tipo(obj.getNombre_tipo());
//        objf.setPrecios(obj.getPrecios());
        objf.setIva(obj.getIva());
        objf.setId_precios(obj.getId_precios());

    }
    private void txtcantidadproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadproKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
//            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtcantidadproKeyTyped

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        String cant;
        String porc;
        String bono = "0";
        if (txtcantidadpro.getText() == null || "".equals(txtcantidadpro.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
        } else {
            cant = txtcantidadpro.getText();
            objf.setCantidad(Integer.parseInt(cant));
            setVisible(false);
        }
        /////////////
        if (!"".equals(txtporcentajeDescuento.getText())) {
            porc = txtporcentajeDescuento.getText();

        } else {
            porc = "0.00";

        }
        BigDecimal b1 = new BigDecimal(porc);
        objf.setPorcentaje_descuento(b1);
        if (!"".equals(txtBono.getText())) {
            bono = txtBono.getText();
        } else {
            bono = "0";
        }
        objf.setBono(Integer.parseInt(bono));
    }//GEN-LAST:event_btnAnadirActionPerformed
    public joinProductoParaNotaPedido getObjf() {
        return objf;
    }

    public void insertarProducto() {
        String precio = txtPrecio.getText();
        BigDecimal PRECIO = new BigDecimal(precio);
        String Cantidad = txtcantidadpro.getText();
        BigDecimal CANTIDAD = new BigDecimal(Cantidad);
        String bono = txtBono.getText();
        BigDecimal BONO = new BigDecimal(bono);
        BigDecimal CantidadTotal = BONO.add(CANTIDAD);
        BigDecimal PrecioTotal = CANTIDAD.multiply(PRECIO);
        BigDecimal PrecioBono = CantidadTotal.divide(PrecioTotal);

        DetalleNotaPedido obj = new DetalleNotaPedido();

        obj.setId_detalle_nota_pedidos(obj2.getId_detalle_nota_pedidos());
        obj.setId_precio(obj2.getId_precio());
        obj.setId_cabecera_nota_pedidos(obj2.getId_cabecera_nota_pedidos());
        obj.setCantidad(Integer.parseInt(txtcantidadpro.getText()));
        obj.setPrecio(PrecioBono);
        String descuento = txtporcentajeDescuento.getText();
        BigDecimal DESCUENTO = new BigDecimal(descuento);
        obj.setDescuento(DESCUENTO);
        String iva = txtIva.getText();
        BigDecimal IVA = new BigDecimal(iva);
        obj.setIva(IVA);
        String total = txtporcentajeDescuento.getText();
        BigDecimal TOTAL = new BigDecimal(total);
        obj.setTotal(TOTAL);

//
//        pro.setDouble(6, dnp.getDescuento());
//        pro.setDouble(7, dnp.getIva());
//        pro.setDouble(8, dnp.getTotal());
//        pro.setDouble(9, dnp.getBono());
        crud.insertarProductoEditarNotaPedidos(obj);
    }
    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed

    }//GEN-LAST:event_codigoActionPerformed

    private void MedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedidaActionPerformed

    }//GEN-LAST:event_MedidaActionPerformed

    private void MedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedidaKeyTyped

    }//GEN-LAST:event_MedidaKeyTyped

    private void txtEnvase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnvase3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnvase3ActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoKeyTyped

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtporcentajeDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtporcentajeDescuentoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
//            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }

    }//GEN-LAST:event_txtporcentajeDescuentoKeyTyped

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed
    String CADENA = "";
    private void txtporcentajeDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtporcentajeDescuentoKeyReleased
        int largor = txtporcentajeDescuento.getText().length();
        if (largor > 2) {
            if (Integer.parseInt(txtporcentajeDescuento.getText()) == 100) {
                CADENA = txtporcentajeDescuento.getText();
                txtporcentajeDescuento.setText(CADENA);
            } else {
                CADENA = txtporcentajeDescuento.getText().substring(0, 2);
                txtporcentajeDescuento.setText(CADENA);
                JOptionPane.showMessageDialog(null, "INGRESE VALOR CORRECTO");
            }
        }

    }//GEN-LAST:event_txtporcentajeDescuentoKeyReleased

    private void txtBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBonoActionPerformed

    private void txtBonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBonoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
//            JOptionPane.showMessageDialog(null, "INGRESE NUMEROS");
        }
    }//GEN-LAST:event_txtBonoKeyTyped

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EditarPrecioNotaPedido Pnp = new EditarPrecioNotaPedido(new javax.swing.JFrame(), true, codigo.getText(), producto.getText());
        Pnp.setVisible(true);
        Pnp.getPrecio();
        txtPrecio.setText(Pnp.getPrecio().getPrecio_compra().toString());

        txtBono.setEnabled(true);
        txtporcentajeDescuento.setEnabled(true);
        txtcantidadpro.setEnabled(true);
        objf.setPrecios(Pnp.getPrecio().getPrecio_compra());
        objf.setId_precios(Pnp.getPrecio().getId_precio());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        int r = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "", JOptionPane.YES_NO_OPTION);

        if (r == JOptionPane.YES_OPTION) {
            objf=null;
            setVisible(false);

        } else {

        }
    }//GEN-LAST:event_lblCerrarMouseClicked

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
            java.util.logging.Logger.getLogger(AgregarProductoEditarNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoEditarNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoEditarNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoEditarNotaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarProductoEditarNotaPedido dialog = new AgregarProductoEditarNotaPedido(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Medida;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField producto;
    private javax.swing.JTextField txtBono;
    private javax.swing.JTextField txtEnvase3;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtcantidadpro;
    private javax.swing.JTextField txtporcentajeDescuento;
    private javax.swing.JTextField valorDescuento;
    // End of variables declaration//GEN-END:variables
}
