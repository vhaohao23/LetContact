
package application.ChatInterface.form;

import application.session_management.ChatSession;
import net.miginfocom.swing.MigLayout;

public class HomeChat extends javax.swing.JLayeredPane {

    
    public HomeChat() {
        initComponents();
        init();
    }

    private void init(){
        setLayout(new MigLayout("fillx, filly","0[300!]0[fill, 100%]0[300!]0","0[fill]0"));
        this.add(new Menu_Left());
        this.add(ChatSession.getInstance().getChat());
        this.add(new Menu_Right());
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
