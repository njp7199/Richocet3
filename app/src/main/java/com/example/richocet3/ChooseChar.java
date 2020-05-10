package com.example.richocet3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChooseChar extends AppCompatActivity {
    public static float purple = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choosechar);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseChar.this, MainActivity.class));
            }
        });

        findViewById(R.id.ninja4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purple += 5;

            }
        });
        findViewById(R.id.ninja).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purple = 0;

            }
        });



    }
}
