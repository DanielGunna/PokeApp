package me.gunna.exemploteste.androidapp.service;

import me.gunna.exemploteste.androidapp.service.model.PokemonListResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Daniel on 18/07/17.
 */

public  interface  IPokeAppService {

    @GET("pokemon/")
    Observable<PokemonListResponse> getPokemonList(@Query("limit") int limit);


}
