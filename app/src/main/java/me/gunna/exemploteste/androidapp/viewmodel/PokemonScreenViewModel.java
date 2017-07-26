package me.gunna.exemploteste.androidapp.viewmodel;


import com.genius.groupie.GroupAdapter;


import java.util.ArrayList;
import java.util.List;

import me.gunna.exemploteste.androidapp.app.Constants;
import me.gunna.exemploteste.androidapp.service.PokeAppService;
import me.gunna.exemploteste.androidapp.service.model.PokemonListItemResponse;
import me.gunna.exemploteste.androidapp.viewmodel.item.PokemonListItem;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Daniel on 26/07/17.
 */

public class PokemonScreenViewModel extends ViewModel {

    private GroupAdapter mPokemonsAdapter = new GroupAdapter();
    private List<PokemonListItem> mPokemonListItens;
    private List<PokemonListItemResponse> mListResponse;
    private Subscription mGetPokemonListSubscription;
    private int mItemsLoaded = 0;


    public GroupAdapter getPokemonsAdapter(){return mPokemonsAdapter;}

    public PokemonScreenViewModel() {

    }

    public void getPokemonList(){
        mGetPokemonListSubscription = PokeAppService
                .getInstance()
                .getPokemonList(Constants.ALL_POKEMONS_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(pokemonListResponse -> {
                    if(pokemonListResponse !=null)
                        return Observable.just(pokemonListResponse.getmPokemons());
                    return Observable.error(new Throwable("Response is null!"));
                })
                .subscribe(
                        pokemonListResponse ->
                            {
                                mListResponse = pokemonListResponse;
                                loadItems();
                            },
                        Throwable::printStackTrace);
    }

    private void loadItems() {

    }

    private List<PokemonListItem> getItems(List<PokemonListItemResponse> pokemonListResponse) {
        mPokemonListItens = new ArrayList<>();

        for(PokemonListItemResponse i : pokemonListResponse)
            mPokemonListItens.add( new PokemonListItem(i,this));

        return mPokemonListItens;
    }

    public void onClickItem(PokemonListItem item){
        
    }


    @Override
    public void destroy() {
        mPokemonsAdapter.clear();
        mPokemonListItens.clear();
        mGetPokemonListSubscription.unsubscribe();
    }
}
