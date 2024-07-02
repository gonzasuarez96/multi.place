package com.nocountry.inmuebles.service.abstraction;

import com.nocountry.inmuebles.util.ContactoCliente;

public interface CorreoService {
     Boolean enviarCorreo(ContactoCliente contacto);
}
