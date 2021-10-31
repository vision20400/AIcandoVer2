package com.sandburg.aicandover2.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sandburg.aicandover2.MainActivity;
import com.sandburg.aicandover2.R;


public class Splash2Activity extends AppCompatActivity { //#씬2(시작화면)

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash2);

            //시작 버튼
            ImageButton startBtn = (ImageButton)findViewById(R.id.splash2_btn);
            startBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(v.getContext(), MainActivity.class));
                    finish();
                }
            });
        }
    }