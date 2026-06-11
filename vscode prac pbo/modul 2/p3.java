import javax.swing.JOptionPane;

public class p3 {
    public static void main(String[] args) {
        String nama,prodi,fakultas;
        nama=JOptionPane.showInputDialog("nama : ");
        prodi=JOptionPane.showInputDialog("prodi : ");
        fakultas=JOptionPane.showInputDialog("fakultas : ");
        String msg="nama : "+nama+"\nprodi : "+prodi+"\nfakultas : "+fakultas;
        JOptionPane.showMessageDialog(null, msg);
    }
}
