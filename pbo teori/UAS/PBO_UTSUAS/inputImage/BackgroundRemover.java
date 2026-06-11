package inputImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundRemover {

    public static void main(String[] args) {
        try {
            // Use an absolute path to the image file
            File inputFile = new File("C:/Users/r687e/Desktop/PBO_UTSUAS/inputImage/ada.jpg"); // Replace with your image file path
            if (!inputFile.exists()) {
                System.err.println("Input file not found: " + inputFile.getAbsolutePath());
                return;
            }
            BufferedImage image = ImageIO.read(inputFile);

            // Define the background color and tolerance
            Color bgColor = Color.WHITE;
            int tolerance = 30;

            // Create an output image with alpha channel (transparency)
            BufferedImage outputImage = new BufferedImage(
                    image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

            // Process each pixel
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int pixel = image.getRGB(x, y);
                    if (isWithinTolerance(pixel, bgColor.getRGB(), tolerance)) {
                        // Set background pixel to transparent
                        outputImage.setRGB(x, y, 0x00FFFFFF);
                    } else {
                        // Copy the original pixel
                        outputImage.setRGB(x, y, pixel);
                    }
                }
            }

            // Save the output image
            File outputFile = new File("output_image.png");
            ImageIO.write(outputImage, "png", outputFile);

            // Display the output image
            displayImage(outputImage);

        } catch (IOException e) {
            System.err.println("Error reading or writing image file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isWithinTolerance(int pixelColor, int bgColor, int tolerance) {
        int red1 = (pixelColor >> 16) & 0xFF;
        int green1 = (pixelColor >> 8) & 0xFF;
        int blue1 = pixelColor & 0xFF;

        int red2 = (bgColor >> 16) & 0xFF;
        int green2 = (bgColor >> 8) & 0xFF;
        int blue2 = bgColor & 0xFF;

        return Math.abs(red1 - red2) <= tolerance &&
               Math.abs(green1 - green2) <= tolerance &&
               Math.abs(blue1 - blue2) <= tolerance;
    }

    private static void displayImage(BufferedImage image) {
        // Create a JFrame to display the image
        JFrame frame = new JFrame("Background Removed Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(image.getWidth(), image.getHeight());

        // Create a JPanel to add the image to
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
