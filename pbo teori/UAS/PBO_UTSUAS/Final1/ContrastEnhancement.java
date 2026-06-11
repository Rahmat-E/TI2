package Final1;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ContrastEnhancement {

    public static void main(String[] args) {
        try {
            // Step 1: Prapemrosesan Citra
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\toyooka.jpg"));

            // Step 2: Peningkatan Kontras
            BufferedImage enhancedImage = histogramEqualization(image);

            // Step 3: Pengurangan Derau
            enhancedImage = applyGaussianBlur(enhancedImage);

            // Step 4: Penajaman Citra
            enhancedImage = applyUnsharpMask(enhancedImage);

            // Step 5: Penyimpanan Citra
            ImageIO.write(enhancedImage, "jpg", new File("enhanced_traffic_sign.jpg"));
            System.out.println("Image enhancement completed successfully: 'enhanced_traffic_sign.jpg'");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage histogramEqualization(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        int[][][] rgb = new int[3][width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                rgb[0][x][y] = (pixel >> 16) & 0xFF;
                rgb[1][x][y] = (pixel >> 8) & 0xFF;
                rgb[2][x][y] = pixel & 0xFF;
            }
        }

        for (int i = 0; i < 3; i++) {
            rgb[i] = equalizeChannel(rgb[i], width, height);
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = rgb[0][x][y];
                int green = rgb[1][x][y];
                int blue = rgb[2][x][y];
                int newPixel = (red << 16) | (green << 8) | blue;
                result.setRGB(x, y, newPixel);
            }
        }

        return result;
    }

    public static int[][] equalizeChannel(int[][] channel, int width, int height) {
        int[] histogram = new int[256];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                histogram[channel[x][y]]++;
            }
        }

        int[] cdf = new int[256];
        cdf[0] = histogram[0];
        for (int i = 1; i < 256; i++) {
            cdf[i] = cdf[i - 1] + histogram[i];
        }

        int cdfMin = 0;
        for (int i = 0; i < 256; i++) {
            if (cdf[i] != 0) {
                cdfMin = cdf[i];
                break;
            }
        }

        int totalPixels = width * height;
        int[] equalizedHistogram = new int[256];
        for (int i = 0; i < 256; i++) {
            equalizedHistogram[i] = (cdf[i] - cdfMin) * 255 / (totalPixels - cdfMin);
            if (equalizedHistogram[i] < 0) equalizedHistogram[i] = 0;
        }

        int[][] newChannel = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newChannel[x][y] = equalizedHistogram[channel[x][y]];
            }
        }

        return newChannel;
    }

    public static BufferedImage applyGaussianBlur(BufferedImage image) {
        float[] matrix = {
            1/16f, 1/8f, 1/16f,
            1/8f,  1/4f, 1/8f,
            1/16f, 1/8f, 1/16f
        };

        return applyConvolution(image, matrix);
    }

    public static BufferedImage applyUnsharpMask(BufferedImage image) {
        float[] blurMatrix = {
            1/16f, 1/8f, 1/16f,
            1/8f,  1/4f, 1/8f,
            1/16f, 1/8f, 1/16f
        };
        BufferedImage blurredImage = applyConvolution(image, blurMatrix);

        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int originalRGB = image.getRGB(x, y);
                int blurredRGB = blurredImage.getRGB(x, y);

                int r = Math.min(255, Math.max(0, ((originalRGB >> 16) & 0xFF) * 2 - ((blurredRGB >> 16) & 0xFF)));
                int g = Math.min(255, Math.max(0, ((originalRGB >> 8) & 0xFF) * 2 - ((blurredRGB >> 8) & 0xFF)));
                int b = Math.min(255, Math.max(0, (originalRGB & 0xFF) * 2 - (blurredRGB & 0xFF)));

                int newPixel = (r << 16) | (g << 8) | b;
                result.setRGB(x, y, newPixel);
            }
        }

        return result;
    }

    public static BufferedImage applyConvolution(BufferedImage image, float[] matrix) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, image.getType());

        int matrixSize = (int) Math.sqrt(matrix.length);
        int offset = matrixSize / 2;

        for (int y = offset; y < height - offset; y++) {
            for (int x = offset; x < width - offset; x++) {
                float r = 0, g = 0, b = 0;
                for (int dy = -offset; dy <= offset; dy++) {
                    for (int dx = -offset; dx <= offset; dx++) {
                        int rgb = image.getRGB(x + dx, y + dy);
                        float weight = matrix[(dy + offset) * matrixSize + (dx + offset)];

                        r += ((rgb >> 16) & 0xFF) * weight;
                        g += ((rgb >> 8) & 0xFF) * weight;
                        b += (rgb & 0xFF) * weight;
                    }
                }

                int newPixel = ((int) Math.min(255, Math.max(0, r)) << 16) |
                               ((int) Math.min(255, Math.max(0, g)) << 8) |
                               (int) Math.min(255, Math.max(0, b));
                result.setRGB(x, y, newPixel);
            }
        }

        return result;
    }
}
