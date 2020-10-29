package managervideojuegos;

import Entidades.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerVideoJuegos {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int EjecucionControl = 0;
        System.out.println("Bienvenido a nuestro centro de renta de Videojuegos, ¿Cómo podemos ayudarte?");
        do {
            EjecucionControl = ejecucionActividades(procesarMenu());
        } while (EjecucionControl != 4);

    }

    public static void desplegarMenu() {
        System.out.println("Menú");
        System.out.println("1. Rentar un Videojuego");
        System.out.println("2. Devolver un Videojuego");
        System.out.println("3. Añadir un videojuego al Stock");
        System.out.println("4. Salir");
    }

    public static int filterOpcion() {
        String opcPreFilter;
        do {
            opcPreFilter = sc.nextLine();
            if (!opcPreFilter.matches("[0-9]+")) {
                System.out.println("Debes introducir un numero, por favor corrije.");
            }
        } while (!opcPreFilter.matches("[0-9]+"));
        return Integer.parseInt(opcPreFilter);
    }

    public static int procesarMenu() {
        desplegarMenu();
        int opc = 0;
        System.out.println("Inserta una opción por favor.");
        do {
            opc = filterOpcion();
            if (opc > 4 || opc < 1) {
                System.out.println("Debes introducir una de las tres opciones, corrige por favor.");
            }
        } while (opc > 4 || opc < 1);
        return opc;
    }

    public static int ejecucionActividades(int opcion) {
        switch (opcion) {
            case 1: {
                System.out.println("Seleccionaste la uno");
                ejecutarRentar();
                break;
            }
            case 2: {
                System.out.println("Seleccionaste la dos");
                ejecutarDevolucion();
                break;
            }
            case 3: {
                System.out.println("Seleccionaste la 3");
                registrarGame();
                break;
            }
            case 4: {
                System.out.println("Seleccionaste la 4");
                System.out.println("Adios");
                break;
            }
        }
        return opcion;
    }

    public static void registrarGame() {
        String Titulo, Clasificacion, Autor, Genero;
        double Precio, HorasGameplay;

        do {
            System.out.println("Por favor, inserta el titulo del Videojuego que deseas ingresar.");
            Titulo = sc.nextLine();
            if (Inventario.validarJuego(Titulo)) {
                System.out.println("Este juego ya ha sido registrado anteriormente, inserta otro titulo");
            }
        } while (Inventario.validarJuego(Titulo));
        System.out.println("Inserta la clasificación");
        Clasificacion = sc.nextLine();
        System.out.println("Inserta el Autor");
        Autor = sc.nextLine();
        System.out.println("Inserta el precio");
        Precio = Double.parseDouble(sc.nextLine());
        System.out.println("Inserta las Horas de Gameplay");
        HorasGameplay = Double.parseDouble(sc.nextLine());
        System.out.println("¿A qué genero pertenece?");
        Genero = sc.nextLine();
        Inventario.crearVideojuego(new Videojuego(Titulo, Clasificacion, Precio, HorasGameplay, Genero, Autor));
        System.out.println("Registrado con éxito");
    }

    public static void ejecutarRentar() {
        int SizeInv = Inventario.imprimirInventario(), opc;
        System.out.println("Selecciona una opción por favor");
        do {
            do {
                opc = filterOpcion();
                if (opc >= SizeInv || opc < 0) {
                    System.out.println("Debes introducir una opción correcta por favor.");
                }
            } while (opc >= SizeInv || opc < 0);

            if (!Inventario.getStatusVideojuego(opc)) {
                System.out.println("Este juego no está disponible, escoge otro");
            }
        } while (!Inventario.getStatusVideojuego(opc));
        System.out.println("¿Por cuántas Horas deseas rentarlo?");
        Inventario.rentarVideojuego(opc, filterOpcion());
        System.out.println("Rentado con éxito!");
    }

    public static void ejecutarDevolucion() {
        int SizeInv = Inventario.imprimirInventario(), opc;
        System.out.println("Selecciona una opción por favor");
        do {
            do {
                opc = filterOpcion();
                if (opc >= SizeInv || opc < 0) {
                    System.out.println("Debes introducir una opción correcta por favor.");
                }
            } while (opc >= SizeInv || opc < 0);

            if (Inventario.getStatusVideojuego(opc)) {
                System.out.println("Este juego está en Stock, escoge otro");
            }
        } while (Inventario.getStatusVideojuego(opc));
        Inventario.devolverVideojuego(opc);
        System.out.println("Devuelto con éxito!");
    }

}
