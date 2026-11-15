package util;

import java.util.Scanner;

public final class Entrada {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Entrada() {
    }

    public static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    public static double lerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = SCANNER.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número, por exemplo 12,50.");
            }
        }
    }

    public static String lerTexto(String msg) {
        System.out.print(msg);
        return SCANNER.nextLine().trim();
    }
}
