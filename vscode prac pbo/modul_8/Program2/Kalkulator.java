package modul_8.Program2;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Kalkulator extends JFrame implements ActionListener{
    public JLabel label1, label2, label3;
    public JTextField text1, text2, text3;
    public JButton button1, button2, button3, button4;

    public Kalkulator() {
        label1 = new JLabel("Nilai A ");
        label1.setLocation(10, 10);
        label1.setSize(label1.getPreferredSize());
        text1 = new JTextField(20);
        text1.setLocation(10, 25);
        text1.setSize(text1.getPreferredSize());
        label2 = new JLabel("Nilai B ");
        label2.setLocation(10, 45);
        label2.setSize(label2.getPreferredSize());
        text2 = new JTextField(20);
        text2.setLocation(10, 60);
        text2.setSize(text2.getPreferredSize());
        label3 = new JLabel("Hasil Perhitungan A dan B");
        label3.setLocation(10, 90);
        label3.setSize(label3.getPreferredSize());
        text3 = new JTextField(20);
        text3.setLocation(10, 105);
        text3.setSize(text3.getPreferredSize());
        button1 = new JButton("Tambah");
        button1.setLocation(245, 10);
        button1.setSize(button1.getPreferredSize());
        button1.addActionListener(this);
        button1.setMnemonic('T');
        button2 = new JButton("Kurang");
        button2.setLocation(245, 40);
        button2.setSize(button2.getPreferredSize());
        button2.addActionListener(this);
        button2.setMnemonic('u');
        button3 = new JButton("Kali");
        button3.setLocation(245, 70);
        button3.setSize(button3.getPreferredSize());
        button3.addActionListener(this);
        button3.setMnemonic('K');
        button4 = new JButton("Bagi");
        button4.setLocation(245, 100);
        button4.setSize(button4.getPreferredSize());
        button4.addActionListener(this);
        button4.setMnemonic('B');
    }
        public void actionPerformed(ActionEvent ae) {
            double a = 0.0, b = 0.0, c = 0.0;
            // baca data dari textfield
            try {
            a = Double.parseDouble(text1.getText());
            b = Double.parseDouble(text2.getText());
            } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            }
            if (ae.getSource() == button1) {
            c = a + b;
            } else if (ae.getSource() == button2) {
            c = a - b;
            } else if (ae.getSource() == button3) {
            c = a * b;
            } else {
            c = a / b;
            }
            // menampilkan hasil pada textfield
            text3.setText(new String().valueOf(c));
            }
            
            public void tampilan() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new JFrame("Kalkulator");
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(label1);
                frame.getContentPane().add(text1);
                frame.getContentPane().add(label2);
                frame.getContentPane().add(text2);
                frame.getContentPane().add(label3);
                frame.getContentPane().add(text3);
                frame.getContentPane().add(button1);
                frame.getContentPane().add(button2);
                frame.getContentPane().add(button3);
                frame.getContentPane().add(button4);
                frame.setBounds(0, 0, 350, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                }
                public static void main(String[] args) throws Exception {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                Kalkulator app = new Kalkulator();
                app.tampilan();
            }
        });
    }
}

