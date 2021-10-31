package com.sandburg.aicandover2.view.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.topMenu;
import com.sandburg.aicandover2.view.scene4.Scene4_1;
import com.sandburg.aicandover2.view.scene4.Scene4_2;
import com.sandburg.aicandover2.view.scene4.Scene4_3;
import com.sandburg.aicandover2.view.scene4.Scene4_4;
import com.sandburg.aicandover2.view.scene4.Scene4_5;

public class Scene4_intro extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene4_intro);

        topMenu = new topMenu ( 40 );

        FragmentManager fragmentManager = getSupportFragmentManager ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();

        ImageButton scene4_1 = (ImageButton)findViewById(R.id.s4_btn1);
        ImageButton scene4_2 = (ImageButton)findViewById(R.id.s4_btn2);
        ImageButton scene4_3 = (ImageButton)findViewById(R.id.s4_btn3);
        ImageButton scene4_4 = (ImageButton)findViewById(R.id.s4_btn4);
        ImageButton scene4_5 = (ImageButton)findViewById(R.id.s4_btn5);

        //scene4_1 (AI란) 버튼
        scene4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene4_1.class));
                finish();
            }
        });

        //scene4_2 (AI의 역사) 버튼
        scene4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene4_2.class));
                finish();
            }
        });

        //scene4_3 (AI와 튜링 테스트) 버튼
        scene4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene4_3.class));
                finish();
            }
        });

        //scene4_4 (AI와 로봇) 버튼
        scene4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene4_4.class));
                finish();
            }
        });

        //scene4_5 (AI의 종류) 버튼
        scene4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene4_5.class));
                finish();
            }
        });

    }
}