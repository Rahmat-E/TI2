public class function {
    arr ar=new arr(null);
    int arr[]={5,3,6,3,4};
    int hasil=0;

    public void runArray(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            }
        System.out.println();
    }
    public double Mean(){
        for(int i=0;i<arr.length;i++){
            hasil+=i;
        }
        return (double)hasil/arr.length;
    }

    public int Max(){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }return max;
    }

    public int Min(){
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min>arr[i]){
                min=arr[i];
            }
        }return min;
    }

    // public void search(int cari){
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]==cari){
    //             System.out.println("angka "+cari+" ada di index ke- "+i);
    //             break;
    //         }
    //     }
    // }
    public void search(int cari) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cari) {
                System.out.println("Angka " + cari + " ada di index ke-" + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Angka " + cari + " tidak ditemukan.");
        }
    }
}

