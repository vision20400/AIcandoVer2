package com.sandburg.aicandover2.view.scene6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.topMenu;
import com.sandburg.aicandover2.view.scene4.Scene4_0_1;
import com.sandburg.aicandover2.view.scene4.Scene4_0_3;

public class Scene6_2 extends AppCompatActivity {
    private com.sandburg.aicandover2.topMenu topMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene4_1);

        //fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene4_0_1("RBhtc3wN0Qs")).commit();


        //top메뉴
        topMenu = new topMenu( 62 );

        fragmentTransaction.add ( R.id.topMenuFrame , topMenu );
        fragmentTransaction.commit ();

        //scene 이동 버튼
        Button scene4_1_pbtn = (Button)findViewById(R.id.scene4_1_pbtn);
        Button scene4_1_nbtn = (Button)findViewById(R.id.scene4_1_nbtn);

        //radiogroup
        RadioGroup radio4_1Group = (RadioGroup) findViewById(R.id.radio4_1Group);
        radio4_1Group.check(R.id.radio4_1_1);

        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radio4_1_3);
        radioButton1.setButtonDrawable(R.drawable.radio_plus1);

        //버튼 세팅
        changeButton(scene4_1_pbtn,scene4_1_nbtn,1,radio4_1Group);

        //radiogroup setOnCheckedChangeListener
        radio4_1Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio4_1_1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene4_0_1("RBhtc3wN0Qs")).commit();
                    changeButton(scene4_1_pbtn,scene4_1_nbtn,1,group);
                }
                else if(checkedId == R.id.radio4_1_2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene6_2_2()).commit();
                    changeButton(scene4_1_pbtn,scene4_1_nbtn,2,group);
                }
                else if(checkedId == R.id.radio4_1_3){
                    getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene4_0_3(62)).commit();
                    changeButton(scene4_1_pbtn,scene4_1_nbtn,3,group);
                }
            }
        });


    }

    public boolean changeButton(Button btn1, Button btn2, int view, RadioGroup group){
        switch (view) {
            case 1 :
                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.VISIBLE);
                //btn2.setText("퀴즈");

                //back.setBackgroundResource(R.drawable.scene_4_1_1back);

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene6_2_2()).commit();
                        group.check(R.id.radio4_1_2);
                    }
                });
                return true ;
            case 2 :
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                //btn1.setText("영상보기");
                //btn2.setText("이해하기+");

                //back.setBackgroundResource(R.drawable.scene_4_1_2back);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene4_0_1("RBhtc3wN0Qs")).commit();
                        group.check(R.id.radio4_1_1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene4_0_3(62)).commit();
                        group.check(R.id.radio4_1_3);
                    }
                });
                return true ;
            case 3 :
                btn1.setVisibility(View.VISIBLE);
                //btn1.setText("퀴즈");
                btn2.setVisibility(View.INVISIBLE);

                //back.setBackgroundResource(R.drawable.scene_4_1_2back);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene6_2_2()).commit();
                        group.check(R.id.radio4_1_2);
                    }
                });
                return true ;
            default :
                return false ;
        }
    }
}