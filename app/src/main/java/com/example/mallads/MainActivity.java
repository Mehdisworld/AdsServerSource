package com.example.mallads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mallads.Ads.AdmobAds;
import com.example.mallads.Ads.FbAds;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class MainActivity extends AppCompatActivity {

    Button letStart;
    AdmobAds admobAds;
    FbAds fbAds;
    RelativeLayout adLayout;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        letStart = findViewById(R.id.letStart);
        //--------------------
        adLayout = findViewById(R.id.adLayout);
        fbAds=new FbAds(this);
        admobAds = new AdmobAds(this);
       if(MyApp.NetworkAds.equalsIgnoreCase("admob")){
         admobAds.showBanner(adLayout);
        }else {
           fbAds.showBanner(adLayout);
        }
        //--------------------

       admobAds.loadInter();

      //  fbAds.showInter();

        letStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MyApp.NetworkAds.equalsIgnoreCase("admob")){
                    admobAds.showInter(new AdmobAds.AdFinished() {
                        @Override
                        public void onAdFinished() {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }else{

                    fbAds.showInterstitiel(new FbAds.Adfinished() {
                        @Override
                        public void onAdfinished() {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    });



                }

            }
        });


    }
}