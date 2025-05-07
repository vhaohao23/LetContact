package application.controller;

import application.dto.OtherInfomationCallVideo;
import application.session_management.SessionManagement;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import java.awt.dnd.DropTarget;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.*;

public class CallVideoController {
    static {
        String relativePath = "src\\main\\resources\\application\\dll\\opencv_java4110.dll";
        String absolutePath = System.getProperty("user.dir") + System.getProperty("file.separator") + relativePath;
        System.load(absolutePath);
    }

    @FXML
    private ImageView yourCamera;

    @FXML
    private ImageView otherCamera;

    OtherInfomationCallVideo otherInfomationCallVideo;

    private int port;

    private InetAddress ip;

    private DatagramSocket sendSocket;

    private DatagramSocket receiveSocket;

    public void init(OtherInfomationCallVideo otherInfomationCallVideo) throws UnknownHostException {
        this.otherInfomationCallVideo=otherInfomationCallVideo;

        port=9876;

        ip=InetAddress.getByName(otherInfomationCallVideo.getLoginSession().getIpAddress());

        try {
            this.sendSocket=new DatagramSocket();
            this.receiveSocket=new DatagramSocket(9876);
        } catch (SocketException ex) {
            ex.printStackTrace();
        }

        //handle your camera
        Thread yourcameraThread = new Thread(this::handleYourCamera);
        yourcameraThread.setDaemon(true); // Will not prevent app from closing
        yourcameraThread.start();

        //handle other camera
        Thread othercameraThread = new Thread(this::handleOtherCamera);
        othercameraThread.setDaemon(true); // Will not prevent app from closing
        othercameraThread.start();
    }

    public void handleYourCamera()  {
        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()) {
            System.out.println("Error: Could not open camera");
            return;
        }

        Mat matFrame = new Mat();

        // Main loop
        while (true) {
            // Read frame from camera
            if (camera.read(matFrame)) {
                // Convert Mat to BufferedImage
                BufferedImage bfimage = matToBufferedImage(matFrame);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bfimage, "jpg", baos);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                byte[] imageData = baos.toByteArray();

                yourCamera.setImage(ImageUtil.getImage(imageData));
//                System.out.println("Your camera: " + imageData.length);

                DatagramPacket senderPacket=new DatagramPacket(imageData,imageData.length,ip,port);
                try {
                    sendSocket.send(senderPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static BufferedImage matToBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer);

        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();

        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    private void handleOtherCamera() {
        while (true){
            byte [] buffer = new byte[25000]; // Buffer size for incoming packets
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            try {
                receiveSocket.receive(receivePacket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            byte[] imageData= receivePacket.getData();
            System.out.println("Other camera: " + imageData.length);
            otherCamera.setImage(ImageUtil.getImage(imageData));
        }
    }
}