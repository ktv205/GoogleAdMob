package com.example.krishnavelagapudi.googleadmob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayAd(View view){
        int id=view.getId();
        switch (id){
            case R.id.banner_button:
                startActivity(new Intent(this,BannerActivity.class));
                break;
            case R.id.interstitial_button:
                startActivity(new Intent(this,InterstitialActivity.class));
                break;
            default:
                break;
        }
    }

}
