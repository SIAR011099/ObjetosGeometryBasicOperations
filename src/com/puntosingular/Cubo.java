package com.puntosingular;

public class Cubo extends Cuadrado {
    public Cubo(Double lado) {
        super(lado);
    }

    public Double calcularVolumen() {
        return lado * lado * lado;
    }

    @Override
    public Double calcularPerimetro() {
        return lado * 12.0;
    }
}
