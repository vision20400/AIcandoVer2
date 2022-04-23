package com.sandburg.aicandover2.view.scene8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.view.intro.Scene8_intro;

public class Scene8_1 extends Fragment {
    private int val;
    YouTubePlayerView youTubePlayerView;

    public Scene8_1(int val) {
        // Required empty public constructor
        this.val = val;
    }
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        View v = inflater.inflate ( R.layout.scene8_1 , container , false );

        TextView scene8_text = (TextView) v.findViewById(R.id.scene8_text);

        ImageButton scene8_back = (ImageButton) v.findViewById(R.id.scene8_back);
        ImageView icon = (ImageView) v.findViewById(R.id.icon);
        ImageButton btn_app_web = (ImageButton) v.findViewById(R.id.btn_app_web);

        //유튜브 영상 재생 및 세팅
        youTubePlayerView = v.findViewById(R.id.player4_1_1);

        youTubePlayerView.setEnableAutomaticInitialization(false);

        switch (val) {
            case 81:
                youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo("OvgIIvwKspo", 0);
                    }
                }, false);

                scene8_text.setText("인공지능과 함께라면 그림그리기, 자신 있어요!");
                icon.setImageResource(R.drawable.web);
                btn_app_web.setImageResource(R.drawable.btn_web);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.autodraw.com/"));
                        startActivity(intent);
                    }
                });

                break;
            case 82:
                youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo("DozvNxbVNUI", 0);
                    }
                }, false);

                scene8_text.setText("인공지능이 여러분을 빈센트 반 고흐로 만들어 줄 거예요.");
                icon.setImageResource(R.drawable.web);
                btn_app_web.setImageResource(R.drawable.btn_web);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://deepdreamgenerator.com/"));
                        startActivity(intent);
                    }
                });
                break;
            case 83:
                scene8_text.setText("인공지능과 함께 베토벤처럼 멋진 노래를 작곡해볼까요?");
                icon.setImageResource(R.drawable.web);
                btn_app_web.setImageResource(R.drawable.btn_web);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://magenta.tensorflow.org/"));
                        startActivity(intent);
                    }
                });
                break;
            case 84:
                youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo("7UtV0KQZ5lQ", 0);
                    }
                }, false);

                scene8_text.setText("어렵고 복잡한 수학문제, 인공지능과 함께 공부해볼까요?");
                icon.setImageResource(R.drawable.app);
                btn_app_web.setImageResource(R.drawable.btn_app);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.microblink.photomath"));
                        startActivity(intent);
                    }
                });
                break;
            case 85:
                youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo("CUO8dnaYzwU", 0);
                    }
                }, false);

                scene8_text.setText("인공지능과 함께 하는 그림 퀴즈를 통해 데이터와 머신러닝에 대해 이해할 수 있어요.");
                icon.setImageResource(R.drawable.web);
                btn_app_web.setImageResource(R.drawable.btn_web);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quickdraw.withgoogle.com/"));
                        startActivity(intent);
                    }
                });
                break;
            case 86:
                youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo("L1nm6oFx3No", 0);
                    }
                }, false);

                scene8_text.setText("인공지능을 활용하면 우리 교실을 세계 유명 미술관으로 만들 수 있어요.");
                icon.setImageResource(R.drawable.app);
                btn_app_web.setImageResource(R.drawable.btn_app);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.cultural"));
                        startActivity(intent);
                    }
                });
                break;
            case 87:
                youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo("JZsXMUTkfIg", 0);
                    }
                }, false);

                scene8_text.setText("누구나 쉽게 머신러닝의 과정을 이해하고 인공지능 모델을 직접 만들 수 있어요.");
                icon.setImageResource(R.drawable.web);
                btn_app_web.setImageResource(R.drawable.btn_web);
                btn_app_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://teachablemachine.withgoogle.com/"));
                        startActivity(intent);
                    }
                });
                break;
        }

        scene8_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = 80;
                Intent intent = new Intent(v.getContext(), Scene8_intro.class);
                intent.putExtra ( "val", val );
                startActivity(intent);
                getActivity().finish();
            }
        });

        return v;
    }

}
