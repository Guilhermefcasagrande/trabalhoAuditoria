/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Guilherme
 */
public class EnvioEmail {

    public void enviaEmail() {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("trabalhosemauditoria@gmail.com", "32547698");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        //session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("trabalhosemauditoria@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse("guilhermefranciscocasagrande@gmail.com");

            message.setRecipients(Message.RecipientType.TO, toUser);
            //Assunto
            message.setSubject("Enviando email com JavaMail");
            //Corpo
            message.setText("Teste de envio de email para trablho do Paulinho. Se receber, responde essa porra. By: Guilherme F. C.");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
