package com.navandu.miscontactos.presentador;

import android.content.Context;

import com.navandu.miscontactos.adapter.ContactoAdaptador;
import com.navandu.miscontactos.db.ConstructorContactos;
import com.navandu.miscontactos.fragment.IReciclerViewFragmentView;
import com.navandu.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by paco on 11/4/17.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{


    private IReciclerViewFragmentView iReciclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;


    public RecyclerViewFragmentPresenter(IReciclerViewFragmentView iReciclerViewFragmentView, Context context) {
        this.iReciclerViewFragmentView = iReciclerViewFragmentView;
        this.context = context;
        obetenerContactosBaseDatos();
    }


    @Override
    public void obetenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {

        iReciclerViewFragmentView.inicializarAdaptadorRV(iReciclerViewFragmentView.crearAdaptador(contactos));
        iReciclerViewFragmentView.generarLinearLayoutVertical();

    }
}
