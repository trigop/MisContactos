package com.navandu.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.navandu.miscontactos.db.ConstructorContactos;
import com.navandu.miscontactos.pojo.Contacto;
import com.navandu.miscontactos.DetalleContacto;
import com.navandu.miscontactos.R;

import java.util.ArrayList;

/**
 * Created by paco on 27/3/17.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {


    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.activity = activity;
        this.contactos = contactos;
    }


    //Infla el layout y lo pasa al viewHolder para que el obtenga cada elemento(view)
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada View

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvLike.setText(String.valueOf(contacto.getLikes()) + " Likes");

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "entramos a el contacto: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Implementamos Like" + contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);

                contactoViewHolder.tvLike.setText(String.valueOf(constructorContactos.obtenerLikeContacto(contacto)) + " Likes");

            }
        });

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return contactos.size();
    }


    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLike;



        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFotoContacto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreContacto);
            tvTelefonoCV    = (TextView) itemView.findViewById(R.id.tvTlfContacto);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLike          = (TextView) itemView.findViewById(R.id.tvLike);



        }
    }



}
