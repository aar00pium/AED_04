package Actividades.Act4.Solucion3;

import java.util.*;

public class ModaDivideVenceras {

    // Clase Limits para definir los límites del subarreglo
    static class Limits {
        int inicio, fin;

        Limits(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        int length() {
            return fin - inicio + 1;
        }
    }

    // TAD SetVector que actúa como una cola de prioridad por longitud descendente
    static class SetVector {
        private PriorityQueue<Limits> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.length(), a.length()));

        void insertar(Limits l) {
            queue.offer(l);
        }

        Limits mayor() {
            return queue.poll();
        }

        int longMayor() {
            return queue.isEmpty() ? 0 : queue.peek().length();
        }

        boolean esVacio() {
            return queue.isEmpty();
        }

        void destruir() {
            queue.clear();
        }
    }

    // Función principal del algoritmo de Divide y Vencerás
    public static int calcularModa(int[] arreglo) {
        SetVector heterogeneos = new SetVector();
        SetVector homogeneos = new SetVector();
        heterogeneos.insertar(new Limits(0, arreglo.length - 1));

        while (heterogeneos.longMayor() > homogeneos.longMayor()) {
            Limits actual = heterogeneos.mayor();
            int mediana = calcularMediana(arreglo, actual.inicio, actual.fin);
            int[] pivotes = pivote2(arreglo, actual.inicio, actual.fin, mediana);

            Limits izquierda = new Limits(actual.inicio, pivotes[0] - 1);
            Limits centro = new Limits(pivotes[0], pivotes[1] - 1);
            Limits derecha = new Limits(pivotes[1], actual.fin);

            if (izquierda.inicio <= izquierda.fin)
                heterogeneos.insertar(izquierda);
            if (derecha.inicio <= derecha.fin)
                heterogeneos.insertar(derecha);
            if (centro.inicio <= centro.fin)
                homogeneos.insertar(centro);
        }

        if (homogeneos.esVacio())
            return arreglo[0];
        Limits modaLimits = homogeneos.mayor();
        return arreglo[modaLimits.inicio];
    }

    // Obtener mediana como el elemento del centro
    private static int calcularMediana(int[] arr, int inicio, int fin) {
        return arr[(inicio + fin) / 2];
    }

    // Partición estilo QuickSort: divide el arreglo en < mediana, == mediana, >
    // mediana
    private static int[] pivote2(int[] arr, int inicio, int fin, int mediana) {
        int izq = inicio;
        int der = inicio;

        for (int i = inicio; i <= fin; i++) {
            if (arr[i] < mediana) {
                int tmp = arr[i];
                arr[i] = arr[izq];
                arr[izq++] = tmp;
            }
        }

        der = izq;
        for (int i = izq; i <= fin; i++) {
            if (arr[i] == mediana) {
                int tmp = arr[i];
                arr[i] = arr[der];
                arr[der++] = tmp;
            }
        }

        return new int[] { izq, der }; // [inicio de iguales, fin de iguales]
    }

    // Main para pruebas
    public static void main(String[] args) {
        int[] datos = { 1, 2, 2, 2, 3, 3, 4 };
        System.out.println("La moda es: " + calcularModa(datos)); // Salida esperada: 2
    }
}
