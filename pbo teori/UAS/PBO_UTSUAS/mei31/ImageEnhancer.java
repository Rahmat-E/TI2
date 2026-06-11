package mei31;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class ImageEnhancer {

    // Fungsi untuk menghilangkan noise menggunakan mean filter
    public static BufferedImage denoiseImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        int kernelSize = 3;
        int edge = kernelSize / 2;

        for (int y = edge; y < height - edge; y++) {
            for (int x = edge; x < width - edge; x++) {
                int sumRed = 0, sumGreen = 0, sumBlue = 0;

                for (int ky = -edge; ky <= edge; ky++) {
                    for (int kx = -edge; kx <= edge; kx++) {
                        int pixel = image.getRGB(x + kx, y + ky);
                        Color color = new Color(pixel);
                        sumRed += color.getRed();
                        sumGreen += color.getGreen();
                        sumBlue += color.getBlue();
                    }
                }

                int numPixels = kernelSize * kernelSize;
                int avgRed = sumRed / numPixels;
                int avgGreen = sumGreen / numPixels;
                int avgBlue = sumBlue / numPixels;

                Color newColor = new Color(avgRed, avgGreen, avgBlue);
                result.setRGB(x, y, newColor.getRGB());
            }
        }
        return result;
    }

    // Fungsi untuk meningkatkan kontras menggunakan histogram equalization
    public static BufferedImage enhanceContrast(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        int[] histogram = new int[256];
        int[] lut = new int[256];

        // Buat histogram
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel);
                int brightness = (int) (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());
                histogram[brightness]++;
            }
        }

        // Buat cumulative distribution function (CDF)
        int sum = 0;
        for (int i = 0; i < histogram.length; i++) {
            sum += histogram[i];
            lut[i] = (int) ((sum * 255.0) / (width * height));
        }

        // Terapkan LUT pada gambar
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel);
                int red = lut[color.getRed()];
                int green = lut[color.getGreen()];
                int blue = lut[color.getBlue()];

                Color newColor = new Color(red, green, blue);
                result.setRGB(x, y, newColor.getRGB());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\r687e\\Desktop\\Neatbeans21\\toyooka.jpg";
        String outputPath = "C:\\Users\\r687e\\Desktop\\Neatbeans21\\output_enhanced.jpg";

        try {
            // Baca gambar dari file
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Hilangkan noise
            BufferedImage denoisedImage = denoiseImage(image);

            // Tingkatkan kontras
            BufferedImage enhancedImage = enhanceContrast(denoisedImage);

            // Pastikan direktori output ada
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();

            // Simpan gambar yang telah ditingkatkan kualitasnya ke file
            ImageIO.write(enhancedImage, "jpg", outputFile);

            System.out.println("Gambar yang telah ditingkatkan kualitasnya berhasil disimpan di " + outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

