package com.sandburg.aicandover2.view.scene4;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Scene4_4_2 extends Fragment {
    //private CountDownTimer countDownTimer;
    //private int count = 10;

    Dialog quiz_dialog01; // 커스텀 다이얼로그1
    Dialog quiz_dialog02; // 커스텀 다이얼로그2
    Dialog quiz_dialog03; // 커스텀 다이얼로그3


    MediaPlayer mediaPlayer; //배경음악
    private int pausePosition;
    MediaPlayer right; //정답 효과음
    MediaPlayer fail; //오답 효과음

    TextView quiz_num,quiz,score,time;
    Button o,x;

    //문제 순서
    int problemNumber = 1;

    String question = "";
    String answer = "";
    int totalscore = 0;

    //quizzes, keys 선언
    HashMap<String,String> quizzes = new HashMap<String, String>();
    ArrayList keys = new ArrayList();

    public Scene4_4_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene4_0_2,container,false);

        //배경음악 재생
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm);
        mediaPlayer.setLooping(true); //무한재생
        mediaPlayer.setVolume(0.4f,0.4f);
        mediaPlayer.start();

        right = MediaPlayer.create(getContext(),R.raw.right);
        fail = MediaPlayer.create(getContext(),R.raw.wrong);
        right.setVolume(0.4f,0.4f);
        fail.setVolume(0.4f,0.4f);

        quiz_dialog01 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        quiz_dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        quiz_dialog01.setContentView(R.layout.quiz_dialog01);             // xml 레이아웃 파일과 연결
        quiz_dialog02 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        quiz_dialog02.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        quiz_dialog02.setContentView(R.layout.quiz_dialog02);             // xml 레이아웃 파일과 연결
        quiz_dialog03 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        quiz_dialog03.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        quiz_dialog03.setContentView(R.layout.quiz_dialog03);             // xml 레이아웃 파일과 연결

        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(quiz_dialog01.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window = quiz_dialog01.getWindow();
        window.setAttributes(lp);

        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp1 = new WindowManager.LayoutParams();
        lp1.copyFrom(quiz_dialog03.getWindow().getAttributes());
        lp1.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp1.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window1 = quiz_dialog03.getWindow();
        window1.setAttributes(lp1);

        //문제
        quizzes.put("모든 로봇은 인공지능을 가지고 있다. ","x");
        quizzes.put("단순한 작업만을 수행하는 로봇도 인공지능이다. ","x");
        quizzes.put("인공지능은 사람으로 비유하면 팔, 다리와 같은 몸이다. ","x");
        quizzes.put("인공지능은 어떤 기계 안에 들어있느냐에 따라서 매우 다양한 모양을 가질 수 있다. ","o");

        //퀴즈, 스코어, 문제 텍스트 / o,x 버튼
        quiz_num = v.findViewById(R.id.quiz_num);
        quiz = v.findViewById(R.id.quiz);
        score = v.findViewById(R.id.score);
        //time = v.findViewById(R.id.time);
        o = v.findViewById(R.id.o);
        x = v.findViewById(R.id.x);

        //keys 리스트 / 셔플
        keys.addAll(quizzes.keySet());
        Collections.shuffle(keys);

        //문제, 답 설정
        showProblem();          

        //"o" 클릭
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select("o");
            }
        });

        //"x" 클릭
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select("x");
            }
        });

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    void showProblem() {
        question = (String) keys.get(problemNumber-1);
        answer = (String)quizzes.get(keys.get(problemNumber-1));

        quiz.setText(question);

        //10초 타이머 실행
        /*count = 10;
        countDownTimer();
        countDownTimer.start();*/

        //문제 번호
        quiz_num.setText("Q"+problemNumber+".");
    }

    //타이머
    /*public void countDownTimer(){
        countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText(String.valueOf(count));
                count --;
            }
            public void onFinish() {
                //타이머 종료시 오답 처리
                time.setText(String.valueOf("0"));
                if(answer.equals("x")){
                    select("o");
                }else{
                    select("x");
                }
            }
        };
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        /*try{
            countDownTimer.cancel();
        } catch (Exception e) {}
        countDownTimer=null;*/
    }

    void select(String select) {
        mediaPlayer.pause();
        pausePosition = mediaPlayer.getCurrentPosition();

        //countDownTimer.cancel();
        if (problemNumber <= quizzes.size()) {
            //정답 선택
            if (answer.equals(select)) {
                totalscore += 10;
                score.setText(Integer.toString(totalscore));
                right.start();
                //showToast("정답입니다.");


                quiz_dialog03.show(); // 다이얼로그 띄우기

                ImageButton quiz_dialog01_cl = quiz_dialog03.findViewById(R.id.quiz_dialog01_cl);
                quiz_dialog01_cl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        problemNumber += 1;
                        if (problemNumber <= quizzes.size()) {
                            showProblem();
                        }else {
                            //showToast("퀴즈 종료");
                            showGameOverBox();
                        }

                        quiz_dialog03.dismiss();
                        mediaPlayer.seekTo(pausePosition);
                        mediaPlayer.start();
                    }
                });

            }
            //오답 선택
            else {
                score.setText(Integer.toString(totalscore));
                fail.start();
                wrong();
                //showToast("오답입니다.");
            }
        }
    }
    void wrong(){
        /*AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("오답!")
                .setMessage(question + '\n' + "답 : " + answer)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //퀴즈 종료 확인
                        problemNumber += 1;
                        if (problemNumber <= quizzes.size()) {
                            showProblem();
                        }else {
                            //showToast("퀴즈 종료");
                            showGameOverBox();
                        }
                    }
                })
                .setCancelable(false) //true by default
                .create();
        alertDialog.show();*/
        quiz_dialog01.show(); // 다이얼로그 띄우기

        ImageButton quiz_dialog01_cl = quiz_dialog01.findViewById(R.id.quiz_dialog01_cl);
        quiz_dialog01_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                problemNumber += 1;
                if (problemNumber <= quizzes.size()) {
                    showProblem();
                }else {
                    //showToast("퀴즈 종료");
                    showGameOverBox();
                }

                quiz_dialog01.dismiss();
                mediaPlayer.seekTo(pausePosition);
                mediaPlayer.start();
            }
        });
    }

    void showGameOverBox() {
        /*AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("성공! 잘했어!")
                .setMessage("점수 : " + totalscore)
                .setNegativeButton("학습완료", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 이해하기+
                        AppCompatActivity activity = (AppCompatActivity) getContext();
                        RadioGroup radio4_1Group = (RadioGroup) activity.findViewById(R.id.radio4_1Group);
                        radio4_1Group.check(R.id.radio4_1_3);
                    }
                })
                .setPositiveButton("다시하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        replay();
                    }
                })
                .setCancelable(false) //true by default
                .create();
        alertDialog.show();*/
        quiz_dialog02.show(); // 다이얼로그 띄우기

        TextView quiz_dialog02_score = quiz_dialog02.findViewById(R.id.quiz_dialog02_score);
        quiz_dialog02_score.setText(totalscore+"");

        ImageButton quiz_dialog02_fi = quiz_dialog02.findViewById(R.id.quiz_dialog02_fi);
        quiz_dialog02_fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) getContext();
                RadioGroup radio4_1Group = (RadioGroup) activity.findViewById(R.id.radio4_1Group);
                radio4_1Group.check(R.id.radio4_1_3);
                quiz_dialog02.dismiss();
            }
        });

        ImageButton quiz_dialog02_re = quiz_dialog02.findViewById(R.id.quiz_dialog02_re);
        quiz_dialog02_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();
                quiz_dialog02.dismiss();
            }
        });
    }

    void replay() {
        problemNumber = 1;
        totalscore = 0;
        Collections.shuffle(keys);

        score.setText(Integer.toString(totalscore));
        showProblem();
    }

    void showToast(String text){
        Toast myToast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        myToast.show();
    }
}
