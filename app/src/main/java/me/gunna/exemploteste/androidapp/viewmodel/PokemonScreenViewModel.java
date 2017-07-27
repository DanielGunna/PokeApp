package me.gunna.exemploteste.androidapp.viewmodel;


import android.databinding.ObservableBoolean;

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
import rx.subjects.PublishSubject;

/**
 * Created by Daniel on 26/07/17.
 */

public class PokemonScreenViewModel extends ViewModel {

    private GroupAdapter mPokemonsAdapter = new GroupAdapter();
    private List<PokemonListItem> mPokemonListItens;
    private List<PokemonListItemResponse> mListResponse;
    private Subscription mGetPokemonListSubscription;
    private ObservableBoolean mIsLoading = new ObservableBoolean();
    private PublishSubject<PokemonListItemResponse> mOnClickSubject = PublishSubject.create();

    public Observable<PokemonListItemResponse> getOnClickObservable(){ return  mOnClickSubject.asObservable();}

    public ObservableBoolean getIsLoading(){return  mIsLoading;}

    public GroupAdapter getPokemonsAdapter() {
        return mPokemonsAdapter;
    }

    public PokemonScreenViewModel() {}

    public void getPokemonList() {
        mIsLoading.set(true);
        if (mListResponse == null) {
            getPokemonListApiCall();
        }else{
            mPokemonsAdapter.addAll(getItems(mListResponse));
            mIsLoading.set(false);
        }
    }

    private void setupPokemonsList(List<PokemonListItemResponse> pokemonListResponse){
        mListResponse = pokemonListResponse;
        mPokemonsAdapter.addAll(getItems(pokemonListResponse));
        mIsLoading.set(false);
    }

    private void getPokemonListApiCall(){
        mGetPokemonListSubscription = PokeAppService
                .getInstance()
                .getPokemonList(Constants.ALL_POKEMONS_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(pokemonListResponse -> {
                    if (pokemonListResponse != null)
                        return Observable.just(pokemonListResponse.getmPokemons());
                    return Observable.error(new Throwable("Response is null!"));
                })
                .subscribe(this::setupPokemonsList,Throwable::printStackTrace);
    }

    private List<PokemonListItem> getItems(List<PokemonListItemResponse> pokemonListResponse) {
        mPokemonListItens = new ArrayList<>();

        for (PokemonListItemResponse i : pokemonListResponse)
            mPokemonListItens.add(new PokemonListItem(i, this));

        return mPokemonListItens;
    }

    public void onClickItem(PokemonListItem item) {
        mOnClickSubject.onNext(item.getItemResponse());
    }

    @Override
    public void destroy() {
        mPokemonsAdapter.clear();
        mPokemonListItens.clear();
        mGetPokemonListSubscription.unsubscribe();
    }
}
