class Kali {
    double a;
    double b;

    public void HasilKali(){
        double c;
        c=a*b;
        System.out.println(" hasil perkalian: "+a+" x "+b+" = "+c);
    }
}
public class Kelasku4 {
    public static void main(String[] args) {
        Kali objKali=new Kali();
        objKali.a=34;
        objKali.b=21;
        objKali.HasilKali();
    }
}
