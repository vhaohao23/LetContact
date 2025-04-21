package application.util;

import application.Main;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class AvatarDisplayUtil {
    public static void avatarDisplay(ImageView avatarImageView, StackPane imageContainer, Image image){
        double w=image.getWidth();
        double h=image.getHeight();
        if (w>h) {
            avatarImageView.setFitHeight(210);
            avatarImageView.setFitWidth(0);
        }
        else {
            avatarImageView.setFitWidth(210);
            avatarImageView.setFitHeight(0);
        }

        avatarImageView.setSmooth(true);
        avatarImageView.setPreserveRatio(true);
        avatarImageView.setImage(image);

        Circle clip = new Circle(imageContainer.getPrefWidth()/2,imageContainer.getPrefHeight()/2, 100);
        imageContainer.setClip(clip);
    }
}
