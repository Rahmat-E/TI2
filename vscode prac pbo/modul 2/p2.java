import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2 {
    public static void main(String[] args)  throws IOException {
        String nama,prodi,fakultas;
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        System.out.print("nama : ");
        nama=br.readLine();
        System.out.print("prodi : ");
        prodi=br.readLine();
        System.out.print("fakultas : ");
        fakultas=br.readLine();
    }
}