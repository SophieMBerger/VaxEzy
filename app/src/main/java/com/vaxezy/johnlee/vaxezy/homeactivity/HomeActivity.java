package com.vaxezy.johnlee.vaxezy.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vaxezy.johnlee.vaxezy.R;

public class HomeActivity extends AppCompatActivity {

    Intent cameraIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: navigate to camera screen
                cameraIntent = new Intent(HomeActivity.this, cameraActivity.class);
                startActivity(cameraIntent);
            }
        });
    }


}
