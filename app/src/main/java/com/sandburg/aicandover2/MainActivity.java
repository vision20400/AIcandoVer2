package com.sandburg.aicandover2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.sandburg.aicandover2.view.intro.Scene4_intro;
import com.sandburg.aicandover2.view.intro.Scene5_intro;
import com.sandburg.aicandover2.view.intro.Scene6_intro;
import com.sandburg.aicandover2.view.intro.Scene7_intro;
import com.sandburg.aicandover2.view.intro.Scene8_intro;
import com.sandburg.aicandover2.view.intro.Scene9_intro;

public class MainActivity extends AppCompatActivity {
    Dialog dialog01; // 커스텀 다이얼로그

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

        dialog01 = new Dialog(this,R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog01.setContentView(R.layout.exit_dialog);             // xml 레이아웃 파일과 연결

        ImageButton exit_yes = dialog01.findViewById(R.id.exit_yes);
        exit_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);						// 태스크를 백그라운드로 이동
                finishAndRemoveTask();						// 액티비티 종료 + 태스크 리스트에서 지우기
                android.os.Process.killProcess(android.os.Process.myPid());	// 앱 프로세스 종료
            }
        });
        ImageButton exit_no = dialog01.findViewById(R.id.exit_no);
        exit_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog01.dismiss();
            }
        });


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
                int val = 80;
                Intent intent = new Intent(v.getContext(), Scene8_intro.class);
                intent.putExtra ( "val", val );
                startActivity(intent);
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
               dialog01.show();
            }
        });
    }
}