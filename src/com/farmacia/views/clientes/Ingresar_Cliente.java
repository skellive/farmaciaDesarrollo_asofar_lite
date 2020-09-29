/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.clientes;


import com.farmacia.validaciones.Validacion;
import com.farmacia.dao.CRUD;
import com.farmacia.dao.Consultas;
import com.farmacia.entities1.Clientes;
import com.farmacia.entities1.Obcx;
import com.farmacia.fecha.Fecha;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ingresar_Cliente extends javax.swing.JDialog {

    int x, y;
    public ArrayList<Obcx> listat = new ArrayList();
    public ArrayList<Obcx> listad = new ArrayList();
    public ArrayList<Obcx> listac = new ArrayList();
    public String[] verificar1 = new String[10];
    public String[] verificar2 = new String[10];
    CRUD cc = new CRUD();
    public ArrayList<Clientes> lista = null;
    Obcx obcx = new Obcx();
    Connection coneccion;
    //Conectar conectar = new Conectar();
    Consultas llamar = new Consultas();
    public String fecha;

    public Ingresar_Cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Connection coneccion;
        //Conectar conectar = new Conectar();
        Consultas llamar = new Consultas();
        //fe();
//        coneccion = conectar.Conexion("Modulo_Cliente");
//        lista = llamar.listarClientes("Modulo_Cliente", "select * from Clientes where Estado = 'A' ");
         
        lista = llamar.listarClientes( "select * from clientes where Estado = 'A' ");
        
        
        fecha_reg.setText(Fecha.getStringFecha(Fecha.FechaSql()));
        Habilitar(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbx2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BotonTelefono = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BotonCorreo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fecha_reg = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        cbx1 = new javax.swing.JComboBox<>();
        direccion = new javax.swing.JTextField();
        lblGuardar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

        cbx2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbx2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...." }));
        cbx2.setPreferredSize(new java.awt.Dimension(126, 28));
        cbx2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("FECHA DE REGISTRO:");

        BotonTelefono.setBackground(new java.awt.Color(0, 27, 134));
        BotonTelefono.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        BotonTelefono.setForeground(new java.awt.Color(255, 255, 255));
        BotonTelefono.setText("+");
        BotonTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTelefonoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setText("NOMBRE:");

        BotonCorreo.setBackground(new java.awt.Color(0, 27, 134));
        BotonCorreo.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        BotonCorreo.setForeground(new java.awt.Color(255, 255, 255));
        BotonCorreo.setText("+");
        BotonCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCorreoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("APELLIDO:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 27, 134));
        jLabel8.setText("CEDULA:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("TELEFONO:");

        cedula.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        cedula.setPreferredSize(new java.awt.Dimension(6, 28));
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cedulaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("CORREO:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setText("DIRECCION:");

        fecha_reg.setEditable(false);
        fecha_reg.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        fecha_reg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha_reg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        fecha_reg.setPreferredSize(new java.awt.Dimension(6, 28));
        fecha_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_regActionPerformed(evt);
            }
        });
        fecha_reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fecha_regKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fecha_regKeyTyped(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        nombre.setMinimumSize(new java.awt.Dimension(6, 28));
        nombre.setPreferredSize(new java.awt.Dimension(6, 28));
        nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFocusLost(evt);
            }
        });
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        apellido.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        apellido.setPreferredSize(new java.awt.Dimension(6, 28));
        apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidoFocusLost(evt);
            }
        });

        cbx1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        cbx1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...." }));
        cbx1.setPreferredSize(new java.awt.Dimension(126, 28));
        cbx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx1ActionPerformed(evt);
            }
        });

        direccion.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        direccion.setMinimumSize(new java.awt.Dimension(6, 28));
        direccion.setPreferredSize(new java.awt.Dimension(6, 28));
        direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                direccionFocusLost(evt);
            }
        });
        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel2.setOpaque(false);

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 27, 134));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("NUEVO CLIENTE");
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel9MouseDragged(evt);
            }
        });
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(162, 162, 162)
                .addComponent(lblCerrar)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(145, 145, 145))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(87, 87, 87))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fecha_reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BotonCorreo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BotonTelefono))
                                .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblGuardar)
                        .addGap(263, 263, 263)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblGuardar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTelefonoActionPerformed
        ArrayList<Obcx> lista = new ArrayList();
        boolean band = false;
        int pos = 0;
        Ingresar_Telefono ic = new Ingresar_Telefono(new javax.swing.JFrame(), true, cedula.getText());
        ic.setVisible(true);
        if (ic.getTelefono() != null) {
            for (int i = 0; i < verificar1.length; i++) {
                if (ic.getTelefono().equals(verificar1[i])) {
                    band = true;
                    JOptionPane.showMessageDialog(null, "EL numero ingresado ya existe");
                    break;
                }
            }
        }   
        if (ic.getTelefono()!= null && band!=true) {
            
       
            verificar1[pos] = ic.getTelefono();
            cbx1.addItem(ic.getTelefono() + " " + ic.getTexto());
            Obcx pol = new Obcx(ic.getTelefono(), ic.getTipo());

            lista.add(pol);
            listat.add(pol);
            pos++;
        }
        
        //System.out.println(lista.get(0).getTcd() + " " + lista.get(0).getTipos());
        //System.out.println(lista.get(1).getTcd() + " " + lista.get(1).getTipos());


    }//GEN-LAST:event_BotonTelefonoActionPerformed


    private void fecha_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_regActionPerformed

    }//GEN-LAST:event_fecha_regActionPerformed

    private void BotonCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCorreoActionPerformed
        ArrayList<Obcx> lista = new ArrayList();
        Ingresar_Correo1 ic = new Ingresar_Correo1(new javax.swing.JFrame(), true, cedula.getText());
        ic.setVisible(true);
        boolean band = false;
        int pos1 = 0;
        if (ic.getCorreo() != null || ic.getCorreo() != "") {
            for (int i = 0; i < verificar2.length; i++) {
                if (ic.getCorreo().equals(verificar2[i])) {
                    band = true;
                    JOptionPane.showMessageDialog(null, "El correo ingresado ya existe");
                    break;
                }
            }
        }
        if (band == false) {
            verificar2[pos1] = ic.getCorreo();
            cbx2.addItem(ic.getCorreo());
            Obcx pol = new Obcx(ic.getCorreo());
            listac.add(pol);
            //listac = lista;
//            System.out.println(lista.get(0).getTcd() + " " + lista.get(0).getTipos());
            pos1++;
        }
    }//GEN-LAST:event_BotonCorreoActionPerformed

    private void cbx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx1ActionPerformed


    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped

        char car = evt.getKeyChar();
        if (cedula.getText().length() >= 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_cedulaKeyTyped

    private void cbx2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx2ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        nombre.setText(nombre.getText().toUpperCase());
    }//GEN-LAST:event_nombreActionPerformed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseDragged

    private void cedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyPressed

    }//GEN-LAST:event_cedulaKeyPressed

    private void nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusLost
        nombre.setText(nombre.getText().toUpperCase());
    }//GEN-LAST:event_nombreFocusLost

    private void apellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidoFocusLost
        apellido.setText(apellido.getText().toUpperCase());
    }//GEN-LAST:event_apellidoFocusLost

    private void fecha_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha_regKeyPressed

    }//GEN-LAST:event_fecha_regKeyPressed

    private void fecha_regKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha_regKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_regKeyTyped

    private void cedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyReleased
       if (Validacion.validarCedula(lista, cedula.getText())) {
            Habilitar(true);
        } else {
            Habilitar(false);
        }
        
    }//GEN-LAST:event_cedulaKeyReleased

    private void direccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionFocusLost

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        setVisible(false);
        Consulta_Clientes cc =new Consulta_Clientes(new javax.swing.JFrame(), true);
        cc.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        if (listat.size() >= 1 && listac.size() >= 1 && nombre.getText().length()>2
                && apellido.getText().length() >2 && direccion.getText().length() >2) {

             String pro = cc.insertarClientes(cedula.getText(),
          //  String pro = cc.insertarClientes("Modulo_Cliente", cedula.getText(),
                    nombre.getText(), apellido.getText(), direccion.getText(),
                    cbx1.getSelectedItem().toString(), cbx2.getSelectedItem().toString());
            if (pro != null) {

                cc.insertarTelefonoCliente(listat, cedula.getText());
                cc.insertarCorreoCliente(listac, cedula.getText());

                JOptionPane.showMessageDialog(null, pro);
                Consulta_Clientes mp = new Consulta_Clientes(new javax.swing.JFrame(), true);
                setVisible(false);
                mp.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "El Cliente ingresado ya existe");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Debe completar todo el formulario");
        }
    }//GEN-LAST:event_lblGuardarMouseClicked
    public void Habilitar(boolean lok) {
        BotonTelefono.setEnabled(lok);
        BotonCorreo.setEnabled(lok);
        direccion.setEnabled(lok);
        //cedula.setEnabled(lok);
        nombre.setEnabled(lok);
        apellido.setEnabled(lok);
        lblGuardar.setEnabled(lok);
    }

//    public void fe() {
//        Calendario1 jh = new Calendario1(new javax.swing.JFrame(), true);
//        //jh.setVisible(true);
//        fecha_registro = jh.getFecha_nacimiento();
//        int com = Fecha.comparacionFecha(fecha_registro, (Date) Fecha.FechaSql());
//        if (com == 1 || com == 0) {
//            fecha.setText(Fecha.getStringFecha(fecha_registro));
//        } else {
//            JOptionPane.showMessageDialog(null, "Fecha Invalida!!");
//            fecha_registro = null;
//            fecha.setText("");
//        }
//    }
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
            java.util.logging.Logger.getLogger(Ingresar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                Ingresar_Cliente dialog = new Ingresar_Cliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotonCorreo;
    private javax.swing.JButton BotonTelefono;
    private javax.swing.JTextField apellido;
    private javax.swing.JComboBox<String> cbx1;
    private javax.swing.JComboBox<String> cbx2;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField fecha_reg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int ICONIFIED) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
