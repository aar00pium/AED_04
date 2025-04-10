package Actividades.Act5.SolucionDinamica;

public class CorteVarillaDP {

    public static int maxValor(int[] precios, int longitud) {
        int[] dp = new int[longitud + 1]; // Almacena resultados intermedios

        for (int i = 1; i <= longitud; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, precios[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[longitud];
    }

    public static void main(String[] args) {
        int[] precios = { 1, 5, 8, 9, 10 };
        int longitud = 4;
        System.out.println("Valor máximo: " + maxValor(precios, longitud)); // Salida: 10
    }
}