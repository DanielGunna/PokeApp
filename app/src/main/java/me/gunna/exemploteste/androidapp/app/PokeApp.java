package me.gunna.exemploteste.androidapp.app;

import android.app.Application;

import com.miguelbcr.ui.rx_paparazzo.RxPaparazzo;

import me.gunna.exemploteste.androidapp.R;
import rx_activity_result.RxActivityResult;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Daniel on 18/07/17.
 */

public class PokeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RxActivityResult.register(this);
        RxPaparazzo.register(this);
        setUpDefaultFont();
    }




    private void setUpDefaultFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.montserrat_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
