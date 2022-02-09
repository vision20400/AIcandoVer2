package com.sandburg.aicandover2.view.scene7;

import static java.lang.Math.abs;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.publicData;
import com.sandburg.aicandover2.topMenu;

import java.util.ArrayList;

public class Scene7_0_0 extends Fragment {
    private int key;

    Dialog dialog01; // 커스텀 다이얼로그
    Dialog dialog02; // 커스텀 다이얼로그
    Dialog dialog03; // 커스텀 다이얼로그
    Dialog dialog04; // 커스텀 다이얼로그
    MediaPlayer pick_sound; //효과음
    MediaPlayer right_sound;
    MediaPlayer wrong_sound;


    TextView scene7_text1;
    TextView scene7_text2;
    ImageView scene7_result;
    ImageButton item_1;
    ImageButton item_2;
    ImageButton item_3;
    ImageButton item_4;
    ImageButton item_5;
    ImageButton item_6;
    ImageButton item_7;
    ImageButton item_8;
    ImageButton item_9;
    ImageButton item_10;
    ImageButton item_11;
    ImageButton item_12;
    ImageButton[] items;
    ImageButton scene7_reset_btn;
    int[] items_id;
    ImageButton scene7_train_btn;
    String Tag = "발견하기";
    MediaPlayer mediaPlayer;

    ArrayList<View> good_data = new ArrayList<View>(); //올바른 데이터
    ArrayList<View> bad_data = new ArrayList<View>(); //잘못된 데이터
    ArrayList<View> A_data = new ArrayList<View>(); // 위
    ArrayList<View> B_data = new ArrayList<View>(); // 아래

    publicData pData = new publicData ();

    public Scene7_0_0(int key) {
        this.key = key;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene7_0_0, container, false);

        scene7_text1 = (TextView) v.findViewById(R.id.scene7_text1);
        scene7_text2 = (TextView) v.findViewById(R.id.scene7_text2);
        scene7_result = (ImageView) v.findViewById(R.id.scene7_result);
        item_1 = (ImageButton) v.findViewById(R.id.item_1);
        item_2 = (ImageButton) v.findViewById(R.id.item_2);
        item_3 = (ImageButton) v.findViewById(R.id.item_3);
        item_4 = (ImageButton) v.findViewById(R.id.item_4);
        item_5 = (ImageButton) v.findViewById(R.id.item_5);
        item_6 = (ImageButton) v.findViewById(R.id.item_6);
        item_7 = (ImageButton) v.findViewById(R.id.item_7);
        item_8 = (ImageButton) v.findViewById(R.id.item_8);
        item_9 = (ImageButton) v.findViewById(R.id.item_9);
        item_10 = (ImageButton) v.findViewById(R.id.item_10);
        item_11 = (ImageButton) v.findViewById(R.id.item_11);
        item_12 = (ImageButton) v.findViewById(R.id.item_12);
        scene7_train_btn = (ImageButton) v.findViewById(R.id.scene7_train_btn);
        scene7_reset_btn = (ImageButton) v.findViewById(R.id.scene7_reset_btn);

        pick_sound = MediaPlayer.create(getContext(), R.raw.pick_sound);
        right_sound = MediaPlayer.create(getContext(), R.raw.right);
        wrong_sound = MediaPlayer.create(getContext(), R.raw.wrong);

        items = new ImageButton[]{item_1,item_2,item_3,item_4,item_5,item_6,item_7,item_8,item_9,item_10,item_11,item_12};
        items_id = new int[]{R.id.item_1,R.id.item_2,R.id.item_3,R.id.item_4,R.id.item_5,R.id.item_6,R.id.item_7,
                R.id.item_8,R.id.item_9,R.id.item_10,R.id.item_11,R.id.item_12};

        dialog01 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog01.setContentView(R.layout.scene7_dialog01);             // xml 레이아웃 파일과 연결

        dialog02 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog02.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog02.setContentView(R.layout.scene7_dialog02);             // xml 레이아웃 파일과 연결

        dialog03 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog03.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog03.setContentView(R.layout.scene7_dialog03);             // xml 레이아웃 파일과 연결

        dialog04 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog04.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog04.setContentView(R.layout.scene7_dialog04);             // xml 레이아웃 파일과 연결

        ImageButton scene7_check_btn = dialog01.findViewById(R.id.scene7_check_btn);
        scene7_check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog01.dismiss();
            }
        });

        ImageButton scene7_check_btn1 = dialog02.findViewById(R.id.scene7_check_btn);
        scene7_check_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog02.dismiss();
            }
        });

        ImageButton scene7_check_btn2 = dialog03.findViewById(R.id.scene7_check_btn);
        scene7_check_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog03.dismiss();
            }
        });

        ImageButton scene7_check_btn3 = dialog04.findViewById(R.id.scene7_check_btn);
        scene7_check_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog04.dismiss();
            }
        });
        int r = 0;
        switch (key){
            case 1:
                scene7_text1.setText("따뜻한 색");
                scene7_text2.setText("차가운 색");

                for( int i = 0; i < pData.cardItemImgList[0][0].length; i++){
                    items[i].setImageResource(pData.cardItemImgList[0][0][i]);
                    r = i;
                }
                for( int i = 0 ; i<  pData.cardItemImgList[0][1].length; i++ ){
                    r++;
                    items[r].setImageResource(pData.cardItemImgList[0][1][i]);
                }
                break;
            case 2:
                scene7_text1.setText("좋은 소리");
                scene7_text2.setText("나쁜 소리");

                for( int i = 0; i < pData.cardItemImgList[1][0].length; i++){
                    items[i].setImageResource(pData.cardItemImgList[1][0][i]);
                    //터치시 소리
                    int finalI = i;
                    items[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mediaPlayer = MediaPlayer.create(getContext(), pData.soundResList[0][finalI]);
                            mediaPlayer.setVolume(0.4f,0.4f);
                            mediaPlayer.start();
                        }
                    });
                    r = i;
                }
                for( int i = 0 ; i<  pData.cardItemImgList[1][1].length; i++ ){
                    r++;
                    items[r].setImageResource(pData.cardItemImgList[1][1][i]);
                    //터치시 소리
                    int finalI = i;
                    items[r].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mediaPlayer = MediaPlayer.create(getContext(), pData.soundResList[1][finalI]);
                            mediaPlayer.setVolume(0.4f,0.4f);
                            mediaPlayer.start();
                        }
                    });
                }

                /*for(int i = 0; i < items.length; i++){
                    items[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                }*/

                break;
            case 3:
                scene7_text1.setText("바른 말");
                scene7_text2.setText("나쁜 말");

                for( int i = 0; i < pData.cardItemImgList[2][0].length; i++){
                    items[i].setImageResource(pData.cardItemImgList[2][0][i]);
                    r = i;
                }
                for( int i = 0 ; i<  pData.cardItemImgList[2][1].length; i++ ){
                    r++;
                    items[r].setImageResource(pData.cardItemImgList[2][1][i]);
                }
                break;
        } //이미지 세팅

        for(int i = 0; i < items.length; i++){
            items[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    ClipData data = ClipData.newPlainText ( "" , "" );
                    v.startDrag ( data , new View.DragShadowBuilder ( v ) , v , 0 );
                    //v.setVisibility(View.INVISIBLE);
                    return true;
                }

            });
        }

        v.findViewById(R.id.scene7_box1).setOnDragListener(
                new DragListener());
        v.findViewById(R.id.scene7_box2).setOnDragListener(
                new DragListener());

        scene7_reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.scene4_frame, new Scene7_0_0(key)).commit();
            }
        });

        scene7_train_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i =0; i < good_data.size();i++){
                    Log.d(Tag, "굿데이터" + good_data.get(i));
                }
                for(int i =0; i < bad_data.size();i++){
                    Log.d(Tag, "배드데이터" + bad_data.get(i));
                }
                for(int i =0; i < A_data.size();i++){
                    Log.d(Tag, "A데이터" + A_data.get(i));
                }
                for(int i =0; i < B_data.size();i++){
                    Log.d(Tag, "B데이터" + B_data.get(i));
                }

                if(A_data.size()+B_data.size() == 0){
                    Log.d(Tag, "데이터가 없습니다");
                    wrong_sound.start();
                    scene7_result.setImageResource(R.drawable.scene7_result1);
                    dialog01.show();
                }else if(A_data.size()+B_data.size() < 6 ){
                    Log.d(Tag, "데이터가 너무 적습니다");
                    wrong_sound.start();
                    scene7_result.setImageResource(R.drawable.scene7_result2);
                    dialog01.show();
                }else if(abs(A_data.size()-B_data.size())>2){
                    Log.d(Tag, "데이터간 균형이 안맞아요");
                    wrong_sound.start();
                    scene7_result.setImageResource(R.drawable.scene7_result2);
                    dialog03.show();
                }else if( bad_data.size()>0){
                    Log.d(Tag, "잘못된 레이블링이 있어요");
                    wrong_sound.start();
                    scene7_result.setImageResource(R.drawable.scene7_result2);
                    dialog02.show();
                }else {
                    right_sound.start();
                    scene7_result.setImageResource(R.drawable.scene7_result3);
                    dialog04.show();
                }
            }
        });
        return v;
    }

    class DragListener implements View.OnDragListener {
        Drawable normalShape = getResources().getDrawable(
                R.drawable.normal_shape);
        Drawable targetShape = getResources().getDrawable(
                R.drawable.target_shape);

        public boolean onDrag(View v, DragEvent event) {

            // 이벤트 시작
            switch (event.getAction()) {

                // 이미지를 드래그 시작될때
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                    break;

                // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                    // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                    v.setBackground(targetShape);
                    break;

                // 드래그한 이미지가 영역을 빠져 나갈때
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                    v.setBackground(normalShape);
                    break;

                // 이미지를 드래그해서 드랍시켰을때
                case DragEvent.ACTION_DROP:
                    Log.d("DragClickListener", "ACTION_DROP");
                    pick_sound.start();

                    if (v == getActivity().findViewById(R.id.scene7_box1)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view
                                .getParent();
                        viewgroup.removeView(view);

                        LinearLayout containView = (LinearLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                        if(good_data.contains(view)) good_data.remove(view);
                        if(bad_data.contains(view)) bad_data.remove(view);
                        if(A_data.contains(view)) A_data.remove(view);
                        if(B_data.contains(view)) B_data.remove(view);

                        for(int i =0; i < 7; i++){
                            if(view == getActivity().findViewById(items_id[i])){
                                good_data.add(view);
                            }
                        }
                        for(int i =7; i < 12; i++){
                            if(view == getActivity().findViewById(items_id[i])){
                                bad_data.add(view);
                            }
                        }
                        A_data.add(view);

                    }else if (v == getActivity().findViewById(R.id.scene7_box2)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view
                                .getParent();
                        viewgroup.removeView(view);

                        LinearLayout containView = (LinearLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                        if(good_data.contains(view)) good_data.remove(view);
                        if(bad_data.contains(view)) bad_data.remove(view);
                        if(A_data.contains(view)) A_data.remove(view);
                        if(B_data.contains(view)) B_data.remove(view);
                        for(int i =0; i < 7; i++){
                            if(view == getActivity().findViewById(items_id[i])){
                                bad_data.add(view);
                            }
                        }
                        for(int i =7; i < 12; i++){
                            if(view == getActivity().findViewById(items_id[i])){
                                good_data.add(view);
                            }
                        }
                        B_data.add(view);

                    }else {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);

                        break;
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    v.setBackground(normalShape); // go back to normal shape

                default:
                    break;
            }
            return true;
        }
    }

}