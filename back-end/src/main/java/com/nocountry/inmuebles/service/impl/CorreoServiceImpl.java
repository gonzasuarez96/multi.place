package com.nocountry.inmuebles.service.impl;

import com.nocountry.inmuebles.service.abstraction.CorreoService;
import com.nocountry.inmuebles.util.ContactoCliente;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    private JavaMailSender mailSender;
    public CorreoServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public Boolean enviarCorreo(ContactoCliente contacto) {
        try{
            String mensaje = "Hola soy " + contacto.getName()+ " "+
                    contacto.getLast_name()+ "\n"+
                    "y estoy interesado en la propiedad que publicaste: " + contacto.getProperty_name() +"\n"+
                    "este es mi numero de telefono: " + contacto.getPhone()+ "\n"+
                    "este es mi correo: " + contacto.getEmail();

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("inmobiliariainmobiliaria132@gmail.com");
            message.setTo(contacto.getUser().email());
            message.setSubject("ESTOY INTERESADO EN LA PROPIEDAD QUE PUBLICASTE");
            message.setText(mensaje);
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }

        return true;
    }
}
