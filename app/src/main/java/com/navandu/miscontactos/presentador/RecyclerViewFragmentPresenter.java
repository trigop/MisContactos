package com.navandu.miscontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.navandu.miscontactos.adapter.ContactoAdaptador;
import com.navandu.miscontactos.db.ConstructorContactos;
import com.navandu.miscontactos.fragment.IReciclerViewFragmentView;
import com.navandu.miscontactos.pojo.Contacto;
import com.navandu.miscontactos.restApi.EndpointsApi;
import com.navandu.miscontactos.restApi.adapter.RestApiAdapter;
import com.navandu.miscontactos.restApi.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obetenerContactosBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obetenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();

            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión !", Toast.LENGTH_LONG).show();
                Log.e("FALLO EN LA CONEXION", t.toString());
            }
        });

    }

    @Override
    public void mostrarContactosRV() {

        iReciclerViewFragmentView.inicializarAdaptadorRV(iReciclerViewFragmentView.crearAdaptador(contactos));
        //iReciclerViewFragmentView.generarLinearLayoutVertical();
        iReciclerViewFragmentView.generarGridLayout();

    }
}
