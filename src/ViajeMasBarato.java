public class ViajeMasBarato {

    public static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n];

        // Inicializar matriz de costos con las tarifas directas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costos[i][j] = tarifas[i][j];
            }
        }

        // Aplicar programación dinámica
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (costos[i][k] != 0 && costos[k][j] != 0) {
                        int nuevoCosto = costos[i][k] + costos[k][j];
                        if (costos[i][j] == 0 || nuevoCosto < costos[i][j]) {
                            costos[i][j] = nuevoCosto;
                        }
                    }
                }
            }
        }

        return costos;
    }

    public static void main(String[] args) {
        // Ejemplo de matriz de tarifas (triangular superior)
        int[][] tarifas = {
                {0, 5, 10, 20},  // Desde 0
                {0, 0, 3, 8},     // Desde 1
                {0, 0, 0, 4},     // Desde 2
                {0, 0, 0, 0}      // Desde 3
        };

        int[][] costosMinimos = calcularCostosMinimos(tarifas);

        // Imprimir resultados
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < costosMinimos.length; i++) {
            for (int j = 0; j < costosMinimos[i].length; j++) {
                System.out.print(costosMinimos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


public class ViajeMasBarato {

    public static int calcularCostoMinimo(int[][] tarifas, int origen, int destino) {
        // Si el costo directo es 0, significa que no hay conexión
        if (tarifas[origen][destino] != 0) {
            return tarifas[origen][destino];
        }

        int n = tarifas.length;
        int costoMinimo = Integer.MAX_VALUE;

        // Probar todos los nodos intermedios
        for (int k = 0; k < n; k++) {
            if (k != origen && k != destino && tarifas[origen][k] != 0 && tarifas[k][destino] != 0) {
                int costoViaK = tarifas[origen][k] + calcularCostoMinimo(tarifas, k, destino);
                costoMinimo = Math.min(costoMinimo, costoViaK);
            }
        }

        return costoMinimo == Integer.MAX_VALUE ? 0 : costoMinimo; // Si no se encontró un camino, retornar 0
    }

    public static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n];

        // Calcular costos mínimos para cada par de nodos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    costos[i][j] = calcularCostoMinimo(tarifas, i, j);
                }
            }
        }

        return costos;
    }

    public static void main(String[] args) {
        // Ejemplo de matriz de tarifas (triangular superior)
        int[][] tarifas = {
                {0, 5, 10, 20},  // Desde 0
                {0, 0, 3, 8},     // Desde 1
                {0, 0, 0, 4},     // Desde 2
                {0, 0, 0, 0}      // Desde 3
        };

        int[][] costosMinimos = calcularCostosMinimos(tarifas);

        // Imprimir resultados
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < costosMinimos.length; i++) {
            for (int j = 0; j < costosMinimos[i].length; j++) {
                System.out.print(costosMinimos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
