package com.navandu.miscontactos.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.navandu.miscontactos.restApi.ConstantesRestApi;
import com.navandu.miscontactos.restApi.EndpointsApi;
import com.navandu.miscontactos.restApi.deserializador.ContactoDeserializador;
import com.navandu.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paco on 19/4/17.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());

        return gsonBuilder.create();

    }

}
