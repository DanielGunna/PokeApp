package me.gunna.exemploteste.androidapp.viewmodel;


import me.gunna.exemploteste.androidapp.ui.fragments.BaseFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.BerriesFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.MovesFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.PokedexFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.PokemonsFragment;
import rx.Observable;
import rx.subjects.ReplaySubject;


/**
 * Created by Daniel on 18/07/17.
 */

public class HomeScreenViewModel extends ViewModel {
    private final ReplaySubject<BaseFragment> mMenuOptionSubject = ReplaySubject.create();
    private static final int FRAG_ID_POKEMONS =  0;
    private static final int FRAG_ID_POKEDEX  =  1;
    private static final int FRAG_ID_MOVES    =  2;
    private static final int FRAG_ID_BERRIES  =  3;

    private final BaseFragment[] mMenuFragments = {
            PokemonsFragment.newInstance(),
            PokedexFragment.newInstance(),
            MovesFragment.newInstance(),
            BerriesFragment.newInstance()
    };

    public Observable<BaseFragment> getMenuOptionObservable(){return mMenuOptionSubject.asObservable();}

    public HomeScreenViewModel() {mMenuOptionSubject.onNext(mMenuFragments[FRAG_ID_POKEMONS]);}

    public void onClickPokemon() {mMenuOptionSubject.onNext(mMenuFragments[FRAG_ID_POKEMONS]);}

    public void onClickPokedex() {mMenuOptionSubject.onNext(mMenuFragments[FRAG_ID_POKEDEX]);}

    public void onClickMoves()   {mMenuOptionSubject.onNext(mMenuFragments[FRAG_ID_MOVES]);}

    public void onClickBerries() {mMenuOptionSubject.onNext(mMenuFragments[FRAG_ID_BERRIES]);}

    @Override
    public void destroy() {

    }
}
