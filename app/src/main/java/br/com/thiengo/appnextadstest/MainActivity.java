package br.com.thiengo.appnextadstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.appnext.ads.interstitial.Interstitial;
import com.appnext.ads.interstitial.InterstitialConfig;
import com.appnext.core.callbacks.OnAdLoaded;

public class MainActivity extends AppCompatActivity {
    private Interstitial interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interstitial = new Interstitial(this,
                                        "Seu Placement ID5",
                                        getConfig() );
        interstitial.setOnAdLoadedCallback(new OnAdLoaded() {
            @Override
            public void adLoaded() {
                Log.i("log", "adLoaded()");
            }
        });
        interstitial.loadAd();
    }


    public void openActivity( View view ){
        Intent intent = null;

        if( view.getId() == R.id.button_1 ){
            intent = new Intent(this, FullScreenActivity.class);
        }
        else if( view.getId() == R.id.button_2 ){
            intent = new Intent(this, RewardedActivity.class);
        }
        startActivity( intent );
    }


    public void displayAd( View view ){
        if( interstitial.isAdLoaded() ){
            interstitial.showAd();
        }
    }

    private InterstitialConfig getConfig(){
        InterstitialConfig config = new InterstitialConfig();
        config.setButtonText("Instalar");
        config.setButtonColor("#ff0000");
        config.setSkipText("Sair");

        return config;
    }
}
