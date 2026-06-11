class data{
    private String username;
    private String password;
}
public class prak2{
    public static void main(String[] args) {
        data obj=new data();
        // menggunakan method setter
        obj.username="rahmat";
        obj.password="TI123";
        // menggnunakan method getter
        System.out.println("username: "+obj.username);
        System.out.println("password: "+obj.password);
    }
}
// Apakah program-2 berjalan dengan baik ? Analisa dan jelaskan mengapa demikian!
// tidak, karena obj tidak dapat mengakses variabel luar method yang private, dapat di atasi dengan penggunakan setter & getter