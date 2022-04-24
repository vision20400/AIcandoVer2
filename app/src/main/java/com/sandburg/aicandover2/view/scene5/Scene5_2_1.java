package com.sandburg.aicandover2.view.scene5;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.publicData;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Scene5_2_1 extends Fragment implements View.OnTouchListener {
    Dialog dialog;
    LinearLayout back_5_2_1;

    ImageView img_job_1;
    ImageView img_job_2;
    ImageView img_job_3;
    ImageView img_job_4;
    ImageView img_job_5;
    ImageView img_job_6;
    ImageView img_job_7;
    ImageView img_job_8;
    ImageView img_job_9;
    ImageView img_job_10;
    ImageView img_job_11;
    ImageView img_job_12;
    ImageView img_job_13;
    ImageButton help;


    public Scene5_2_1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene5_2_1, container, false);

        img_job_1 = (ImageView) v.findViewById(R.id.img_job_1);
        img_job_2 = (ImageView) v.findViewById(R.id.img_job_2);
        img_job_3 = (ImageView) v.findViewById(R.id.img_job_3);
        img_job_4 = (ImageView) v.findViewById(R.id.img_job_4);
        img_job_5 = (ImageView) v.findViewById(R.id.img_job_5);
        img_job_6 = (ImageView) v.findViewById(R.id.img_job_6);
        img_job_7 = (ImageView) v.findViewById(R.id.img_job_7);
        img_job_8 = (ImageView) v.findViewById(R.id.img_job_8);
        img_job_9 = (ImageView) v.findViewById(R.id.img_job_9);
        img_job_10 = (ImageView) v.findViewById(R.id.img_job_10);
        img_job_11 = (ImageView) v.findViewById(R.id.img_job_11);
        img_job_12 = (ImageView) v.findViewById(R.id.img_job_12);
        img_job_13 = (ImageView) v.findViewById(R.id.img_job_13);
        help = v.findViewById(R.id.help);

        img_job_1.setOnTouchListener(this);
        img_job_2.setOnTouchListener(this);
        img_job_3.setOnTouchListener(this);
        img_job_4.setOnTouchListener(this);
        img_job_5.setOnTouchListener(this);
        img_job_6.setOnTouchListener(this);
        img_job_7.setOnTouchListener(this);
        img_job_8.setOnTouchListener(this);
        img_job_9.setOnTouchListener(this);
        img_job_10.setOnTouchListener(this);
        img_job_11.setOnTouchListener(this);
        img_job_12.setOnTouchListener(this);
        img_job_13.setOnTouchListener(this);

        dialog = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog.setContentView(R.layout.scene5_dialog_help);             // xml 레이아웃 파일과 연결


        v.findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //capture
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss"); //년,월,일,시간 포멧 설정
                Date time = new Date(); //파일명 중복 방지를 위해 사용될 현재시간
                String current_time = sdf.format(time); //String형 변수에 저장

                back_5_2_1 = v.findViewById(R.id.back_5_2_1);
                Request_Capture(back_5_2_1,current_time + "_capture"); //지정한 Layout 영역 사진첩 저장 요청
            }
        });

        //share
        v.findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //capture
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss"); //년,월,일,시간 포멧 설정
                Date time = new Date(); //파일명 중복 방지를 위해 사용될 현재시간
                String current_time = sdf.format(time); //String형 변수에 저장

                back_5_2_1 = v.findViewById(R.id.back_5_2_1);
                Request_Share(back_5_2_1,current_time + "_capture"); //지정한 Layout 영역 사진첩 저장 요청
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 사이즈 full
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                Window window = dialog.getWindow();
                window.setAttributes(lp);

                dialog.show(); // 다이얼로그 띄우기

                ImageButton dialog_cl = dialog.findViewById(R.id.dialog_cl);
                dialog_cl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        return v;
    }

    float oldXvalue;
    float oldYvalue;


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int width = ((ViewGroup) v.getParent()).getWidth() - v.getWidth();
        int height = ((ViewGroup) v.getParent()).getHeight() - v.getHeight();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            oldXvalue = event.getX();
            oldYvalue = event.getY();
            //  Log.i("Tag1", "Action Down X" + event.getX() + "," + event.getY());
            Log.i("Tag1", "Action Down rX " + event.getRawX() + "," + event.getRawY());
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            v.setX((float) (event.getRawX() - (oldXvalue+ v.getWidth()*1.4)));
            v.setY((float) (event.getRawY() - (oldYvalue + v.getHeight()*1.6)));
            //  Log.i("Tag2", "Action Down " + me.getRawX() + "," + me.getRawY());
        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            if (v.getX() > width && v.getY() > height) {
                v.setX(width);
                v.setY(height);
            } else if (v.getX() < 0 && v.getY() > height) {
                v.setX(0);
                v.setY(height);
            } else if (v.getX() > width && v.getY() < 0) {
                v.setX(width);
                v.setY(0);
            } else if (v.getX() < 0 && v.getY() < 0) {
                v.setX(0);
                v.setY(0);
            } else if (v.getX() < 0 || v.getX() > width) {
                if (v.getX() < 0) {
                    v.setX(0);
                    v.setY((float) (event.getRawY() - (oldYvalue + v.getHeight()*1.6)));
                } else {
                    v.setX(width);
                    v.setY((float) (event.getRawY() - (oldYvalue + v.getHeight()*1.6)));
                }
            } else if (v.getY() < 0 || v.getY() > height) {
                if (v.getY() < 0) {
                    v.setX((float) (event.getRawX() - (oldXvalue+ v.getWidth()*1.4)));
                    v.setY(0);
                } else {
                    v.setX((float) (event.getRawX() - (oldXvalue+ v.getWidth()*1.4)));
                    v.setY(height);
                }
            }


        }
        return true;
    }

    //캡쳐
    public void Request_Capture(View view, String title){
        if(view==null){ //Null Point Exception ERROR 방지
            System.out.println("::::ERROR:::: view == NULL");
            return;
        }

        /* 캡쳐 파일 저장 */
//        view.buildDrawingCache(); //캐시 비트 맵 만들기
        view.setDrawingCacheEnabled(true);

        Bitmap bitmap = view.getDrawingCache();
        FileOutputStream fos;

        /* 저장할 폴더 Setting */
        File uploadFolder = Environment.getExternalStoragePublicDirectory("/DCIM/Camera/"); //저장 경로 (File Type형 변수)



        if (!uploadFolder.exists()) { //만약 경로에 폴더가 없다면
            uploadFolder.mkdir(); //폴더 생성
        }

        /* 파일 저장 */
        String Str_Path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/"; //저장 경로 (String Type 변수)

        try{
            fos = new FileOutputStream(Str_Path+title+".jpg"); // 경로 + 제목 + .jpg로 FileOutputStream Setting
            bitmap.compress(Bitmap.CompressFormat.JPEG,80,fos);
        }catch (Exception e){
            e.printStackTrace();
        }

        //캡쳐 파일 미디어 스캔 (https://hongdroid.tistory.com/7)

        MediaScanner ms = MediaScanner.newInstance(getActivity().getApplicationContext());




        try { // TODO : 미디어 스캔
            ms.mediaScanning(Str_Path + title + ".jpg",0);
            Toast myToast = Toast.makeText(this.getContext().getApplicationContext(),"저장되었습니다.", Toast.LENGTH_SHORT);
            myToast.show();
            view.setDrawingCacheEnabled(false);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("::::ERROR:::: "+e);
        }

    }//End Function

    public void Request_Share(View view, String title){
        if(view==null){ //Null Point Exception ERROR 방지
            System.out.println("::::ERROR:::: view == NULL");
            return;
        }

        /* 캡쳐 파일 저장 */
//        view.buildDrawingCache(); //캐시 비트 맵 만들기
        view.setDrawingCacheEnabled(true);

        Bitmap bitmap = view.getDrawingCache();
        FileOutputStream fos;

        /* 저장할 폴더 Setting */
        File uploadFolder = Environment.getExternalStoragePublicDirectory("/DCIM/Camera/"); //저장 경로 (File Type형 변수)



        if (!uploadFolder.exists()) { //만약 경로에 폴더가 없다면
            uploadFolder.mkdir(); //폴더 생성
        }

        /* 파일 저장 */
        String Str_Path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/"; //저장 경로 (String Type 변수)
        String adress = Str_Path+title+".jpg";

        try{
            fos = new FileOutputStream(Str_Path+title+".jpg"); // 경로 + 제목 + .jpg로 FileOutputStream Setting
            bitmap.compress(Bitmap.CompressFormat.JPEG,80,fos);
        }catch (Exception e){
            e.printStackTrace();
        }

        //캡쳐 파일 미디어 스캔 (https://hongdroid.tistory.com/7)

        MediaScanner ms = MediaScanner.newInstance(getActivity().getApplicationContext());


        try { // TODO : 미디어 스캔
//            ms.mediaScanning(Str_Path + title + ".jpg",1);
            Uri uri = FileProvider.getUriForFile(getContext(), "com.sandburg.aicandover2", new File(adress));
            Intent shareintent = new Intent(Intent.ACTION_SEND);

            shareintent.putExtra(Intent.EXTRA_STREAM,uri);
            shareintent.setType("image/*");
            startActivity(Intent.createChooser(shareintent,"공유"));
            view.setDrawingCacheEnabled(false);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("::::ERROR:::: "+e);
        }

    }//End Function


}