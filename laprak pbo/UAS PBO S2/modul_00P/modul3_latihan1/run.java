import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        function func=new function();
        Scanner input =new Scanner(System.in);
        System.out.println("nilai rata-rata: "+func.Mean());
        System.out.println("nilai maksimum: "+func.Max());
        System.out.println("nilai minimum: "+func.Min());
        System.out.print("masukkan bilangan yang ingin di cari (3,4,5,6): ");
        int inputan=Integer.parseInt(input.nextLine());
        func.runArray();
        func.search(inputan);
        input.close();
    }
}
