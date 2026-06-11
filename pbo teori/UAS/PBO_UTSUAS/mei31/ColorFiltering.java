package mei31;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ColorFiltering {
    public static void main(String[] args) {
        try {
            // Memuat gambar input
            BufferedImage inputImage = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\30km.jpg"));

            // Melakukan penyaringan warna dan transformasi ke mode biner
            BufferedImage binaryImage = filterColorsToBinary(inputImage);

            // Menyimpan gambar hasil penyaringan
            ImageIO.write(binaryImage, "jpg", new File("binary_image.jpg"));
            System.out.println("Gambar hasil penyaringan berhasil disimpan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage filterColorsToBinary(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                if (isRed(red, green, blue) || isBlue(red, green, blue) || isYellow(red, green, blue) || isAmber(red, green, blue)) {
                    result.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    result.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        return result;
    }

    private static boolean isRed(int red, int green, int blue) {
        return red > 150 && green < 100 && blue < 100;
    }

    private static boolean isBlue(int red, int green, int blue) {
        return blue > 150 && green < 100 && red < 100;
    }

    private static boolean isYellow(int red, int green, int blue) {
        return red > 150 && green > 150 && blue < 100;
    }

    private static boolean isAmber(int red, int green, int blue) {
        return red > 200 && green > 100 && green < 200 && blue < 50;
    }
}
