/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.views.precios;

//import com.farmacia.dao.Conectar;
//import com.farmacia.dao.ConsultasSQL;
//import com.farmacia.domain.Telefono_Cliente;
//import com.farmacia.validaciones.Validaciones;
//import com.objetos.views.clientes.*;
//import com.farmacia.validaciones.Validacion;
//import com.objetos.dao.CRUD;
//import com.objetos.dao.Consultas;
//import com.objetos.entities.Precios;
//import com.objetos.entities.Telefono_Cliente;
import com.farmacia.conponentes.Formato_Numeros;
import com.farmacia.dao.CRUD;
import com.farmacia.dao.Consultas;
import com.farmacia.entities1.Precios;
import com.farmacia.views.compras.OrdenCompra;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author guest-v52snc
 */
public class modificar_precio_producto extends javax.swing.JDialog {

    int x, y;
    
    private Double precio;
    private Double precioCompra;
    private Double precioVenta;
    private Long id_precio;
    String FechaActual,presentacion;
    public String[] verificar = new String[10];
    CRUD crud = new CRUD();
    static Long id_producto;
    public ArrayList<Precios> lista_t = null;
    Consultas llamar = new Consultas();
    Precios objeto=null;
    Date date = new Date();
    int Unidades = 0;
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Precios precios = null;
    String query=("SELECT id_precio,`id_producto`,`precio_base`,`precio_compra`, `compra_unidad`,`precio_venta`,`venta_unidad`, estado,porcentaje,`descuentoVenta`  FROM `precios` WHERE `id_producto`= " + id_producto);
    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public modificar_precio_producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
         txtprociento.setVisible(false);
    }   
    public modificar_precio_producto(java.awt.Frame parent, boolean modal, Long id, Precios pr1) {
        
        super(parent, modal);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        txtprociento.setVisible(false);
        // Habilitar(false);
        id_producto = id;
        //this.presentacion=crud.BuscarPresentacion(id_producto);
        Unidades=Integer.parseInt(crud.BuscarUnidadesProducto(id_producto)) ;
        if(Unidades>1){
            txt_venta_unidad.setEnabled(true);
            txtcomprUni.setEnabled(true);
        }else{
            txt_venta_unidad.setEnabled(false);
            txtcomprUni.setEnabled(false);
        }
        //System.out.println(presentacion);
        //JOptionPane.showMessageDialog(this, presentacion);
        precios = pr1;
        lista_t = llamar.listarPrecioCompra(query);
        for (int i = 0; i < lista_t.size(); i++) {
            System.out.println(223 + " hol" + id_producto + " " + lista_t.get(i).getPrecio_compra());
        }
        
         preciobase.setText(pr1.getPrecio_base().toString());
    nuevo1.setText(pr1.getPrecio_compra().toString());
    if(pr1.getCompra_unidad()== null){
    txtcomprUni.setText("0");
        System.out.println("compra unidad. no obtuvo valor");    
    }  else{
        txtcomprUni.setText(precios.getCompra_unidad().toString());
    System.out.println("compra unidad: " + pr1.getCompra_unidad().toString());        
    }
    
    
    nuevo2.setText(pr1.getPrecio_venta().toString());
    txtDescVent.setText(pr1.getDescuentoVenta().toString());
  // txtprociento.setText(precios.getPorcentaje().toString());25112020 ccevallos
    txt_venta_unidad.setText(""+pr1.getVenta_unidad());

        
       // nuevo2.setEditable(false);
   
    }
    public void llenarPrecios(){
    preciobase.setText(precios.getPrecio_base().toString());
    nuevo1.setText(precios.getPrecio_compra().toString());
    nuevo2.setText(precios.getPrecio_venta().toString());
    txtDescVent.setText(precios.getDescuentoVenta().toString());
  // txtprociento.setText(precios.getPorcentaje().toString());25112020 ccevallos
    txt_venta_unidad.setText(""+precios.getVenta_unidad());
    System.out.println("compra unidad"+ precios.getCompra_unidad().toString());
    //txtcomprUni.setText(precios.getCompra_unidad().toString());
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
        nuevo1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nuevo2 = new javax.swing.JTextField();
        txtprociento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        preciobase = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescVent = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        txt_venta_unidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcomprUni = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 99, 50), 2, true));
        jPanel1.setOpaque(false);

        nuevo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nuevo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        nuevo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nuevo1FocusLost(evt);
            }
        });
        nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo1ActionPerformed(evt);
            }
        });
        nuevo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevo1KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setText("PRECIO COMPRA:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setText("PRECIO VENTA:");

        nuevo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nuevo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        nuevo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nuevo2FocusLost(evt);
            }
        });
        nuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo2ActionPerformed(evt);
            }
        });
        nuevo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nuevo2KeyTyped(evt);
            }
        });

        txtprociento.setEditable(false);
        txtprociento.setText("0");
        txtprociento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtprociento.setEnabled(false);
        txtprociento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprocientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprocientoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 27, 134));
        jLabel11.setText("PRECIO BASE:");

        preciobase.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        preciobase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        preciobase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciobaseActionPerformed(evt);
            }
        });
        preciobase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                preciobaseKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preciobaseKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 134));
        jLabel5.setText("DESC. VENTA:");

        txtDescVent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescVent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtDescVent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescVentFocusLost(evt);
            }
        });
        txtDescVent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescVentActionPerformed(evt);
            }
        });
        txtDescVent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescVentKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(50, 99, 50)));
        jPanel2.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANTENIMIENTO DE PRECIOS");
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(530, 230));
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
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
                .addGap(35, 35, 35)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCerrar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCerrar)
                .addContainerGap())
        );

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });

        txt_venta_unidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_venta_unidad.setText("0");
        txt_venta_unidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txt_venta_unidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_venta_unidadFocusLost(evt);
            }
        });
        txt_venta_unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_unidadActionPerformed(evt);
            }
        });
        txt_venta_unidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_venta_unidadKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 27, 134));
        jLabel6.setText("VENTA UNIDAD:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("COMPRA UNDAD:");

        txtcomprUni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcomprUni.setText("0");
        txtcomprUni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtcomprUni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcomprUniFocusLost(evt);
            }
        });
        txtcomprUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcomprUniActionPerformed(evt);
            }
        });
        txtcomprUni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcomprUniKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_venta_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuardar)
                    .addComponent(txtDescVent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(preciobase))
                        .addGap(65, 65, 65)
                        .addComponent(txtprociento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcomprUni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preciobase, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprociento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcomprUni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescVent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblGuardar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevo1KeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && nuevo1.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_nuevo1KeyTyped
    public void Habilitar(boolean lock) {
        lblGuardar.setEnabled(lock);
        // cbx1.setEnabled(lock);
        

    }    public boolean Validar() {
        boolean pos = false;
        //lista_t = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_base`,`precio_compra`,`precio_venta`,`venta_unidad`, estado,`descuentoVenta`  FROM `precios` WHERE `id_producto`= " + id_producto);
       lista_t = llamar.listarPrecioCompra("SELECT id_precio,`id_producto`,`precio_base`,`precio_compra`, `compra_unidad`,`precio_venta`,`venta_unidad`, estado,porcentaje,`descuentoVenta`  FROM `precios` WHERE `id_producto`= " + id_producto);
        // System.out.println(id_producto + " " + lista_t.get(0).getId_producto());
        for (int i = 0; i < lista_t.size(); i++) {
            // System.out.println(223 + " hol"+id_producto +" " +lista_t.get(i).getPrecio_compra());
            if (id_producto.equals(lista_t.get(i).getId_producto())) {
                //    System.out.println(33 + " "+id_producto +" " +lista_t.get(i).getPrecio_compra());
                // for (int j = 0; j < lista_t.size(); j++) {
                Double PrecioCompra = Double.valueOf(nuevo1.getText());
                Double PrecioVenta = Double.valueOf(nuevo2.getText());

                if (Objects.equals(lista_t.get(i).getPrecio_compra(), PrecioCompra)) {
                    int h = Confirmacion("Deseas Mantener el Precio Compra de "+nuevo1.getText()+" ?");
                    if(h==0){
                    pos = false;
                    }else{pos = true;}
                    
                }
                if (Objects.equals(lista_t.get(i).getPrecio_venta(), PrecioVenta)) {
                    int h = Confirmacion("Deseas Mantener el Precio Venta "+nuevo2.getText()+"?");
                    if(h==0){
                    pos = false;
                    }else{pos = true;}
//                    pos = true;
//                    return pos;

                }

            }
        }
        return pos;
    }
    public int Confirmacion(String msx) {
        int select = JOptionPane.showConfirmDialog(null, msx, "Confirmar", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
        System.out.println(select);
        return select;
    }

    private void nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo1ActionPerformed

    }//GEN-LAST:event_nuevo1ActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        x = evt.getX();
        y = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseDragged

    private void nuevo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nuevo1FocusLost


    }//GEN-LAST:event_nuevo1FocusLost

    private void nuevo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nuevo2FocusLost
        //  Thread.sleep(5*1000);
        boolean valor = validarPrecios();
        if (valor == true) {
            //  BotonGuardar.setEnabled(true);
        }
    }//GEN-LAST:event_nuevo2FocusLost
    public boolean validarPrecios() {
        boolean valor = false;
        Double comboA = Double.valueOf(nuevo1.getText());
        Double comboB = Double.valueOf(nuevo2.getText());
        if (comboA > comboB) {
            JOptionPane.showMessageDialog(this, "el precio de venta debe ser mayor al de compras");
            return valor;
        }

        return valor = true;
    }
    private void nuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo2ActionPerformed

    }//GEN-LAST:event_nuevo2ActionPerformed

    private void nuevo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevo2KeyTyped
          if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && nuevo2.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_nuevo2KeyTyped

    private void txtprocientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprocientoKeyTyped
       char car = evt.getKeyChar();
       if (txtprociento.getText().length() >= 3) {
            evt.consume();
        }
        if (car < '0' || car > '9') {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtprocientoKeyTyped

    private void txtprocientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprocientoKeyReleased
        try{
        double procentaje=(Double.parseDouble(txtprociento.getText())/100);
        System.out.println(procentaje);
        double valor1 = Double.parseDouble(nuevo1.getText())*procentaje;
            System.out.println(valor1);
        double suma = Double.parseDouble(nuevo1.getText())+valor1;
            System.out.println("suma: "+suma);
            String result= Formato_Numeros.formatoNumero(String.valueOf(suma));
            nuevo2.setText(result.replace(',', '.'));
        }catch(Exception e){
        }
    }//GEN-LAST:event_txtprocientoKeyReleased

    private void preciobaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciobaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preciobaseActionPerformed

    private void preciobaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciobaseKeyReleased
//        int largor = txtDescuentoVenta.getText().length();
//        if (largor > 2) {
//            if (Integer.parseInt(txtDescuentoVenta.getText()) == 100) {
//                CADENA = txtDescuentoVenta.getText();
//                txtDescuentoVenta.setText(CADENA);
//            } else {
//                CADENA = txtDescuentoVenta.getText().substring(0, 2);
//                txtDescuentoVenta.setText(CADENA);
//                JOptionPane.showMessageDialog(null, "INGRESE VALOR CORRECTO");
//            }
//        }
    }//GEN-LAST:event_preciobaseKeyReleased

    private void preciobaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciobaseKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && preciobase.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_preciobaseKeyTyped

    private void txtDescVentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescVentFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescVentFocusLost

    private void txtDescVentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescVentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescVentActionPerformed

    private void txtDescVentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescVentKeyTyped
//       char c = evt.getKeyChar();
//        if (!Character.isDigit(c) || Character.isSpaceChar(c)) {
//            getToolkit().beep();
//            evt.consume();
//        }
if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtDescVent.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescVentKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        boolean pos = Validar();
        boolean var = false;
        String valor = null;
        if (pos == false) {
            Double Compra = precios.getPrecio_compra();
            Double Venta = precios.getPrecio_venta();
            Double PrecioFar = Double.valueOf(preciobase.getText());
            Double PrecioCompra = Double.valueOf(nuevo1.getText());
            Double PrecioVenta = Double.valueOf(nuevo2.getText());
            Double VentaUnidad = Double.valueOf(txt_venta_unidad.getText());
            Double CompraUnidad = Double.valueOf(txtcomprUni.getText());
            int desVent=Integer.valueOf(txtDescVent.getText());
            int porcent=Integer.valueOf(txtprociento.getText());
            valor = crud.actualizarPrecioProductos("UPDATE precios SET `precio_base`= "+PrecioFar+",`precio_compra`= " + PrecioCompra + ", `compra_unidad`= " + CompraUnidad + ",`precio_venta`= " + PrecioVenta + ",`venta_unidad`= "+VentaUnidad+",`porcentaje`= "+porcent+",`descuentoVenta`="+desVent+" WHERE `id_producto`= " + id_producto + " AND `id_precio`= " + precios.getId_precio() + " AND `precio_compra`= " + Compra + " AND `precio_venta`= " + Venta);
            JOptionPane.showMessageDialog(this, valor);
            setVisible(false);

        }
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void txt_venta_unidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_venta_unidadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_unidadFocusLost

    private void txt_venta_unidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_unidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_unidadActionPerformed

    private void txt_venta_unidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_venta_unidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_unidadKeyTyped

    private void txtcomprUniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcomprUniFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprUniFocusLost

    private void txtcomprUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcomprUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprUniActionPerformed

    private void txtcomprUniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcomprUniKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprUniKeyTyped
     
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
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
            java.util.logging.Logger.getLogger(modificar_precio_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificar_precio_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificar_precio_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificar_precio_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
     
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                modificar_precio_producto dialog = new modificar_precio_producto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JTextField nuevo1;
    private javax.swing.JTextField nuevo2;
    public static javax.swing.JTextField preciobase;
    private javax.swing.JTextField txtDescVent;
    private javax.swing.JTextField txt_venta_unidad;
    private javax.swing.JTextField txtcomprUni;
    private javax.swing.JTextField txtprociento;
    // End of variables declaration//GEN-END:variables
}
