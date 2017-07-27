package me.gunna.exemploteste.androidapp.ui.activity;





import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import me.gunna.exemploteste.androidapp.databinding.FragmentPokemonDetailsBinding;
import me.gunna.exemploteste.androidapp.service.model.PokemonListItemResponse;
import me.gunna.exemploteste.androidapp.ui.fragments.BaseFragment;

/**
 * Created by Daniel on 27/07/17.
 */

public class PokemonDetailsFragment extends BaseFragment<FragmentPokemonDetailsBinding> {

    private static  final String ARG_POKEMON = "ARG_POKEMON";

    public static PokemonDetailsFragment newInstance(PokemonListItemResponse response) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_POKEMON, Parcels.wrap(response));
        PokemonDetailsFragment fragment = new PokemonDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewBinding = FragmentPokemonDetailsBinding.inflate(inflater,container,false);

        return mViewBinding.getRoot();
    }
}
