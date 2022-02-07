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
import com.sandburg.aicandover2.view.scene5.Scene5_1;
import com.sandburg.aicandover2.view.scene5.Scene5_2;
import com.sandburg.aicandover2.view.scene5.Scene5_3;
import com.sandburg.aicandover2.view.scene6.Scene6_1;
import com.sandburg.aicandover2.view.scene6.Scene6_2;
import com.sandburg.aicandover2.view.scene6.Scene6_3;

public class Scene6_intro extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( this , MainActivity.class ) );
        finish ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene6_intro);

        topMenu = new topMenu ( 60 );

        FragmentManager fragmentManager = getSupportFragmentManager ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();

        ImageButton scene6_1 = (ImageButton)findViewById(R.id.s6_btn1);
        ImageButton scene6_2 = (ImageButton)findViewById(R.id.s6_btn2);
        ImageButton scene6_3 = (ImageButton)findViewById(R.id.s6_btn3);

        scene6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene6_1.class));
                finish();
            }
        });
        scene6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene6_2.class));
                finish();
            }
        });

        scene6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene6_3.class));
                finish();
            }
        });
    }
}