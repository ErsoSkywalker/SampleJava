/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

public class Inventario {

    private static ArrayList<Videojuego> InventarioVideojuegos = new ArrayList<>();

    public static ArrayList<Videojuego> getInventarioVideojuegos() {
        return InventarioVideojuegos;
    }

    public static boolean getStatusVideojuego(int Numero) {
        return InventarioVideojuegos.get(Numero).isDisponible();
    }

    public static void rentarVideojuego(int Numero, int Horas) {
        InventarioVideojuegos.get(Numero).rentarJuego(Horas);
    }

    public static void devolverVideojuego(int Numero) {
        InventarioVideojuegos.get(Numero).devolverJuego();
    }

    public static int imprimirInventario() {

        for (int i = 0; i < InventarioVideojuegos.size(); i++) {
            System.out.println(i + "\t" + InventarioVideojuegos.get(i).getTitulo() + "\t" + InventarioVideojuegos.get(i).getAutor() + "\t" + InventarioVideojuegos.get(i).getClasificacion() + "\t" + InventarioVideojuegos.get(i).getGeneros() + "\t" + InventarioVideojuegos.get(i).getPrecio() + "\t" + InventarioVideojuegos.get(i).getHorasUsado() + "\t" + InventarioVideojuegos.get(i).getHorasGameplay() + "\t" + InventarioVideojuegos.get(i).isDisponible());
        }
        return InventarioVideojuegos.size();
    }

    public static void crearVideojuego(Videojuego videojuego) {
        InventarioVideojuegos.add(videojuego);
    }

    public static boolean validarJuego(String Titulo) {
        boolean Validate = false;
        for (Videojuego videojuego : InventarioVideojuegos) {
            Validate = (videojuego.getTitulo().equalsIgnoreCase(Titulo)) ? true : Validate;
        }
        return Validate;
    }

}
