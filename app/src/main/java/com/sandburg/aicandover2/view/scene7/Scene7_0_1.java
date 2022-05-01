package com.sandburg.aicandover2.view.scene7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.sandburg.aicandover2.R;

public class Scene7_0_1 extends Fragment {

    private String VideoID = "Dl1KXRACLq4"; //유튜브 영상 ID
    YouTubePlayerView youTubePlayerView;
    public Scene7_0_1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene4_0_1,container,false);


        //유튜브 영상 재생 및 세팅
        youTubePlayerView = v.findViewById(R.id.player4_1_1);

        youTubePlayerView.setEnableAutomaticInitialization(false);
        youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(VideoID, 0);
            }
        }, false);
        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        youTubePlayerView = getView().findViewById(R.id.player4_1_1);
        youTubePlayerView.setEnableAutomaticInitialization(false);
        youTubePlayerView.release();
    }
}
