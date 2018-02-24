package br.com.mobileti.moviecatalog.api;

import br.com.mobileti.moviecatalog.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipe on 24/02/18.
 */

public class ApiBuilder {

    private static ApiBuilder INSTANCE = null;
    public static String BASE_URL = "https://api.themoviedb.org/3/";

    private ApiService apiService;

    private ApiBuilder() {
        build();
    }

    public static ApiBuilder getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApiBuilder();

        }

        return INSTANCE;
    }

    private void build() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
