package AA_OOP_TSD;

public class Main {
    public static void main(String[] args) {
        try {
            ImageProcessor processor = new ImageProcessor("C:\\Users\\r687e\\Desktop\\Neatbeans21\\double.jpg");
            processor.thresholding();
            processor.saveImage("hasil_colorFiltering.jpg");

            System.out.println("New image saved as 'hasil_colorFiltering.jpg'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
