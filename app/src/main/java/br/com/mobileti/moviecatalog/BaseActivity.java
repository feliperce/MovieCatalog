package br.com.mobileti.moviecatalog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.mobileti.moviecatalog.utils.Network;

/**
 * Created by felipe on 25/02/18.
 */

public class BaseActivity extends AppCompatActivity {

    protected boolean isConnected;

    @Override
    protected void onResume() {
        super.onResume();
        isConnected = Network.isNetworkAvailable(this);
        checkConnection();
    }

    private void checkConnection() {
        if(!isConnected) {
            Snackbar.make(getWindow().getDecorView().getRootView(),
                    "Sem conexão com a internet!",
                    Snackbar.LENGTH_SHORT).show();
        }
    }

}
