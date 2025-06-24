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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
    
    // ... các phần code khác giữ nguyên ...
    
    public void addItemRight(byte[] imageData) {
        try {
            Chat_Right item = new Chat_Right();
            
            // Chuyển đổi byte[] thành BufferedImage
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage bufferedImage = ImageIO.read(bis);
            
            if (bufferedImage != null) {
                // Chuyển BufferedImage thành ImageIcon
                ImageIcon imageIcon = new ImageIcon(bufferedImage);
                
                // Thêm ảnh vào item
                item.setImage(imageIcon);
                
                // Thêm item vào body với căn lề bên phải
                body.add(item, "wrap, al right, w 100::80%, gapy 5");
                body.revalidate();
                body.repaint();
                item.setTime();
                scrollToBottom();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Lỗi khi hiển thị ảnh",
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void addItemLeft(Message message) {
        if (message != null && message.getParticipant() != null) {
            Chat_Left_With_Profile item = new Chat_Left_With_Profile();
            
            // Xử lý tin nhắn dựa vào type
            if ("image".equals(message.getType())) {
                try {
                    // Chuyển đổi byte[] thành BufferedImage
                    ByteArrayInputStream bis = new ByteArrayInputStream(message.getContent());
                    BufferedImage bufferedImage = ImageIO.read(bis);
                    if (bufferedImage != null) {
                        item.setImage(new ImageIcon(bufferedImage));
                        // Không set text khi là ảnh
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Xử lý tin nhắn text
                item.setText(new String(message.getContent(), StandardCharsets.UTF_8));
            }
            
            // Thiết lập thông tin người gửi
            item.setUserProfile(message.getParticipant().getUser().getUserName());
            
            // Thêm avatar nếu có
            if (message.getParticipant().getUser().getAvatar() != null) {
                try {
                    ByteArrayInputStream bis = new ByteArrayInputStream(
                        message.getParticipant().getUser().getAvatar());
                    BufferedImage bImage = ImageIO.read(bis);
                    if (bImage != null) {
                        item.setImageProfile(new ImageIcon(bImage));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            item.setTime();
            body.add(item, "wrap, w 100::80%, gapy 5");
            body.revalidate();
            body.repaint();
            scrollToBottom();
        }
    }

    // Xóa phương thức addItemLeft(byte[] imageData, String userName) vì không cần thiết nữa
    // Tất cả xử lý ảnh sẽ được thực hiện trong addItemLeft(Message message)
    
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