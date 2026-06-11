
package Form;

public class Data {
    
    private int nomor;
    private String deadline;
    private String kegiatan;
    private String deskripsi;

    public Data(int nomor, String deadline, String kegiatan, String deskripsi) {
        this.nomor = nomor;
        this.deadline = deadline;
        this.kegiatan = kegiatan;
        this.deskripsi = deskripsi;
    }

   
    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}


