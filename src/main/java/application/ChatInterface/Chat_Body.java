package application.ChatInterface;

import application.AdminPart.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.nio.charset.StandardCharsets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import application.model.Message;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.VerticalLayout;

public class Chat_Body extends javax.swing.JPanel {

    
    public Chat_Body() {
        initComponents();
        init();
    }

    private void init(){
        body.setLayout(new MigLayout("fillx", "5[]5", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }

    public void clearChat() {
        body.removeAll();
        body.repaint();
        body.revalidate();
    }

    public void addItemLeft(Message message) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(new String(message.getContent(), StandardCharsets.UTF_8));
        item.setUserProfile(message.getParticipant().getUser().getUserName());
        item.setTime();
        body.add(item, "wrap, w 100::80%, gapy 5");
        body.revalidate();
        body.repaint();
        scrollToBottom();
    }
    
//    public void addItemLeft(String text, String user, String[] image){
//        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
//        item.setText(text);
//        item.setImage(image);
//        item.setTime();
//        // item.setUserProfile(user);
//        body.add(item, "wrap, w 100::80%");
//        body.repaint();
//        body.revalidate();
//    }
    
    public void addItemFile(String text, String user, String fileName, String fileSize){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(user);
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemRight(String text, Icon... image){
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setImage(image);
        body.add(item, "wrap, al right, w 100::80%, gapy 5");
        body.revalidate();
        body.repaint();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemFileRight(String text, String fileName, String fileSize){
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setFile(fileName, fileSize);
        body.add(item, "wrap, al right ,w 100::80%");
        item.setTime();
        body.repaint();
        body.revalidate();
    }
    
    public void addDate(String date){
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
    }
    
    private void scrollToBottom(){
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
