package com.example.facultades.service;

import com.example.facultades.service.model.EmailDtoContacto;
import jakarta.mail.MessagingException;


public interface IEmailService {

    public void sendMail(EmailDtoContacto email) throws MessagingException;

}
