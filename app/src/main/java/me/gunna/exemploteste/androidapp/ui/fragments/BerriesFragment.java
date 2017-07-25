package me.gunna.exemploteste.androidapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.gunna.exemploteste.androidapp.databinding.FragmentBerriesBinding;


/**
 * Created by Daniel on 18/07/17.
 */

public class BerriesFragment extends BaseFragment<FragmentBerriesBinding> {
    public static BerriesFragment newInstance() {

        Bundle args = new Bundle();

        BerriesFragment fragment = new BerriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Berries");
        mViewBinding = FragmentBerriesBinding.inflate(inflater,container,false);
        return mViewBinding.getRoot();
    }
}
