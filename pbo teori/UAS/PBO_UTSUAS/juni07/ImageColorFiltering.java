package juni07;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageColorFiltering {
    // Constants for RGB values of colors
    private static final int RED = 0xFF0000;
    private static final int BLUE = 0x0000FF;
    private static final int YELLOW = 0xFFFF00;
    private static final int GREEN = 0x00FF00;
    private static final int ORANGE = 0xFFA500;
    
    public static void main(String[] args) {
        try {
            // Load the image from the directory
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\turn.jpg"));
            
            // Color filtering
            BufferedImage filteredImage = colorFiltering(image);
            ImageIO.write(filteredImage, "jpg", new File("filtered_image.jpg")); // Save filtered image
            
            System.out.println("Image filtering completed. Filtered image saved as 'filtered_image.jpg'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static BufferedImage colorFiltering(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage filteredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                
                // Apply color filtering based on RGB values
                if (isRed(red, green, blue) || isBlue(red, green, blue) || isYellow(red, green, blue) || isGreen(red, green, blue) || isOrange(red, green, blue)) {
                    filteredImage.setRGB(x, y, rgb);
                } else {
                    filteredImage.setRGB(x, y, 0x000000); // Set non-relevant colors to black
                }
            }
        }
        
        return filteredImage;
    }
    
    private static boolean isRed(int red, int green, int blue) {
        return red > 150 && green < 100 && blue < 100;
    }
    
    private static boolean isBlue(int red, int green, int blue) {
        return blue > 150 && red < 100 && green < 100;
    }
    
    private static boolean isYellow(int red, int green, int blue) {
        return red > 150 && green > 150 && blue < 100;
    }
    
    private static boolean isGreen(int red, int green, int blue) {
        return green > 150 && red < 100 && blue < 100;
    }
    
    private static boolean isOrange(int red, int green, int blue) {
        return red > 200 && green > 100 && blue < 100;
    }
}
