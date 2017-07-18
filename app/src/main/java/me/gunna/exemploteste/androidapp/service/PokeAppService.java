package me.gunna.exemploteste.androidapp.service;

import me.gunna.exemploteste.androidapp.BuildConfig;
import me.gunna.exemploteste.androidapp.helper.RxErrorHandlingCallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel on 18/07/17.
 */

public class PokeAppService {

    private static IPokeAppService sInstance;



    public static IPokeAppService getInstance(){
        if(sInstance == null)
            createIntance();

        return sInstance;
    }

    private static void createIntance() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logInterceptor);
        }

        Retrofit retrofitInstance = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .build();

        sInstance = retrofitInstance.create(IPokeAppService.class);

    }


}
