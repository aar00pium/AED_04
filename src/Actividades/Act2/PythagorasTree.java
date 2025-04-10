package Actividades;

import javax.swing.*; // Importa las clases para interfaces gráficas
import java.awt.*; // Importa clases para gráficos y colores

// Clase que extiende JPanel para dibujar el Árbol de Pitágoras
public class PythagorasTree extends JPanel {
    private int profundidad; // Nivel de profundidad del árbol

    // Constructor que recibe la profundidad deseada
    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800)); // Tamaño de la ventana
        setBackground(Color.BLACK); // Fondo negro
    }

    // Método que se llama automáticamente para dibujar el componente
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN); // Color de las ramas del árbol
        drawTree(g2d, 400, 700, 120, -90, profundidad); // Dibuja el árbol desde el punto inicial
    }

    // Método recursivo para dibujar el árbol
    private void drawTree(Graphics2D g, int x1, int y1, double longitud, double angulo, int profundidad) {
        if (profundidad == 0)
            return; // Condición base: no dibuja más ramas

        // Calcula las coordenadas del punto final de la línea
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angulo)) * longitud);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angulo)) * longitud);

        g.drawLine(x1, y1, x2, y2); // Dibuja la línea (rama)

        // Llamadas recursivas para las ramas izquierda y derecha
        drawTree(g, x2, y2, longitud * 0.7, angulo - 45, profundidad - 1); // Rama izquierda
        drawTree(g, x2, y2, longitud * 0.7, angulo + 45, profundidad - 1); // Rama derecha
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        int profundidad = 6; // Puedes cambiar este valor a 6, 8 o 10 según lo desees
        JFrame ventana = new JFrame("Árbol de Pitágoras - Nivel " + profundidad);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al cerrar ventana
        ventana.add(new PythagorasTree(profundidad)); // Añade el panel con el árbol
        ventana.pack(); // Ajusta el tamaño de la ventana
        ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventana.setVisible(true); // Muestra la ventana
    }
}
