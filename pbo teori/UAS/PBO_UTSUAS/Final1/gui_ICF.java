package Final1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class gui_ICF extends JFrame {
    private JLabel originalImageLabel;
    private JLabel filteredImageLabel;
    private BufferedImage originalImage;
    private BufferedImage filteredImage;

    public gui_ICF() {
        setTitle("Image Color Filtering");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel(new GridLayout(1, 2));
        originalImageLabel = new JLabel();
        filteredImageLabel = new JLabel();
        imagePanel.add(originalImageLabel);
        imagePanel.add(filteredImageLabel);
        add(imagePanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton loadButton = new JButton("Load Image");
        JButton processButton = new JButton("Process Image");
        controlPanel.add(loadButton);
        controlPanel.add(processButton);
        add(controlPanel, BorderLayout.SOUTH);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processImage();
            }
        });

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                originalImage = ImageIO.read(file);
                ImageIcon icon = new ImageIcon(resizeImage(originalImage, 400, 400)); // Resize the image to fit the label
                originalImageLabel.setIcon(icon);
                filteredImageLabel.setIcon(null);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void processImage() {
        if (originalImage != null) {
            filteredImage = colorFiltering(originalImage);
            ImageIcon icon = new ImageIcon(resizeImage(filteredImage, 400, 400)); // Resize the filtered image to fit the label
            filteredImageLabel.setIcon(icon);
        } else {
            JOptionPane.showMessageDialog(this, "Please load an image first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private BufferedImage colorFiltering(BufferedImage image) {
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

                if (isRed(hsv) || isBlue(hsv) || isYellow(hsv) || isGreen(hsv) || isOrange(hsv)) {
                    filteredImage.setRGB(x, y, rgb);
                } else {
                    filteredImage.setRGB(x, y, 0x000000);
                }
            }
        }
        return filteredImage;
    }

    private double[] rgbToHsv(int red, int green, int blue) {
        double r = red / 255.0;
        double g = green / 255.0;
        double b = blue / 255.0;

        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g, b));
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

    private boolean isRed(double[] hsv) {
        return (hsv[0] >= 0 && hsv[0] <= 10 || hsv[0] >= 350 && hsv[0] <= 360) && hsv[1] >= 0.5 && hsv[2] >= 0.5;
    }

    private boolean isBlue(double[] hsv) {
        return hsv[0] >= 180 && hsv[0] <= 240 && hsv[1] >= 0.5 && hsv[2] >= 0.3;
    }

    private boolean isYellow(double[] hsv) {
        return hsv[0] >= 10 && hsv[0] <= 65 && hsv[1] >= 0.7 && hsv[2] >= 0.75;
    }

    private boolean isGreen(double[] hsv) {
        return hsv[0] >= 85 && hsv[0] <= 140 && hsv[1] >= 0.5 && hsv[2] >= 0.3;
    }

    private boolean isOrange(double[] hsv) {
        return hsv[0] >= 15 && hsv[0] <= 40 && hsv[1] >= 0.5 && hsv[2] >= 0.5;
    }

    private Image resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(resultingImage, 0, 0, null);
        g2d.dispose();
        return outputImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gui_ICF().setVisible(true);
            }
        });
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

                if (isRed(red, green, blue) || isBlue(red, green, blue) || isYellow(red, green, blue) || isGreen(red, green, blue) || isOrange(red, green, blue)) {
                    filteredImage.setRGB(x, y, rgb);
                } else {
                    filteredImage.setRGB(x, y, 0x000000);
                }
            }
        }

        return filteredImage;
    }

    private static boolean isRed(int red, int green, int blue) {
        return red > 150 && green < 100 && blue < 100;
    }

    private static boolean isBlue(int red, int green, int blue) {
        return blue > 150 && red < 100 && green < 100;
    }

    private static boolean isYellow(int red, int green, int blue) {
        return red > 150 && green > 150 && blue < 100;
    }

    private static boolean isGreen(int red, int green, int blue) {
        return green > 150 && red < 100 && blue < 100;
    }

    private static boolean isOrange(int red, int green, int blue) {
        return red > 200 && green > 100 && blue < 100;
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(resultingImage, 0, 0, null);
        g2d.dispose();
        return outputImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gui_ICF().setVisible(true);
            }
        });
    }
}
