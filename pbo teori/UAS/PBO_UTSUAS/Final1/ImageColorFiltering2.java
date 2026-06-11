package Final1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageColorFiltering2 {
    public static void main(String[] args) { 
        // 1. Metode Main untuk Memuat dan Menyimpan Gambar
        try {
            // input image
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\warning.jpg"));
            // output image
            BufferedImage filteredImage = colorFiltering(image);
            ImageIO.write(filteredImage, "jpg", new File("filtered_image.jpg")); // gambar tersimpan
            System.out.println("Berhasil !, output gambar: 'filtered_image.jpg'");
            // Crop the filtered image to include only the colored object
            BufferedImage croppedImage = cropToObject(filteredImage);
            ImageIO.write(croppedImage, "jpg", new File("cropped_image.jpg")); // gambar terpotong disimpan
            System.out.println("Berhasil !, output gambar terpotong: 'cropped_image.jpg'");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    // Penyaringan Warna
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
                
                if (isRed(red, green, blue) || isBlue(red, green, blue) || isYellow(red, green, blue) || isGreen(red, green, blue) || isOrange(red, green, blue)) {
                    filteredImage.setRGB(x, y, rgb);
                } else {
                    filteredImage.setRGB(x, y, 0x000000); // warna hitam
                }
            }
        }
        
        return filteredImage;
    }
    
    // Deteksi Warna
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
    
    // Metode untuk Memotong Bagian Hitam
    private static BufferedImage cropToObject(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        
        int minX = width, minY = height, maxX = 0, maxY = 0;
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                if (rgb != 0x000000) { // jika piksel bukan hitam
                    if (x < minX) minX = x;
                    if (y < minY) minY = y;
                    if (x > maxX) maxX = x;
                    if (y > maxY) maxY = y;
                }
            }
        }
        
        // Memastikan bahwa koordinat valid untuk pemotongan
        if (minX < maxX && minY < maxY) {
            return image.getSubimage(minX, minY, maxX - minX + 1, maxY - minY + 1);
        } else {
            // Jika tidak ada bagian berwarna ditemukan, kembalikan gambar asli
            return image;
        }
    }
}

