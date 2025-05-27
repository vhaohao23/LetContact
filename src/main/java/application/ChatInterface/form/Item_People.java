package application.ChatInterface.form;

import application.model.User;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import application.ChatInterface.event.PublicEvent;
import com.mysql.cj.conf.PropertyDefinitions;

public class Item_People extends javax.swing.JPanel {

    private User user;

    public Item_People(User user) {
        this.user = user;
        initComponents();
        lb.setText(user.getUserName());
        lbStatus.setText(user.getStatus());
        activeStatus1.setActive("ACTIVE".equalsIgnoreCase(user.getStatus()));
        if (user.getAvatar() != null && user.getAvatar().length > 0) {
            imageAvatar1.setIcon(new ImageIcon(user.getAvatar()));
        } else {
            imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/avatar.png")));
        }
        init();
    }

    public User getUser() {
        return user;
    }

    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(163, 192, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(243, 249, 255));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                PublicEvent.getInstance().getEventMenuLeft().selectUser(user);
                PublicEvent.getInstance().getEventMenuRight().selectUser(user);
                System.out.println(user.getUserName());
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        imageAvatar1 = new application.raven.swing.ImageAvatar();
        lb = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus1 = new application.raven.swing.ActiveStatus();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setForeground(new java.awt.Color(0, 0, 153));
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/avatar.png")));

        lb.setFont(new java.awt.Font("Segoe UI", 1, 14));

        lbStatus.setFont(new java.awt.Font("Segoe UI", 2, 12));
        lbStatus.setForeground(new java.awt.Color(110, 110, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(activeStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(lb)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(activeStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 8, Short.MAX_VALUE)))
                                .addGap(0, 0, 0))
        );
    }

    private application.raven.swing.ActiveStatus activeStatus1;
    private application.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbStatus;
}