package AA_OOP_TSD;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageProcessor {
    private BufferedImage image;

    public ImageProcessor(String imagePath) throws Exception {
        this.image = ImageIO.read(new File(imagePath));
    }
    public void thresholding() {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage filteredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                rumusRGBtoHSV rgbHSV = new rumusRGBtoHSV();
                rgbHSV.setRed(red);
                rgbHSV.setGreen(green);
                rgbHSV.setBlue(blue);
                double[] hsv = rgbHSV.convert();

                if (seleksiWarna.isRed(hsv) || seleksiWarna.isBlue(hsv) || seleksiWarna.isYellow(hsv) || seleksiWarna.isGreen(hsv) || seleksiWarna.isOrange(hsv)) {
                    filteredImage.setRGB(x, y, rgb);
                } else {
                    filteredImage.setRGB(x, y, 0x000000);
                }
            }
        }
        this.image = filteredImage;
    }

    public void saveImage(String outputPath) throws Exception {
        ImageIO.write(image, "jpg", new File(outputPath));
    }
}
