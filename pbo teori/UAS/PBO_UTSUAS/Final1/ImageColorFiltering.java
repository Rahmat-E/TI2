package Final1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


// 1. Metode Main untuk Memuat dan Menyimpan Gambar
// 2. Metode colorFiltering untuk Penyaringan Warna
// 3. Metode isRed, isBlue, isYellow, isGreen, isOrange untuk Mengecek Warna

public class ImageColorFiltering {
    public static void main(String[] args) { 
    // 1. Metode Main untuk Memuat dan Menyimpan Gambar
        try {
            // input image
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\Neatbeans21\\toyooka.jpg"));
            // output image
            BufferedImage filteredImage = colorFiltering(image);
            ImageIO.write(filteredImage, "jpg", new File("filtered_image.jpg")); // gambar tersimpan
            System.out.println("");
            System.out.println("berhasil !,  output gambar:'filtered_image.jpg'");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
    
    //run gambar untuk mengambil warna RGB-nya.
    // Penyaringan Warna: Menggunakan metode isRed, isBlue, isYellow, isGreen, dan isOrange untuk menentukan apakah piksel termasuk salah satu warna yang diinginkan. Jika iya, piksel tersebut disimpan di gambar hasil penyaringan. Jika tidak, piksel diubah menjadi hitam
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
                } else {// warna tetap
                    filteredImage.setRGB(x, y, 0x000000);// warna hitam
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
