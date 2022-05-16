/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentencionesjudiciales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class ServidorMercantil {

    public static void main(String[] args) {
        int port = 5002;
        String resultado="";
        while (true) {
            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("Se inicio el servidor con éxito");
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String respuesta = fromClient.readLine(); //recibe del cliente
                String[] arreglo = respuesta.split(":");

                if (arreglo[0].equals("Buscar")) {
                    String[] datos = arreglo[1].split("-");
                    resultado = BuscarCliente(datos[0], datos[1], datos[2]);

                }
                 if (arreglo[0].equals("Congelar")) {
                    String[] datos = arreglo[1].split("-");
                    resultado = CongelarCliente(datos[0],Double.valueOf(datos[1]) );

                }

                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resultado);             // da la respuesta
                System.out.println("Cliente se conecto");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static String BuscarCliente(String ci, String nombres, String apellidos) {
        if (ci.equals("11021654") && nombres.equals("Juan Perez") && apellidos.equals("Segovia")) {
            return "23254-5000";
        } else {
            return "";
        }

    }

    private static String CongelarCliente(String cuenta, Double monto) {
      if (cuenta.equals("23254"))
      {
          return "SI-"+cuenta;
      }
      else
          return "NO-No Encontrado";
    }

}
