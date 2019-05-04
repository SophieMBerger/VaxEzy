package com.vaxezy.johnlee.vaxezy.homeactivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vaxezy.johnlee.vaxezy.R;
import com.vaxezy.johnlee.vaxezy.detailactivity.DetailActivity;
import com.vaxezy.johnlee.vaxezy.recommendation.RecommendationActivity;

public class HomeActivity extends AppCompatActivity {
    LinearLayout list;
    Button recco;
    Intent cameraIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FloatingActionButton fab = findViewById(R.id.fab);
        list = findViewById(R.id.record_list);

        recco = findViewById(R.id.recommendation);
        recco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent details = new Intent(getApplicationContext(), RecommendationActivity.class);
                startActivity(details);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: navigate to camera screen
                cameraIntent = new Intent(HomeActivity.this, cameraActivity.class);
                startActivity(cameraIntent);
            }
        });

        String ndc = "993833";
        addRecords(Integer.parseInt(ndc),"Pneumococcal 28 1ML", ndc, "Left Arm", "Sunnyside Clinic", "May 9, 2019");
        String ndc2 = "223332";
        addRecords(Integer.parseInt(ndc2),"TDP 0.5ML", ndc, "Right Arm", "Vancouver General", "April 10, 2000");
    }

    private void addRecords(Integer id, String label, String ndc, String location, String clinic, String date) {
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF); //white background
        border.setStroke(1, 0xFF999999); //black border with full opacity

        LinearLayout row = new LinearLayout(this);
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        row.setOrientation(LinearLayout.VERTICAL);
        row.setBackground(border);

        // row 1
        LinearLayout row1 = new LinearLayout(getApplicationContext());
        LinearLayout.LayoutParams lparams1 = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams1.setMargins(32,16,32, 8);
        row1.setLayoutParams(lparams1);
        TextView label1 = new TextView(getApplicationContext());
        TextView label2 = new TextView(getApplicationContext());
        label1.setText(label + "      |     ");

        label2.setText(ndc);
        label1.setTextSize(20);
        label2.setTextSize(20);
        label2.setGravity(Gravity.RIGHT);
        row1.addView(label1);
        row1.addView(label2);

        // row 2
        LinearLayout row2 = new LinearLayout(getApplicationContext());
        LinearLayout.LayoutParams lparams2 = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams2.setMargins(32,8,32, 8);
        row2.setLayoutParams(lparams2);
        TextView label3 = new TextView(getApplicationContext());
        TextView label4 = new TextView(getApplicationContext());
        label3.setText(location + "     |     ");
        label4.setText(clinic);
        label3.setTextSize(20);
        label4.setTextSize(20);
        label4.setGravity(Gravity.RIGHT);
        row2.addView(label3);
        row2.addView(label4);

        // row 3
        LinearLayout row3 = new LinearLayout(getApplicationContext());
        LinearLayout.LayoutParams lparams3 = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams3.setMargins(32,8,32, 32);
        row3.setLayoutParams(lparams3);
        TextView label5 = new TextView(getApplicationContext());
        label5.setTextSize(20);
        label5.setText(date);
        row3.addView(label5);

        // finally add to row
        row.setLayoutParams(lparams);
        row.addView(row1);
        row.addView(row2);
        row.addView(row3);
        row.setId(id);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent details = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(details);
            }
        });
        list.addView(row);
    }
}
