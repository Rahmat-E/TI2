 class Mahasiswa {
    String nama;
    String jurusan;
}
public class Kelasku {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1=new Mahasiswa();
        mahasiswa1.nama="cinta laura";
        mahasiswa1.jurusan="Ekonomi";
        Mahasiswa mahasiswa2 =new Mahasiswa();
        mahasiswa2.nama="miley cyrus";
        mahasiswa2.jurusan="Teknik Elektro";
        System.out.println("nama mahasiswa: "+mahasiswa1.nama);
        System.out.println("jurusan: "+mahasiswa1.jurusan);
        System.out.println("nama mahasiswa: "+mahasiswa2.nama);
        System.out.println("jurusan: "+mahasiswa2.jurusan);
    }
}