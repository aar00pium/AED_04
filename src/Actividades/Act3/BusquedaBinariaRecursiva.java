public class BusquedaBinariaRecursiva {

    public static int buscar(int[] arreglo, int objetivo) {
        return buscarRecursivo(arreglo, objetivo, 0, arreglo.length - 1);
    }

    private static int buscarRecursivo(int[] arreglo, int objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1; // Elemento no encontrado
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        if (arreglo[medio] == objetivo) {
            return medio; // Elemento encontrado
        } else if (arreglo[medio] < objetivo) {
            return buscarRecursivo(arreglo, objetivo, medio + 1, derecha); // Buscar en mitad derecha
        } else {
            return buscarRecursivo(arreglo, objetivo, izquierda, medio - 1); // Buscar en mitad izquierda
        }
    }

    public static void main(String[] args) {
        int[] arregloOrdenado = { 2, 4, 6, 8, 10, 12, 14 };
        int objetivo = 8;
        int resultado = buscar(arregloOrdenado, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        }
    }
}