/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carlosmontellano.factorial;

/**
 *
 * @author Carlos
 */
public class Operacion {
    int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Operacion(int n) {
        this.n = n;
    }
    public int calcularFibonaci()
    {
        return fibonacci(this.n);
    }
    private int fibonacci(int n)
    {
        if (n==0 || n==1)
                {
                    return 1;
                }
        else
             return fibonacci(n-1)+fibonacci(n-2);
    }
}
