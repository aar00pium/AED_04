package Actividades.Act3;

public class BusquedaBinariaIterativa {

    public static int buscar(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arreglo[medio] == objetivo) {
                return medio;
            } else if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1; // Elemento no encontrado
    }

    public static void main(String[] args) {
        int[] arregloOrdenado = { 1, 3, 5, 7, 9, 11, 13 };
        int objetivo = 11;
        int resultado = buscar(arregloOrdenado, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        }
    }
}