class Dec{
    final double phi=3.14;
    double tinggiTabung,jariJari;
    double panjang,lebar;
    double tinggiTrapesium, sBawah,sAtas;

    public void LuasTabung(){
        double luas;
        luas=(2*phi*jariJari)*(jariJari+tinggiTabung);
        System.out.println("luas tabung = "+luas);
    }
    public void LuasPersegiPanjang(){
        double luas;
        luas=panjang*lebar;
        System.out.println("luas persegi panjang = "+luas);
    }
    public void LuasTrapesium(){
        double luas;
        luas=0.5*(sBawah+sAtas)*tinggiTrapesium;
        System.out.println(" luas trapesium = "+luas);
    }
}
public class Tugas2 {
    public static void main(String[] args) {
        Dec tabung=new Dec();
        tabung.jariJari=5;
        tabung.tinggiTabung=9;
        tabung.LuasTabung();
        System.out.println("=================");
        Dec persegiPanjang=new Dec();
        persegiPanjang.panjang=32;
        persegiPanjang.lebar=34;
        persegiPanjang.LuasPersegiPanjang();
        System.out.println("=================");
        Dec trapesium=new Dec();
        trapesium.sAtas=14;
        trapesium.sBawah=43;
        trapesium.tinggiTrapesium=18;
        trapesium.LuasTrapesium();
    }
}