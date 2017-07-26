package me.gunna.exemploteste.androidapp.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Daniel on 26/07/17.
 */

public class PokemonListResponse {
    @SerializedName("count")
    private int mPokemonCount;
    @SerializedName("results")
    private List<PokemonListItemResponse> mPokemons;
    @SerializedName("previous")
    private String previousPage;
    @SerializedName("next")
    private String nextPage;

    public int getmPokemonCount() {
        return mPokemonCount;
    }

    public void setmPokemonCount(int mPokemonCount) {
        this.mPokemonCount = mPokemonCount;
    }

    public List<PokemonListItemResponse> getmPokemons() {
        return mPokemons;
    }

    public void setmPokemons(List<PokemonListItemResponse> mPokemons) {
        this.mPokemons = mPokemons;
    }

    public String getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }
}
