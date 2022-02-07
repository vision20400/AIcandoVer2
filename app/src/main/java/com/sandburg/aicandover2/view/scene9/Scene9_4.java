package com.sandburg.aicandover2.view.scene9;

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
import com.sandburg.aicandover2.view.scene4.Scene4_0_3;
import com.sandburg.aicandover2.view.scene5.Scene5_2_1;

public class Scene9_4 extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    public void onBackPressed() {
        startActivity ( new Intent( this , MainActivity.class ) );
        finish ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene4_1);

        //fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene9_4_1()).commit();


        //top메뉴
        topMenu = new topMenu( 94 );

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();

        //scene 이동 버튼
        Button scene4_1_pbtn = (Button)findViewById(R.id.scene4_1_pbtn);
        Button scene4_1_nbtn = (Button)findViewById(R.id.scene4_1_nbtn);

        //radiogroup
        RadioGroup radio4_1Group = (RadioGroup) findViewById(R.id.radio4_1Group);
        radio4_1Group.check(R.id.radio4_1_1);

        scene4_1_nbtn.setVisibility(View.INVISIBLE);
        scene4_1_pbtn.setVisibility(View.INVISIBLE);
        radio4_1Group.setVisibility(View.GONE);


    }

}