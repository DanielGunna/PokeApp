package me.gunna.exemploteste.androidapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.gunna.exemploteste.androidapp.databinding.FragmentPokemonsBinding;

/**
 * Created by Daniel on 18/07/17.
 */

public class PokemonsFragment extends BaseFragment<FragmentPokemonsBinding> {


    public static PokemonsFragment newInstance() {
        Bundle args = new Bundle();
        PokemonsFragment fragment = new PokemonsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Pokemons");
        mViewBinding = FragmentPokemonsBinding.inflate(inflater,container,false);
        return mViewBinding.getRoot();
    }
}
