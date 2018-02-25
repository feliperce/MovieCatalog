package br.com.mobileti.moviecatalog.application;

import android.app.Application;

import java.util.Locale;

/**
 * Created by felipe on 25/02/18.
 */

public class MyApplication extends Application {

    public static final String COUNTRY_CODE = String.format(
            "%s-%s",
            Locale.getDefault().getLanguage(),
            Locale.getDefault().getCountry());

    @Override
    public void onCreate() {
        super.onCreate();

    }

}
