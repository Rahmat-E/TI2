package COLOR;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class getRGB {

    private int[] avgRGB;

    public getRGB() {
        BufferedImage image = null;
        try {
            File file = new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\stop2.jpg");
            image = ImageIO.read(file);
            this.avgRGB = colorSegmentation(image);
        } catch (IOException e) {
            e.printStackTrace();
            this.avgRGB = new int[]{0, 0, 0};
        }
    }

    public int[] getAvgRGB() {
        return this.avgRGB;
    }

    private static int[] colorSegmentation(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        // Menghitung total nilai RGB dari semua piksel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                totalRed += (pixel >> 16) & 0xFF;
                totalGreen += (pixel >> 8) & 0xFF;
                totalBlue += pixel & 0xFF;
            }
        }

        // Menghitung rata-rata nilai RGB
        int totalPixels = width * height;
        int avgRed = totalRed / totalPixels;
        int avgGreen = totalGreen / totalPixels;
        int avgBlue = totalBlue / totalPixels;

        return new int[]{avgRed, avgGreen, avgBlue};
    }
}
