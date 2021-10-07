package br.com.jms;
import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;

/**
 * Gerenciador de processos de eventos de cartão.
 * @auhtor Igor Romão
 * @version 1.1 - 07/10/21
 * @since 07/10/21
 */
public class Consumidor {
    public static void main(String[] args) throws Exception {

        System.out.println("Iniciando fila");
        InitialContext cont = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) cont.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        new Scanner(System.in).nextLine();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) cont.lookup("players");
        MessageConsumer consumer = session.createConsumer(fila);
        Message message = consumer.receive();
        System.out.println("Recebendo mensagem " + message);
        session.close();
        connection.close();
        cont.close();
    }
}
