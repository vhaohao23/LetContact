package application.util;

import application.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class AvatarDisplayUtil {
    public static void avatarDisplay(ImageView avatarImageView, StackPane imageContainer, Image image){

        avatarImageView.setFitWidth(Math.min(210,Math.max(210,image.getWidth()/2)));
        avatarImageView.setFitHeight(Math.min(210,Math.max(210,image.getHeight()/2)));
        avatarImageView.setPreserveRatio(true);
        avatarImageView.setSmooth(true);
        avatarImageView.setImage(image);

        Circle clip = new Circle(105,105,100);
        imageContainer.setClip(clip);
    }
}
