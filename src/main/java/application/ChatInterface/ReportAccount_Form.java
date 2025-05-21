
package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.form.Item_Report;
import net.miginfocom.swing.MigLayout;


public class ReportAccount_Form extends javax.swing.JLayeredPane {

    
    public ReportAccount_Form() {
        initComponents();
        init();
    }
    
    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("filly", "2[]4[]2", "fill"));
        showPeople();
    }
    private void showPeople() {
    for (int i = 0; i < 20; i++) {
        int row = i / 3; 
        int col = i % 3; 
        menuList.add(new Item_Report("People " + i, "dd/mm/yy", "gender", "Friend"), String.format("cell %d %d, grow", col, row));
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        button = new com.raven.swing.Button();
        jtsearch = new application.AdminPart.SearchText();

        sp.setBackground(new java.awt.Color(222, 242, 255));

        menuList.setBackground(new java.awt.Color(200, 227, 255));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/search.png"))); // NOI18N
        button.setOpaque(true);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jtsearch.setForeground(new java.awt.Color(153, 153, 153));
        jtsearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtsearchActionPerformed(evt);
            }
        });

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(button, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(jtsearch, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addGroup(layout.createSequentialGroup()
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonActionPerformed

    private void jtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button;
    private application.AdminPart.SearchText jtsearch;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
