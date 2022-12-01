package com.example.mallads.Ads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.example.mallads.MyApp;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;


public class FbAds {


    public interface Adfinished {
        void onAdfinished();
    }

    private Context mcontext;

    public FbAds(Context context) {
        this.mcontext = context;
        AudienceNetworkAds.initialize(mcontext);
    }

    public void showBanner(RelativeLayout adContainer) {
        AdView adView = new AdView(mcontext, MyApp.BannerFacebook, AdSize.BANNER_HEIGHT_50);
        adContainer.addView(adView);
        adView.loadAd();
    }

    public void showInterstitiel(Adfinished adfinished) {

        InterstitialAd interstitialAd = new InterstitialAd(mcontext, MyApp.InterstitialFacebook );
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                adfinished.onAdfinished();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                adfinished.onAdfinished();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed

                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback

            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback

            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }



}

