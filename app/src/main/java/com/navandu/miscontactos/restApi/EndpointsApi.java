package com.navandu.miscontactos.restApi;

import com.navandu.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by paco on 19/4/17.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

}
