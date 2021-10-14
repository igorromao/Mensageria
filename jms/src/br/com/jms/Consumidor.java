package br.com.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;


/**
 * Gerenciador consumidor fila.
 * @version 1.1 - 07/10/21
 * @auhtor Igor Romão
 * @since 07/10/21
 */
public class Consumidor {
    public static void main(String[] args) throws Exception {

        System.out.println("Iniciando fila");
        InitialContext cont = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) cont.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) cont.lookup("players");
        MessageConsumer consumer = session.createConsumer(fila);
        consumer.setMessageListener(message -> {
            TextMessage text = (TextMessage) message;
            try {
                System.out.println(text.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
        new Scanner(System.in).nextLine();
        session.close();
        connection.close();
        cont.close();
    }
}
