package application.util;

import application.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class AvatarDisplayUtil {
    public static void avatarDisplay(ImageView avatarImageView, AnchorPane imageContainer){
        avatarImageView.setPreserveRatio(true);
        avatarImageView.setSmooth(true);
        Image image = new Image(Main.class.getResource("/application/img/DefaultAvatar.png").toExternalForm());
        avatarImageView.setImage(image);

        Circle clip = new Circle();
        clip.centerXProperty().bind(imageContainer.widthProperty().divide(2));
        clip.centerYProperty().bind(imageContainer.heightProperty().divide(2));
        clip.radiusProperty().bind(imageContainer.widthProperty().divide(2));
        imageContainer.setClip(clip);
    }
}
