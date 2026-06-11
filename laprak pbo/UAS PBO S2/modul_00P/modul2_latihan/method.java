class method{

        data objData=new data
        (2000,1000,500,"bolpoint","pensil","penghapus",10);

        public int hargaBolpoint(){
            return objData.getStock()*objData.getHargaBolpoint();
        }
        public int hargaPensil(){
            return objData.getStock()*objData.getHargaPensil();
        }
        public int hargaPenghapus(){
            return objData.getStock()*objData.getHargaPenghapus();
        }
}
