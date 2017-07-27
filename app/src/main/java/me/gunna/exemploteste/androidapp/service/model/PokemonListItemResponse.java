package me.gunna.exemploteste.androidapp.service.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


/**
 * Created by Daniel on 26/07/17.
 */
@Parcel(Parcel.Serialization.BEAN)
public class PokemonListItemResponse {
    @SerializedName("url")
    private String pokemonUrl;
    @SerializedName("name")
    private String pokemonName;


    public String getPokemonUrl() {
        return pokemonUrl;
    }

    public void setPokemonUrl(String pokemonUrl) {
        this.pokemonUrl = pokemonUrl;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getId(){
        return Integer.parseInt(pokemonUrl.split("/")[6]);
    }
}
