package me.gunna.exemploteste.androidapp.ui.fragments;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.databinding.FragmentPokedexBinding;

/**
 * Created by Daniel on 18/07/17.
 */

public class PokedexFragment extends BaseFragment<FragmentPokedexBinding> {


    public static PokedexFragment newInstance() {

        Bundle args = new Bundle();

        PokedexFragment fragment = new PokedexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentPokedexBinding.inflate(inflater,container,false);
        return mViewBinding.getRoot();
    }
}
