package me.gunna.exemploteste.androidapp.ui.activity;


import android.databinding.ViewDataBinding;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.ui.fragments.BaseFragment;

/**
 * Created by Daniel on 18/07/17.
 */

public  abstract  class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B mViewBinding;

    protected void setUpToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void replaceFragment(BaseFragment fragment, int resId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(resId, fragment);
        transaction.commit();
    }

}
