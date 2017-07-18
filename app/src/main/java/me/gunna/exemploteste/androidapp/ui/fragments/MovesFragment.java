package me.gunna.exemploteste.androidapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import me.gunna.exemploteste.androidapp.databinding.FragmentMovesBinding;

/**
 * Created by Daniel on 18/07/17.
 */

public class MovesFragment extends BaseFragment<FragmentMovesBinding> {

    public static MovesFragment newInstance() {

        Bundle args = new Bundle();

        MovesFragment fragment = new MovesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentMovesBinding.inflate(inflater,container,false);
        return mViewBinding.getRoot();
    }
}
