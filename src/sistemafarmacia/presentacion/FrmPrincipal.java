package sistemafarmacia.presentacion;

import com.farmacia.entities1.Listar_usuario;
import com.farmacia.view.principal.Envases;
import com.farmacia.view.principal.Tipo_Producto;
import com.farmacia.views.clientes.Consulta_Clientes;
import com.farmacia.views.laboratorio.Consulta_Lab;
import com.farmacia.views.marca.ConsultaMarcas;
import com.farmacia.views.medida.ConsultaMedidas;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import sistemafarmacia.Fondo;
import sistemafarmacia.VariablesFunciones;
import com.farmacia.entities1.Usuario;
import com.farmacia.view.excel.subirExcelBD;
import com.farmacia.view.excel.subirExcelpRODUCTOS;
import com.farmacia.view.principal.Categoria;
import com.farmacia.views.Reportes.KardexReporte;

import com.farmacia.views.Reportes.Reporte_Compra;
import com.farmacia.views.Reportes.Reporte_Productos_Compras;
import com.farmacia.views.Reportes.Reporte_Venta;
import com.farmacia.views.ayuda.Acerca;
//import com.farmacia.views.ayuda.AcercaDe;
import com.farmacia.views.compras.CabeceraCompra;
import com.farmacia.views.compras.ListaCompras;
import com.farmacia.views.compras.ListaComprasDesactivadas;
import com.farmacia.views.compras.ListaDePedidos;
import com.farmacia.views.compras.VentanaComprasDesactivadas;
import com.farmacia.views.comprasRealizadas.ComprasEfectuadas;
import com.farmacia.views.contentPane.ContentPanel;
import com.farmacia.views.covertidor.Convertidor_lista_Productos;
import com.farmacia.views.devoluciones.ComprasDevueltas;
import com.farmacia.views.ingresoRapido.ingresoRapido;
import com.farmacia.views.iva.Mostrar_iva;
import com.farmacia.views.pedidos.MantenimientoNotaPedidos;
import com.farmacia.views.pedidos.NotePedidos;

import com.farmacia.views.producto.MantenimientoProducto;
import com.farmacia.views.producto.Products;
import com.farmacia.views.proveedor.Consulta_Proveedor;
import com.farmacia.views.stock.Kardex_Productos;
import com.farmacia.views.stock.Stock_Productos;
import com.farmacia.views.usuario.Local;
import com.farmacia.views.usuario.Mostrar_usuario;
import com.farmacia.views.ventas.ListarVentas;
import com.farmacia.views.ventas.MenuPreVentas;
import com.farmacia.views.ventas.ventasEliminadas;
import java.awt.Color;
import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {

    ContentPanel fondo = new ContentPanel();
    private static final String TITLE = "Principal";
    VariablesFunciones variables = new VariablesFunciones();
    Listar_usuario objUsuario = null;
//    private static Usuario usuarioSession;

//    public static Usuario getUsuarioSession() {
//        return usuarioSession;
//    }
//    public FrmPrincipal() {
//        //initComponents();
//    }
    public FrmPrincipal(Listar_usuario obj2, String tipo) {
        setContentPane(fondo);
        initComponents();
        if ("ADMINISTRADOR".equals(tipo)) {
        } else {
            if ("VENDEDOR".equals(tipo)) {
                menuProducto.setVisible(false);
                jmLocal.setVisible(false);
                jmCompras.setVisible(false);
                jmReporteCompra.setVisible(false);
                mnEliminadas.setVisible(false);
                lblIngresoRapido.setVisible(false);
                lblEmpleados.setVisible(false);
                lblProveedores.setVisible(false);
                mnuExcel.setVisible(false);
            }
            if ("BODEGUERO".equals(tipo)) {
                jmLocal.setVisible(false);
                jmVenta.setVisible(false);
                jmIva.setVisible(false);
                jmVentaReporte.setVisible(false);
                lblEmpleados.setVisible(false);
                lblProveedores.setVisible(false);
                mnEliminadas.setVisible(false);
            }
            if ("SUPERVISOR".equals(tipo)) {
                jmLocal.setVisible(false);
                jmIva.setVisible(false);
            }
            if ("ENCARGADO".equals(tipo)) {
                lblEmpleados.setVisible(false);
                mnEliminadas.setVisible(false);
                jmLocal.setVisible(false);
                jmIva.setVisible(false);
                lblProveedores.setVisible(false);
            }
        }
        this.setTitle(variables.getTitle() + TITLE + "  " + obj2.getCargo() + ": " + obj2.getNombres() + "  " + obj2.getApellidos());
        this.setLocationRelativeTo(null);
//        this.setExtendedState(this.MAXIMIZED_BOTH);
//        this.setIconImage(variables.getIconoVentana());
//        pnlBanner.setBackground(variables.getColor());
//        pnlPie.setBackground(variables.getColor());
//        this.add(new Fondo(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height), BorderLayout.CENTER);
//        usuarioSession = usuario;
//        lblNombreUsuario.setText(usuario.getPersona().getNombres() + " " + usuario.getPersona().getApellidos());
//        lblPrivilegio.setText(usuario.getPerfil());
        objUsuario = obj2;
        lblNombreUsuario.setText(obj2.getNombres() + " " + obj2.getApellidos());
        lblPrivilegio.setText(" " + obj2.getCargo());
    }

    private FrmPrincipal() {
        setContentPane(fondo);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        pnlPie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblPrivilegio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlBanner = new javax.swing.JPanel();
        lblProductos = new javax.swing.JLabel();
        lblIngresoRapido = new javax.swing.JLabel();
        lblGenerarVenta = new javax.swing.JLabel();
        lblEmpleados = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblProveedores = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProducto = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuLaboratorio = new javax.swing.JMenuItem();
        jmIva = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmLocal = new javax.swing.JMenu();
        jmLocal2 = new javax.swing.JMenuItem();
        jmEmpleados = new javax.swing.JMenuItem();
        jmVenta = new javax.swing.JMenu();
        mnuRegistrarVenta = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenuItem();
        jMnuListVentas = new javax.swing.JMenuItem();
        mnEliminadas = new javax.swing.JMenuItem();
        jmCompras = new javax.swing.JMenu();
        mnuRegistrarVenta1 = new javax.swing.JMenuItem();
        mnuCliente1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnuMantCompra = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmReporteCompra = new javax.swing.JMenuItem();
        jmVentaReporte = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuExcel = new javax.swing.JMenu();
        mnuAcerca1 = new javax.swing.JMenuItem();
        mnuAcerca2 = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAcerca = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlPie.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(50, 99, 50)));
        pnlPie.setForeground(new java.awt.Color(0, 27, 134));
        pnlPie.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 134));
        jLabel1.setText("Usuario:");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(55, 99, 55));
        lblNombreUsuario.setText("Nombre Completo de Usuario");

        lblPrivilegio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrivilegio.setForeground(new java.awt.Color(55, 99, 55));
        lblPrivilegio.setText("Administrador");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 134));
        jLabel4.setText("Privilegio:");

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrivilegio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPieLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblPrivilegio))
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblNombreUsuario)))
                .addContainerGap())
        );

        pnlBanner.setOpaque(false);

        lblProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Productos.png"))); // NOI18N
        lblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProductosMouseClicked(evt);
            }
        });

        lblIngresoRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/ingreso.png"))); // NOI18N
        lblIngresoRapido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIngresoRapido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIngresoRapidoMouseClicked(evt);
            }
        });

        lblGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Generar.png"))); // NOI18N
        lblGenerarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGenerarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenerarVentaMouseClicked(evt);
            }
        });

        lblEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Empleados.png"))); // NOI18N
        lblEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmpleadosMouseClicked(evt);
            }
        });

        lblClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Clientes.png"))); // NOI18N
        lblClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClientesMouseClicked(evt);
            }
        });

        lblProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Proveedores.png"))); // NOI18N
        lblProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProveedoresMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBannerLayout = new javax.swing.GroupLayout(pnlBanner);
        pnlBanner.setLayout(pnlBannerLayout);
        pnlBannerLayout.setHorizontalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBannerLayout.createSequentialGroup()
                        .addComponent(lblProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(lblIngresoRapido)
                        .addGap(176, 176, 176)
                        .addComponent(lblGenerarVenta)
                        .addGap(53, 53, 53))
                    .addGroup(pnlBannerLayout.createSequentialGroup()
                        .addComponent(lblEmpleados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClientes)
                        .addGap(220, 220, 220)
                        .addComponent(lblProveedores)
                        .addGap(64, 64, 64))))
        );
        pnlBannerLayout.setVerticalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductos)
                    .addComponent(lblIngresoRapido)
                    .addComponent(lblGenerarVenta))
                .addGap(78, 78, 78)
                .addGroup(pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpleados)
                    .addComponent(lblProveedores)
                    .addComponent(lblClientes))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(55, 99, 55)));
        jMenuBar1.setOpaque(false);

        menuProducto.setText("PRODUCTOS");
        menuProducto.setToolTipText("");
        menuProducto.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        jMenu6.setText("COMPONENTES");
        jMenu6.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem2.setText("PRESENTACIONES");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem3.setText("TIPOS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem4.setText("MEDIDAS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem5.setText("CATEGORIAS");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        mnuLaboratorio.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuLaboratorio.setText("MARCAS/LABORATORIOS");
        mnuLaboratorio.setToolTipText("");
        mnuLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLaboratorioActionPerformed(evt);
            }
        });
        jMenu6.add(mnuLaboratorio);

        jmIva.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jmIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIvaActionPerformed(evt);
            }
        });
        jMenu6.add(jmIva);

        menuProducto.add(jMenu6);
        menuProducto.add(jSeparator2);

        jMenuItem7.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem7.setText("MANTENIMIENTO");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuProducto.add(jMenuItem7);

        jMenuBar1.add(menuProducto);

        jmLocal.setText("USUARIO");
        jmLocal.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jmLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLocalActionPerformed(evt);
            }
        });

        jmLocal2.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jmLocal2.setText("LOCAL");
        jmLocal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLocal2ActionPerformed(evt);
            }
        });
        jmLocal.add(jmLocal2);

        jmEmpleados.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jmEmpleados.setText("EMPLEADOS");
        jmEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEmpleadosActionPerformed(evt);
            }
        });
        jmLocal.add(jmEmpleados);

        jMenuBar1.add(jmLocal);

        jmVenta.setText("VENTAS");
        jmVenta.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        mnuRegistrarVenta.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuRegistrarVenta.setText("REGISTRAR VENTA");
        mnuRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarVentaActionPerformed(evt);
            }
        });
        jmVenta.add(mnuRegistrarVenta);

        mnuCliente.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuCliente.setText("CLIENTES");
        mnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClienteActionPerformed(evt);
            }
        });
        jmVenta.add(mnuCliente);

        jMnuListVentas.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMnuListVentas.setText("LISTA DE VENTAS");
        jMnuListVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuListVentasActionPerformed(evt);
            }
        });
        jmVenta.add(jMnuListVentas);

        mnEliminadas.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnEliminadas.setText("VENTAS ELIMINADAS");
        mnEliminadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEliminadasActionPerformed(evt);
            }
        });
        jmVenta.add(mnEliminadas);

        jMenuBar1.add(jmVenta);

        jmCompras.setText("COMPRAS");
        jmCompras.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        mnuRegistrarVenta1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuRegistrarVenta1.setText("REGISTRAR NOTA DE PEDIDO");
        mnuRegistrarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarVenta1ActionPerformed(evt);
            }
        });
        jmCompras.add(mnuRegistrarVenta1);

        mnuCliente1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuCliente1.setText("PROVEEDORES");
        mnuCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCliente1ActionPerformed(evt);
            }
        });
        jmCompras.add(mnuCliente1);

        jMenuItem8.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem8.setText("REGISTRAR COMPRA");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmCompras.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem9.setText("MANTENIMIENTO NOTA PEDIDO");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmCompras.add(jMenuItem9);

        mnuMantCompra.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuMantCompra.setText("MANTENIMIENTO COMPRA");
        mnuMantCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantCompraActionPerformed(evt);
            }
        });
        jmCompras.add(mnuMantCompra);

        jMenuBar1.add(jmCompras);

        jMenu1.setText("INVENTARIO");
        jMenu1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem13.setText("PRODUCTOS EN INVENTARIO");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuBar1.add(jMenu1);

        jMenu8.setText("REPORTES");
        jMenu8.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenu8.add(jSeparator3);

        jmReporteCompra.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jmReporteCompra.setText("COMPRAS");
        jmReporteCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReporteCompraActionPerformed(evt);
            }
        });
        jMenu8.add(jmReporteCompra);

        jmVentaReporte.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jmVentaReporte.setText("VENTAS");
        jmVentaReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVentaReporteActionPerformed(evt);
            }
        });
        jMenu8.add(jmVentaReporte);

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jMenuItem1.setText("INVENTARIO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenuBar1.add(jMenu8);

        mnuExcel.setText("EXCEL");
        mnuExcel.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        mnuAcerca1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuAcerca1.setText("SUBIR EXCEL PRODUCTOS / COMPRAS");
        mnuAcerca1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAcerca1MouseClicked(evt);
            }
        });
        mnuAcerca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcerca1ActionPerformed(evt);
            }
        });
        mnuExcel.add(mnuAcerca1);

        mnuAcerca2.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuAcerca2.setText("SUBIR EXCEL PRODUCTOS");
        mnuAcerca2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAcerca2MouseClicked(evt);
            }
        });
        mnuAcerca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcerca2ActionPerformed(evt);
            }
        });
        mnuExcel.add(mnuAcerca2);

        jMenuBar1.add(mnuExcel);

        mnuAyuda.setText("AYUDA");
        mnuAyuda.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        mnuAcerca.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        mnuAcerca.setText("ACERCA DE...");
        mnuAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAcercaMouseClicked(evt);
            }
        });
        mnuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcercaActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAcerca);

        jMenuItem6.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jMenuItem6.setText("SALIR");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuAyuda.add(jMenuItem6);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLaboratorioActionPerformed
        //Consulta_Lab cl = new Consulta_Lab(new javax.swing.JFrame(), true);
        //cl.setVisible(true);

        ConsultaMarcas cm = new ConsultaMarcas(new javax.swing.JFrame(), true);
        cm.setVisible(true);
//        Consulta_Lab cl = new Consulta_Lab(new javax.swing.JFrame(), true);
//        cl.setVisible(true);
    }//GEN-LAST:event_mnuLaboratorioActionPerformed

    private void mnuRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarVentaActionPerformed
        MenuPreVentas mp = new MenuPreVentas(new javax.swing.JFrame(), true, objUsuario);
        mp.setVisible(true);
//        MenuPreVentas mp = new MenuPreVentas(new javax.swing.JFrame(), true);
//        mp.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarVentaActionPerformed

    private void mnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClienteActionPerformed
        MenuPreVentas mp = new MenuPreVentas(new javax.swing.JFrame(), true);
        mp.setVisible(true);
//        Consulta_Clientes cl = new Consulta_Clientes(new javax.swing.JFrame(), true);
//        cl.setVisible(true);
    }//GEN-LAST:event_mnuClienteActionPerformed

    private void mnuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcercaActionPerformed
//        DlgAcerca acerca = new DlgAcerca(this, rootPaneCheckingEnabled);
//        acerca.setVisible(rootPaneCheckingEnabled);
        Acerca a = new Acerca();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_mnuAcercaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        Envases e = new Envases(new javax.swing.JFrame(), true);
//        e.setVisible(true);
        Envases e = new Envases(new javax.swing.JFrame(), true);
        e.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
//        Tipo_Producto t = new Tipo_Producto(new javax.swing.JFrame(), true);
//        t.setVisible(true);
        Categoria ca = new Categoria(new javax.swing.JFrame(), true);
        ca.setVisible(true);


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
//        ConsultaMarcas cmx = new ConsultaMarcas(new javax.swing.JFrame(), true);
//        cmx.setVisible(true);
        Tipo_Producto t = new Tipo_Producto(new javax.swing.JFrame(), true);
        t.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
//        ConsultaMedidas cm = new ConsultaMedidas(new javax.swing.JFrame(), true);
//        cm.setVisible(true);
        ConsultaMedidas cm = new ConsultaMedidas(new javax.swing.JFrame(), true);
        cm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        FrmLogin lo = new FrmLogin();
        lo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        MantenimientoProducto p1 = new MantenimientoProducto(new javax.swing.JFrame(), true, objUsuario);
        p1.setVisible(true);
//        MantenimientoProducto p1 = new MantenimientoProducto(new javax.swing.JFrame(), true, objUsuario);
//        p1.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void mnuRegistrarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarVenta1ActionPerformed
//        NotePedidos np = new NotePedidos(new javax.swing.JFrame(), true, objUsuario);
//        np.setVisible(true);
        NotePedidos np = new NotePedidos(new javax.swing.JFrame(), true, objUsuario);
        np.setVisible(true);
         //NotePedidos np = new NotePedidos(new javax.swing.JFrame(), true, objUsuario);
        //np.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarVenta1ActionPerformed

    private void mnuCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCliente1ActionPerformed
//        Consulta_Proveedor pro = new Consulta_Proveedor(new javax.swing.JFrame(), true);
//        pro.setVisible(true);
        Consulta_Proveedor pro = new Consulta_Proveedor(new javax.swing.JFrame(), true);
        pro.setVisible(true);
    }//GEN-LAST:event_mnuCliente1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
//        CabeceraCompra CB = new CabeceraCompra(new javax.swing.JFrame(), true, objUsuario);
//        CB.setVisible(true);
        CabeceraCompra CB = new CabeceraCompra(new javax.swing.JFrame(), true, objUsuario);
        CB.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
//        MantenimientoNotaPedidos mp = new MantenimientoNotaPedidos(new javax.swing.JFrame(), true, objUsuario);
//        mp.setVisible(true);
        MantenimientoNotaPedidos mp = new MantenimientoNotaPedidos(new javax.swing.JFrame(), true, objUsuario);
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jmIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIvaActionPerformed
//        Mostrar_iva MI = new Mostrar_iva(new javax.swing.JFrame(), true);
//        MI.setVisible(true);
        //Mostrar_iva MI = new Mostrar_iva(new javax.swing.JFrame(), true);
        //  MI.setVisible(true);
    }//GEN-LAST:event_jmIvaActionPerformed

    private void jmLocal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLocal2ActionPerformed
        Local lc = new Local(new javax.swing.JFrame(), true);
        lc.setVisible(true);
    }//GEN-LAST:event_jmLocal2ActionPerformed

    private void jmEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEmpleadosActionPerformed
        Mostrar_usuario mu = new Mostrar_usuario(new javax.swing.JFrame(), true);
        mu.setVisible(true);
    }//GEN-LAST:event_jmEmpleadosActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
//        Stock_Productos sp = new Stock_Productos(this, rootPaneCheckingEnabled);
//        sp.setVisible(rootPaneCheckingEnabled);
        Kardex_Productos sp = new Kardex_Productos(this, rootPaneCheckingEnabled, objUsuario);
        sp.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jmReporteCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReporteCompraActionPerformed
//        Reporte_Compra Rc = new Reporte_Compra(this, rootPaneCheckingEnabled);
//        Rc.setVisible(rootPaneCheckingEnabled);
        Reporte_Compra Rc = new Reporte_Compra(this, rootPaneCheckingEnabled);
        Rc.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmReporteCompraActionPerformed

    private void jmVentaReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVentaReporteActionPerformed
//        Reporte_Venta Rv = new Reporte_Venta(this, rootPaneCheckingEnabled);
//        Rv.setVisible(rootPaneCheckingEnabled);
        Reporte_Venta Rv = new Reporte_Venta(this, rootPaneCheckingEnabled);
        Rv.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmVentaReporteActionPerformed

    private void jMnuListVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuListVentasActionPerformed
        ListarVentas livt = new ListarVentas(objUsuario);
        livt.setVisible(true);
    }//GEN-LAST:event_jMnuListVentasActionPerformed

    private void jmLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLocalActionPerformed
//        if ("ADMINISTRADOR".equals(objUsuario.getCargo())) {
//            jmLocal2.setVisible(true);
//        } else {
//            jmLocal2.setVisible(false);
//        }
    }//GEN-LAST:event_jmLocalActionPerformed

    private void mnuAcercaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAcercaMouseClicked

    }//GEN-LAST:event_mnuAcercaMouseClicked

    private void mnuAcerca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcerca1ActionPerformed
        subirExcelBD seb = new subirExcelBD();
        seb.setVisible(true);
    }//GEN-LAST:event_mnuAcerca1ActionPerformed

    private void mnuAcerca1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAcerca1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAcerca1MouseClicked

    private void lblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductosMouseClicked
        Products pr = new Products(new javax.swing.JFrame(), true, objUsuario);
        pr.setVisible(true);
    }//GEN-LAST:event_lblProductosMouseClicked

    private void lblGenerarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerarVentaMouseClicked
        MenuPreVentas mp = new MenuPreVentas(new javax.swing.JFrame(), true, objUsuario);
        mp.setVisible(true);
    }//GEN-LAST:event_lblGenerarVentaMouseClicked

    private void lblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmpleadosMouseClicked
        Mostrar_usuario mu = new Mostrar_usuario(new javax.swing.JFrame(), true);
        mu.setVisible(true);
    }//GEN-LAST:event_lblEmpleadosMouseClicked

    private void lblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClientesMouseClicked
        Consulta_Clientes cliente = new Consulta_Clientes(new javax.swing.JFrame(), true);
        cliente.setVisible(true);
    }//GEN-LAST:event_lblClientesMouseClicked

    private void lblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProveedoresMouseClicked
        Consulta_Proveedor p = new Consulta_Proveedor(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_lblProveedoresMouseClicked

    private void lblIngresoRapidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresoRapidoMouseClicked
        ingresoRapido igrp = new ingresoRapido();
        igrp.setVisible(true);
    }//GEN-LAST:event_lblIngresoRapidoMouseClicked

    private void mnuMantCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantCompraActionPerformed
        ListaCompras Rc = new ListaCompras(this, rootPaneCheckingEnabled, objUsuario);
        Rc.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuMantCompraActionPerformed

    private void mnEliminadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEliminadasActionPerformed
        ventasEliminadas ve = new ventasEliminadas();
        ve.setVisible(true);
    }//GEN-LAST:event_mnEliminadasActionPerformed

    private void mnuAcerca2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAcerca2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuAcerca2MouseClicked

    private void mnuAcerca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcerca2ActionPerformed

        subirExcelpRODUCTOS sebp = new subirExcelpRODUCTOS();
        sebp.setVisible(true);


    }//GEN-LAST:event_mnuAcerca2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        KardexReporte kp = new KardexReporte(this, rootPaneCheckingEnabled, objUsuario);
        kp.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public Listar_usuario getUsuario() {
        return objUsuario;
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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMnuListVentas;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu jmCompras;
    private javax.swing.JMenuItem jmEmpleados;
    private javax.swing.JMenuItem jmIva;
    private javax.swing.JMenu jmLocal;
    private javax.swing.JMenuItem jmLocal2;
    private javax.swing.JMenuItem jmReporteCompra;
    private javax.swing.JMenu jmVenta;
    private javax.swing.JMenuItem jmVentaReporte;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblEmpleados;
    private javax.swing.JLabel lblGenerarVenta;
    private javax.swing.JLabel lblIngresoRapido;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPrivilegio;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblProveedores;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenuItem mnEliminadas;
    private javax.swing.JMenuItem mnuAcerca;
    private javax.swing.JMenuItem mnuAcerca1;
    private javax.swing.JMenuItem mnuAcerca2;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuCliente;
    private javax.swing.JMenuItem mnuCliente1;
    private javax.swing.JMenu mnuExcel;
    private javax.swing.JMenuItem mnuLaboratorio;
    private javax.swing.JMenuItem mnuMantCompra;
    private javax.swing.JMenuItem mnuRegistrarVenta;
    private javax.swing.JMenuItem mnuRegistrarVenta1;
    private javax.swing.JPanel pnlBanner;
    private javax.swing.JPanel pnlPie;
    // End of variables declaration//GEN-END:variables
}
