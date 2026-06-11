public class tugas1 {
    final int x=10;

    public static void main(String[] args) {
        tugas1 myObj=new tugas1();
        myObj.x=25;
        System.out.println(myObj.x);
    }
}

// output dari kode diatas  adalah: error: cannot assign a value to final variable x myObj.x=25;
// output error karena kita memberi/merubah nilai pada variabel yang nilai nya  sudah final