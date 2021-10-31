package com.sandburg.aicandover2.view.scene6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sandburg.aicandover2.R;

public class Scene6_3_2 extends Fragment {
    int[] result_score = {0,0,0,0,0,0,0,0};
    int[] result_index = {0,0,0,0,0,0,0,0};
    int[] img = {R.drawable.result0,R.drawable.result1,R.drawable.result2,
            R.drawable.result3,R.drawable.result4,R.drawable.result5,R.drawable.result6,R.drawable.result7};

    ImageButton scene6_3_2_re;
    ImageView result_img0;
    ImageView result_img1;
    ImageView result_img2;
    ImageView result_img3;
    ImageView result_img4;
    ImageView result_img5;
    ImageView result_img6;
    ImageView result_img7;

    public Scene6_3_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene6_3_2,container,false);

        result_img0 = (ImageView) v.findViewById(R.id.result_img0);
        result_img1 = (ImageView) v.findViewById(R.id.result_img1);
        result_img2 = (ImageView) v.findViewById(R.id.result_img2);
        result_img3 = (ImageView) v.findViewById(R.id.result_img3);
        result_img4 = (ImageView) v.findViewById(R.id.result_img4);
        result_img5 = (ImageView) v.findViewById(R.id.result_img5);
        result_img6 = (ImageView) v.findViewById(R.id.result_img6);
        result_img7 = (ImageView) v.findViewById(R.id.result_img7);

        Bundle bundle = getArguments();

        if(bundle != null){
            result_score = bundle.getIntArray("result"); //Name 받기.
        }


        int maxIndex;
        for(int i=0; i<8; i++){
            maxIndex = max(result_score);
            result_index[i] = maxIndex;
            result_score[maxIndex] = -1;
        }
//result_index => result_score의 높은 순 score 인덱스


        result_img0.setImageResource(img[result_index[0]]);
        result_img1.setImageResource(img[result_index[1]]);
        result_img2.setImageResource(img[result_index[2]]);
        result_img3.setImageResource(img[result_index[3]]);
        result_img4.setImageResource(img[result_index[4]]);
        result_img5.setImageResource(img[result_index[5]]);
        result_img6.setImageResource(img[result_index[6]]);
        result_img7.setImageResource(img[result_index[7]]);

        scene6_3_2_re = (ImageButton) v.findViewById(R.id.scene6_3_2_re);
        scene6_3_2_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragment
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene6_3_1()).commit();
            }
        });
        return v;
    }


    public int max(int[] array) {
        int[] arr = array;

        int max = arr[0];
        int maxIndex = 0;

        // 최대값, 최대값의 인덱스 구하기
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}
