package COLOR;

public class COLOR {
    public static void main(String[] args) {
        getRGB getrgb = new getRGB();
        int[] avgRGB = getrgb.getAvgRGB();

        int Red = avgRGB[0];
        int Green = avgRGB[1];
        int Blue = avgRGB[2];
        System.out.println(Red+" , "+Green+" , "+Blue);
        // Konversi RGB ke rentang 0-1
        double red = Red / 255.0;
        double green = Green / 255.0;
        double blue = Blue / 255.0;

        // mencari nilai max min
        double[] rgb = {red, green, blue};
        System.out.println("nilai red setelah dikonversi 0-1: " + rgb[0]);
        System.out.println("nilai green setelah dikonversi 0-1: " + rgb[1]);
        System.out.println("nilai blue setelah dikonversi 0-1: " + rgb[2]);
        System.out.println();

        // menentukan nilai yang paling kecil di antara array rgb
        double MIN = rgb[0];
        for (int i = 0; i < 2; i++) {
            if (MIN > rgb[i + 1]) {
                MIN = rgb[i + 1];
            }
        }
        System.out.println("nilai Cmin: " + MIN);

        // menentukan nilai yang paling besar di antara array rgb
        double MAX = rgb[0];
        for (int i = 0; i < rgb.length - 1; i++) {
            if (MAX < rgb[i + 1]) {
                MAX = rgb[i + 1];
            }
        }
        System.out.println("nilai Cmax: " + MAX);
        double delta = MAX - MIN;
        System.out.println();

        // menghitung hue
        double[] hsv = new double[3];
        if (delta == 0) {
            hsv[0] = 0;
        } else if (MAX == red) {
            hsv[0] = 60 * ((((green - blue) / delta) % 6));
        } else if (MAX == green) {
            hsv[0] = 60 * (((blue - red) / delta) + 2);
        } else {
            hsv[0] = 60 * (((red - green) / delta) + 4);
        }
        if (hsv[0] < 0) {
            hsv[0] += 360;
        }
        System.out.println("nilai hue: " + hsv[0]);

        // mencari nilai saturation
        if (MAX == 0) {
            hsv[1] = 0;
        } else {
            hsv[1] = delta / MAX;
        }
        System.out.println("nilai saturation: " + hsv[1]);

        // nilai value
        hsv[2] = MAX;
        System.out.println("value: " + hsv[2]);

        // menentukan warna
        if ((hsv[0] >= 0 && hsv[0] <= 10) || ((hsv[0] >= 350 && hsv[0] <= 360)) && (hsv[1] >= 0.5 && hsv[1] <= 1) && (hsv[2] >= 0.5 && hsv[2] <= 1)) {
            System.out.println("Warna terdeteksi: Merah");
        } else if ((hsv[0] >= 10 && hsv[0] <= 65) && (hsv[1] >= 0.7 && hsv[1] <= 1) && (hsv[2] > 0.75 && hsv[2] <= 1)) {
            System.out.println("Warna terdeteksi: kuning/orange");
        } else if ((hsv[0] >= 180 && hsv[0] <= 240) && (hsv[1] >= 0.5 && hsv[1] <= 1) && (hsv[2] > 0.3 && hsv[2] <= 1)) {
            System.out.println("Warna terdeteksi: biru");
        } else if ((hsv[0] >= 0 && hsv[0] <= 360) && (hsv[1] >= 0 && hsv[1] <= 0.1) && (hsv[2] > 0.9 && hsv[2] <= 1)) {
            System.out.println("Warna terdeteksi: putih");
        } else {
            System.out.println("Warna terdeteksi: belum");
        }
    }
}
