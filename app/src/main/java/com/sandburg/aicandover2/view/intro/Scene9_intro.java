package com.sandburg.aicandover2.view.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sandburg.aicandover2.MainActivity;
import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.topMenu;
import com.sandburg.aicandover2.view.scene6.Scene6_1;
import com.sandburg.aicandover2.view.scene9.Scene9_4;

public class Scene9_intro extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( this , MainActivity.class ) );
        finish ();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene9_intro);

        topMenu = new topMenu ( 90 );

        FragmentManager fragmentManager = getSupportFragmentManager ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();

        ImageButton scene9_1 = (ImageButton)findViewById(R.id.s9_btn1);
        ImageButton scene9_2 = (ImageButton)findViewById(R.id.s9_btn2);
        ImageButton scene9_4 = (ImageButton)findViewById(R.id.s9_btn4);

        scene9_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=org.JTayler.lite.examples.classification"));
                startActivity(i);
            }
        });

        scene9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=org.tensorflow.lite.examples.soundclassifier"));
                startActivity(i);
            }
        });

        scene9_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene9_4.class));
                finish();
            }
        });
    }
}