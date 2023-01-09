/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ahorcado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a22manuelmf
 */
public class aforcado {

    String palabra;
    ArrayList<Character> letras = new ArrayList<>();
    int erros;

    private void pedirPalabra() {
        Scanner informacion = new Scanner(System.in);
        System.out.println("Introduce la palabra secreta");
        this.palabra = informacion.nextLine();
    }

    private void pedirErros() {
        Scanner informacion = new Scanner(System.in);
        System.out.println("Introduce los errores limite ");
        this.erros = informacion.nextInt();

    }

    private void crearArray() {
        for (int i = 0; i < palabra.length(); i++) {
            letras.add('_');
        }
    }

    private void amosarArray() {
        for (int i = 0; i < letras.size(); i++) {
            System.out.print(letras.get(i)+" ");
        }
    }

    private void pedirLetra() {
        Scanner informacion = new Scanner(System.in);
        System.out.println("¿Que letra quiere probar?");
        char letrita = informacion.nextLine().charAt(0);
        rellenarArray(letrita);
        //comentarios absurdos para ver si esto funciona
    }

    private void rellenarArray(char letrita) {
        boolean fueError = true;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letrita) {
                letras.set(i, letrita);
                fueError = false;
            }
        }
        if (fueError) {
            this.erros--;
            System.out.println("Esa letra no estaba en la palabra te quedan "+erros+" oportunidades");
        }
    }

    public void xogar() {
        pedirPalabra();
        crearArray();
        pedirErros();
        boolean ganaste = false;
        
        while (erros != 0 && !ganaste) {
            if (!letras.contains('_')) {
                ganaste = true;
            } else {
                System.out.println("estos son los huecos de la palabra");
                amosarArray();

                pedirLetra();
            }
        }
        if(erros==0){
            System.out.println("se han agotado tus oportunidades y la ejecucion ha sido completada ");
        }
        else{
            System.out.println("el condenado ha sido salvado por tu gran capacidad de adivinacion palabril");
        }

    }

}
