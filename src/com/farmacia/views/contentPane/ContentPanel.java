package com.farmacia.views.contentPane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ContentPanel extends JPanel {
    private Image imagen;
    
    @Override
    public void paintComponent(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/img/iconos/asofarLite.png")).getImage();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - imagen.getWidth(null))/2;
        int y = (this.getHeight()- imagen.getHeight(null))/3;
        g2d.drawImage(imagen, x, y, null);
        setBackground(Color.white);
    }
    
}
