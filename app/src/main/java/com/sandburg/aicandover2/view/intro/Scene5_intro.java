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
import com.sandburg.aicandover2.view.scene5.Scene5_1;
import com.sandburg.aicandover2.view.scene5.Scene5_2;
import com.sandburg.aicandover2.view.scene5.Scene5_3;

public class Scene5_intro extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( this , MainActivity.class ) );
        finish ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene5_intro);

        topMenu = new topMenu ( 50 );

        FragmentManager fragmentManager = getSupportFragmentManager ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();

        ImageButton scene5_1 = (ImageButton)findViewById(R.id.s5_btn1);
        ImageButton scene5_2 = (ImageButton)findViewById(R.id.s5_btn2);
        ImageButton scene5_3 = (ImageButton)findViewById(R.id.s5_btn3);

        scene5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene5_1.class));
                finish();
            }
        });

        scene5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene5_2.class));
                finish();
            }
        });

        scene5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene5_3.class));
                finish();
            }
        });
    }
}