
package application.ChatInterface.form;


public class Item_Friend extends javax.swing.JPanel {

    
    public Item_Friend(String name, String dob, String gender, String status) {
        initComponents();
        lbuserName.setText(name);
        lbdob.setText(dob);
        lbgender.setText(gender);
        lbstatus.setText(status);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar = new com.raven.swing.ImageAvatar();
        lbuserName = new javax.swing.JLabel();
        lbdob = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        button1 = new com.raven.swing.Button();
        button2 = new com.raven.swing.Button();
        lbstatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/AccountIcon.png")));

        lbuserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbuserName.setText("USER NAME");

        lbdob.setText("Dob");

        lbgender.setText("Gender");

        button1.setBackground(new java.awt.Color(163, 209, 255));
        button1.setForeground(new java.awt.Color(0, 51, 153));
        button1.setText("Chat Now");
        button1.setToolTipText("Chat now!");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(184, 212, 241));
        button2.setForeground(new java.awt.Color(0, 51, 153));
        button2.setText("Unfriend");
        button2.setToolTipText("");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        lbstatus.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbdob)
                    .addComponent(lbgender)
                    .addComponent(lbuserName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbstatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbuserName)
                        .addGap(12, 12, 12)
                        .addComponent(lbdob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbgender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbstatus)))
                .addGap(0, 9, Short.MAX_VALUE))
            .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private com.raven.swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel lbdob;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lbstatus;
    private javax.swing.JLabel lbuserName;
    // End of variables declaration//GEN-END:variables
}
