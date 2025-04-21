package application.util;

import application.Main;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImageUtil {
    public static byte[] getImageData(File imageFile) throws IOException, IOException {
        return Files.readAllBytes(imageFile.toPath());
    }

    public static Image getImage(byte[] imageData){
        ByteArrayInputStream baiser=new ByteArrayInputStream(imageData);
        Image image = new Image(baiser);
        return image;
    }
}
