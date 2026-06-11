package Shape;
import java.util.Scanner;

public class sudut {

    public static String warna(int sudut1, int sudut2, int sudut3, int sudut4) {
        
        if (sudut1 == 360 && sudut2 == 360 && sudut3 == 360 && sudut4 == 360) {
            return "lingkaran";
        }else if (sudut1 == 90 && sudut2 == 90 && sudut3 == 90 && sudut4 == 90) {
            return "segi empat";
        }
                else if (sudut1 + sudut2 + sudut3 == 180 && sudut4 == 0) {
            return "segitiga";
        }
        else if (sudut1 == 135 && sudut2 == 135 && sudut3 == 135 && sudut4 == 135) {
            return "segi 8";
        }
        else if (sudut1 == 110 && sudut2 == 70 && sudut3 == 110 && sudut4 == 70) {
            return "diamond";
        }
        else {
            return "shape not detected";
        }
    }

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter four angles of the shape (enter 0 for the fourth angle if it's a triangle):");
        int sudut1 = scanner.nextInt();
        int sudut2 = scanner.nextInt();
        int sudut3 = scanner.nextInt();
        int sudut4 = scanner.nextInt();

        String result = warna(sudut1, sudut2, sudut3, sudut4);
        System.out.println("hasil: " + result);

        scanner.close();
    }
}
