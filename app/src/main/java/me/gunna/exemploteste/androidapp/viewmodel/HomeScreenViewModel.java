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

    public Observable<BaseFragment> getMenuOptionObservable(){return mMenuOptionSubject.asObservable();}

    public HomeScreenViewModel() {mMenuOptionSubject.onNext(PokemonsFragment.newInstance());}

    public void onClickPokemon() {mMenuOptionSubject.onNext(PokemonsFragment.newInstance());}

    public void onClickPokedex() {mMenuOptionSubject.onNext(PokedexFragment.newInstance());}

    public void onClickMoves()   {mMenuOptionSubject.onNext(MovesFragment.newInstance());}

    public void onClickBerries() {mMenuOptionSubject.onNext(BerriesFragment.newInstance());}

    @Override
    public void destroy() {

    }
}
