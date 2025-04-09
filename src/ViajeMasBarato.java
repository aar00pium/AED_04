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