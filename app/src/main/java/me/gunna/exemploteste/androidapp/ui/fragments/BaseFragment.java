package me.gunna.exemploteste.androidapp.ui.fragments;

import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;

/**
 * Created by Daniel on 18/07/17.
 */

public class BaseFragment<B extends ViewDataBinding> extends Fragment {
    protected  B mViewBinding;
}
