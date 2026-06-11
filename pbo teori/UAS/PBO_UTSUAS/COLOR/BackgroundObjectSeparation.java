
package COLOR;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundObjectSeparation {

    public static void main(String[] args) {
     
        BufferedImage image = null;
        try {
            File file = new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\stop.jpg");
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (image == null) {
            System.out.println("Failed to load the image.");
            return;
        }

        BufferedImage result = colorSegmentation(image);

        
        try {
            File outputFile = new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\result.jpg");
            ImageIO.write(result, "jpg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        createAndShowGUI(image, result);
    }

    private static BufferedImage colorSegmentation(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        getRGB getrgb = new getRGB();
        int[] avgRGB = getrgb.getAvgRGB();


         
        
        int minRed = 0, maxRed =avgRGB[0];
        int minGreen = 0, maxGreen =avgRGB[1];
        int minBlue = 0, maxBlue=avgRGB[2];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                 if (red >= minRed && red <= maxRed && green >= minGreen && green <= maxGreen && blue >= minBlue && blue <= maxBlue) {
                    result.setRGB(x, y, Color.BLACK.getRGB()); // Object
                } else {
                    result.setRGB(x, y, Color.WHITE.getRGB()); // Background
                }
            }
        }

        return result;
    }

    private static void createAndShowGUI(BufferedImage originalImage, BufferedImage resultImage) {
        JFrame frame = new JFrame("Background Object Separation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

         JLabel originalLabel = new JLabel(new ImageIcon(originalImage));
        JLabel resultLabel = new JLabel(new ImageIcon(resultImage));
        
        frame.add(originalLabel);
        frame.add(resultLabel);

        frame.pack();
        frame.setVisible(true);
    }
}
