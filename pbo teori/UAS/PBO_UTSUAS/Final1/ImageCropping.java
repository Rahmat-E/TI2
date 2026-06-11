package Final1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageCropping {

    public static void main(String[] args) {
        try {
            // Baca gambar hasil pengolahan warna
            BufferedImage filteredImage = ImageIO.read(new File("filtered_image_hsv.jpg"));

            // Ambil ukuran gambar hasil pengolahan
            int width = filteredImage.getWidth();
            int height = filteredImage.getHeight();

            // Inisialisasi batas untuk cropping
            int x_min = width;   // x minimum
            int y_min = height;  // y minimum
            int x_max = 0;       // x maximum
            int y_max = 0;       // y maximum

            // Cari batas objek yang tidak hitam (non-hitam)
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = filteredImage.getRGB(x, y);
                    if (rgb != 0x000000) {  // jika bukan hitam
                        // Update batas
                        if (x < x_min) x_min = x;
                        if (x > x_max) x_max = x;
                        if (y < y_min) y_min = y;
                        if (y > y_max) y_max = y;
                    }
                }
            }

            // Hitung ukuran objek
            int objWidth = x_max - x_min + 1;
            int objHeight = y_max - y_min + 1;

            // Periksa aspek rasio objek dan tentukan ukuran cropping
            int cropSize = Math.min(objWidth, objHeight);
            int cropX = x_min + (objWidth - cropSize) / 2;
            int cropY = y_min + (objHeight - cropSize) / 2;

            // Potong objek menjadi ukuran 100x100 piksel
            BufferedImage croppedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            croppedImage.getGraphics().drawImage(filteredImage, 0, 0, 100, 100, cropX, cropY, cropX + cropSize, cropY + cropSize, null);

            // Simpan gambar hasil cropping
            ImageIO.write(croppedImage, "jpg", new File("cropped_object.jpg"));

            System.out.println("Objek yang dipotong berhasil disimpan sebagai 'cropped_object.jpg'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
