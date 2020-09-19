package com.farmacia.views.ayuda;

public class Acerca extends javax.swing.JFrame {

    public Acerca() {
        initComponents();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        asofarLite = new javax.swing.JLabel();
        logoClubJava = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        director = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        asofarLite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/asofarLiteAcerca.png"))); // NOI18N

        logoClubJava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Java.png"))); // NOI18N

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/cerrar.png"))); // NOI18N
        cerrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(55, 99, 55));
        titulo.setText("SISTEMA DE INVENTARIO");

        version.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        version.setForeground(new java.awt.Color(55, 99, 55));
        version.setText("Version 1.0");

        copyright.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        copyright.setForeground(new java.awt.Color(55, 99, 55));
        copyright.setText("Copyright c 2019, 2020 Club de Programación Java ISTG. Todos los derechos reservados.");

        director.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        director.setForeground(new java.awt.Color(55, 99, 55));
        director.setText("Dirigido por Ing. Jose Luis Tapia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(3, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrar)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 48, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(asofarLite)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(version)
                                .addGap(215, 215, 215))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(copyright)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(director)
                                        .addGap(134, 134, 134)))
                                .addComponent(logoClubJava)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cerrar)
                .addGap(2, 2, 2)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(asofarLite)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(version)
                        .addGap(28, 28, 28)
                        .addComponent(copyright)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(director)
                        .addGap(16, 16, 16))
                    .addComponent(logoClubJava))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_cerrarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asofarLite;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel director;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoClubJava;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
