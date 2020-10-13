package sistemafarmacia.presentacion;

import com.farmacia.AES.hash;
import com.farmacia.dao.CRUD;
import com.farmacia.entities1.Listar_usuario;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.farmacia.operaciones.Operaciones;
import com.farmacia.views.usuario.Mostrar_usuario;
import com.farmacia.views.usuario.Registrar_usuario;
import com.farmacia.views.ventas.MenuPreVentas;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemafarmacia.VariablesFunciones;

public class FrmLogin extends javax.swing.JFrame {

    private static final String TITLE = "INICIAR SESION";
    VariablesFunciones variables = new VariablesFunciones();
    CRUD cr = new CRUD();
    Listar_usuario objeto = null;
    ArrayList<Listar_usuario> listar = null;

    public FrmLogin() {
        initComponents();
        getContentPane().setBackground(Color.white);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        listar = cr.get_listar_usuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        lblBanner = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlHeader.setOpaque(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/asofarLoguito.png"))); // NOI18N

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addGap(17, 17, 17))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addComponent(lblCerrar)
                        .addGap(16, 16, 16))))
        );

        pnlBody.setOpaque(false);

        jLabel2.setForeground(new java.awt.Color(0, 27, 134));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Usuario:");

        jLabel3.setForeground(new java.awt.Color(0, 27, 134));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Contraseña:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtContrasenia.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 99, 50)));
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyTyped(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(0, 27, 134));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Ingresar");
        btnAceptar.setActionCommand("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblBanner.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblBanner.setForeground(new java.awt.Color(0, 27, 134));
        lblBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanner.setText("INICIAR SESION");

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addComponent(lblBanner)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBodyLayout.createSequentialGroup()
                        .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario)
                            .addGroup(pnlBodyLayout.createSequentialGroup()
                                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void iniciarSesion() {
        if (txtUsuario.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Ingrese un usuario válido");
        } else if (txtContrasenia.getText().length() < 2) {
            JOptionPane.showMessageDialog(null, "Ingrese una contraseña válida");
        } else {
            String pass = new String(txtContrasenia.getPassword());
            String nuevoPass = hash.sha1(pass);
            Listar_usuario obj = new Listar_usuario();
            obj.setCorreo(txtUsuario.getText());
            obj.setPassword(nuevoPass);
            System.out.println("contraseña " + nuevoPass);
            obj.setIp_equipo(Operaciones.getIpDispositivo());
//            obj.setIp_publico(Operaciones.getIpPublica().getIp_publica_full());
            obj.setDir_ip_completa(Operaciones.getIpLocalCompleta());
            obj.setUsuario_equipo(Operaciones.getNombreDispositivo());
            try {
                String a = cr.Iniciar_sesion(obj);
                //JOptionPane.showMessageDialog(this, a);
                if (!"Usuario no existe".equals(a)) {
                    objeto = devuelveObjeto(txtUsuario.getText(), listar);
                    if (objeto != null) {
                        //System.out.println("holaaaaa");
                        FrmPrincipal acc = new FrmPrincipal(objeto, objeto.getCargo());
                        acc.setVisible(true);
                        dispose();
                        listar.clear();
                        listar = cr.get_listar_usuario();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Usuario no existe!!!");
                    txtUsuario.setText("");
                    txtContrasenia.setText("");
                }
//                objeto = devuelveObjeto(txtUsuario.getText(), listar);
//                if (objeto != null) {
//                    //System.out.println("holaaaaa");
//                    FrmPrincipal acc = new FrmPrincipal(objeto, objeto.getCargo());
//                    acc.setVisible(true);
//                    dispose();
//                    listar.clear();
//                    listar = cr.get_listar_usuario();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Usuario no existe!!!");
//                    txtUsuario.setText("");
//                    txtContrasenia.setText("");
//                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        }
    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public Listar_usuario devuelveObjeto(String datos, ArrayList<Listar_usuario> listarobj) {
        Listar_usuario objeto1 = null;
        for (int i = 0; i < listarobj.size(); i++) {
            if (datos.equals(listarobj.get(i).getCorreo())) {
                objeto1 = listarobj.get(i);
                break;
            }
        }
        return objeto1;
    }

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarSesion();
        }
    }//GEN-LAST:event_txtContraseniaKeyPressed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char c = evt.getKeyChar();
        char mas = '+', por = '*', div = '/', dp = ':', pc = ';', c2 = ',', p1 = '{', p2 = '}';
        char lla1 = '[', el = '^', lla2 = ']', el2 = '¿', co = '?', co2 = '¡', c3 = '!', d = '"', e = '#';
        char col = '$', a = '!', b = '=', e2 = '%', f = '&', g = '=', h = 'º', i = 'ª', j = '(', k = ')', l = '<', m = '>';
        char n = 'ç', o = '´', p = '`', q = '¨', r = 'Ñ', s = '·', t = 'ñ';
        if (Character.isWhitespace(c) || c == mas || c == por || c == div || c == dp
                || c == pc || c == c2 || c == p1 || c == p2 || c == lla1 || c == lla2
                || c == el || c == el2 || c == co || c == co2 || c == c3 || c == d || c == e
                || c == col || c == a || c == b || c == e2 || c == f || c == g || c == h
                || c == i || c == j || c == k || c == l || c == m || c == n || c == o || c == p
                || c == q || c == r || c == s || c == t) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyTyped
        char c = evt.getKeyChar();
        if (c == ' ') {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Espacio no es un caracter válido");
        }
    }//GEN-LAST:event_txtContraseniaKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
