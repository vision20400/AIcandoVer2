package com.sandburg.aicandover2.view.scene9;

import android.Manifest;
import android.app.Dialog;
import android.app.SearchManager;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.view.intro.Scene9_intro;

import java.util.ArrayList;

public class Scene9_4_2 extends Fragment {

    MediaPlayer pick_sound;
    MediaPlayer right; //정답 효과음
    MediaPlayer fail; //오답 효과음

    TextView textView;
    final int PERMISSION = 1;
    Intent intent;
    SpeechRecognizer mRecognizer;
    String[] quiz = new String[7];
    String[] answer = new String[7];
    String[] text = new String[5];
    TextView scene9_text0;
    TextView scene9_text1;
    TextView scene9_text2;
    TextView scene9_text3;
    TextView scene9_text4;
    TextView scene9_text5;
    TextView[] textViews;
    int count;
    Dialog scene9_dialog03; // 커스텀 다이얼로그


    public Scene9_4_2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene9_4_2, container, false);

        pick_sound = MediaPlayer.create(getContext(),R.raw.pick_sound);
        right = MediaPlayer.create(getContext(),R.raw.right);
        fail = MediaPlayer.create(getContext(),R.raw.wrong);

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
        scene9_text0 = (TextView) v.findViewById(R.id.scene9_text0);
        scene9_text1 = (TextView) v.findViewById(R.id.scene9_text1);
        scene9_text2 = (TextView) v.findViewById(R.id.scene9_text2);
        scene9_text3 = (TextView) v.findViewById(R.id.scene9_text3);
        scene9_text4 = (TextView) v.findViewById(R.id.scene9_text4);
        scene9_text5 = (TextView) v.findViewById(R.id.scene9_text5);

        scene9_dialog03 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        scene9_dialog03.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        scene9_dialog03.setContentView(R.layout.scene9_dialog03);             // xml 레이아웃 파일과 연결

        ImageButton scene9_dialog03_btn = scene9_dialog03.findViewById(R.id.scene9_dialog03_btn);
        scene9_dialog03_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scene9_dialog03.dismiss();
                startActivity ( new Intent ( getActivity () , Scene9_intro.class ) );
                getActivity().finish();
            }
        });

        textViews = new TextView[]{scene9_text1, scene9_text2, scene9_text3, scene9_text4, scene9_text5};
        count = 0;

        quiz = new String[]{"Q1. 독도의 날은 몇월몇일일까요?",
                "Q2. 독도 근처에 살던 바다사자로 멸종된 동물의 이름은 무엇일까요?",
                "Q3. 조선 숙종 때의 사람으로 일본으로 건너가 독도가 우리 땅임을 확인한 사람은 누구일까요?",
                "Q4. “독도는 우리 땅” 노래에 나오는 책으로 조선이 독도를 우리 땅으로 인식하고 있음을 알려주는 책은 무엇일까요?",
                "Q5. 신라 지증왕 때 이 장군이 우산국(울릉도)를 정벌하여 독도가 우리 땅이 되었어요. \n" +
                        "이 장군은 누구일까요?",
                "최종미션1. 모은 글자 5개를 조합하여 단어를 만들고, “독도야” 버튼을 누른 다음 말해주세요.",
                "최종미션2. 독도는 우리나라의 천연기념물입니다.\n" +
                        "독도는 천연기념물 몇 호 일까요?"
        };
        answer = new String[]{"10월 25일", "강치", "안용복", "세종실록 지리지", "이사부", "천연기념물", "336호"};
        text = new String[]{"천", "물", "기", "연", "념"};

        scene9_text0.setText(quiz[count]);

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
                //도움말
                pick_sound.start();
                mRecognizer=SpeechRecognizer.createSpeechRecognizer(getContext());
                mRecognizer.setRecognitionListener(listener1);
                mRecognizer.startListening(intent);
            }
        });

        scene9_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity () , Scene9_intro.class ) );
                getActivity().finish();
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

            if(textView.getText().equals(answer[count])){
                right.start();
                if(count<5) textViews[count].setText(text[count]);
                count++;
                if(count<7) scene9_text0.setText(quiz[count]);
                if(count>6){
                    scene9_dialog03.show();
                }
            }else{
                fail.start();
                Toast.makeText(getContext().getApplicationContext(), "오답입니다. ",
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {} };

    private RecognitionListener listener1 = new RecognitionListener() {
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
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, textView.getText().toString());


            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            } else {
                String msg = "Sorry, there is no web browser available";
                //Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {} };

}