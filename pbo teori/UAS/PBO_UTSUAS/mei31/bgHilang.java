package mei31;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bgHilang {

    // Fungsi untuk mengubah gambar dengan mempertahankan warna tertentu dan membuat latar belakang transparan
    public static BufferedImage retainColorAndMakeBackgroundTransparent(BufferedImage image, String color) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage processedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                boolean isTargetColor = false;
                switch (color.toLowerCase()) {
                    case "red":
                        isTargetColor = (red > 100 && green < 100 && blue < 100);
                        break;
                    case "blue":
                        isTargetColor = (blue > 100 && red < 150 && green < 150);
                        break;
                    case "yellow":
                        isTargetColor = (red > 150 && green > 150 && blue < 100);
                        break;
                    case "amber":
                        isTargetColor = (red > 150 && green > 100 && green < 200 && blue < 150);
                        break;
                }

                if (isTargetColor) {
                    processedImage.setRGB(x, y, pixel);
                } else {
                    processedImage.setRGB(x, y, 0x00000000); // Transparan
                }
            }
        }
        return processedImage;
    }

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\r687e\\Desktop\\Neatbeans21\\stop2.jpg";
        String outputPath = "C:\\Users\\r687e\\Desktop\\Neatbeans21\\output_transparent.png";
        String color = "red"; // Ubah sesuai dengan warna yang diinginkan: red, blue, yellow, amber

        try {
            // Baca gambar dari file
            BufferedImage image = ImageIO.read(new File(imagePath));
            
            // Ubah gambar dengan mempertahankan warna tertentu dan membuat latar belakang transparan
            BufferedImage processedImage = retainColorAndMakeBackgroundTransparent(image, color);
            
            // Pastikan direktori output ada
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            
            // Simpan gambar yang telah diproses ke file
            ImageIO.write(processedImage, "png", outputFile);
            
            System.out.println("Gambar dengan latar belakang transparan berhasil disimpan di " + outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

