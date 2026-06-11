package modul_6.program_3;

class Burung extends Hewan {
    // Menggunakan method dari kelas induk abstrak
    @Override
    protected void munculSuara() {
    System.out.println("Suara Burung: Cit...cit..cit.");
    }
}
