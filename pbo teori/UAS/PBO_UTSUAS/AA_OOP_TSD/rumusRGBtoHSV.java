package AA_OOP_TSD;

public class rumusRGBtoHSV {
    private int red;
    private int green;
    private int blue;
    public rumusRGBtoHSV() {
    }
    public rumusRGBtoHSV(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public int getRed() {
        return red;
    }
    public void setRed(int red) {
        this.red = red;
    }
    public int getGreen() {
        return green;
    }
    public void setGreen(int green) {
        this.green = green;
    }
    public int getBlue() {
        return blue;
    }
    public void setBlue(int blue) {
        this.blue = blue;
    }
    public double[] convert() {
        double r = red / 255.0;
        double g = green / 255.0;
        double b = blue / 255.0;
        double[] rgb = {r, g, b};
        double min = rgb[0];
        double max = rgb[0];
        for (int i = 1; i < rgb.length; i++) {
            if (min > rgb[i]) {
                min = rgb[i];
            }
            if (max < rgb[i]) {
                max = rgb[i];
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
}
