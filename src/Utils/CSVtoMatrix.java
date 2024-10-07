package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVtoMatrix {

    // Método para leer el archivo CSV y retornar una matriz de enteros
    public int[][] leerCSV(String filePath, String separador) throws IOException {
        // Obtener el número de filas y columnas
        int[] dimensiones = contarFilasYColumnas(filePath, separador);
        int filas = dimensiones[0];
        int columnas = dimensiones[1];

        // Crear la matriz
        int[][] matriz = new int[filas][columnas];

        // Leer el archivo nuevamente para llenar la matriz
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int filaActual = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(separador);
                for (int i = 0; i < columnas; i++) {
                    matriz[filaActual][i] = Integer.parseInt(values[i]); // Convertir a entero
                }
                filaActual++;
            }
        }

        return matriz;
    }

    // Método para contar las filas y columnas del archivo CSV
    private int[] contarFilasYColumnas(String filePath, String separador) throws IOException {
        int filas = 0;
        int columnas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separador);
                if (filas == 0) {
                    columnas = values.length; // Número de columnas basado en la primera línea
                }
                filas++;
            }
        }

        return new int[]{filas, columnas};
    }

    // Método para imprimir la matriz
    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
