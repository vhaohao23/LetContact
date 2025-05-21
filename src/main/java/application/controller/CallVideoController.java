package application.controller;

import application.dto.OtherInfomationCallVideo;
import application.dto.SendToOther;
import application.session_management.UDPSocketSession;
import application.util.ImageUtil;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
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

    private DatagramSocket socket;
    
    // Audio recording variables
    private TargetDataLine audioLine;
    private AudioFormat audioFormat;
    private boolean isRecording = true;
    private SourceDataLine speaker;

    public void init(OtherInfomationCallVideo otherInfomationCallVideo) throws UnknownHostException {
        this.otherInfomationCallVideo=otherInfomationCallVideo;

        port=9877;

        ip=InetAddress.getByName(otherInfomationCallVideo.getLoginSession().getUdpIpAddress());

        try {
            this.socket=  UDPSocketSession.getInstance().socket;
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        // Initialize audio format
        audioFormat = new AudioFormat(44100, 16, 1, true, true);

        //handle your camera
        Thread yourcameraThread = new Thread(this::handleYourCamera);
        yourcameraThread.setDaemon(true); // Will not prevent app from closing
        yourcameraThread.start();

        //handle other camera
        Thread othercameraThread = new Thread(this::handleOtherCamera);
        othercameraThread.setDaemon(true); // Will not prevent app from closing
        othercameraThread.start();

        // Initialize audio recording
        initAudioRecording();
    }

    private void initAudioRecording() {
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
            audioLine = (TargetDataLine) AudioSystem.getLine(info);
            audioLine.open(audioFormat);
            audioLine.start();

            // Start audio recording thread
            Thread audioThread = new Thread(this::handleAudioRecording);
            audioThread.setDaemon(true);
            audioThread.start();

            // Initialize speaker for playback
            DataLine.Info speakerInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            speaker = (SourceDataLine) AudioSystem.getLine(speakerInfo);
            speaker.open(audioFormat);
            speaker.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void handleAudioRecording() {
        byte[] buffer = new byte[4096];
        while (isRecording) {
            int count = audioLine.read(buffer, 0, buffer.length);
            if (count > 0) {
                // Send audio data along with video
                SendToOther sendToOther = new SendToOther(null, buffer, ip, port);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    oos.writeObject(sendToOther);
                    oos.flush();
                    byte[] data = baos.toByteArray();
                    DatagramPacket senderPacket = new DatagramPacket(data, data.length, ip, port);
//                    DatagramPacket senderPacket = new DatagramPacket(data, data.length, InetAddress.getByName("34.201.147.74"), 9877);

                    socket.send(senderPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void handleYourCamera()  {
        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()) {
            System.out.println("Error: Could not open camera");
            return;
        }

        Mat matFrame = new Mat();
        
        punchHole(new SendToOther(null, null, ip, 10000));
        
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

                SendToOther sendToOther = new SendToOther(imageData, null, ip, port);
                ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(baos1);
                    oos.writeObject(sendToOther);
                    oos.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                byte[] data = baos1.toByteArray();

                DatagramPacket senderPacket= null;
                senderPacket = new DatagramPacket(data,data.length, ip,port);
//                    senderPacket = new DatagramPacket(data,data.length, InetAddress.getByName("34.201.147.74"),9877);
                try {
                    socket.send(senderPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(33); // ~30 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
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
            try {
                byte [] buffer = new byte[65536]; // Buffer size for incoming packets
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
                ObjectInputStream ois = new ObjectInputStream(bais);
                SendToOther receivedObject = (SendToOther) ois.readObject();

                // Handle video data
                if (receivedObject.imageData != null) {
                    otherCamera.setImage(ImageUtil.getImage(receivedObject.imageData));
                }

                // Handle audio data
                if (receivedObject.voiceData != null) {
                    speaker.write(receivedObject.voiceData, 0, receivedObject.voiceData.length);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void punchHole(SendToOther sendToOther) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(sendToOther);
            oos.flush();
            byte[] data = baos.toByteArray();

            DatagramPacket senderPacket = new DatagramPacket(data, data.length, ip,port);
//            DatagramPacket senderPacket = new DatagramPacket(data, data.length, InetAddress.getByName("34.201.147.74"),9877);
            socket.send(senderPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cleanup method to be called when the call ends
    public void cleanup() {
        isRecording = false;
        if (audioLine != null) {
            audioLine.stop();
            audioLine.close();
        }
        if (speaker != null) {
            speaker.stop();
            speaker.close();
        }
    }
}