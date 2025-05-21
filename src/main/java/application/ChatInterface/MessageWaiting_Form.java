
package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.form.Item_People;
import application.ChatInterface.form.Item_Stranger;
import net.miginfocom.swing.MigLayout;


public class MessageWaiting_Form extends javax.swing.JLayeredPane {

    
    public MessageWaiting_Form() {
        initComponents();
        init();
    }
    
    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("filly", "2[]4", "fill"));
        showPeople();
    }
    private void showPeople() {
    for (int i = 0; i < 20; i++) {
        int row = i / 2; 
        int col = i % 2; 
        menuList.add(new Item_Stranger("Stranger " + i, "dd/mm/yy", "gender"), String.format("cell %d %d, grow", col, row));
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        sp.setBackground(new java.awt.Color(222, 242, 255));

        menuList.setBackground(new java.awt.Color(200, 227, 255));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
