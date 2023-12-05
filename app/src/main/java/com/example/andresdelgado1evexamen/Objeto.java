package com.example.andresdelgado1evexamen;

public class Objeto {
    private final String numero, tiempo;
    public Objeto (String numero, String tiempo){
        this.numero = numero;
        this.tiempo = tiempo;
    }

    public String getNumero() {
        return numero;
    }

    public String getTiempo() {
        return tiempo;
    }
}
