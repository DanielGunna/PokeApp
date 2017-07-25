package me.gunna.exemploteste.androidapp.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.databinding.ActivityMainBinding;
import me.gunna.exemploteste.androidapp.viewmodel.HomeScreenViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private HomeScreenViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewBinding = DataBindingUtil.setContentView(this, R.layout. activity_main);

        mViewModel = new HomeScreenViewModel(getSupportFragmentManager(),mViewBinding.draweLayout);

        mViewBinding.setViewModel(mViewModel);

        setUpToolbar();
        setupDrawerMenu();
    }

    private void setupDrawerMenu() {
        mViewBinding.draweLayout.addDrawerListener(getToogle());
    }


    private void setUpToolbar() {
        Toolbar toolbar = mViewBinding.toolbarBinding.toolbar;
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    public DrawerLayout.DrawerListener getToogle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mViewBinding.draweLayout,
                mViewBinding.toolbarBinding.toolbar, 0, 0) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        toggle.syncState();
        return  toggle;
    }
}
