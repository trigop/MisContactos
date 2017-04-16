package com.navandu.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navandu.miscontactos.R;
import com.navandu.miscontactos.adapter.ContactoAdaptador;
import com.navandu.miscontactos.pojo.Contacto;
import com.navandu.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.navandu.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by paco on 1/4/17.
 */

public class RecyclerViewFragment extends Fragment implements IReciclerViewFragmentView{


    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }



    /*
    public void inicializarListaContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contacto("Paco Montes", "777 333 222", "sss@asas.com", R.drawable.dummyimg_250, likes));
        contactos.add(new Contacto("Agustin Mata", "444 353 222", "asdfe@usduf.com", R.drawable.img400x400, likes));
        contactos.add(new Contacto("Juan Carlos", "587 100 222", "iudd@asdf.com", R.drawable.dummyimg_250, likes));
        contactos.add(new Contacto("María de la O", "220 347 222", "jasyw@asuyb.com", R.drawable.img400x400, likes));
        contactos.add(new Contacto("Dácil Perez", "696 398 222", "hasyc.com", R.drawable.dummyimg_250, likes));




    }*/

    @Override
    public void generarLinearLayoutVertical() {

        //Declaramos
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager llm = new GridLayoutManager(this, 2);
        listaContactos.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {

        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {

        listaContactos.setAdapter(adaptador);

    }
}
