package me.gunna.exemploteste.androidapp.viewmodel;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.ui.fragments.BaseFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.BerriesFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.MovesFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.PokedexFragment;
import me.gunna.exemploteste.androidapp.ui.fragments.PokemonsFragment;


/**
 * Created by Daniel on 18/07/17.
 */

public class HomeScreenViewModel extends ViewModel {


    private FragmentManager mFragmentManager;
    private DrawerLayout mDrawer;


    public HomeScreenViewModel(FragmentManager manager, DrawerLayout drawerLayout) {
        mFragmentManager = manager;
        mDrawer = drawerLayout;
        replaceFragment(PokemonsFragment.newInstance());
    }

    public void onClickPokemon() {
        mDrawer.closeDrawers();
        replaceFragment(PokemonsFragment.newInstance());
    }

    public void onClickPokedex() {
        mDrawer.closeDrawers();
        replaceFragment(PokedexFragment.newInstance());
    }

    public void onClickMoves() {
        mDrawer.closeDrawers();
        replaceFragment(MovesFragment.newInstance());
    }

    public void onClickBerries() {
        mDrawer.closeDrawers();
        replaceFragment(BerriesFragment.newInstance());
    }


    private void replaceFragment(BaseFragment fragment) {
        if (mFragmentManager != null) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.currentView, fragment);
            transaction.commit();
        }
    }

    @Override
    public void destroy() {

    }
}
