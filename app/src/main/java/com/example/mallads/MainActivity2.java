package com.example.mallads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //  Log.e("cccc", String.valueOf(MyApp.isJsonDone));
                if(MyApp.isJsonDone == 0){
                    handler.postDelayed(this,CustomUtils.TIME);
                }
                else if(MyApp.isJsonDone == 1)
                {
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);

                }
                else if(MyApp.isJsonDone == 2){
                    Toast.makeText(getApplicationContext(), "Error Plese try again later", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        },CustomUtils.TIME);

    }
}