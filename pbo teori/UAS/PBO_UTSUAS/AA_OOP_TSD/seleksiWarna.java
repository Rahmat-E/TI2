package AA_OOP_TSD;

public class seleksiWarna {
    public static boolean isRed(double[] hsv) {
        return (hsv[0] >= 0 && hsv[0] <= 10 || hsv[0] >= 350 && hsv[0] <= 360) && hsv[1] >= 0.5 && hsv[2] >= 0.5;
    }
    public static boolean isBlue(double[] hsv) {
        return hsv[0] >= 180 && hsv[0] <= 240 && hsv[1] >= 0.5 && hsv[2] >= 0.3;
    }
    public static boolean isYellow(double[] hsv) {
        return hsv[0] >= 10 && hsv[0] <= 65 && hsv[1] >= 0.7 && hsv[2] >= 0.75;
    }
    public static boolean isGreen(double[] hsv) {
        return hsv[0] >= 85 && hsv[0] <= 140 && hsv[1] >= 0.5 && hsv[2] >= 0.3;
    }
    public static boolean isOrange(double[] hsv) {
        return hsv[0] >= 15 && hsv[0] <= 40 && hsv[1] >= 0.5 && hsv[2] >= 0.5;
    }
}
