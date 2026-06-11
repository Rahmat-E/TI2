package modul_6.program_3;

public class polymorfOveride {
    public static void main(String[] args) {
    Hewan kucing = new Kucing();
    kucing.munculSuara();
    Hewan burung = new Burung();
    burung.munculSuara();
    }
}

//Morf/bentuk apa yang memiliki kesamaan? Apakah yang sama dan apakah yang berbeda???

// class Hewan sebagai superclass dan class Burung dan Kucing sebagai subclass

//Objek kucing memanggil metode munculSuara() dari kelas Kucing, sehingga outputnya adalah suara kucing

//Objek burung memanggil metode munculSuara() dari kelas Burung, sehingga outputnya adalah suara burung.
