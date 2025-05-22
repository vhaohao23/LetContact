
package application.ChatInterface.form;

import application.AdminPart.ScrollBar;
import javax.swing.JLayeredPane;

import application.raven.swing.Button;
import net.miginfocom.swing.MigLayout;


public class Menu_Left_Create_Group extends javax.swing.JPanel {

    
    public Menu_Left_Create_Group() {
        initComponents();
        init();
    }

    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx","0[]0", "0[]2"));
        showPeople();
    }
    private void showPeople(){
        menuList.removeAll();
        for (int i = 0; i<20; i++){
            menuList.add(new Item_People("People " + i), "wrap");
        }
        refreshMenuList();
    }
    
    private void showGroup(){
        menuList.removeAll();
        for (int i = 0; i<10; i++){
            menuList.add(new Item_People("Group " + i), "wrap");
        }
        refreshMenuList();
    }
    
    private void refreshMenuList(){
        menuList.repaint();
        menuList.revalidate();  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        buttonSearch = new Button();
        searchText = new application.AdminPart.SearchText();
        sp1 = new javax.swing.JScrollPane();
        menuList1 = new javax.swing.JLayeredPane();
        buttonMenuLeft = new Button();
        buttonCreate1 = new Button();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(227, 237, 250));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/search.png"))); // NOI18N
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        sp1.setBorder(null);
        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList1.setBackground(new java.awt.Color(211, 221, 235));
        menuList1.setOpaque(true);

        javax.swing.GroupLayout menuList1Layout = new javax.swing.GroupLayout(menuList1);
        menuList1.setLayout(menuList1Layout);
        menuList1Layout.setHorizontalGroup(
            menuList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuList1Layout.setVerticalGroup(
            menuList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );

        sp1.setViewportView(menuList1);

        buttonMenuLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/menu.png"))); // NOI18N
        buttonMenuLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuLeftActionPerformed(evt);
            }
        });

        buttonCreate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/AdminImage/create.png"))); // NOI18N
        buttonCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonCreate1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonMenuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sp1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMenuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCreate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonMenuLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenuLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMenuLeftActionPerformed

    private void buttonCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCreate1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button buttonCreate1;
    private Button buttonMenuLeft;
    private Button buttonSearch;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JLayeredPane menuList1;
    private application.AdminPart.SearchText searchText;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane sp1;
    // End of variables declaration//GEN-END:variables
}
