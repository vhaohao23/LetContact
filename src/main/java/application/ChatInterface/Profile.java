
package application.ChatInterface;

import application.model.User;
import application.raven.swing.ImageAvatar;
import application.session_management.SessionManagement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Profile extends javax.swing.JPanel {

    public Profile() {
        initComponents();
        setOpaque(false);
        loadUserAvatar();
    }

    private void loadUserAvatar() {
        try {
            User currentUser = SessionManagement.getInstance().getLoginSession().getUser();
            BufferedImage processedImage = null;

            if (currentUser != null && currentUser.getAvatar() != null) {
                byte[] avatarBytes = currentUser.getAvatar();
                ByteArrayInputStream bais = new ByteArrayInputStream(avatarBytes);
                BufferedImage originalImage = ImageIO.read(bais);
                if (originalImage != null) {
                    processedImage = processImage(originalImage);
                }
            }

            if (processedImage == null) {
                BufferedImage defaultImage = ImageIO.read(getClass().getResource("/application/AdminImage/Black_cat.jpg"));
                processedImage = processImage(defaultImage);
            }

            ImageIcon icon = new ImageIcon(processedImage);
            pic.setIcon(icon);

        } catch (IOException e) {
            e.printStackTrace();
            // Fallback to default image on error
            try {
                BufferedImage defaultImage = ImageIO.read(getClass().getResource("/application/AdminImage/Black_cat.jpg"));
                ImageIcon icon = new ImageIcon(processImage(defaultImage));
                pic.setIcon(icon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private BufferedImage processImage(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;

        BufferedImage croppedImage = originalImage.getSubimage(x, y, size, size);

        BufferedImage scaledImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(croppedImage, 0, 0, 100, 100, null);
        g2d.dispose();

        return scaledImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new ImageAvatar();

        pic.setForeground(new java.awt.Color(245, 245, 245));
        pic.setBorderSize(2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
