package modul_6.tugas2;

public class Polymorphism {
    public static void main(String[] args) {
        Piano pi =new Piano();
        pi.tampil();
        Biola bi =new Biola();
        bi.tampil();
        Gitar gt =new Gitar();
        gt.tampil();
        Drum dr =new Drum();
        dr.tampil();
        Saxaphone sx=new Saxaphone();
        sx.tampil();
        Trumpet tr=new Trumpet();
        tr.tampil();
    }
}


// class methodTampil sebagai superclass yang menyediakan method tampil()
//class Piano, Gitar, Biola, Drum, Saxaphone, dan Trumpet sebagai subclass(mewarisi class methodTampil) dan override method tampil() untuk print pesan
