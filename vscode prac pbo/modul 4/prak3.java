public class prak3 {
    private String username;
    private String password;
    // method getter
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    // method setter
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        prak3 obj=new prak3();
        // menggunakan method setter
        obj.setUsername("black pink");
        obj.setPassword("TeknikInformatika");
        // menggunakan method getter
        System.out.println("Username: "+ obj.getUsername());
        System.out.println("Password: "+ obj.getPassword());
    }
}

//Apakah program-3 berjalan dengan baik ? Analisa dan jelaskan mengapa demikian!
// iya program dapat berjalan dengan baik karena obj mendapatkan nilai variabel melalui metode setter & Getter tanpa membutuhkan akses langsung ke variabel private
