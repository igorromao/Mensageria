package br.com.jms;

import javax.jms.*;
import javax.naming.InitialContext;


/**
 * Gerenciador de Topico de fila.
 * @version 1.1 - 14/10/21
 * @auhtor Igor Romão
 * @since 14/10/21
 */
public class Topico {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando envio para fila");
        InitialContext cont = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) cont.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination topico = (Destination) cont.lookup("players");
        MessageProducer producer = session.createProducer(topico);
        Message message = session.createTextMessage("<player><id>05</id></player>");
        producer.send(message);
        session.close();
        connection.close();
        cont.close();
    }
}
