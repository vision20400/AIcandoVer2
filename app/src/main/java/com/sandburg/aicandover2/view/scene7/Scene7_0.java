package com.sandburg.aicandover2.view.scene7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.sandburg.aicandover2.MainActivity;
import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.topMenu;
import com.sandburg.aicandover2.view.intro.Scene6_intro;
import com.sandburg.aicandover2.view.intro.Scene7_intro;
import com.sandburg.aicandover2.view.scene4.Scene4_0_3;
import com.sandburg.aicandover2.view.scene6.Scene6_3_1;

public class Scene7_0 extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( this , Scene7_intro.class ) );
        finish ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene4_1);

        Intent secondIntent = getIntent();
        int key = secondIntent.getIntExtra("key",1);

        switch (key){
            case 0:
                topMenu = new topMenu(70);
                break;
            case 1:
                topMenu = new topMenu(71);
                break;
            case 2:
                topMenu = new topMenu(72);
                break;
            case 3:
                topMenu = new topMenu(73);
                break;
        }

        //fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(key == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene7_0_1()).commit();

        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene7_0_0(key)).commit();
        }

        fragmentTransaction.add(R.id.topMenuFrame, topMenu);
        fragmentTransaction.commit();

        //scene ?????? ??????
        Button scene4_1_pbtn = (Button) findViewById(R.id.scene4_1_pbtn);
        Button scene4_1_nbtn = (Button) findViewById(R.id.scene4_1_nbtn);

        scene4_1_pbtn.setVisibility(View.INVISIBLE);
        scene4_1_nbtn.setVisibility(View.INVISIBLE);
        //radiogroup
        RadioGroup radio4_1Group = (RadioGroup) findViewById(R.id.radio4_1Group);
        radio4_1Group.setVisibility(View.GONE);

    }
}