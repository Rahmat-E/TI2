class data {
    public int hargaBolpoint;
    public int hargaPensil;
    public int hargaPenghapus;
    public String bolpoint;
    public String pensil;
    public String penghapus;
    public int stock;
    

    
    public data(int hargaBolpoint, int hargaPensil, int hargaPenghapus, String bolpoint, String pensil,
            String penghapus, int stock) {
        this.hargaBolpoint = hargaBolpoint;
        this.hargaPensil = hargaPensil;
        this.hargaPenghapus = hargaPenghapus;
        this.bolpoint = bolpoint;
        this.pensil = pensil;
        this.penghapus = penghapus;
        this.stock = stock;
    }
    public String getBolpoint() {
        return bolpoint;
    }
    public void setBolpoint(String bolpoint) {
        this.bolpoint = "bolpoint";
    }
    public String getPensil() {
        return pensil;
    }
    public void setPensil(String pensil) {
        this.pensil = "pensil";
    }
    public String getPenghapus() {
        return penghapus;
    }
    public void setPenghapus(String penghapus) {
        this.penghapus = "penghapus";
    }
    

    
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getHargaBolpoint() {
        return hargaBolpoint;
    }
    public void setHargaBolpoint(int hargaBolpoint) {
        this.hargaBolpoint = hargaBolpoint;
    }
    public int getHargaPensil() {
        return hargaPensil;
    }
    public void setHargaPensil(int hargaPensil) {
        this.hargaPensil = hargaPensil;
    }
    public int getHargaPenghapus() {
        return hargaPenghapus;
    }
    public void setHargaPenghapus(int hargaPenghapus) {
        this.hargaPenghapus = hargaPenghapus;
    }
}
