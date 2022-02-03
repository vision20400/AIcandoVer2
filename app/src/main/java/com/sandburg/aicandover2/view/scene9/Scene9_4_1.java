package com.sandburg.aicandover2.view.scene9;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sandburg.aicandover2.MainActivity;
import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.view.intro.Scene8_intro;
import com.sandburg.aicandover2.view.intro.Scene9_intro;

import java.util.ArrayList;

public class Scene9_4_1 extends Fragment {

    MediaPlayer pick_sound;

    Dialog scene9_dialog01; // 커스텀 다이얼로그1
    Dialog scene9_dialog02; // 커스텀 다이얼로그2

    TextView textView;
    final int PERMISSION = 1;
    Intent intent;
    SpeechRecognizer mRecognizer;

    public Scene9_4_1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene9_4_1, container, false);

        pick_sound = MediaPlayer.create(getContext(),R.raw.pick_sound);

        textView = (TextView) v.findViewById(R.id.textView22);
        //stt
        if ( Build.VERSION.SDK_INT >= 23 ){ // 퍼미션 체크
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET,
                    Manifest.permission.RECORD_AUDIO},PERMISSION);
        }
        intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getContext().getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");

        ImageButton scene9_btn1 = (ImageButton) v.findViewById(R.id.scene9_btn1);
        ImageButton scene9_btn2 = (ImageButton) v.findViewById(R.id.scene9_btn2);
        ImageButton scene9_back = (ImageButton) v.findViewById(R.id.scene9_back);

        scene9_dialog01 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        scene9_dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        scene9_dialog01.setContentView(R.layout.scene9_dialog01);             // xml 레이아웃 파일과 연결
        scene9_dialog02 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        scene9_dialog02.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        scene9_dialog02.setContentView(R.layout.scene9_dialog02);             // xml 레이아웃 파일과 연결

        scene9_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pick_sound.start();
                mRecognizer=SpeechRecognizer.createSpeechRecognizer(getContext());
                mRecognizer.setRecognitionListener(listener);
                mRecognizer.startListening(intent);
            }
        });

        scene9_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scene9_dialog01.show(); // 다이얼로그 띄우기
            }
        });

        scene9_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity () , Scene9_intro.class ) );
                getActivity().finish();
            }
        });

        scene9_dialog01.show(); // 다이얼로그 띄우기

        ImageButton scene9_dialog01_btn = scene9_dialog01.findViewById(R.id.scene9_dialog01_btn);
        scene9_dialog01_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scene9_dialog01.dismiss();
                scene9_dialog02.show();
            }
        });

        ImageButton scene9_dialog02_btn = scene9_dialog02.findViewById(R.id.scene9_dialog02_btn);
        scene9_dialog02_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scene9_dialog02.dismiss();
            }
        });

        return v;
    }


    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getContext().getApplicationContext(),
                    "음성인식을 시작합니다.",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {}

        @Override
        public void onRmsChanged(float rmsdB) {}

        @Override
        public void onBufferReceived(byte[] buffer) {}

        @Override
        public void onEndOfSpeech() {}

        @Override public void onError(int error) {
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                break;
            }

            Toast.makeText(getContext().getApplicationContext(), "에러가 발생하였습니다. : "
                    + message,Toast.LENGTH_SHORT).show();
        }

        @Override public void onResults(Bundle results) {
            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어줍니다.
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for(int i = 0; i < matches.size() ; i++){
                textView.setText(matches.get(i));
            }

            if(textView.getText().equals("독도는 내가 지킨다")){
                AppCompatActivity activity = (AppCompatActivity) getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene9_4_2()).commit();
                scene9_dialog01.dismiss();
                scene9_dialog02.dismiss();
            }else{
                Toast.makeText(getContext().getApplicationContext(), "다시 말해주세요 ",
                        Toast.LENGTH_SHORT).show();
        }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {} };

}