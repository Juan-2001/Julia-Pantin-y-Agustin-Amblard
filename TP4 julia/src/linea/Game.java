package linea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Dimensiones del juego:");
            int columnas = promptAsInt("Base? ", reader);
            int filas = promptAsInt("Altura? ", reader);
            char estrategia = promptAsChar("Estrategia de juego (A, B, C): ", reader);
            Linea game = new Linea(columnas, filas, estrategia);

            System.out.println(game.show());

            while (!game.finished()) {
                try {
                    if (game.isEsTurnoRojas()) {
                        game.playRedAt(promptAsInt("Jugada para Rojas (introduce el número de columna): ", reader));
                    } else {
                        game.playBlueAt(promptAsInt("Jugada para Azules (introduce el número de columna): ", reader));
                    }
                    System.out.println(game.show());
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Juego terminado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int promptAsInt(String message, BufferedReader reader) throws Exception {
        System.out.print(message);
        return Integer.parseInt(reader.readLine().trim());
    }

    private static char promptAsChar(String message, BufferedReader reader) throws Exception {
        System.out.print(message);
        String line = reader.readLine().trim();
        if (line.length() != 1) {
            throw new IllegalArgumentException("Se espera un solo carácter.");
        }
        return line.charAt(0);
    }
}
