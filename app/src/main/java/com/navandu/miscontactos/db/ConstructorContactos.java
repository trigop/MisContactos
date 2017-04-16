package com.navandu.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.navandu.miscontactos.R;
import com.navandu.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by paco on 11/4/17.
 */

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }


    public ArrayList<Contacto> obtenerDatos(){



        /*ArrayList<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Paco Montes", "777 333 222", "sss@asas.com", R.drawable.dummyimg_250, 5));
        contactos.add(new Contacto("Agustin Mata", "444 353 222", "asdfe@usduf.com", R.drawable.img400x400, 3));
        contactos.add(new Contacto("Juan Carlos", "587 100 222", "iudd@asdf.com", R.drawable.dummyimg_250, 10));
        contactos.add(new Contacto("María de la O", "220 347 222", "jasyw@asuyb.com", R.drawable.img400x400, 5));
        contactos.add(new Contacto("Dácil Perez", "696 398 222", "hasyc.com", R.drawable.dummyimg_250, 2));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db)   ;

        return db.obtenerTodosLosContactos();
    }


    public void insertarTresContactos(BaseDatos db){


        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Dacil Marina");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "48 51475 25");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "email@test.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.dummyimg_250);
        db.insertarContacto(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Adonchua del infierno");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "1455 475 25");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "email2@test.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.img400x400);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Panteruela perraca");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "99 887382");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "emailpanteruela@test.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.dummyimg_250);
        db.insertarContacto(contentValues);

    }

    public void darLikeContacto(Contacto contacto){

        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);

        db.insertarLikeContacto(contentValues);


    }

    public int obtenerLikeContacto(Contacto contacto){

        BaseDatos db = new BaseDatos(context);
        return db.obetenerLikeContacto(contacto);

    }


}
