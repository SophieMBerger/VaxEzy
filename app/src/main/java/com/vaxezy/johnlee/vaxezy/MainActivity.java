package com.vaxezy.johnlee.vaxezy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.vaxezy.johnlee.vaxezy.homeactivity.HomeActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout screen;
    private LottieAnimationView syringe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screen = findViewById(R.id.splash_screen);

        screen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        syringe = findViewById(R.id.syringe);
        syringe.playAnimation();
    }
}
