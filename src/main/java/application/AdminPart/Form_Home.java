package application.AdminPart;




import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Form_Home extends JPanel {

    public Form_Home() {
    initComponents();
    card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/application/AdminImage/cloudw.png")), "Total accounts registered", "1000", "Increased by 70%"));
    card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/application/AdminImage/user.png")), "Number of active users", "700", "Increased by 70%"));
    card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/application/AdminImage/blockuser.png")), "Number of banned users", "300", "Decreased by 30%"));
    // add row table
    spTable.setVerticalScrollBar(new ScollBar());
    spTable.getVerticalScrollBar().setBackground(Color.WHITE);
    spTable.getViewport().setBackground(Color.WHITE);
    JPanel p = new JPanel();
    p.setBackground(Color.WHITE);
    spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"B", "Băng", "Nguyễn", "2002-06-22", "female", "470 Trần Đại Nghĩa street", "912345678", "bangnguyen22@gmail.com", "bangnguyen22", StatusType.BANNED});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    table.addRow(new Object[] {"A", "An", "Nguyễn", "2000-03-15", "male", "470 Trần Đại Nghĩa street", "987654321", "nguyenvana1503@gmail.com", "nguyenvana1503", StatusType.ACTIVE});
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new application.AdminPart.Card();
        card2 = new application.AdminPart.Card();
        card3 = new application.AdminPart.Card();
        panelBorder1 = new application.AdminPart.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new JScrollPane();
        table = new application.AdminPart.Table();

        setBackground(new Color(246, 246, 246));

        panel.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        card1.setColor1(new Color(0, 51, 153));
        panel.add(card1);

        card2.setColor1(new Color(0, 51, 153));
        panel.add(card2);

        card3.setColor1(new Color(0, 51, 153));
        panel.add(card3);

        panelBorder1.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(127, 127, 127));
        jLabel1.setText("Statistical Table");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "FirstName", "LastName", "Dob", "Gender", "Address", "Phone", "Email", "Password", "Status"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 951, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.AdminPart.Card card1;
    private application.AdminPart.Card card2;
    private application.AdminPart.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private application.AdminPart.PanelBorder panelBorder1;
    private JScrollPane spTable;
    private application.AdminPart.Table table;
    // End of variables declaration//GEN-END:variables
}
