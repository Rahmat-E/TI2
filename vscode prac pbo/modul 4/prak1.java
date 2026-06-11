class data{
    public String username;
    public String password;

}
public class prak1 {
    public static void main(String[] args) {
        data obj=new data();
        // menggunakan method setter
        obj.username="blackpink";
        obj.password="praktikum1";
        // menggnunakan method getter
        System.out.println("username: "+obj.username);
        System.out.println("password: "+obj.password);
    }
}

// Apakah program-1 berjalan dengan baik ?
// iya