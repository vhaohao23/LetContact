
package application.ChatInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import org.jdesktop.swingx.graphics.ShadowRenderer;

public class HeaderChat extends javax.swing.JPanel {

    
    public HeaderChat() {
        initComponents();
        setBackground(new Color(250,250,250));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new com.raven.swing.Button();

        cmdMenu.setBackground(new java.awt.Color(250, 250, 250));
        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/menu.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        int width = getWidth();
        int height = getHeight() - 6;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
        grphcs.drawImage(new ShadowRenderer(3, 0.3f, Color.GRAY).createShadow(img), -3, 0, null);
        grphcs.drawImage(img, 0, 0, null);
    }

    private int x;
private int y;

public void initMoving(JFrame fram){
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
        
    });
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            fram.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
        }
    });
}
    public void addEvenMenu (ActionListener event){
        cmdMenu.addActionListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button cmdMenu;
    // End of variables declaration//GEN-END:variables
}
