
package application.ChatInterface;

import application.ChatInterface.event.EventImageView;
import application.ChatInterface.event.PublicEvent;
import javax.swing.Icon;

public class ChatSection_Form extends javax.swing.JPanel {

    
    public ChatSection_Form() {
        initComponents();
        view_Image.setVisible(false);
        home.setVisible(true);
        initEvent();
    }
    
    private void initEvent() {
        PublicEvent.getInstance().addEventImageView(new EventImageView(){
            @Override
            public void viewImage(Icon image) {
                view_Image.viewImage(image);
            }
            
            @Override
            public void saveImage(Icon image) {
                System.out.println("Save Image next update");
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        border = new javax.swing.JPanel();
        body = new javax.swing.JLayeredPane();
        view_Image = new application.ChatInterface.form.View_Image();
        home = new application.ChatInterface.form.HomeChat();

        border.setBackground(new java.awt.Color(229, 229, 229));

        body.setLayout(new java.awt.CardLayout());
        body.setLayer(view_Image, javax.swing.JLayeredPane.POPUP_LAYER);
        body.add(view_Image, "card3");
        body.add(home, "card2");

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1673, Short.MAX_VALUE)
        );
        borderLayout.setVerticalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane body;
    private javax.swing.JPanel border;
    private application.ChatInterface.form.HomeChat home;
    private application.ChatInterface.form.View_Image view_Image;
    // End of variables declaration//GEN-END:variables
}
