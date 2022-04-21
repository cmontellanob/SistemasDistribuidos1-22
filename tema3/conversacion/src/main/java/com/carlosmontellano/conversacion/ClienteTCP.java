/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosmontellano.conversacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class ClienteTCP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;
        String mensaje = "";
        try {

            Socket client = new Socket("localhost", port);

            while (!mensaje.equals("salir")) {
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.print("cliente:");
                mensaje = sc.next();
                toServer.println(mensaje);
                String result = fromServer.readLine();
                System.out.println("Server: " + result);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
