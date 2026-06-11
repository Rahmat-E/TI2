package Final1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ContourDetection {
    public static void main(String[] args) {
        try {
            // Muat gambar hasil filtering
            BufferedImage filteredImage = ImageIO.read(new File("filtered_image_hsv.jpg"));

            // Pastikan gambar berhasil dimuat
            if (filteredImage == null) {
                System.out.println("Gambar tidak dapat dimuat!");
                return;
            }

            // Deteksi tepi dan temukan bounding box
            BufferedImage contourImage = detectBoundingBox(filteredImage);

            // Simpan hasil
            ImageIO.write(contourImage, "jpg", new File("contour_image.jpg"));
            System.out.println("Gambar hasil kontur disimpan sebagai 'contour_image.jpg'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage detectBoundingBox(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage contourImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Salin gambar asli ke gambar kontur
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                contourImage.setRGB(x, y, image.getRGB(x, y));
            }
        }

        // Matriks kernel untuk deteksi tepi Sobel
        int[][] sobelX = {
            { -1, 0, 1 },
            { -2, 0, 2 },
            { -1, 0, 1 }
        };
        int[][] sobelY = {
            { -1, -2, -1 },
            { 0, 0, 0 },
            { 1, 2, 1 }
        };

        // Variabel untuk menyimpan batas-batas bounding box
        int minX = width, minY = height, maxX = 0, maxY = 0;

        // Aplikasi deteksi tepi Sobel
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                int gx = 0;
                int gy = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int rgb = image.getRGB(x + j, y + i);
                        int gray = (rgb >> 16) & 0xFF;
                        gx += sobelX[i + 1][j + 1] * gray;
                        gy += sobelY[i + 1][j + 1] * gray;
                    }
                }

                int edgeMagnitude = (int) Math.sqrt(gx * gx + gy * gy);
                if (edgeMagnitude > 128) {
                    contourImage.setRGB(x, y, Color.RED.getRGB());
                    if (x < minX) minX = x;
                    if (y < minY) minY = y;
                    if (x > maxX) maxX = x;
                    if (y > maxY) maxY = y;
                }
            }
        }

        // Gambar bounding box
        for (int x = minX; x <= maxX; x++) {
            contourImage.setRGB(x, minY, Color.RED.getRGB());
            contourImage.setRGB(x, maxY, Color.RED.getRGB());
        }
        for (int y = minY; y <= maxY; y++) {
            contourImage.setRGB(minX, y, Color.RED.getRGB());
            contourImage.setRGB(maxX, y, Color.RED.getRGB());
        }

        return contourImage;
    }
}
