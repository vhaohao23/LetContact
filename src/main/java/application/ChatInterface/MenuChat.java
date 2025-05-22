
package application.ChatInterface;

import application.AdminPart.*;
import application.AdminPart.EventMenuSelected;
import application.AdminPart.Model_Menu;
import application.model.User;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.List;
import javax.swing.JFrame;

public class MenuChat extends javax.swing.JPanel {

    private EventMenuSelected event;
    private List<User> friendsList;
    
    public void addEventMenuSelected (EventMenuSelected event){
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    public MenuChat() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
    private void init(){
        listMenu1.addItem(new Model_Menu("bubble-chat", "Chat Section", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("message", "Message Waiting", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("calling", "Calling", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMTY));
        listMenu1.addItem(new Model_Menu("list", "List Friends", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("search_1", "Search Friends", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMTY));
        listMenu1.addItem(new Model_Menu("restriction", "Restricted Account", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("report", "Report", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("settings", "Setting", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("logout", "Log Out", Model_Menu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu1 = new application.AdminPart.ListMenu<>();
        profile1 = new application.ChatInterface.Profile();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
            .addComponent(profile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#0b3eab"), 0, getHeight(), Color.decode("#dcecff"));
        g2.setPaint(g);
        int height = 140;
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 0);
        f.curveTo(0, 0, 0, 70, 100, 70);
        f.curveTo(100, 70, getWidth(), 70, getWidth(), height);
        f.lineTo(getWidth(), getHeight());
        f.lineTo(0, getHeight());
        g2.setColor(new Color(246, 246, 246));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setPaint(g);
        g2.fill(f);
        super.paint(grphcs); 
    }
private int x;
private int y;

public void initMoving(JFrame fram){
    profile1.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
        
    });
    profile1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            fram.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.AdminPart.ListMenu<String> listMenu1;
    private application.ChatInterface.Profile profile1;
    // End of variables declaration//GEN-END:variables
}
