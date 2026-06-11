package modul_6.program_1;

public class poliymorfisme {
    public static void main(String[] args) {
        Laptop lp = new Laptop();
        lp.tampil();
        PC pc = new PC();
        pc.tampil();
    }
}
// Perhatikan, analisa dan pahami program di atas, Morf/bentuk apa yang memiliki kesamaan? Apakah output menampilkan kesamaan?

//pada program 1: class Laptop dan PC keduanya  mewarisi dari kelas Komputer dan overridding method tampil();




