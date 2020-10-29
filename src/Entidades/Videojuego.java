package Entidades;

import java.util.ArrayList;

public class Videojuego {

    private String Titulo, Clasificacion, Autor, Generos;
    private double Precio, HorasGameplay;
    private int HorasUsado = 0;
    private boolean Disponible;

    public Videojuego(String Titulo, String Clasificacion, double Precio, double HorasGameplay, String Generos, String Autor) {
        this.Autor = Autor;
        this.Clasificacion = Clasificacion;
        this.Generos = Generos;
        this.HorasGameplay = HorasGameplay;
        this.Precio = Precio;
        this.Titulo = Titulo;
        this.Disponible = true;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getHorasGameplay() {
        return HorasGameplay;
    }

    public void setHorasGameplay(double HorasGameplay) {
        this.HorasGameplay = HorasGameplay;
    }

    public String getGeneros() {
        return Generos;
    }

    public void setGeneros(String Generos) {
        this.Generos = Generos;
    }

    public void rentarJuego(int horas) {
        setHorasUsado(getHorasUsado() + horas);
        setDisponible(false);
    }

    public void devolverJuego() {
        setDisponible(true);
    }

    /**
     * @return the Autor
     */
    public String getAutor() {
        return Autor;
    }

    /**
     * @param Autor the Autor to set
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    /**
     * @return the HorasUsado
     */
    public int getHorasUsado() {
        return HorasUsado;
    }

    /**
     * @param HorasUsado the HorasUsado to set
     */
    public void setHorasUsado(int HorasUsado) {
        this.HorasUsado = HorasUsado;
    }

    /**
     * @return the Disponible
     */
    public boolean isDisponible() {
        return Disponible;
    }

    /**
     * @param Disponible the Disponible to set
     */
    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

}
