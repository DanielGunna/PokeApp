package me.gunna.exemploteste.androidapp.ui.activity;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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

}
