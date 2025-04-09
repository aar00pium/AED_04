public class ElementoKMasPequeno {

    public static int encontrarKthMasPequeño(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k debe estar entre 1 y el tamaño del arreglo");
        }
        return seleccionarRapido(arr, 0, arr.length - 1, k - 1);
    }

    private static int seleccionarRapido(int[] arr, int izquierda, int derecha, int k) {
        if (izquierda == derecha) {
            return arr[izquierda];
        }

        int indicePivote = particionar(arr, izquierda, derecha);

        if (k == indicePivote) {
            return arr[k];
        } else if (k < indicePivote) {
            return seleccionarRapido(arr, izquierda, indicePivote - 1, k);
        } else {
            return seleccionarRapido(arr, indicePivote + 1, derecha, k);
        }
    }

    private static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];
        int i = izquierda;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                intercambiar(arr, i, j);
                i++;
            }
        }

        intercambiar(arr, i, derecha);
        return i;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Ejemplos del enunciado
        System.out.println(encontrarKthMasPequeño(new int[]{4, 2, 7, 10, 4, 17}, 3)); // 4
        System.out.println(encontrarKthMasPequeño(new int[]{4, 2, 7, 10, 4, 1, 6}, 5)); // 6
        System.out.println(encontrarKthMasPequeño(new int[]{4, 2, 7, 1, 4, 6}, 1)); // 1
        System.out.println(encontrarKthMasPequeño(new int[]{9, 2, 7, 1, 7}, 4)); // 7
    }
}
