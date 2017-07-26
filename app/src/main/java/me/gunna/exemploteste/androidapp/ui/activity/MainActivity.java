package me.gunna.exemploteste.androidapp.ui.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.databinding.ActivityMainBinding;
import me.gunna.exemploteste.androidapp.ui.fragments.BaseFragment;
import me.gunna.exemploteste.androidapp.viewmodel.HomeScreenViewModel;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private HomeScreenViewModel mViewModel;
    private CompositeSubscription mSubscriptions = new  CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewBinding = DataBindingUtil.setContentView(this, R.layout. activity_main);

        mViewModel = new HomeScreenViewModel();

        mViewBinding.setViewModel(mViewModel);

        setUpToolbar(mViewBinding.toolbarBinding.toolbar);
        setupDrawerMenu();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!mSubscriptions.hasSubscriptions())
            addMenuSubscription();
    }

    private void addMenuSubscription() {
        mSubscriptions.add(mViewModel
                .getMenuOptionObservable()
                .subscribe(this::replaceFragment)
        );
    }

    private void setupDrawerMenu() {
        mViewBinding.draweLayout.addDrawerListener(getToogle());
    }

    private void replaceFragment(BaseFragment fragment) {
        mViewBinding.draweLayout.closeDrawers();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.currentView, fragment);
        transaction.commit();
    }

    public DrawerLayout.DrawerListener getToogle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mViewBinding.draweLayout,
                mViewBinding.toolbarBinding.toolbar, 0, 0) {
            @Override
            public void onDrawerClosed(View drawerView) {super.onDrawerClosed(drawerView);}

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        toggle.syncState();
        return  toggle;
    }
}
