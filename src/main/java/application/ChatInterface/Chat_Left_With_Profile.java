
package application.ChatInterface;

import application.raven.swing.ImageAvatar;

import java.awt.Color;
import static java.util.Calendar.PM;
import javax.swing.Icon;


public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {

    
    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(163, 192, 230));
    }

    public void setUserProfile(String user){
        txt.setUserProfile(user);
    }
    
    public void setImageProfile(Icon image){
        IaImage.setIcon(image);
    }
    
    public void setText(String text){
        if(text.equals("")){
            txt.hideText();
        } else{
            txt.setText(text);
        }
    }
    
    public void setImage(Icon... image){
        txt.setImage(false, image);
    }
    
    public void setImage(String... image){
        txt.setImage(false, image);
    }
    
    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    
    public void setTime(){
        txt.setTime("10:30 PM");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        IaImage = new ImageAvatar();
        txt = new application.ChatInterface.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        IaImage.setForeground(new java.awt.Color(0, 102, 204));
        IaImage.setBorderSize(1);
        IaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/avt2.jpg"))); // NOI18N
        IaImage.setMaximumSize(new java.awt.Dimension(31, 31));
        IaImage.setMinimumSize(new java.awt.Dimension(31, 31));
        IaImage.setPreferredSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(IaImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(IaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ImageAvatar IaImage;
    private javax.swing.JLayeredPane jLayeredPane1;
    private application.ChatInterface.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
