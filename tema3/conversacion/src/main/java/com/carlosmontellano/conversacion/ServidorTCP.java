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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class ServidorTCP {

    public static void main(String[] args) {
        int port = 5002;
        Scanner sc = new Scanner(System.in);
        String recibido = "";
        String recibidoCompleto = "";
        String enviar = "";
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            while (true) {

                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion
                System.out.println("Cliente se conecto");
                while (!recibido.equals("salir")) {
                    toClient = new PrintStream(client.getOutputStream());
                    BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                    recibido = fromClient.readLine();
                    recibidoCompleto = recibido;
//                    while (recibido.length() > 0) {
                        recibido = fromClient.readLine();
                        recibidoCompleto += recibido;
  //                  }
                    System.out.println("cliente:" + recibidoCompleto);
                    System.out.print("servidor:");
                    enviar = sc.next();

                    toClient.println(enviar);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
