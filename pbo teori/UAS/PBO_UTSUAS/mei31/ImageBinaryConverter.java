package mei31;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBinaryConverter {

    // Fungsi untuk mengubah gambar ke mode biner berdasarkan warna tertentu
    public static BufferedImage convertToBinary(BufferedImage image, String color) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage binaryImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;
                
                // Transformasi ke biner berdasarkan warna tertentu
                boolean isTargetColor = false;
                switch (color.toLowerCase()) {
                    case "red":
                        isTargetColor = (red > 100 && green < 100 && blue < 100);
                        break;
                    case "blue":
                        isTargetColor = (blue > 100 && red < 100 && green < 100);
                        break;
                    case "yellow":
                        isTargetColor = (red > 100 && green > 100 && blue < 100);
                        break;
                    case "orange":
                        isTargetColor = (red > 100 && green > 50 && green < 150 && blue < 100);
                        break;
                }
                // Putih untuk warna target, hitam untuk lainnya
                int binaryColor = isTargetColor ? 0xFFFFFF : 0x000000; 
                binaryImage.setRGB(x, y, binaryColor);
            }
        }
        return binaryImage;
    }

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\r687e\\Desktop\\Neatbeans21\\warning.jpg";
        String outputPath = "path/to/output_binary_image.jpg";
        String color = "yellow"; // Ubah sesuai dengan warna yang diinginkan: red, blue, yellow,
        
        try {
            // Baca gambar dari file
            BufferedImage image = ImageIO.read(new File(imagePath));
            
            // Ubah gambar ke mode biner berdasarkan warna tertentu
            BufferedImage binaryImage = convertToBinary(image, color);
            
            // Pastikan direktori output ada
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            
            // Simpan gambar biner ke file
            ImageIO.write(binaryImage, "jpg", outputFile);
            
            System.out.println("Gambar biner berhasil disimpan di " + outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

