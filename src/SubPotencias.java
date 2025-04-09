public class SubPotencias {
    public static boolean sumaRestringida(int n, int[] arr, int obj) {
        if (arrRestringido(n, arr, 0) == obj) {
            return true;
        }
        return false;
    }
    public static int arrRestringido(int n, int[] arr, int elem) {
        if (elem == (n - 1)) {
            if (esPotenciaDos(arr[elem]) || arr[elem] % 5 == 0) {
                return arr[elem];
            }
            return 0;
        } else {
            if (esPotenciaDos(arr[elem]) || (arr[elem] % 5 == 0 && arr[elem + 1] % 2 == 0)) {
                return arr[elem] + arrRestringido(n, arr, elem + 1);
            }
        }
        return arrRestringido(n, arr, elem + 1);
    }
    public static boolean esPotenciaDos(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 8, 10, 3, 5};
        System.out.println("Entrada: 5 4 8 10 3 5 27");
        System.out.println("Salida: " + sumaRestringida(arr1.length, arr1, 27));

        int[] arr2 = new int[]{4, 8, 10, 3, 6};
        System.out.println("Entrada: 5 4 8 10 3 6 27");
        System.out.println("Salida: " + sumaRestringida(arr2.length, arr2, 27));

        int[] arr3 = new int[]{2, 16, 5, 7, 10};
        System.out.println("Entrada: 6 2 16 5 7 10 33");
        System.out.println("Salida: " + sumaRestringida(arr3.length, arr3, 33));

        int[] arr4 = new int[]{2, 16, 5, 3, 10};
        System.out.println("Entrada: 6 2 16 5 3 10 33");
        System.out.println("Salida: " + sumaRestringida(arr4.length, arr4, 33));
    }
}
