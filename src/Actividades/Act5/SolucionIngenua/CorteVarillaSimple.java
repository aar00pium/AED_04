package Actividades.Act5.SolucionIngenua;

public class CorteVarillaSimple {

    public static int maxValor(int[] precios, int longitud) {
        if (longitud <= 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < longitud; i++) {
            max = Math.max(max, precios[i] + maxValor(precios, longitud - i - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] precios = { 1, 5, 8, 9, 10 };
        int longitud = 4;
        System.out.println("Valor máximo: " + maxValor(precios, longitud)); // Salida: 10
    }
}