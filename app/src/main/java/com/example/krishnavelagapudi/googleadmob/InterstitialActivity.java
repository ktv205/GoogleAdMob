package com.example.krishnavelagapudi.googleadmob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class InterstitialActivity extends AppCompatActivity {

    Button mShowButton;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        mShowButton=(Button)findViewById(R.id.display_interstitial_button);
        mShowButton.setEnabled(false);
    }

    public void loadInterstitialAd(){
        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.loading_interstitial));
        mInterstitialAd=new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new ToastListener(this){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mShowButton.setEnabled(true);
                mShowButton.setText(getResources().getString(R.string.display_intertitial));
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        AdRequest adRequest=new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void displayAd(View view){
        int id=view.getId();
        switch (id){
            case R.id.load_interstitial_button:
                loadInterstitialAd();
                break;
            case R.id.display_interstitial_button:
                showInterstitialAd();
                break;
            default:
                break;
        }
    }

    public void showInterstitialAd(){
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.interstitial_not_ready));


    }
}
