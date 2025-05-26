
package application.ChatInterface.form;

import application.session_management.ChatSession;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class HomeChat extends javax.swing.JLayeredPane {

    private JPanel currentMenuPanel;

    public HomeChat() {
        initComponents();
        init();
    }

    private void init(){
        setLayout(new MigLayout("fillx, filly", "0[300!]0[fill, 100%]0[300!]0", "0[fill]0"));
        currentMenuPanel = new Menu_Left(this); // Khởi tạo với Menu_Left
        this.add(currentMenuPanel);
        this.add(ChatSession.getInstance().getChat());
        this.add(new Menu_Right());
    }

    public void showMenu(JPanel newMenu) {
        this.remove(currentMenuPanel); // Xóa panel hiện tại
        currentMenuPanel = newMenu; // Cập nhật panel mới
        this.add(currentMenuPanel, 0); // Thêm panel mới vào vị trí đầu tiên
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
