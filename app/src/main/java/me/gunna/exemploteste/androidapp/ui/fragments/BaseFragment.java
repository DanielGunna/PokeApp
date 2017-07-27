package me.gunna.exemploteste.androidapp.ui.fragments;

import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Daniel on 18/07/17.
 */

public class BaseFragment<B extends ViewDataBinding> extends Fragment {
    protected  B mViewBinding;

    protected void replaceFragment(BaseFragment fragment, int resId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(resId, fragment);
        transaction.commit();
    }
}
