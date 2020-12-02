/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.proveedor;

import com.farmacia.join_entidades.ListarJoinProveedor;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.Correo;
import com.farmacia.entities1.Direccion;
import com.farmacia.entities1.Fecha;
import com.farmacia.entities1.Obcx;
import com.farmacia.entities1.ProveedorRep;
import com.farmacia.entities1.Telefono;
import com.farmacia.filtros.filtrosProductos;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author ANGEL JESUS
 */
public class Editar_Proveedor extends javax.swing.JDialog {
    private String rutaimagen = "";
    int x, y;
    CRUD crud=new CRUD();
    filtrosProductos fil = new filtrosProductos();
    ArrayList<Obcx> listat = null;
    ArrayList<Obcx> listad = null;
    ArrayList<Obcx> listac = null;
    ArrayList<Telefono> telefonos = null;
    ArrayList<Correo> correos = null;
    ArrayList<Direccion> direcciones = null;
    static ArrayList<ListarJoinProveedor> proveedores = null;
    private static ListarJoinProveedor proveedor;
    Long tip1=null,tip3=null;
    String tip2=null;
    Obcx obcx = new Obcx();
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private Date fecha_registro;
    public String fot;

    public Editar_Proveedor(java.awt.Frame parent, boolean modal,ListarJoinProveedor proveedor1) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        proveedor = proveedor1;
        ArrayList<Obcx> listat = null;
        ArrayList<Obcx> listad = null;
        ArrayList<Obcx> listac = null;
        //coneccion = conectar.Conexion("farmacia");
        telefonos = crud.listarTelefono(fil.comboProveedorTelefono());
        correos = crud.listarCorreo(fil.comboProveedorCorreo());
        //direcciones = llamar.listarDireccion("farmacia", "select * from direccion ");
        LlenarDatos(proveedor1, telefonos, correos, direcciones);
        //fe();
        Habilitar(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        contacto = new javax.swing.JTextField();
        cbx1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        dire = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        btnagregarTelf = new javax.swing.JButton();
        cbx2 = new javax.swing.JComboBox<>();
        btnagregarCorreo = new javax.swing.JButton();
        lblImprimir = new javax.swing.JLabel();
        lblInactivar = new javax.swing.JLabel();
        lblActualizar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50), 2));
        jPanel1.setOpaque(false);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("FECHA DE INGRESO:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setText("ENTIDAD/RAZON SOCIAL:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("CONTACTO:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("TELEFONO:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("CORREO:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 27, 134));
        jLabel7.setText("DIRECCION:");

        fecha.setEditable(false);
        fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        fecha.setPreferredSize(new java.awt.Dimension(10, 25));
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFocusLost(evt);
            }
        });

        contacto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        contacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                contactoFocusLost(evt);
            }
        });

        cbx1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 27, 134));
        jLabel8.setText("CEDULA/RUC:");

        cedula.setEditable(false);
        cedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });

        dire.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        dire.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                direFocusLost(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 27, 134));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("AGREGAR IMAGEN");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 27, 134));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("ELIMINAR");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 99, 50), 2, true));

        btnagregarTelf.setBackground(new java.awt.Color(0, 27, 134));
        btnagregarTelf.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnagregarTelf.setForeground(new java.awt.Color(255, 255, 255));
        btnagregarTelf.setText("AGREGAR");
        btnagregarTelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregarTelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarTelfActionPerformed(evt);
            }
        });

        cbx2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnagregarCorreo.setBackground(new java.awt.Color(0, 27, 134));
        btnagregarCorreo.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        btnagregarCorreo.setForeground(new java.awt.Color(255, 255, 255));
        btnagregarCorreo.setText("AGREGAR");
        btnagregarCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarCorreoActionPerformed(evt);
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
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cedula)
                            .addComponent(nombre)
                            .addComponent(contacto)
                            .addComponent(dire, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addComponent(btnagregarTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnagregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(dire, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnagregarTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/imprimir.png"))); // NOI18N
        lblImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImprimirMouseClicked(evt);
            }
        });

        lblInactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/personaInactiva.png"))); // NOI18N
        lblInactivar.setToolTipText("");
        lblInactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInactivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInactivarMouseClicked(evt);
            }
        });

        lblActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/actualizar.png"))); // NOI18N
        lblActualizar.setText("ACTUALIZAR");
        lblActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActualizarMouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 99, 50)));
        jPanel3.setOpaque(false);

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 27, 134));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ACTUALIZAR PROVEEDOR");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(134, 134, 134)
                .addComponent(lblCerrar)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(lblActualizar)
                .addGap(80, 80, 80)
                .addComponent(lblInactivar)
                .addGap(98, 98, 98)
                .addComponent(lblImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImprimir)
                    .addComponent(lblInactivar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblActualizar))))
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
    public void LlenarDatos(ListarJoinProveedor pro, ArrayList<Telefono> telf,
            ArrayList<Correo> cor, ArrayList<Direccion> dir) {
        fecha_registro = pro.getFecha_registro();
        fecha.setText(Fecha.getStringFecha(pro.getFecha_registro()));
        if (String.valueOf(pro.getCedula_ruc()).length() <= 9) {
            cedula.setText("0" + String.valueOf(pro.getCedula_ruc()));
        } else {
            cedula.setText(String.valueOf(pro.getCedula_ruc()));
        }
        System.out.println(pro.getDireccion());
        dire.setText(pro.getDireccion());
        nombre.setText(pro.getEntidad());
        contacto.setText(pro.getRepresentante());
        for (int i = 0; i < telefonos.size(); i++) {
            if (pro.getCedula_ruc().equals(telefonos.get(i).getCedula_ruc())) {
                switch (telefonos.get(i).getId_tipo_telefono()) {
                    case 1:
                        cbx1.addItem(telefonos.get(i).getTelefono() + " " + "INSTITUCIONAL");
                        break;
                    case 2:
                        cbx1.addItem(telefonos.get(i).getTelefono() + " " + "PERSONAL");
                        break;
                    case 3:
                        cbx1.addItem(telefonos.get(i).getTelefono() + " " + "OTRO");
                }
            }
        }
        for (int i = 0; i < correos.size(); i++) {
            if (pro.getCedula_ruc().equals(correos.get(i).getCedula_ruc())) {
                switch (correos.get(i).getId_tipo_correo()) {
                    case 1:
                        cbx2.addItem(correos.get(i).getCorreo() + " " + "INSTITUCIONAL");
                        break;
                    case 2:
                        cbx2.addItem(correos.get(i).getCorreo() + " " + "PERSONAL");
                        break;
                    case 3:
                        cbx2.addItem(correos.get(i).getCorreo() + " " + "OTRO");
                }
            }
        }

        cbx1.setSelectedItem(pro.getTelefono());
        cbx2.setSelectedItem(pro.getMail());
        tip1=pro.getId_proveedor_clase();
        tip2=pro.getEstado();
        tip3=pro.getId_proveedor();
        getPicture2(pro.getDireccionImagen());     
        System.out.println(pro.getDireccionImagen());
    }

    private void btnagregarTelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarTelfActionPerformed
        ArrayList<Obcx> lista = new ArrayList();
        Ingresar_Telefono ic = new Ingresar_Telefono(new javax.swing.JFrame(), true, cedula.getText());
        ic.setVisible(true);
        if (ic.getTelefono() != null) {
            cbx1.addItem(ic.getTelefono() + " " + ic.getTexto());
            Obcx pol = new Obcx(ic.getTelefono(), ic.getTipo());
            lista.add(pol);
            listat = lista;
            crud.insertarTelefono(lista,cedula.getText());
            //System.out.println(lista.get(0).getTcd() + " " + lista.get(0).getTipos());

        }
    }//GEN-LAST:event_btnagregarTelfActionPerformed

///    public String editarProveedor() {
//        String mensaje = null;
//
//        try {
//            coneccion = conectar.Conexion("farmacia");
//            coneccion.setAutoCommit(false);
//            CallableStatement prcProcedimientoAlmacenado = coneccion.prepareCall(""
//                    + "{ call insertarProveedor(?,?,?,?) }");
//            prcProcedimientoAlmacenado.setInt(1, Integer.valueOf(cedula.getText()));
//            prcProcedimientoAlmacenado.setString(2, nombre.getText());
//            prcProcedimientoAlmacenado.setString(3, contacto.getText());
//            prcProcedimientoAlmacenado.registerOutParameter("mst", Types.VARCHAR);
//            prcProcedimientoAlmacenado.executeUpdate();
//            mensaje = prcProcedimientoAlmacenado.getString("mst");
//            coneccion.commit();
//
//        } catch (SQLException ex) {
//            try {
//                coneccion.rollback();
//
//            } catch (SQLException ex1) {
//                Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            coneccion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return mensaje;
//
//    }
    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed

    }//GEN-LAST:event_fechaActionPerformed

    private void btnagregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarCorreoActionPerformed
        ArrayList<Obcx> lista = new ArrayList();
        Ingresar_Correo ic = new Ingresar_Correo(new javax.swing.JFrame(), true, cedula.getText());
        ic.setVisible(true);
        if (ic.getTelefono() != " ") {
            cbx2.addItem(ic.getTelefono() + " " + ic.getTexto());
            Obcx pol = new Obcx(ic.getTelefono(), ic.getTipo());
            lista.add(pol);
            listac = lista;
            crud.insertarCorreoCliente(lista,cedula.getText());
            // System.out.println(lista.get(0).getTcd() + " " + lista.get(0).getTipos());
        }
    }//GEN-LAST:event_btnagregarCorreoActionPerformed

    private void cbx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx1ActionPerformed
        String x= cbx1.getSelectedItem().toString();
        System.out.println(x);
    }//GEN-LAST:event_cbx1ActionPerformed

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        char car = evt.getKeyChar();
        if (cedula.getText().length() >= 10) {
            evt.consume();
            Habilitar(true);
        } else {
            Habilitar(false);
        }
        if (car < '0' || car > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_cedulaKeyTyped
    public int Confirmacion(String msx) {
        int select = JOptionPane.showConfirmDialog(null, msx, "Confirmar", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);

        System.out.println(select);
        return select;
    }
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

    private void nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusLost
        nombre.setText(nombre.getText().toUpperCase());
    }//GEN-LAST:event_nombreFocusLost

    private void contactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactoFocusLost
        contacto.setText(contacto.getText().toUpperCase());
    }//GEN-LAST:event_contactoFocusLost

    private void direFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_direFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String pass = "";
        getPicture1(pass);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        VaciarImagen();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        Consulta_Proveedor cp = new Consulta_Proveedor(new javax.swing.JFrame(),true);   
        setVisible(false);
        cp.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImprimirMouseClicked
        ArrayList proveedor = new ArrayList();        
        ProveedorRep proveedor1 = new ProveedorRep(cedula.getText(),nombre.getText(),contacto.getText(),dire.getText(),fecha.getText(),cbx1.getSelectedItem().toString(),cbx2.getSelectedItem().toString(),rutaimagen);
        proveedor.add(proveedor1);
        try {
//            String dir = System.getProperty("user.dir")+"/Reportes/"+"";
//            JasperReport reporte =  (JasperReport) JRLoader.loadObject(dir);   
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("Editar_Proveedor.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null, new JRBeanCollectionDataSource(proveedor));
            JDialog frame = new JDialog(this);
            JRViewer viewer = new JRViewer(jprint);
            frame.add(viewer);
            frame.setSize(new Dimension(ancho/2,alto/2));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            viewer.setFitWidthZoomRatio();
        } catch (JRException ex) {
            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblImprimirMouseClicked

    private void lblInactivarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivarMouseClicked
        int h = Confirmacion("Deseas Eliminar el proveedor con Cedula/Ruc : "
                + cedula.getText() + " y Nombre : " + nombre.getText());
        if (h == 0) {
            String sol = crud.eliminarProveedor(Long.valueOf("1"),tip3);
            JOptionPane.showMessageDialog(null, sol);
            Consulta_Proveedor mp = new Consulta_Proveedor(new javax.swing.JFrame(), true);
            setVisible(false);
            mp.setVisible(true);

        }
    }//GEN-LAST:event_lblInactivarMouseClicked

    private void lblActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarMouseClicked
        int h = Confirmacion("Deseas Actualizar el proveedor con Cedula/Ruc : "
                + cedula.getText() + " y Nombre : " + nombre.getText());
        if (h == 0){
           // ArrayList<ListarJoinProveedor> lista=;
            ListarJoinProveedor p = new ListarJoinProveedor();            
            p.setId_proveedor_clase(tip1);
            p.setCedula_ruc(cedula.getText());
            p.setEntidad(nombre.getText());
            p.setRepresentante(contacto.getText());
            p.setDireccion(dire.getText());
            System.out.println(fecha_registro);
            p.setFecha_registro(fecha_registro);
            p.setEstado(tip2);
            p.setTelefono(cbx1.getSelectedItem().toString());
            if(cbx2.getSelectedIndex() >= 1){
            p.setMail(cbx2.getSelectedItem().toString());
            }
            p.setId_proveedor(tip3);
            p.setDireccionImagen(rutaimagen);
            String valor = crud.insertarProveedor(p);
            JOptionPane.showMessageDialog(null, valor);
            Consulta_Proveedor mp = new Consulta_Proveedor(new javax.swing.JFrame(), true);
            setVisible(false);
            mp.setVisible(true);

        }
    }//GEN-LAST:event_lblActualizarMouseClicked
//    public String eliminarEditor(String por) {
//        String mensaje = null;
//     //   int por1 = Integer.valueOf(por);
//        try {
//            coneccion = conectar.Conexion("farmacia");
//            coneccion.setAutoCommit(false);
//            CallableStatement prcProcedimientoAlmacenado = coneccion.prepareCall(""
//                    + "{ call eliminarProveedor(?,?) }");
//            prcProcedimientoAlmacenado.setString(1, cedula.getText());
//            prcProcedimientoAlmacenado.registerOutParameter("mst", Types.VARCHAR);
//            prcProcedimientoAlmacenado.executeUpdate();
//            mensaje = prcProcedimientoAlmacenado.getString("mst");
//            coneccion.commit();
//
//        } catch (SQLException ex) {
//            try {
//                coneccion.rollback();
//
//            } catch (SQLException ex1) {
//                Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            coneccion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return mensaje;
//
//    }
    public void VaciarImagen() {
        // String fil = "\\G:\\sin-imagen.png";
        //   String  fil= "\\home\\ineval\\Escritorio\\P-FARMACIA\\sin-imagen.png"; //Windows
         fot = "logologin.png";
        imagen.setIcon(new ImageIcon(fot));
        ImageIcon icon = new ImageIcon(fot);
        Image img = icon.getImage();
        System.out.println(fot + " Foto " + imagen.getWidth() + " " + imagen.getHeight());
        Image newimg = img.getScaledInstance(148,147, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcono = new ImageIcon(newimg);
        imagen.setIcon(newIcono);
        rutaimagen = fot;
    }
    
    private void getPicture1(String path) {
        JFileChooser dig = new JFileChooser(path);
        dig.setFileFilter(new FileNameExtensionFilter("Archivos de imagen",
                "tif", "jpg", "jpeg", "png", "gif"));
        int opcion = dig.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            fot = dig.getSelectedFile().getPath();
            rutaimagen = dig.getSelectedFile().getPath();
            imagen.setIcon(new ImageIcon(fot));
            ImageIcon icon = new ImageIcon(fot);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(148,147, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcono = new ImageIcon(newimg);
            imagen.setIcon(newIcono);            
            System.out.println(fot + " Foto " + imagen.getWidth() + " " + imagen.getHeight());
            System.out.println("ruta= "+rutaimagen +"\n"+
                                "ruta2 "+fot);
        }
    }

        private void getPicture2(String path) {
        //JFileChooser dig = new JFileChooser(path);
        //dig.setFileFilter(new FileNameExtensionFilter("Archivos de imagen",
              //  "tif", "jpg", "jpeg", "png", "gif"));
        //int opcion = dig.showOpenDialog(this);
        //if (opcion == JFileChooser.APPROVE_OPTION) {
            //fot = dig.getSelectedFile().getPath();
            //rutaimagen = dig.getSelectedFile().getPath();
            rutaimagen = path;
            imagen.setIcon(new ImageIcon(path));
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(110,106, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcono = new ImageIcon(newimg);
            imagen.setIcon(newIcono);            
            System.out.println(fot + " Foto " + imagen.getWidth() + " " + imagen.getHeight());
            System.out.println("ruta= "+rutaimagen +"\n"+
                                "ruta2 "+fot);
        }
    
    public void vaciarimagen(){
        fot = "logologin.png";
        imagen.setIcon(new ImageIcon(fot));
        ImageIcon icon = new ImageIcon(fot);
        Image img = icon.getImage();
        System.out.println(fil + " Foto " + imagen.getWidth() + " " + imagen.getHeight());
        Image newimg = img.getScaledInstance(259, 221, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcono = new ImageIcon(newimg);
        imagen.setIcon(newIcono);
        rutaimagen = fot;
    }          
    public void Habilitar(boolean lok) {
        btnagregarTelf.setEnabled(lok);
        btnagregarCorreo.setEnabled(lok);
        dire.setEnabled(lok);
        //cedula.setEnabled(lok);
        nombre.setEnabled(lok);
        contacto.setEnabled(lok);
        lblActualizar.setEnabled(lok);
    }

    public void fe() {
        Calendario1 jh = new Calendario1(new javax.swing.JFrame(), true);
        //jh.setVisible(true);
        fecha_registro = jh.getFecha_nacimiento();
        int com = Fecha.comparacionFecha(fecha_registro, (Date) Fecha.FechaSql());
        if (com == 1 || com == 0) {
            fecha.setText(Fecha.getStringFecha(fecha_registro));
        } else {
            JOptionPane.showMessageDialog(null, "Fecha Invalida!!");
            fecha_registro = null;
            fecha.setText("");
        }
    }

//    public String insertarProveedor() {
//        String mensaje = null;
//
//        try {
//            coneccion = conectar.Conexion("farmacia");
//            coneccion.setAutoCommit(false);
//            CallableStatement prcProcedimientoAlmacenado = coneccion.prepareCall(""
//                    + "{ call editarProveedor(?,?,?,?,?,?,?) }");
//            prcProcedimientoAlmacenado.setString(1, cedula.getText());
//            prcProcedimientoAlmacenado.setString(2, nombre.getText());
//            prcProcedimientoAlmacenado.setString(3, contacto.getText());
//            prcProcedimientoAlmacenado.setString(4, dire.getText());
//            prcProcedimientoAlmacenado.setString(5, cbx1.getSelectedItem().toString());
//            prcProcedimientoAlmacenado.setString(6, cbx2.getSelectedItem().toString());
//            prcProcedimientoAlmacenado.registerOutParameter("mst", Types.VARCHAR);
//            prcProcedimientoAlmacenado.executeUpdate();
//            mensaje = prcProcedimientoAlmacenado.getString("mst");
//            coneccion.commit();
//
//        } catch (SQLException ex) {
//            try {
//                coneccion.rollback();
//
//            } catch (SQLException ex1) {
//                Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            coneccion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Editar_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return mensaje;
//
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
            java.util.logging.Logger.getLogger(Editar_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Editar_Proveedor dialog = new Editar_Proveedor(new javax.swing.JFrame(), true, proveedor);
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
    private javax.swing.JButton btnagregarCorreo;
    private javax.swing.JButton btnagregarTelf;
    private javax.swing.JComboBox<String> cbx1;
    private javax.swing.JComboBox<String> cbx2;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField contacto;
    private javax.swing.JTextField dire;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblImprimir;
    private javax.swing.JLabel lblInactivar;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int ICONIFIED) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
