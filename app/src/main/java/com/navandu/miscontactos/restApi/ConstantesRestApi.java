package com.navandu.miscontactos.restApi;

/**
 * Created by paco on 19/4/17.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/users/self/?access_token=32301124.310f25b.6a91a840d8134c49b9a81078ac6d8fb5

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "32301124.310f25b.6a91a840d8134c49b9a81078ac6d8fb5";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=32301124.310f25b.6a91a840d8134c49b9a81078ac6d8fb5







}
