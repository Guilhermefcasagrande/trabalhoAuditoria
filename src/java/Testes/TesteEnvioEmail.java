/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Guilherme
 */
public class TesteEnvioEmail {

    public static void main(String[] args) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com.br"); // o servidor SMTP para envio do e-mail
        email.addTo("guilhermefc@unidavi.edu.br", "Guilherme Francisco"); //destinatário
        email.setFrom("guilhermefranciscocasagrande@gmail.com", "Me"); // remetente
        email.setSubject("Mensagem de Teste"); // assunto do e-mail
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
        email.send(); //envia o e-mail
    }
}
