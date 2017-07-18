package me.gunna.exemploteste.androidapp.viewmodel;



import me.gunna.exemploteste.androidapp.ui.fragments.BaseFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.BerriesFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.MovesFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.PokedexFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.PokemonsFragment;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Daniel on 18/07/17.
 */

public class HomeScreenViewModel extends ViewModel {

    private PublishSubject<BaseFragment> mChangeFragmentSubject = PublishSubject.create();

    public Observable<BaseFragment> getChangeFragmentObservable(){ return mChangeFragmentSubject.asObservable();}

    public HomeScreenViewModel(){

    }

    public void onClickPokemon(){
        mChangeFragmentSubject.onNext(PokemonsFragment.newInstance());
    }
    public void onClickPokedex(){
        mChangeFragmentSubject.onNext(PokedexFragment.newInstance());
    }
    public void onClickMoves(){
        mChangeFragmentSubject.onNext(MovesFragment.newInstance());
    }
    public void onClickBerries(){
        mChangeFragmentSubject.onNext(BerriesFragment.newInstance());
    }




    @Override
    public void destroy() {

    }
}
