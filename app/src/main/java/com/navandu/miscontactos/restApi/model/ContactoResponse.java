package com.navandu.miscontactos.restApi.model;

import com.navandu.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by paco on 19/4/17.
 */

public class ContactoResponse {

    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
