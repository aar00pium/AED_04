package Ejercicios.Ejercicio3;

public class ViajeMasBarato {

    /**
     * Calcula el costo mínimo de viaje entre dos nodos usando recursión
     * 
     * para tarifas Matriz de adyacencia con los costos directos entre nodos
     * (0=sinconexión directa)
     * para origen Nodo de partida (índice)
     * para destino Nodo de llegada (índice)
     * return El costo mínimo del viaje, o 0 si no hay ruta posible
     */
    public static int calcularCostoMinimo(int[][] tarifas, int origen, int destino) {
        // Si existe un costo directo, lo retornamos inmediatamente
        if (tarifas[origen][destino] != 0) {
            return tarifas[origen][destino];
        }

        int n = tarifas.length;
        int costoMinimo = Integer.MAX_VALUE; // Inicializamos con valor máximo

        // Buscamos todas las posibles rutas intermedias
        for (int k = 0; k < n; k++) {
            // Verificamos que k sea un nodo intermedio válido:
            // - No es ni origen ni destino
            // - Existe conexión origen->k y k->destino
            if (k != origen && k != destino && tarifas[origen][k] != 0 && tarifas[k][destino] != 0) {
                // Costo total pasando por este nodo k
                int costoViaK = tarifas[origen][k] + calcularCostoMinimo(tarifas, k, destino);
                // Nos quedamos con el mínimo encontrado
                costoMinimo = Math.min(costoMinimo, costoViaK);
            }
        }

        // Si no encontramos ruta, retornamos 0
        return costoMinimo == Integer.MAX_VALUE ? 0 : costoMinimo;
    }

    /**
     * Calcula la matriz de costos mínimos entre todos los pares de nodos
     * 
     * para tarifas Matriz de adyacencia con costos directos
     * return Matriz con los costos mínimos entre todos los nodos
     */
    public static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n]; // Matriz de resultados

        // Calculamos para cada par de nodos (i,j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { // No calculamos el costo a sí mismo
                    costos[i][j] = calcularCostoMinimo(tarifas, i, j);
                }
            }
        }

        return costos;
    }

    public static void main(String[] args) {
        // Ejemplo de matriz de tarifas (triangular superior)
        // Representación de un grafo dirigido con costos:
        // 0 -> 1: 5
        // 0 -> 2: 10
        // 0 -> 3: 20
        // 1 -> 2: 3
        // 1 -> 3: 8
        // 2 -> 3: 4
        int[][] tarifas = {
                { 0, 5, 10, 20 }, // Desde 0
                { 0, 0, 3, 8 }, // Desde 1
                { 0, 0, 0, 4 }, // Desde 2
                { 0, 0, 0, 0 } // Desde 3
        };

        // Calculamos todos los costos mínimos
        int[][] costosMinimos = calcularCostosMinimos(tarifas);

        // Imprimimos la matriz resultante
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < costosMinimos.length; i++) {
            for (int j = 0; j < costosMinimos[i].length; j++) {
                System.out.print(costosMinimos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}