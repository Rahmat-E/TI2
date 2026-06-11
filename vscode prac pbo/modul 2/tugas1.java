import java.util.Scanner;

public class tugas1 {
    static String nama,prodi,fakultas,nTugas,nUts,nUas;
    static Scanner input=new Scanner(System.in);
    static double dTugas,dUas,dUts,c;
    public static void main(String[] args) {
        
        System.out.println("=====input data=====");
        System.out.print("Nama : ");
        nama=input.nextLine();
        System.out.print("Prodi : ");
        prodi=input.nextLine();
        System.out.print("Fakultas : ");
        fakultas=input.nextLine();
        System.out.print("nilai tugas : ");
        nTugas=input.nextLine();
        System.out.print("nilai UTS : ");
        nUts=input.nextLine();
        System.out.print("nilai UAS : ");   
        nUas=input.nextLine();
        
        dTugas=Double.parseDouble(nTugas);
        dUts=Double.parseDouble(nUts);
        dUas=Double.parseDouble(nUas);

        System.out.println("=====cetak data=====");
        System.out.println("nama : "+nama);
        System.out.println("prodi : "+prodi);
        System.out.println("fakultas : "+fakultas);
        System.out.println("nilai prak/tugas : "+dTugas);
        System.out.println("nilai uts : "+dUts);
        System.out.println("nilai uas : "+dUas);

        System.out.println("=====nilai akhir=====");
        System.out.println("nilai akhir : "+nilaiAkhir());
    }

    static double nilaiAkhir(){
        c=(dTugas*0.3)+(dUts*0.3)+(dUas*0.4);
        return c;
    }
}
