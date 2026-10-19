package app;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final double META_VENTAS = 500_000;


    public static void main(String[] args) {
        System.out.println("===== Sistema de ventas - Food Truck Express =====");

        String[] productos = {"Hamburguesas", "Perros Calientes", "Papas Fritas"};
        String[] turnos = {"Almuerzo", "Tarde", "Noche", "Madrugada"};
        double[][] ventas = new double[productos.length][turnos.length];

        registrarVentas(productos, turnos, ventas);
        mostrarReporte(productos, turnos, ventas);

        SCANNER.close();
    }

    static void registrarVentas(String[] productos, String[] turnos, double[][] ventas) {

        for (int producto = 0; producto < productos.length; producto++) {
            for  (int turno = 0; turno < turnos.length; turno++) {
                System.out.print("Ventas de " + productos[producto] + " en el turno " + turnos[turno] + ": ");
                ventas[producto][turno] = leerVentaValida();
            }
        }
    }

    static double leerVentaValida() {
        while (true) {

            if  (!SCANNER.hasNextDouble()) {
                System.out.println("Error: Ingrese un valor numerico valido.");
                SCANNER.next();
                continue;
            }

            double venta = SCANNER.nextDouble();
            if (venta < 0) {
                System.out.println("Error: Ingrse un numero positivo.");
                continue;
            }
            return venta;
        }
    }

    static void mostrarReporte (String[] productos, String[] turnos, double[][] ventas) {
        double totalGeneral = 0;

        System.out.println("========Reporte de ventas========");
        for (int producto = 0; producto < productos.length; producto++) {
            double totalProducto = 0;
            for  (int turno = 0; turno < turnos.length; turno++) {
                totalProducto += ventas[producto][turno];
            }
            totalGeneral += totalProducto;
            System.out.println("Total de " + productos[producto] + ": " + totalProducto);
        }

        System.out.println("Total general: $" + totalGeneral);
        if (totalGeneral < META_VENTAS) {
            System.out.println("Meta no alcanzada.");
        } else  {
            System.out.println("Meta alcanzada.");
        }
    }
}
