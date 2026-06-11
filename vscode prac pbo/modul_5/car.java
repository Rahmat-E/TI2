package modul_5;

class car extends vehicle{
    private String modelName="Mustang";
    public static void main(String[] args) {
        car myCar = new car();
        myCar.honk();
        System.out.println(myCar.brand+" "+myCar.modelName);
    }
}