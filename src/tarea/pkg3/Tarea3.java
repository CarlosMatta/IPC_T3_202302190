/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.pkg3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author famil
 */
public abstract class Tarea3 {

    protected int numeroDeLados;

    public Tarea3(int numeroDeLados) {
        this.numeroDeLados = numeroDeLados;
    }

    public abstract double calcularArea();

    public abstract String getNombre();

    public void imprimirArea() {
        System.out.println(getNombre() + ": " + calcularArea());
    }
}

class Pentagono extends Tarea3 {

    private double lado;

    public Pentagono(double lado) {
        super(5);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (5.0 / 4.0) * Math.pow(lado, 2) * (1 / Math.tan(Math.PI / 5));
    }

    @Override
    public String getNombre() {
        return "Pentágono";
    }
}

class Cuadrado extends Tarea3 {

    private double lado;

    public Cuadrado(double lado) {
        super(4);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2);
    }

    @Override
    public String getNombre() {
        return "Cuadrado";
    }
}

class Triangulo extends Tarea3 {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        super(3);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public String getNombre() {
        return "Triángulo";
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduce el numero de lados de la figura 3 para un triangulo, 4 para un cuadrado, 5 para un pentagono):");
        int numeroDeLados = scanner.nextInt();

        System.out.println("Por favor, introduce el valor del lado o la base y la altura para el triangulo");
        double valor1 = scanner.nextDouble();
        double valor2 = (numeroDeLados == 3) ? scanner.nextDouble() : valor1;

        Tarea3 figura;
        switch (numeroDeLados) {
            case 3:
                figura = new Triangulo(valor1, valor2);
                break;
            case 4:
                figura = new Cuadrado(valor1);
                break;
            case 5:
                figura = new Pentagono(valor1);
                break;
            default:
                System.out.println("Número de lados no válido.");
                return;
        }

        figura.imprimirArea();
    }
}
