public class Main {
    public static void main(String[] args) {
        method me=new method();
        data objData=new data(2000,1000,500,"bolpoint","pensil","penghapus",10);
        System.out.println("nama alat tulis: "+objData.getBolpoint());
        System.out.println("stock: "+objData.getStock());
        System.out.println("harga satuan: "+objData.getHargaBolpoint());
        System.out.println("harga bolpoint: "+me.hargaBolpoint());

    }
}
