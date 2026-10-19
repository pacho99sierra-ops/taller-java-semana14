package app;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("===== Sistema de ventas - Food Truck Express =====");

        String[] productos = {"Hamburguesas", "Perros Calientes", "Papas Fritas"};
        String[] turnos = {"Almuerzo", "Tarde", "Noche", "Madrugada"};
        double[][] ventas = new double[productos.length][turnos.length];

        registrarVentas(productos, turnos, ventas);

        SCANNER.close();
    }

    static void registrarVentas(String[] productos, String[] turnos, double[][] ventas) {

        for (int producto = 0; producto < productos.length; producto++) {
            for  (int turno = 0; turno < turnos.length; turno++) {
                System.out.print("Ventas de " + productos[producto] + " en el turno " + turnos[turno] + ": ");
                ventas[producto][turno] = SCANNER.nextDouble();
            }
        }
    }
}
