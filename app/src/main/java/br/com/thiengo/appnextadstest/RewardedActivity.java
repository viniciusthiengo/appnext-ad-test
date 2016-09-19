package br.com.thiengo.appnextadstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.appnext.ads.fullscreen.FullScreenVideo;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.callbacks.OnAdLoaded;

public class RewardedActivity extends AppCompatActivity {
    private RewardedVideo rewardedVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded);

        rewardedVideo = new RewardedVideo(this, "Seu Placement ID");
        rewardedVideo.setOnAdLoadedCallback(new OnAdLoaded() {
            @Override
            public void adLoaded() {
                rewardedVideo.setRewardsAmountRewarded("1000");
                rewardedVideo.setRewardsUserId("65s4d6v5sd4v");
                rewardedVideo.setRewardsRewardTypeCurrency("points");
            }
        });
        rewardedVideo.loadAd();
    }

    public void displayAd( View view ){
        if( rewardedVideo.isAdLoaded() ){
            rewardedVideo.setVideoLength(FullScreenVideo.VIDEO_LENGTH_SHORT);
            rewardedVideo.showAd();
        }
    }
}
