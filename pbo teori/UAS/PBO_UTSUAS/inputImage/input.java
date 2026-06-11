package inputImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class input extends JFrame {
    private JLabel imageLabel;
    private JButton browseButton;

    public input() {
        super("Image Input Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        browseButton = new JButton("Browse");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        } else {
                            String filename = f.getName().toLowerCase();
                            return filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png") || filename.endsWith(".bmp") || filename.endsWith(".gif");
                        }
                    }

                    @Override
                    public String getDescription() {
                        return "Image Files (*.jpg, *.jpeg, *.png, *.bmp, *.gif)";
                    }
                });

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage bufferedImage = ImageIO.read(selectedFile);
                        ImageIcon imageIcon = new ImageIcon(bufferedImage);
                        imageLabel.setIcon(imageIcon);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(browseButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new input().setVisible(true);
            }
        });
    }
}
