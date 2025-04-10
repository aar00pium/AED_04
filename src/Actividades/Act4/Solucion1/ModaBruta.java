package Actividades.Act4.Solucion1;

// SOLUCION 1
public class ModaBruta {
    public static int frecuencia(int[] arr, int valor) {
        int count = 0;
        for (int num : arr) {
            if (num == valor)
                count++;
        }
        return count;
    }

    public static int moda1(int[] arr) {
        int maxFrecuencia = 0;
        int moda = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int frec = frecuencia(arr, arr[i]);
            if (frec > maxFrecuencia) {
                maxFrecuencia = frec;
                moda = arr[i];
            }
        }
        return moda;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 2, 4, 4, 4, 4, 5 };
        System.out.println("Moda (fuerza bruta): " + moda1(arr));
    }
}
