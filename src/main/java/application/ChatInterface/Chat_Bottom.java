
package application.ChatInterface;

import application.AdminPart.ScrollBar;
import application.ChatInterface.event.PublicEvent;
import application.dao.ParticipantDAO;
import application.model.Message;
import application.model.Participant;
import application.model.User;
import application.raven.swing.JIMSendTextPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import javax.swing.*;

import application.session_management.SessionManagement;
import net.miginfocom.swing.MigLayout;

public class Chat_Bottom extends javax.swing.JPanel {

    private User user;
    public Chat_Bottom() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "0[fill]0[]0[]2", "2[fill]2[]0");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                refresh();
                if(ke.getKeyChar() == 10 && ke.isControlDown()){
                    eventSend(txt);
                }
            }
        });
        txt.setHintText("Write Message Here ...");
        scroll.setViewportView(txt);
        ScrollBar sb = new ScrollBar();
        sb.setPreferredSize(new Dimension(2, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]5[]10", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(Color.WHITE);
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/send.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eventSend(txt);
            }
        });
        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/3dots.png")));
        cmdMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(panelMore.isVisible()){
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/3dots.png")));
                    panelMore.setVisible(false);
                    mig.setComponentConstraints(panelMore, "dock south, h 0!");
                } else {
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/application/AdminImage/3dots1.png")));
                    panelMore.setVisible(true);
                    mig.setComponentConstraints(panelMore, "dock south, h 170!");
                }
                refresh();
            }
        });
        panel.add(cmd);
        panel.add(cmdMore);
        add(panel, "wrap");
        panelMore = new Panel_More();
        panelMore.setVisible(false);
        add(panelMore, "dock south, h 0!");
    }

    private void refresh() {
        revalidate();
    }
    
    private void eventSend(JIMSendTextPane txt){
        String text = txt.getText().trim();
        if (!text.equals("")) {
            try {
                Participant participant = new ParticipantDAO().selectParticipantOneByTwoUser(
                        SessionManagement.getInstance().getLoginSession().getUser(),
                        PublicEvent.getInstance().getEventChat().getCurrentUser());
                if (participant != null) {
                    Message message = new Message(
                            participant,
                            text.getBytes(StandardCharsets.UTF_8),
                            new Date(System.currentTimeMillis()),
                            "text"
                    );

                    PublicEvent.getInstance().getEventChat().sendMessage(message);

                    txt.setText("");
                    txt.grabFocus();
                    refresh();
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Có lỗi xảy ra khi gửi tin nhắn",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        txt.grabFocus();

    }
    private MigLayout mig;
    private Panel_More panelMore;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(71, 118, 199));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
