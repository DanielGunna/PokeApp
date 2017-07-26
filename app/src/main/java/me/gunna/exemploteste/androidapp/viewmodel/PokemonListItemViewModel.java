package me.gunna.exemploteste.androidapp.viewmodel;

import me.gunna.exemploteste.androidapp.service.model.PokemonListItemResponse;
import me.gunna.exemploteste.androidapp.viewmodel.item.PokemonListItem;

/**
 * Created by Daniel on 26/07/17.
 */

public class PokemonListItemViewModel extends  ViewModel{

    private PokemonListItemResponse mItemResponse;
    private PokemonListItem mItem;


    public PokemonListItemViewModel(PokemonListItemResponse mItemResponse, PokemonListItem item) {
        this.mItemResponse = mItemResponse;
        this.mItem = item;
    }

    public String getPokemonName(){return mItemResponse.getPokemonName();}

    public String getPokemonId(){return  String.valueOf(mItemResponse.getId());}

    public PokemonListItem getItem(){ return mItem;}

    @Override
    public void destroy() {

    }
}
