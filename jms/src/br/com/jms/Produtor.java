package br.com.jms;

import javax.jms.*;
import javax.naming.InitialContext;



/**
 * Gerenciador de Envio de fila.
 * @version 1.1 - 13/10/21
 * @auhtor Igor Romão
 * @since 13/10/21
 */
public class Produtor {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando envio para fila");
        InitialContext cont = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) cont.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) cont.lookup("players");
        MessageProducer producer = session.createProducer(fila);
        Message message = session.createTextMessage("<player><id>05</id></player>");
        producer.send(message);
        session.close();
        connection.close();
        cont.close();
    }
}
