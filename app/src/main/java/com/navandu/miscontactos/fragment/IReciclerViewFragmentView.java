package com.navandu.miscontactos.fragment;

import com.navandu.miscontactos.adapter.ContactoAdaptador;
import com.navandu.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by paco on 11/4/17.
 */

public interface IReciclerViewFragmentView {



    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);




}
