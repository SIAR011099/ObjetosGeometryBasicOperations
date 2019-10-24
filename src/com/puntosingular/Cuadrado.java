package com.puntosingular;

public class Cuadrado {
    private Double lado = 0.0;

    public Cuadrado(Double lado) {
        this.lado = lado;
    }

    public Double calcularArea() {
        return lado * lado;
    }

    public Double calcularPerimetro() {
        return lado * 4;
    }
}
