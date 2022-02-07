package com.sandburg.aicandover2.view.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sandburg.aicandover2.MainActivity;
import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.topMenu;
import com.sandburg.aicandover2.view.scene4.Scene4_1;
import com.sandburg.aicandover2.view.scene4.Scene4_2;
import com.sandburg.aicandover2.view.scene4.Scene4_3;
import com.sandburg.aicandover2.view.scene7.Scene7_0;

public class Scene7_intro extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( this , MainActivity.class ) );
        finish ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene7_intro);

        topMenu = new topMenu ( 70 );

        FragmentManager fragmentManager = getSupportFragmentManager ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();


        ImageButton scene4_0 = (ImageButton)findViewById(R.id.s7_btn0);
        ImageButton scene4_1 = (ImageButton)findViewById(R.id.s7_btn1);
        ImageButton scene4_2 = (ImageButton)findViewById(R.id.s7_btn2);
        ImageButton scene4_3 = (ImageButton)findViewById(R.id.s7_btn3);

        scene4_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), Scene7_0.class);
                intent.putExtra("key", 0);
                startActivity(intent);
                finish();
            }
        });

        scene4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Scene7_0.class);
                intent.putExtra("key", 1);
                startActivity(intent);
                finish();
            }
        });

        scene4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Scene7_0.class);
                intent.putExtra("key", 2);
                startActivity(intent);
                finish();
            }
        });

        scene4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Scene7_0.class);
                intent.putExtra("key", 3);
                startActivity(intent);
                finish();
            }
        });
    }
}