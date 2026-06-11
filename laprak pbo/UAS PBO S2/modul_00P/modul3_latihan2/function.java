import java.util.function.Function;

class function {
    data dt = new data(null);
    int[] arr = {2, 5, 3, 5, 9, 5};

    public int[] change() {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length); // Copying the original array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                newArr[i] = 1;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        function func = new function();
        func.change();
        for (int i = 0; i <6; i++) { // Use newArr length instead of hardcoding 6
            System.out.print(func.change() + " ");
        }
        System.out.println(); // Move to the next line after printing all elements
    }
}
