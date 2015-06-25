package com.example.krishnavelagapudi.googleadmob;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;

public class ToastListener extends AdListener {
    Toast toast;
    Context mContext;

    ToastListener(Context context){
        mContext=context;
    }
    @Override
    public void onAdClosed() {
        super.onAdClosed();
        if(toast!=null){
            toast.cancel();
        }
        toast=Toast.makeText(mContext,"ad closed",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        super.onAdFailedToLoad(errorCode);
        if(toast!=null){
            toast.cancel();
        }
        toast=Toast.makeText(mContext,"ad failed",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
        if(toast!=null){
            toast.cancel();
        }
        toast=Toast.makeText(mContext,"ad loaded",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onAdOpened() {
        super.onAdOpened();
        if(toast!=null){
            toast.cancel();
        }
        toast=Toast.makeText(mContext,"ad opened",Toast.LENGTH_SHORT);
        toast.show();
    }
}
