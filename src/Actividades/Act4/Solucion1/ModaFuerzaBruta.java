package Actividades.Act4.Solucion1;

// SOLUCION 1
public class ModaFuerzaBruta {

    // Función principal para calcular la moda
    public static int calcularModa(int[] arreglo) {
        int moda = arreglo[0];
        int maxFrecuencia = calcularFrecuencia(arreglo, 0, arreglo.length - 1, moda);

        for (int i = 1; i < arreglo.length; i++) {
            int frecuenciaActual = calcularFrecuencia(arreglo, i, arreglo.length - 1, arreglo[i]);
            if (frecuenciaActual > maxFrecuencia) {
                maxFrecuencia = frecuenciaActual;
                moda = arreglo[i];
            }
        }
        return moda;
    }

    // Función auxiliar para calcular frecuencia
    private static int calcularFrecuencia(int[] arreglo, int inicio, int fin, int elemento) {
        int frecuencia = 0;
        for (int i = inicio; i <= fin; i++) {
            if (arreglo[i] == elemento) {
                frecuencia++;
            }
        }
        return frecuencia;
    }

    public static void main(String[] args) {
        int[] datos = { 1, 2, 2, 3, 3, 3, 4 };
        System.out.println("La moda es: " + calcularModa(datos)); // Salida: 3
    }
}