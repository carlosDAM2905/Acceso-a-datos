package manejodeficheros.practica01;

import java.io.Serializable;

public class Conciertos implements Serializable {
    private String grupo;
    private String lugar;
    private String fecha;
    private String hora;

    //constructor:

    public Conciertos(String grupo, String hora, String lugar, String fecha) {
        this.grupo = grupo;
        this.hora = hora;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    //getter y setters:

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    //toString:


    @Override
    public String toString() {
        return "Grupo: " + grupo + '\'' +
                " Lugar: " + lugar + '\'' +
                " Fecha: " + fecha + '\'' +
                " Hora: " + hora + '\'';
    }
}
