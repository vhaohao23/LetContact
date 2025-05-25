
package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.ChatMain;
import application.ChatInterface.OptionButton;
import application.raven.swing.Emoji;
import application.raven.swing.Model_Emoji;
import application.raven.swing.WrapLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Panel_More extends javax.swing.JPanel {

    
    public Panel_More() {
        initComponents();
        init();
    }

    private  void init (){
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        panelHeader.add(getEmojiStyle3());
        panelHeader.setBackground(new Color(209,228,255));
        add(panelHeader, "w 100%, h 30!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
        panelDetail.setBackground(new Color(237, 246, 255));
        add(ch, "w 100%, h 100%");
    }
    
    private JButton getButtonFile(){
        application.ChatInterface.OptionButton cmd = new application.ChatInterface.OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/link.png")));
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser ch = new JFileChooser();
                ch.showOpenDialog(ChatMain.getFrames()[0]);
                //Update next
            }
        });
        return cmd;
    }
    
    private JButton getEmojiStyle1(){
        application.ChatInterface.OptionButton cmd = new application.ChatInterface.OptionButton();
        cmd.setIcon(Emoji.getInstance().getImoji(1).toSize(25,25).getIcon());
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emoji.getInstance().getStyle1()){
                    JButton c = new JButton(d.getIcon());
                    c.setName(d.getId()+"");
                    c.setBorder(new EmptyBorder(3,3,3,3));
                    c.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    c.setContentAreaFilled(false);
                    panelDetail.add(c);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    
    private JButton getEmojiStyle2(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getImoji(55).toSize(25,25).getIcon());
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emoji.getInstance().getStyle2()){
                    JButton c = new JButton(d.getIcon());
                    c.setName(d.getId()+"");
                    c.setBorder(new EmptyBorder(3,3,3,3));
                    c.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    c.setContentAreaFilled(false);
                    panelDetail.add(c);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    
     private JButton getEmojiStyle3(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getImoji(90).toSize(25,25).getIcon());
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emoji.getInstance().getStyle3()){
                    JButton c = new JButton(d.getIcon());
                    c.setName(d.getId()+"");
                    c.setBorder(new EmptyBorder(3,3,3,3));
                    c.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    c.setContentAreaFilled(false);
                    panelDetail.add(c);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearSelected(){
        for (Component c : panelHeader.getComponents()){
            if (c instanceof OptionButton){
                ((OptionButton)c).setSelected(false);
            }
        }
    }
    
    private JPanel panelHeader;
    private JPanel panelDetail;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
