package inputImage;

import java.io.FileInputStream;
import java.io.IOException;

public class coba {
    public static void main(String[] args) {
        try {
            FileInputStream byteFile = new FileInputStream("C:/Users/r687e/Desktop/PBO_UTSUAS/inputImage/50km.jpg");

            System.out.println(byteFile.read());
            System.out.println(byteFile.read());
            System.out.println(byteFile.read());
            System.out.println(byteFile.read());

            byteFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
