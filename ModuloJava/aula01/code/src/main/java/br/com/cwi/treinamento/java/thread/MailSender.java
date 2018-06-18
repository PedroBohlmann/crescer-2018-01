package br.com.cwi.treinamento.java.thread;

public class MailSender {

    public void sendEmails(String ...emails) {

        for (String email : emails) {
            new Thread() {

                @Override
                public void run() {
                    System.out.printf("%s - Sending email to %s %n", Thread.currentThread().getName(), email);

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }.start();
        }

    }

}
