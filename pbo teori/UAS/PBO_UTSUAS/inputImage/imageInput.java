package inputImage;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class imageInput extends JPanel {
    private BufferedImage image;

    public imageInput() {
        try {
            // Membaca gambar dari file
            image = ImageIO.read(new File("C:/Users/r687e/Desktop/PBO_UTSUAS/inputImage/50km.jpg"));
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Menggambar gambar pada panel
            g.drawImage(image, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        imageInput panel = new imageInput();

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Sesuaikan ukuran frame
        frame.setVisible(true);
    }
}

