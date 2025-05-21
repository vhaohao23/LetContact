
package application.ChatInterface.form;

import application.ChatInterface.ChatSection_Form;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainForm extends javax.swing.JPanel {

    
    public MainForm() {
        initComponents();
        show (new ChatSection_Form());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerChat1 = new application.ChatInterface.HeaderChat();
        body = new javax.swing.JPanel();

        setBackground(new java.awt.Color(250, 250, 250));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerChat1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerChat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addEvenMenu (ActionListener event){
        headerChat1.addEvenMenu(event);
    }
    public void initMoving(JFrame fram){
        headerChat1.initMoving(fram);
    }
    public void show(Component com){
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private application.ChatInterface.HeaderChat headerChat1;
    // End of variables declaration//GEN-END:variables
}
