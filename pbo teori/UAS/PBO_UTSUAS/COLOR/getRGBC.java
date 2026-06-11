package COLOR;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class getRGBC{
    public static void main(String[] args) {
        // Path ke file gambar
        String imagePath = "C:\\Users\\r687e\\Desktop\\PBO_UTSUAS\\stop.jpg"; 

        // Koordinat piksel yang ingin Anda ambil nilai RGB-nya
        int x = 100;
        int y = 100;

        try {
            // Baca gambar
            File file = new File(imagePath);
            BufferedImage image = ImageIO.read(file);

            // Ambil nilai RGB pada koordinat tertentu
            int pixel = image.getRGB(x, y);

            // Ekstrak nilai RGB
            int red = (pixel >> 16) & 0xFF;
            int green = (pixel >> 8) & 0xFF;
            int blue = pixel & 0xFF;

            // Cetak nilai RGB
            System.out.println("Nilai RGB di posisi (" + x + ", " + y + "): (" + red + ", " + green + ", " + blue + ")");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("gambar tidak terbaca");
        }
    }
}

