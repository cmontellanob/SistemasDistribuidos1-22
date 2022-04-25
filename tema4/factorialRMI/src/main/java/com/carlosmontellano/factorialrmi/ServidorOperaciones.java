/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carlosmontellano.factorialrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
public class ServidorOperaciones extends UnicastRemoteObject implements IOperaciones {

    public ServidorOperaciones() throws RemoteException {
        super();
    }

    @Override
    public int factorial(int n) throws RemoteException {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f = f * i;
        }

        return f;
    }
}
