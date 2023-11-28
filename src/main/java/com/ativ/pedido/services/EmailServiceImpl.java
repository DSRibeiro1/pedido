// package com.ativ.pedido.services;

// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;

// @Service
// public class EmailServiceImpl implements EmailService {

// private final JavaMailSender javaMailSender;

// public EmailServiceImpl(JavaMailSender javaMailSender) {
// this.javaMailSender = javaMailSender;
// }

// @Override
// public void enviarEmail(String destinatario, String assunto, String corpo) {
// MimeMessage mimeMessage = javaMailSender.createMimeMessage();
// MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

// try {
// helper.setTo(destinatario);
// helper.setSubject(assunto);
// helper.setText(corpo, true); // O segundo parâmetro indica que o corpo é
// HTML, se for o caso.

// javaMailSender.send(mimeMessage);
// } catch (MessagingException e) {
// // Lida com exceções de envio de e-mail
// e.printStackTrace();
// }
// }
// }
