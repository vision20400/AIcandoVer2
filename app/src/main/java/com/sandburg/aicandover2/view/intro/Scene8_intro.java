package com.sandburg.aicandover2.view.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.sandburg.aicandover2.MainActivity;
import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.topMenu;
import com.sandburg.aicandover2.view.scene4.Scene4_0_1;
import com.sandburg.aicandover2.view.scene8.Scene8_0;
import com.sandburg.aicandover2.view.scene8.Scene8_1;

public class Scene8_intro extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;
    private int val;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent ( this , MainActivity.class ) );
        finish ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene4_1);

        //fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        //scene 이동 버튼
        Button scene4_1_pbtn = (Button)findViewById(R.id.scene4_1_pbtn);
        Button scene4_1_nbtn = (Button)findViewById(R.id.scene4_1_nbtn);

        //radiogroup
        RadioGroup radio4_1Group = (RadioGroup) findViewById(R.id.radio4_1Group);

        scene4_1_nbtn.setVisibility(View.INVISIBLE);
        scene4_1_pbtn.setVisibility(View.INVISIBLE);
        radio4_1Group.setVisibility(View.GONE);

        Intent intent = getIntent ();
        val = intent.getExtras ().getInt ( "val" );


        switch (val) {
            case 80:
                topMenu = new topMenu( 80 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_0()).commit();
                break;
            case 81:
                topMenu = new topMenu( 81 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(81)).commit();
                break;
            case 82:
                topMenu = new topMenu( 82 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(82)).commit();
                break;
            case 83:
                topMenu = new topMenu( 83 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(83)).commit();
                break;
            case 84:
                topMenu = new topMenu( 84 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(84)).commit();
                break;
            case 85:
                topMenu = new topMenu( 85 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(85)).commit();
                break;
            case 86:
                topMenu = new topMenu( 86 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(86)).commit();
                break;
            case 87:
                topMenu = new topMenu( 87 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(87)).commit();
                break;
            case 88:
                topMenu = new topMenu( 88 );
                fragmentTransaction.replace(R.id.topMenuFrame , topMenu ).commit ();
                getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene8_1(88)).commit();
                break;
        }

    }
}