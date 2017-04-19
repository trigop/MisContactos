package com.navandu.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleContacto extends AppCompatActivity {


    //private TextView tvNombre;
    //private TextView tvEmail;
    //private TextView tvTelefono;

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";

    private ImageView imgFotoContactoDetalle;
    private TextView tvLikeDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        /*Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/


        Bundle parametros = getIntent().getExtras();
        String url = parametros.getString(KEY_EXTRA_URL);
        int likes = parametros.getInt(KEY_EXTRA_LIKES);



        tvLikeDetalle = (TextView) findViewById(R.id.tvLikeDetalle);
        tvLikeDetalle.setText(String.valueOf(likes));

        imgFotoContactoDetalle = (ImageView) findViewById(R.id.imgFotoContactoDetalle);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.like)
                .into(imgFotoContactoDetalle);

    }

/*
    public void llamar(View v) {

        String telefono = tvTelefono.getText().toString();
        Log.i("Llamada", "intentado llamar");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }


    public void enviarMail(View v){

        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto:");
        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent, "Email"));

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //Comprobamos que se pulsa el boton de retorno para lanzar una actividad
        //previamente esta actividad ha sido eliminada con finish()
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }*/
}
