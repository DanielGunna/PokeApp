package me.gunna.exemploteste.androidapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.databinding.FragmentPokemonsBinding;
import me.gunna.exemploteste.androidapp.viewmodel.PokemonScreenViewModel;

/**
 * Created by Daniel on 18/07/17.
 */

public class PokemonsFragment extends BaseFragment<FragmentPokemonsBinding> {

    private PokemonScreenViewModel mViewModel;

    public static PokemonsFragment newInstance() {
        Bundle args = new Bundle();
        PokemonsFragment fragment = new PokemonsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.title_pokemons));

        if(mViewModel == null)
            mViewModel = new PokemonScreenViewModel();

        mViewBinding = FragmentPokemonsBinding.inflate(inflater,container,false);

        mViewBinding.setViewModel(mViewModel);

        return mViewBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.getPokemonList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel.destroy();
    }
}
