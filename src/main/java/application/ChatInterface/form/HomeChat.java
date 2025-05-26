
package application.ChatInterface.form;

import application.session_management.ChatSession;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class HomeChat extends javax.swing.JLayeredPane {

    private JPanel currentMenuPanel;
    private JPanel currentRightMenuPanel;

    public HomeChat() {
        initComponents();
        init();
    }

    private void init(){
        setLayout(new MigLayout("fillx, filly", "0[300!]0[fill, 100%]0[300!]0", "0[fill]0"));
        currentMenuPanel = new Menu_Left(this);
        currentRightMenuPanel = new Menu_Right(); // Khởi tạo với Menu_Right
        this.add(currentMenuPanel);
        this.add(ChatSession.getInstance().getChat());
        this.add(currentRightMenuPanel);
    }

    public void showMenu(JPanel newMenu) {
        this.remove(currentMenuPanel);
        currentMenuPanel = newMenu;
        this.add(currentMenuPanel, 0);
        this.revalidate();
        this.repaint();
    }

    public void showRightMenu(JPanel newRightMenu) {
        this.remove(currentRightMenuPanel);
        currentRightMenuPanel = newRightMenu;
        this.add(currentRightMenuPanel, 2); // Thêm vào vị trí thứ 3 (sau Menu_Left và Chat)
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
