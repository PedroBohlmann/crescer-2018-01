package br.com.cwi.treinamento.java.thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailSenderTest {

    @Test
    public void shouldSendEmailsInParallel() {
        MailSender mailSender = new MailSender();

        mailSender.sendEmails("a@test.com", "b@test.com", "c@test.com");
    }

}