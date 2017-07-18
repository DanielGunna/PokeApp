package me.gunna.exemploteste.androidapp.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewBinding = DataBindingUtil.setContentView(this, R.layout. activity_main);





    }
}
