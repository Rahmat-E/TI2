package Final1;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ColorEnhancement {

    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\toyooka.jpg"));

            BufferedImage result = enhanceColors(image);

            ImageIO.write(result, "jpg", new File("enhanced_colors_image.jpg"));
            System.out.println("Color enhancement completed successfully.: 'enhanced_colors_image.jpg'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage enhanceColors(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);

                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                int[] roundedColors = roundColors(red, green, blue);

                int newPixel = (roundedColors[0] << 16) | (roundedColors[1] << 8) | roundedColors[2];
                result.setRGB(x, y, newPixel);
            }
        }

        return result;
    }

    public static int[] roundColors(int red, int green, int blue) {
        int newRed = roundToNearestColor(red);
        int newGreen = roundToNearestColor(green);
        int newBlue = roundToNearestColor(blue);
        return new int[]{newRed, newGreen, newBlue};
    }

    public static int roundToNearestColor(int value) {
        if (value > 127) {
            return 255;
        } else {
            return 0;
        }
    }
}
