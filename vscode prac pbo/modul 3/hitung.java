import java.util.Scanner;

public class hitung {
    double bil1,bil2;

    public hitung(double bil1, double bil2){
        this.bil1=bil1;
        this.bil2=bil2;
    }
    public double penjumlahan(){
        return bil1+bil2;
    }
    public double pengurangan(){
        return bil1-bil2;
    }
    public double perkalian(){
        return bil1*bil2;
    }
    public double pembagian(){
        return bil1/bil2;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("===== input x dan y =====");
        System.out.print("x : ");
        double bil1=Double.parseDouble(input.nextLine());
        System.out.print("y : ");
        double bil2=Double.parseDouble(input.nextLine());

        hitung operasi=new hitung(bil1,bil2);

        System.out.println("===== hasil operasi =====");
        System.out.println("Penjumlahan : "+operasi.penjumlahan());
        System.out.println("Pengurangan : "+operasi.pengurangan());
        System.out.println("Perkalian : "+operasi.perkalian());
        System.out.println("Pembagian : "+operasi.pembagian());
    }
}
