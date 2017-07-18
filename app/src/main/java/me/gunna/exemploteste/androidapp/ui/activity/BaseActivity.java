package me.gunna.exemploteste.androidapp.ui.activity;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Daniel on 18/07/17.
 */

public  abstract  class BaseActivity<B extends ViewDataBinding> extends Activity {

    protected B mViewBinding;


}
