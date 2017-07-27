package me.gunna.exemploteste.androidapp.service;


import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by Daniel on 18/07/17.
 */

public class DataBinder  {


    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, boolean visible){
        view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

}
