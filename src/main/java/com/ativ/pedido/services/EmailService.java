package com.ativ.pedido.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    // Construtor que recebe um JavaMailSender como dependência
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    // Método para enviar e-mails
    public void sendEmail(String to, String subject, String text) {
        // Criação de um objeto SimpleMailMessage para representar o e-mail
        SimpleMailMessage message = new SimpleMailMessage();

        // Configuração do destinatário, assunto e corpo da mensagem
        message.setTo(to); // destinatario
        message.setSubject(subject); // assunto
        message.setText(text); // corpo da mensagem

        // Envio da mensagem usando o JavaMailSender
        javaMailSender.send(message); // msg enviada
    }
}
