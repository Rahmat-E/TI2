package coba;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ICF_hsv {
    public static void main(String[] args) {
        try {
            
            BufferedImage image = ImageIO.read(new File("C:\\Users\\r687e\\Desktop\\PBO_UTSUAS\\enhanced_colors_image.jpg"));
    
            
            BufferedImage filteredImage = colorFiltering(image);
            ImageIO.write(filteredImage, "jpg", new File("filtered_image_hsv.jpg")); 
            
            System.out.println("gmbar baru :  'filtered_image_hsv.jpg'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
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
    
                double[] hsv = rgbToHsv(red, green, blue);
    
                // jika red/blue/yellw/green/orange =warna tetap;
                // jika waran selain itu maka di jadikan hitam
                if (isRed(hsv) || isBlue(hsv) || isYellow(hsv) || isGreen(hsv) || isOrange(hsv)) {
                    filteredImage.setRGB(x, y, rgb);
                } else {
                    filteredImage.setRGB(x, y, 0x000000); 
                }
            }
        }
        return filteredImage;
    }
    
    private static double[] rgbToHsv(int red, int green, int blue) {
        double r = red / 255;
        double g = green / 255;
        double b = blue / 255;
    
        double []rgbD={red,green,blue};
    
        double max=rgbD[0]; 
        for(int i=0;i<rgbD.length-1;i++){
            if(max<rgbD[i+1]){
                max=rgbD[i+1];
            }
        }
        double min=rgbD[0]; 
        for(int i=0;i<2;i++){
            if(min>rgbD[i+1]){
                min=rgbD[i+1];
            }
        }
        double delta = max - min;
    
        double hue = 0;
        if (delta != 0) {
            if (max == r) {
                hue = 60 * (((g - b) / delta) % 6);
            } else if (max == g) {
                hue = 60 * (((b - r) / delta) + 2);
            } else {
                hue = 60 * (((r - g) / delta) + 4);
            }
        }
    
        if (hue < 0) {
            hue += 360;
        }
    
        double saturation = (max == 0) ? 0 : (delta / max);
        double value = max;
    
        return new double[]{hue, saturation, value};
    }
    
    private static boolean isRed(double[] hsv) {
        return (hsv[0] >= 0 && hsv[0] <= 10 || hsv[0] >= 350 && hsv[0] <= 360) && hsv[1] >= 0.5 && hsv[2] >= 0.5;
    }
    
    private static boolean isBlue(double[] hsv) {
        return hsv[0] >= 180 && hsv[0] <= 240 && hsv[1] >= 0.5 && hsv[2] >= 0.3;
    }
    
    private static boolean isYellow(double[] hsv) {
        return hsv[0] >= 10 && hsv[0] <= 65 && hsv[1] >= 0.7 && hsv[2] >= 0.75;
    }
    
    private static boolean isGreen(double[] hsv) {
        return hsv[0] >= 85 && hsv[0] <= 140 && hsv[1] >= 0.5 && hsv[2] >= 0.3;
    }
    
    private static boolean isOrange(double[] hsv) {
        return hsv[0] >= 15 && hsv[0] <= 40 && hsv[1] >= 0.5 && hsv[2] >= 0.5;
    }
}