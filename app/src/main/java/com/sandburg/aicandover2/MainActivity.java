package com.sandburg.aicandover2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sandburg.aicandover2.view.intro.Scene4_intro;
import com.sandburg.aicandover2.view.intro.Scene5_intro;
import com.sandburg.aicandover2.view.intro.Scene6_intro;
import com.sandburg.aicandover2.view.intro.Scene7_intro;
import com.sandburg.aicandover2.view.intro.Scene8_intro;
import com.sandburg.aicandover2.view.intro.Scene9_intro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton scene4_intro = (ImageButton)findViewById(R.id.main_btn1);
        ImageButton scene5_intro = (ImageButton)findViewById(R.id.main_btn2);
        ImageButton scene6_intro = (ImageButton)findViewById(R.id.main_btn3);
        ImageButton scene7_intro = (ImageButton)findViewById(R.id.main_btn4);
        ImageButton scene8_intro = (ImageButton)findViewById(R.id.main_btn5);
        ImageButton scene9_intro = (ImageButton)findViewById(R.id.main_btn6);
        ImageButton exit = (ImageButton)findViewById(R.id.main_exit);



        //scene4_intro (이해하기) 버튼
        scene4_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene4_intro.class));
                finish();
            }
        });

        //scene5_intro (준비하기) 버튼
        scene5_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene5_intro.class));
                finish();
            }
        });

        //scene6_intro (바로서기) 버튼
        scene6_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene6_intro.class));
                finish();
            }
        });

        //scene7_intro (발견하기) 버튼
        scene7_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene7_intro.class));
                finish();
            }
        });

        //scene8_intro (적용하기) 버튼
        scene8_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene8_intro.class));
                finish();
            }
        });

        //scene9_intro (놀이터) 버튼
        scene9_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Scene9_intro.class));
                finish();
            }
        });

        //exit 버튼
        exit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);						// 태스크를 백그라운드로 이동
                finishAndRemoveTask();						// 액티비티 종료 + 태스크 리스트에서 지우기
                android.os.Process.killProcess(android.os.Process.myPid());	// 앱 프로세스 종료
            }
        });
    }
}