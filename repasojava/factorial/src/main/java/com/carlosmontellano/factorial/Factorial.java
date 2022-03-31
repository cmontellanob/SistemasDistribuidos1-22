/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.carlosmontellano.factorial;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Factorial {

    
    
    public static void main(String[] args) {
        Scanner sn =new Scanner(System.in);
        System.out.println("Introduzca N");
        int n= sn.nextInt();
        Operacion o=new Operacion(n);
        System.out.println(o.calcularFibonaci());
    }
    
}
