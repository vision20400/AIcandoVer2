package com.sandburg.aicandover2.view.scene5;

import android.app.Dialog;
import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.publicData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scene5_1_1 extends Fragment{
    private int boxPeopleCnt = 0;
    private int boxAiCnt = 0;
    int cnt=0;
    int sound_check=0;

    Dialog dialog01; // 커스텀 다이얼로그

    MediaPlayer mediaPlayer; //배경음악
    private int pausePosition;
    MediaPlayer right; //정답 효과음
    MediaPlayer fail; //오답 효과음

    //문제 답 묶인 이중 List 만들기
    List<List<String>> arr = new ArrayList<>();
    publicData pData = new publicData ();
    public void setArr(){
        for(int i=0; i< pData.cardItemStrList[0].length;i++) {
            for (int j = 0; j < pData.cardItemStrList[0][i].length; j++) {
                List<String> arrRow = new ArrayList<String>();
                if (i==0){
                    arrRow.add(pData.cardItemStrList[0][0][j]);
                    arrRow.add("people");
                }
                if (i==1){
                    arrRow.add(pData.cardItemStrList[0][1][j]);
                    arrRow.add("ai");
                }
                arr.add(arrRow);
            }
        }
    }
    //어레이 셔플해서 실행시마다 랜덤하게 문제 등장
    public void suffleArr(List<List<String>> arr){
        Collections.shuffle(arr);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene5_1_1, container, false);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView box_people = (ImageView) v.findViewById(R.id.box_people);
        ImageView box_ai = (ImageView) v.findViewById(R.id.box_ai);
        ImageButton sound_btn = (ImageButton) v.findViewById(R.id.sound_btn);
        setArr();
        suffleArr(arr);
        textView.setText(arr.get(cnt).get(0));
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v,MotionEvent event) {
                ClipData data = ClipData.newPlainText ( "" , "" );
                v.startDrag ( data , new View.DragShadowBuilder ( v ) , v , 0 );
                return true;
            }
        });
        v.findViewById(R.id.box_ai).setOnDragListener(new DragListener(textView,box_people,box_ai));
        v.findViewById(R.id.box_people).setOnDragListener(new DragListener(textView,box_people,box_ai));

        //배경음악 재생
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm);
        mediaPlayer.setLooping(true); //무한재생
        mediaPlayer.setVolume(0.4f,0.4f);
        mediaPlayer.start();

        right = MediaPlayer.create(getContext(),R.raw.right);
        fail = MediaPlayer.create(getContext(),R.raw.wrong);
        right.setVolume(0.4f,0.4f);
        fail.setVolume(0.4f,0.4f);

        dialog01 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog01.setContentView(R.layout.scene5_dialog01);             // xml 레이아웃 파일과 연결

        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog01.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window = dialog01.getWindow();
        window.setAttributes(lp);

        ImageButton scene5_dialog01_btn1 = dialog01.findViewById(R.id.scene5_dialog01_btn1);
        scene5_dialog01_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) getContext();
                RadioGroup radio4_1Group = (RadioGroup) activity.findViewById(R.id.radio4_1Group);
                radio4_1Group.check(R.id.radio4_1_1);
                boxPeopleCnt = 0;
                boxAiCnt = 0;
                cnt=0;
                textView.setText(arr.get(cnt).get(0));
                box_people.setImageResource(R.drawable.box_people);
                box_ai.setImageResource(R.drawable.box_ai);

                dialog01.dismiss();
            }
        });

        ImageButton scene5_dialog01_btn2 = dialog01.findViewById(R.id.scene5_dialog01_btn2);
        scene5_dialog01_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) getContext();
                RadioGroup radio4_1Group = (RadioGroup) activity.findViewById(R.id.radio4_1Group);
                radio4_1Group.check(R.id.radio4_1_2);
                dialog01.dismiss();
            }
        });

        sound_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_check == 0){
                    mediaPlayer.pause();
                    pausePosition = mediaPlayer.getCurrentPosition();
                    sound_btn.setImageResource(android.R.drawable.ic_lock_silent_mode);
                    sound_check = 1;
                }else {
                    mediaPlayer.seekTo(pausePosition);
                    mediaPlayer.start();
                    sound_btn.setImageResource(android.R.drawable.ic_lock_silent_mode_off);
                    sound_check = 0;
                }
            }
        });
        return v;
    }

    public class  DragListener implements View.OnDragListener {
        TextView text;
        ImageView box_people;
        ImageView box_ai;

        public DragListener(TextView text,ImageView box_people,ImageView box_ai) {
            this.text=text;
            this.box_people=box_people;
            this.box_ai=box_ai;
        }

        public boolean onDrag(View v, DragEvent event) {

            final int action = event.getAction();

            switch(action) {
                //drop 만 남기고 나머지 다 제거 -> 로그 여러번 뜨는거 해결
                case DragEvent.ACTION_DROP:
                    if (v == getActivity().findViewById(R.id.box_people)){
                        if(arr.get(cnt).get(1)=="people"){ //문제의 답 == 놓은위치 => cnt&boxCnt++
                            right.start();
                            if (cnt==21){
                                //다음 페이지로 이동하는거 추가해줘야  강제종료(index error) 발생안함
                                //명시적? 암시적? 인덴트 ? 그거 써가지고 다음페이지로 넘어가는거
                                dialog01.show(); // 다이얼로그 띄우기
                            }else{
                                cnt++;
                                box_people.setImageResource(pData.boxBackgroundImg[1][boxPeopleCnt]);
                                boxPeopleCnt++;
                                text.setText(arr.get(cnt).get(0)); //text 변환
                            }

                        }else {fail.start();}
                        break;
                    } else if (v == getActivity().findViewById(R.id.box_ai)){
                        if(arr.get(cnt).get(1)=="ai"){
                            right.start();
                            if (cnt==21){
                                //다음 페이지로 이동하는거 추가해줘야  강제종료(index error) 발생안함
                                dialog01.show(); // 다이얼로그 띄우기
                            }else{
                                cnt++;
                                box_ai.setImageResource(pData.boxBackgroundImg[0][boxAiCnt]);
                                boxAiCnt++;
                                text.setText(arr.get(cnt).get(0));
                            }
                        }else {fail.start();}
                        break;
                    }
                    break;

                default:
                    break;
            }
            return true;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}