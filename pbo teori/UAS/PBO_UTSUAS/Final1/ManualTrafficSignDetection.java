package Final1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ManualTrafficSignDetection {
    public static void main(String[] args) {
        try {
            // Muat gambar
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\50km.jpg"));
            if (image == null) {
                System.out.println("Gambar tidak dapat dimuat!");
                return;
            }

            // Konversi ke HSV dan terapkan pemfilteran warna
            BufferedImage mask = filterColor(image, 0, 10, 70, 255, 50, 255); // Filter warna merah

            // Deteksi kontur
            BufferedImage contourImage = findContours(mask);

            // Simpan hasil
            ImageIO.write(contourImage, "jpg", new File("output.jpg"));
            System.out.println("Proses selesai. Gambar hasil disimpan sebagai output.jpg.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Filter warna berdasarkan rentang HSV
    private static BufferedImage filterColor(BufferedImage image, int hMin, int hMax, int sMin, int sMax, int vMin, int vMax) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage mask = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                float[] hsv = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);

                int h = (int) (hsv[0] * 360);
                int s = (int) (hsv[1] * 255);
                int v = (int) (hsv[2] * 255);

                if (h >= hMin && h <= hMax && s >= sMin && s <= sMax && v >= vMin && v <= vMax) {
                    mask.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    mask.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        return mask;
    }

    // Temukan kontur dengan algoritma sederhana
    private static BufferedImage findContours(BufferedImage mask) {
        int width = mask.getWidth();
        int height = mask.getHeight();
        BufferedImage contourImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Salin gambar asli ke gambar kontur
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                contourImage.setRGB(x, y, mask.getRGB(x, y));
            }
        }

        // Deteksi tepi sederhana (deteksi perbedaan piksel tetangga)
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                if (isEdge(mask, x, y)) {
                    contourImage.setRGB(x, y, Color.RED.getRGB()); // Gambar tepi dengan warna merah
                }
            }
        }

        return contourImage;
    }

    // Cek apakah piksel adalah tepi
    private static boolean isEdge(BufferedImage mask, int x, int y) {
        int pixel = mask.getRGB(x, y);
        int left = mask.getRGB(x - 1, y);
        int right = mask.getRGB(x + 1, y);
        int up = mask.getRGB(x, y - 1);
        int down = mask.getRGB(x, y + 1);

        return pixel != left || pixel != right || pixel != up || pixel != down;
    }
}

