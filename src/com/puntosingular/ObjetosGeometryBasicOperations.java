package com.puntosingular;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjetosGeometryBasicOperations {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Operaciones básicas sobre un Cuadrado / Cubo");
        System.out.println();

        Double lado = 0.0;
        do {
            System.out.print("Para comenzar, es necesario introducir la medida del lado del cuadrado (cms), o cero (0) para salir.");
            System.out.println();
            System.out.print("Medida del lado (cm): ");

            try {
                lado = Double.parseDouble(reader.readLine());

                if (lado < 0) {
                    System.out.println();
                    System.out.println("El dato introducido no es válido.");
                } else if (lado > 0) {
                    // menu de operaciones
                    mostrarMenuOperaciones(lado);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("El dato introducido no es válido.");
                lado = -1.0;
            }

            System.out.println();
            System.out.println();
        } while (lado != 0);

        System.out.println();
        System.out.println("¡Hasta luego!");
    }

    public static void mostrarMenuOperaciones(Double lado) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int option = 0;
        do {
            System.out.println();
            System.out.println();
            System.out.println("Introduce el número de la operación que deseas realizar, utilizando el siguiente menú:");
            System.out.println("\t1) Calcular area de un cuadrado.");
            System.out.println("\t2) Calcular perímetro de un cuadrado.");
            System.out.println("\t3) Calcular volúmen de un cubo.");
            System.out.println("\t4) Calcular perímetro de un cubo.");
            System.out.println("\t5) Cancelar.");
            System.out.println();
            System.out.print("\tOpción: ");
            try {
                option = Integer.parseInt(reader.readLine());

                if (option < 1 || option > 5) {
                    System.out.println("\tEl dato introducido no es válido.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println("\tEl dato introducido no es válido.");
                option = 0;
            }

            Cuadrado cuadrado;
            Cubo cubo;
            String resultado = "";
            switch (option) {
                case 1:
                    cuadrado = new Cuadrado(lado);
                    resultado = String.format("\tEl area del cuadrado es: %f cm", cuadrado.calcularArea());
                    break;
                case 2:
                    cuadrado = new Cuadrado(lado);
                    resultado = String.format("\tEl perímetro del cuadrado es: %f cm", cuadrado.calcularPerimetro());
                    break;
                case 3:
                    cubo = new Cubo(lado);
                    resultado = String.format("\tEl volumen del cubo es: %f cm", cubo.calcularVolumen());
                    break;
                case 4:
                    cubo = new Cubo(lado);
                    resultado = String.format("\tEl perímetro del cubo es: %f cm", cubo.calcularPerimetro());
                    break;
            }

            if (!resultado.equals("")) {
                System.out.println();
                System.out.println("\tLa medida del lado es: " + lado.toString() + " cm.");
                System.out.println(resultado);
            }

            if (option != 5) {
                int returnOption = 0;
                do {
                    System.out.println();
                    System.out.println();
                    System.out.print("Para regresar al menú de operaciones, introduzca [1]. Para regresar al menú inicial, introduzca [2]: ");

                    try {
                        returnOption = Integer.parseInt(reader.readLine());

                        if (returnOption != 1 && returnOption != 2) {
                            System.out.println("El dato introducido no es válido.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException nfe) {
                        System.out.println("El dato introducido no es válido.");
                        returnOption = 0;
                    }
                } while (returnOption != 1 && returnOption != 2);

                if (returnOption == 1) {
                    option = 0;
                } else {
                    option = 5;
                }
            }

        } while (option != 5);
    }
}
