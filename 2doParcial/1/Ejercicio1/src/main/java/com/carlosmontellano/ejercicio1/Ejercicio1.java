/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.carlosmontellano.ejercicio1;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Carlos
 */
public class Ejercicio1 {

   private final static String QUEUE_NAME = "cajas";
    private final static String QUEUE_NAME2 = "plataforma";
    

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "[Cliente:2]";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] se envio elmensaje '" + message + "'");
        }
        try (Connection connection = factory.newConnection();
             Channel channel2 = connection.createChannel()) {
            channel2.queueDeclare(QUEUE_NAME2, false, false, false, null);
            String message = "[Plataform: 2]";
            channel2.basicPublish("", QUEUE_NAME2, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Seenvio el mensaje '" + message + "'");
        }
    }
}
