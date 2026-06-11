import java.util.Scanner;

public class tugasMain {
    public static void main(String[] args) {
        tugas obj=new tugas();
        kali hitung=new kali();
        Scanner input=new Scanner(System.in);
        
        System.out.println("===== INPUT PEMBELIAN BUKU ======");
        System.out.print("Judul Buku : ");
        String inputJudul=input.nextLine();
        obj.setJudulBuku(inputJudul);
        System.out.print("Pengarang : ");
        String inputPengarang=input.nextLine();
        obj.setPengarang(inputPengarang);
        System.out.print("Harga Buku : ");
        int inputHarga=Integer.parseInt(input.nextLine());
        obj.setHargaBuku(inputHarga);
        System.out.print("Jumlah Pembelian : ");
        int inputJumlahPembelian=Integer.parseInt(input.nextLine());
        obj.setJumlahPembelian(inputJumlahPembelian);

        System.out.println("===== DATA PEMBELIAN =====");
        System.out.println("Judul Buku : "+obj.getJudulBuku());
        System.out.println("Pengarang : "+obj.getPengarang());
        System.out.println("Harga Buku (Rp) : "+ obj.getHargaBuku());
        System.out.println("Jumlah Pembelian : "+obj.getJumlahPembelian());

        System.out.println("====== TOTAL PEMBELAJARAN =====");
        System.out.println("TOTAL (Rp) : "+hitung.kali(obj.getHargaBuku(),obj.getJumlahPembelian()));
    }
}
