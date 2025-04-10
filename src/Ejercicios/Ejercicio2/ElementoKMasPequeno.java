public class ElementoKMasPequeno {

    /**
     * Encuentra el k-ésimo elemento más pequeño en un arreglo no ordenado
     * 
     * para arr - arreglo de enteros
     * para k - posición buscada (1-based)
     * return el k-ésimo elemento más pequeño
     * throws IllegalArgumentException si k está fuera de rango
     */
    public static int encontrarKthMasPequeño(int[] arr, int k) {
        // Validar que k esté dentro del rango válido
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k debe estar entre 1 y el tamaño del arreglo");
        }
        // Llamar al método de selección rápida (con índice 0-based)
        return seleccionarRapido(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * Implementación del algoritmo de selección rápida (Quickselect)
     * 
     * para arr - arreglo de enteros
     * para izquierda - índice izquierdo del subarreglo actual
     * para derecha - índice derecho del subarreglo actual
     * para k - posición buscada (0-based)
     * return el k-ésimo elemento más pequeño en el subarreglo
     */
    private static int seleccionarRapido(int[] arr, int izquierda, int derecha, int k) {
        // Caso base: subarreglo de un solo elemento
        if (izquierda == derecha) {
            return arr[izquierda];
        }

        // Obtener el índice del pivote después de particionar
        int indicePivote = particionar(arr, izquierda, derecha);

        // Comparar el índice del pivote con k
        if (k == indicePivote) {
            return arr[k]; // Encontramos el elemento buscado
        } else if (k < indicePivote) {
            // Buscar en la partición izquierda
            return seleccionarRapido(arr, izquierda, indicePivote - 1, k);
        } else {
            // Buscar en la partición derecha
            return seleccionarRapido(arr, indicePivote + 1, derecha, k);
        }
    }

    /**
     * Particiona el arreglo usando el último elemento como pivote
     * 
     * para arr - arreglo a particionar
     * para izquierda - índice izquierdo del subarreglo
     * para derecha - índice derecho del subarreglo
     * return la posición final del pivote
     */
    private static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha]; // Seleccionar el último elemento como pivote
        int i = izquierda; // Índice del elemento más pequeño

        for (int j = izquierda; j < derecha; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivote) {
                intercambiar(arr, i, j); // Moverlo a la posición i
                i++; // Incrementar el índice del elemento más pequeño
            }
        }

        // Colocar el pivote en su posición correcta
        intercambiar(arr, i, derecha);
        return i; // Retornar la posición del pivote
    }

    /**
     * Intercambia dos elementos en un arreglo
     * 
     * para arr - arreglo
     * para i - primer índice
     * para j - segundo índice
     */
    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Ejemplos del enunciado
        System.out.println(encontrarKthMasPequeño(new int[] { 4, 2, 7, 10, 4, 17 }, 3)); // 4
        System.out.println(encontrarKthMasPequeño(new int[] { 4, 2, 7, 10, 4, 1, 6 }, 5)); // 6
        System.out.println(encontrarKthMasPequeño(new int[] { 4, 2, 7, 1, 4, 6 }, 1)); // 1
        System.out.println(encontrarKthMasPequeño(new int[] { 9, 2, 7, 1, 7 }, 4)); // 7
    }
}