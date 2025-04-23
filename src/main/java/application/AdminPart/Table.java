package application.AdminPart;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setResizingAllowed(true);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 10) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean selected, boolean bln1, int i, int i1) {
                if (i1 != 9) {
                    Component com = super.getTableCellRendererComponent(table, o, selected, bln1, i, i1);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (selected) {
                        com.setForeground(new Color(234, 141, 141));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                } else {
                    StatusType type = null;
                    if (o instanceof StatusType) {
                        type = (StatusType) o;
                    } else if (o instanceof String) {
                        try {
                            type = StatusType.valueOf((String) o);
                        } catch (IllegalArgumentException e) {
                            return super.getTableCellRendererComponent(table, o, selected, bln1, i, i1);
                        }
                    } else {
                        return super.getTableCellRendererComponent(table, o, selected, bln1, i, i1);
                    }
                    CellStatus cell = new CellStatus(type);
                    return cell;
                }
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
