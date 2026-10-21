package com.curso.errores;

/**
 * Laboratorio: errores que compilan pero fallan durante la ejecución.
 * Cada escenario se ejecuta por separado y NO captura la excepción.
 */
public class Laboratorio {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: mvn exec:java -Dexec.args=1 (casos 1 a 7)");
            return;
        }
        System.out.println("Iniciando caso " + args[0]);
        switch (args[0]) {
            case "1" -> divisionEntreCero();
            case "2" -> referenciaNula();
            case "3" -> indiceFueraDeRango();
            case "4" -> numeroInvalido();
            case "5" -> conversionDeTipo();
            case "6" -> modificacionDuranteIteracion();
            case "7" -> recursionSinFin();
            default -> System.out.println("Caso no disponible: elija del 1 al 7.");
        }
        System.out.println("Fin del caso (esta línea no aparece si ocurre una excepción).");
    }

    static void divisionEntreCero() {
        int saldo = 100;
        int cuotas = 0;
        System.out.println("Cuota: " + (saldo / cuotas)); // ArithmeticException
    }

    static void referenciaNula() {
        String cliente = null;
        System.out.println("Longitud: " + cliente.length()); // NullPointerException
    }

    static void indiceFueraDeRango() {
        int[] movimientos = {100, 200, 300};
        System.out.println(movimientos[3]); // ArrayIndexOutOfBoundsException
    }

    static void numeroInvalido() {
        String monto = "12O0"; // Contiene la letra O, no cero.
        System.out.println(Integer.parseInt(monto)); // NumberFormatException
    }

    static void conversionDeTipo() {
        Object dato = "Transferencia";
        Integer numero = (Integer) dato; // ClassCastException
        System.out.println(numero);
    }

    static void modificacionDuranteIteracion() {
        java.util.List<String> cuentas = new java.util.ArrayList<>(java.util.List.of("A", "B", "C"));
        for (String cuenta : cuentas) {
            if (cuenta.equals("A")) cuentas.remove(cuenta); // ConcurrentModificationException
        }
    }

    static void recursionSinFin() {
        recursionSinFin(); // StackOverflowError: ejecutar solo con supervisión.
    }
}
