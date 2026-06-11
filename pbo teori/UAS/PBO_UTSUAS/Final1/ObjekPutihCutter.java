package Final1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjekPutihCutter {
    private BufferedImage image;
    private int width;
    private int height;

    public ObjekPutihCutter(String imagePath) throws IOException {
        this.image = ImageIO.read(new File(imagePath));
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public void potongObjekPutih(String outputPath) throws IOException {
        int xStart = -1, yStart = -1, xEnd = -1, yEnd = -1;

        // Cari koordinat awal dan akhir dari objek putih
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                if (pixel == 0xFFFFFFFF) { // Putih dalam RGB
                    if (xStart == -1) {
                        xStart = x;
                        yStart = y;
                    }
                    xEnd = x;
                    yEnd = y;
                }
            }
        }

        if (xStart != -1 && yStart != -1 && xEnd != -1 && yEnd != -1) {
            // Hitung ukuran objek yang akan dipotong
            int objWidth = xEnd - xStart;
            int objHeight = yEnd - yStart;

            // Potong menjadi potongan berukuran 
            int targetSize = 250;
            int startX = Math.max(0, xStart - (targetSize - objWidth) / 2);
            int startY = Math.max(0, yStart - (targetSize - objHeight) / 2);

            BufferedImage objImage = image.getSubimage(startX, startY, Math.min(targetSize, objWidth), Math.min(targetSize, objHeight));

            // Simpan gambar objek putih yang dipotong
            File outputFile = new File(outputPath);
            ImageIO.write(objImage, "jpg", outputFile);
            System.out.println("Objek putih berhasil dipotong dan disimpan di " + outputPath);
        } else {
            System.out.println("Tidak ada objek putih yang ditemukan untuk dipotong.");
        }
    }

    public static void main(String[] args) {
        String inputImagePath = "path/to/output_binary_image.jpg";
        String outputImagePath = "path/to/cut_white_object.jpg";

        try {
            ObjekPutihCutter cutter = new ObjekPutihCutter(inputImagePath);
            cutter.potongObjekPutih(outputImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

