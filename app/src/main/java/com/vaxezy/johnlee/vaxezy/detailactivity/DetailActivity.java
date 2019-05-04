package com.vaxezy.johnlee.vaxezy.detailactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vaxezy.johnlee.vaxezy.R;

public class DetailActivity extends AppCompatActivity {
    TextView label;
    TextView clinic;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        label = findViewById(R.id.label);
        clinic = findViewById(R.id.clinic);
        date = findViewById(R.id.date);

        label.setText("Pneumococcal 28 0.5 ML");
        clinic.setText("Sunnyside Clinic");
        date.setText("May 9, 2019");
    }
}
