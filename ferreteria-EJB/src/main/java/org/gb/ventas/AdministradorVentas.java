package org.gb.ventas;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 * Created by gustavo on 25/11/14.
 */
@Stateless
public class AdministradorVentas {

    @Resource(name = "java:jboss/exported/jms/queue/test")
    private Queue queue;

    @Resource(name = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;


    public String holaAdminVentas(){
        return "Hola administrador de ventas";
    }

    public void crearMensaje(){
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            //MessageConsumer consumer = session.createConsumer(queue);
            connection.start();
            TextMessage textMessage = session.createTextMessage("Mi primer mensaje JMS");
            messageProducer.send(textMessage);
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
