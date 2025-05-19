package application.controller;

import application.dto.CallAccept;
import application.dto.MessageType;
import application.model.User;
import application.session_management.SessionManagement;
import application.session_management.TCPSocketSession;
import application.util.AvatarDisplayUtil;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CallNotificationController {
    @FXML
    private ImageView callerAvatar;

    @FXML
    private Label callerUsername;

    @FXML
    private ImageView acceptCall;

    @FXML
    private ImageView rejectCall;

    @FXML
    private StackPane callerAvatarContainer;

    User caller;
    User callee;

    public void init(User caller,User callee) {
        Image image= ImageUtil.getImage(caller.getAvatar());
        AvatarDisplayUtil.avatarDisplay(callerAvatar, callerAvatarContainer,image);
        callerUsername.setText(caller.getUserName());

        this.caller=caller;
        this.callee=callee;
    }

    public void acceptCall(MouseEvent e) {
        CallAccept callAccept=new CallAccept(MessageType.CALL_ACCEPT,caller,callee);

        try {
            TCPSocketSession.getInstance().out.writeObject(callAccept);
            TCPSocketSession.getInstance().out.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }
}
