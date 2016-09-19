package br.com.thiengo.appnextadstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appnext.ads.fullscreen.FullScreenVideo;
import com.appnext.core.callbacks.OnAdClosed;

public class FullScreenActivity extends AppCompatActivity {
    // e9b0ea73-ace5-4d2b-bd53-cc5732104127
    private FullScreenVideo fullScreenVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        fullScreenVideo = new FullScreenVideo(this, "Seu Placement ID");
        fullScreenVideo.setOnAdClosedCallback(new OnAdClosed() {
            @Override
            public void onAdClosed() {
                finish();
            }
        });
        fullScreenVideo.loadAd();
    }

    @Override
    public void onBackPressed() {
        if( fullScreenVideo.isAdLoaded() ){
            fullScreenVideo.setVideoLength( FullScreenVideo.VIDEO_LENGTH_SHORT );
            fullScreenVideo.showAd();
        }
        else{
            finish();
        }
    }
}
