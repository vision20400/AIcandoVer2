package com.sandburg.aicandover2.view.scene6;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sandburg.aicandover2.R;

public class Scene6_3_1 extends Fragment {
    Dialog moral_dialog01; // 커스텀 다이얼로그1
    Dialog moral_dialog02; // 커스텀 다이얼로그2

    int img_check1=0;
    int img_check2=0;

    int[] result_score = {0,0,0,0,0,0,0,0}; // 다수, 준법, 여자, 남자, 노인, 아이, 사람, 동물
    int[][] pick = new int [6][2]; //선택 결과 디폴트/선택1/선택2 [케이스][pick]
    int[][] pick1_score = {
            {0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0},
            {0,0,0,1,0,1,0,0},
            {1,0,1,0,0,1,0,0},
            {0,0,1,0,0,0,1,0},
            {1,1,0,0,0,0,0,1}
    };
    int[][] pick2_score = {
            {0,1,0,0,1,0,0,0},
            {1,0,0,0,0,0,0,1},
            {0,0,1,0,1,0,0,0},
            {0,1,0,1,1,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,0,0,0,0,1,0}
    };

    ImageButton help;

    ImageButton pick1;
    ImageButton pick2;
    ImageButton Pimg1;
    ImageButton Pimg2;
    ImageButton case1;
    ImageButton case2;
    ImageButton case3;
    ImageButton case4;
    ImageButton case5;
    ImageButton case6;
    /*ImageView result1;
    ImageView result2;
    ImageView result3;
    ImageView result4;
    ImageView result5;
    ImageView result6;*/
    CheckBox result1_1;
    CheckBox result1_2;
    CheckBox result2_1;
    CheckBox result2_2;
    CheckBox result3_1;
    CheckBox result3_2;
    CheckBox result4_1;
    CheckBox result4_2;
    CheckBox result5_1;
    CheckBox result5_2;
    CheckBox result6_1;
    CheckBox result6_2;
    ImageButton scene6_result;
    //public ImageView[] result;
    public CheckBox[] result1;
    public CheckBox[] result2;

    public Scene6_3_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene6_3_1,container,false);

        pick1 = v.findViewById(R.id.pick1);
        pick2 = v.findViewById(R.id.pick2);
        Pimg1 = v.findViewById(R.id.Pimg1);
        Pimg2 = v.findViewById(R.id.Pimg2);
        case1 = v.findViewById(R.id.case1);
        case2 = v.findViewById(R.id.case2);
        case3 = v.findViewById(R.id.case3);
        case4 = v.findViewById(R.id.case4);
        case5 = v.findViewById(R.id.case5);
        case6 = v.findViewById(R.id.case6);
        /*result1 = v.findViewById(R.id.result1); //이제 안씀
        result2 = v.findViewById(R.id.result2);
        result3 = v.findViewById(R.id.result3);
        result4 = v.findViewById(R.id.result4);
        result5 = v.findViewById(R.id.result5);
        result6 = v.findViewById(R.id.result6);*/
        result1_1 = v.findViewById(R.id.result1_1);
        result1_2 = v.findViewById(R.id.result1_2);
        result2_1 = v.findViewById(R.id.result2_1);
        result2_2 = v.findViewById(R.id.result2_2);
        result3_1 = v.findViewById(R.id.result3_1);
        result3_2 = v.findViewById(R.id.result3_2);
        result4_1 = v.findViewById(R.id.result4_1);
        result4_2 = v.findViewById(R.id.result4_2);
        result5_1 = v.findViewById(R.id.result5_1);
        result5_2 = v.findViewById(R.id.result5_2);
        result6_1 = v.findViewById(R.id.result6_1);
        result6_2 = v.findViewById(R.id.result6_2);
        scene6_result = v.findViewById(R.id.scene6_result);
        help = v.findViewById(R.id.help);

        //result = new ImageView[]{result1, result2, result3, result4, result5, result6};
        result1 = new CheckBox[]{result1_1, result2_1, result3_1, result4_1, result5_1, result6_1};
        result2 = new CheckBox[]{result1_2, result2_2, result3_2, result4_2, result5_2, result6_2};

        moral_dialog01 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        moral_dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        moral_dialog01.setContentView(R.layout.moral_dialog01);             // xml 레이아웃 파일과 연결
        moral_dialog02 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        moral_dialog02.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        moral_dialog02.setContentView(R.layout.moral_dialog02);             // xml 레이아웃 파일과 연결

        //pick 초기화
        for(int i=0; i < 6; i++){
            for(int j=0; j<2; j++) {
                pick[i][j] = 0;
            }
        }

        pick[0][0]=1;

        case1.setImageResource(R.drawable.case_btn1_active);


        //상황선택
        case1.setOnClickListener ( new caseClickListener() );
        case2.setOnClickListener ( new caseClickListener() );
        case3.setOnClickListener ( new caseClickListener() );
        case4.setOnClickListener ( new caseClickListener() );
        case5.setOnClickListener ( new caseClickListener() );
        case6.setOnClickListener ( new caseClickListener() );

        //선택
        pick1.setOnClickListener ( new pickClickListener(result1,result2) );
        pick2.setOnClickListener ( new pickClickListener(result1,result2) );



        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 사이즈 full
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(moral_dialog01.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                Window window = moral_dialog01.getWindow();
                window.setAttributes(lp);

                moral_dialog01.show(); // 다이얼로그 띄우기

                ImageButton moral_dialog01_cl = moral_dialog01.findViewById(R.id.moral_dialog01_cl);
                moral_dialog01_cl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        moral_dialog01.dismiss();
                    }
                });
            }
        });

        Pimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(img_check1 == 0){
                    img_check1 = 1;
                }else {
                    img_check1 = 0;
                }

                caseImg(pick);
            }
        });

        Pimg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(img_check2 == 0){
                    img_check2 = 1;
                }else {
                    img_check2 = 0;
                }

                caseImg(pick);
            }
        });

        scene6_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택안됨 체크
                int check = 0;
                for(int i=0; i<6; i++){
                    if(pick[i][1] == 0){
                        moral_dialog02.show(); // 다이얼로그 띄우기
                        check = 1;

                        ImageButton moral_dialog02_cl = moral_dialog02.findViewById(R.id.moral_dialog02_cl);
                        moral_dialog02_cl.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                moral_dialog02.dismiss();
                            }
                        });
                        break;
                    }
                }

                if(check == 0){
                    for(int i=0; i<6; i++) {
                        if(pick[i][1]==1){
                            for(int j=0; j<8;j++) result_score[j] += pick1_score[i][j];
                        }else if(pick[i][1]==2){
                            for(int j=0; j<8;j++) result_score[j] += pick2_score[i][j];
                        }
                    }

                    Scene6_3_2 Scene6_3_2 = new Scene6_3_2();

                    Bundle bundle = new Bundle();
                    bundle.putIntArray("result", result_score);
                    Scene6_3_2.setArguments(bundle);

                    //fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.scene4_frame, Scene6_3_2).commit();

                }
            }
        });

        return v;
    }

    public class pickClickListener implements View.OnClickListener {

        public pickClickListener(CheckBox[] list1,CheckBox[] list2) {
            result1 = list1; result2 = list2;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId ()){
                case R.id.pick1:
                    for(int i=0; i<6;i++){
                        if(pick[i][0]==1){
                            pick[i][1]=1;
                        }
                    }
                    break;
                case R.id.pick2:
                    for(int i=0; i<6;i++){
                        if(pick[i][0]==1){
                            pick[i][1]=2;
                        }
                    }
                    break;
            }
            result_View();
        }

        public void result_View(){
            for(int i=0; i<6; i++){
                /*if(pick[i][1] == 1) result[i].setImageResource(R.drawable.pick1_2);
                if(pick[i][1] == 2) result[i].setImageResource(R.drawable.pick2_2);*/
                if(pick[i][1] == 1) {
                    result1[i].setChecked(true);
                } else{
                    result1[i].setChecked(false);
                }
                if(pick[i][1] == 2) {
                    result2[i].setChecked(true);
                } else{
                    result2[i].setChecked(false);
                }
            }
        }
    }


        public class caseClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //상황 이미지 초기화
            case1.setImageResource(R.drawable.case_btn1);
            case2.setImageResource(R.drawable.case_btn2);
            case3.setImageResource(R.drawable.case_btn3);
            case4.setImageResource(R.drawable.case_btn4);
            case5.setImageResource(R.drawable.case_btn5);
            case6.setImageResource(R.drawable.case_btn6);

            //pick 초기화
            for(int i=0; i < 6; i++){
                    pick[i][0] = 0;
            }
            switch (v.getId ()){
                case R.id.case1:pick[0][0]=1;
                    case1.setImageResource(R.drawable.case_btn1_active);
                    break;
                case R.id.case2:pick[1][0]=1;
                    case2.setImageResource(R.drawable.case_btn2_active);
                    break;
                case R.id.case3:pick[2][0]=1;
                    case3.setImageResource(R.drawable.case_btn3_active);
                    break;
                case R.id.case4:pick[3][0]=1;
                    case4.setImageResource(R.drawable.case_btn4_active);
                    break;
                case R.id.case5:pick[4][0]=1;
                    case5.setImageResource(R.drawable.case_btn5_active);
                    break;
                case R.id.case6:pick[5][0]=1;
                    case6.setImageResource(R.drawable.case_btn6_active);
                    break;
            }

            img_check1 = 0;
            img_check2 = 0;

            caseImg(pick);

        }

    };

    public void caseImg(int[][] pick){
        for(int i=0; i<6;i++){
            if(pick[0][0]==1){
                if(img_check1 == 0){
                    Pimg1.setImageResource(R.drawable.moral1_1);
                }else {
                    Pimg1.setImageResource(R.drawable.moral1_3);
                }
                if(img_check2 == 0){
                    Pimg2.setImageResource(R.drawable.moral1_2);
                }else {
                    Pimg2.setImageResource(R.drawable.moral1_4);
                }
            }
            if(pick[1][0]==1){
                if(img_check1 == 0){
                    Pimg1.setImageResource(R.drawable.moral2_1);
                }else {
                    Pimg1.setImageResource(R.drawable.moral2_3);
                }
                if(img_check2 == 0){
                    Pimg2.setImageResource(R.drawable.moral2_2);
                }else {
                    Pimg2.setImageResource(R.drawable.moral2_4);
                }
            }
            if(pick[2][0]==1){
                if(img_check1 == 0){
                    Pimg1.setImageResource(R.drawable.moral3_1);
                }else {
                    Pimg1.setImageResource(R.drawable.moral3_3);
                }
                if(img_check2 == 0){
                    Pimg2.setImageResource(R.drawable.moral3_2);
                }else {
                    Pimg2.setImageResource(R.drawable.moral3_4);
                }
            }
            if(pick[3][0]==1){
                if(img_check1 == 0){
                    Pimg1.setImageResource(R.drawable.moral4_1);
                }else {
                    Pimg1.setImageResource(R.drawable.moral4_3);
                }
                if(img_check2 == 0){
                    Pimg2.setImageResource(R.drawable.moral4_2);
                }else {
                    Pimg2.setImageResource(R.drawable.moral4_4);
                }
            }
            if(pick[4][0]==1){
                if(img_check1 == 0){
                    Pimg1.setImageResource(R.drawable.moral5_1);
                }else {
                    Pimg1.setImageResource(R.drawable.moral5_3);
                }
                if(img_check2 == 0){
                    Pimg2.setImageResource(R.drawable.moral5_2);
                }else {
                    Pimg2.setImageResource(R.drawable.moral5_4);
                }
            }
            if(pick[5][0]==1){
                if(img_check1 == 0){
                    Pimg1.setImageResource(R.drawable.moral6_1);
                }else {
                    Pimg1.setImageResource(R.drawable.moral6_3);
                }
                if(img_check2 == 0){
                    Pimg2.setImageResource(R.drawable.moral6_2);
                }else {
                    Pimg2.setImageResource(R.drawable.moral6_4);
                }
            }
        }
    }

}
