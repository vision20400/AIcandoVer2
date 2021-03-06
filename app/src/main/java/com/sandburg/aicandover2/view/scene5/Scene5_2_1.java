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

        dialog = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog ?????????
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        dialog.setContentView(R.layout.scene5_dialog_help);             // xml ???????????? ????????? ??????


        v.findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //capture
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss"); //???,???,???,?????? ?????? ??????
                Date time = new Date(); //????????? ?????? ????????? ?????? ????????? ????????????
                String current_time = sdf.format(time); //String??? ????????? ??????

                back_5_2_1 = v.findViewById(R.id.back_5_2_1);
                Request_Capture(back_5_2_1,current_time + "_capture"); //????????? Layout ?????? ????????? ?????? ??????
            }
        });

        //share
        v.findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //capture
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss"); //???,???,???,?????? ?????? ??????
                Date time = new Date(); //????????? ?????? ????????? ?????? ????????? ????????????
                String current_time = sdf.format(time); //String??? ????????? ??????

                back_5_2_1 = v.findViewById(R.id.back_5_2_1);
                Request_Share(back_5_2_1,current_time + "_capture"); //????????? Layout ?????? ????????? ?????? ??????
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //??????????????? ????????? full
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                Window window = dialog.getWindow();
                window.setAttributes(lp);

                dialog.show(); // ??????????????? ?????????

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

    //??????
    public void Request_Capture(View view, String title){
        if(view==null){ //Null Point Exception ERROR ??????
            System.out.println("::::ERROR:::: view == NULL");
            return;
        }

        /* ?????? ?????? ?????? */
//        view.buildDrawingCache(); //?????? ?????? ??? ?????????
        view.setDrawingCacheEnabled(true);

        Bitmap bitmap = view.getDrawingCache();
        FileOutputStream fos;

        /* ????????? ?????? Setting */
        File uploadFolder = Environment.getExternalStoragePublicDirectory("/DCIM/Camera/"); //?????? ?????? (File Type??? ??????)



        if (!uploadFolder.exists()) { //?????? ????????? ????????? ?????????
            uploadFolder.mkdir(); //?????? ??????
        }

        /* ?????? ?????? */
        String Str_Path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/"; //?????? ?????? (String Type ??????)

        try{
            fos = new FileOutputStream(Str_Path+title+".jpg"); // ?????? + ?????? + .jpg??? FileOutputStream Setting
            bitmap.compress(Bitmap.CompressFormat.JPEG,80,fos);
        }catch (Exception e){
            e.printStackTrace();
        }

        //?????? ?????? ????????? ?????? (https://hongdroid.tistory.com/7)

        MediaScanner ms = MediaScanner.newInstance(getActivity().getApplicationContext());




        try { // TODO : ????????? ??????
            ms.mediaScanning(Str_Path + title + ".jpg",0);
            Toast myToast = Toast.makeText(this.getContext().getApplicationContext(),"?????????????????????.", Toast.LENGTH_SHORT);
            myToast.show();
            view.setDrawingCacheEnabled(false);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("::::ERROR:::: "+e);
        }

    }//End Function

    public void Request_Share(View view, String title){
        if(view==null){ //Null Point Exception ERROR ??????
            System.out.println("::::ERROR:::: view == NULL");
            return;
        }

        /* ?????? ?????? ?????? */
//        view.buildDrawingCache(); //?????? ?????? ??? ?????????
        view.setDrawingCacheEnabled(true);

        Bitmap bitmap = view.getDrawingCache();
        FileOutputStream fos;

        /* ????????? ?????? Setting */
        File uploadFolder = Environment.getExternalStoragePublicDirectory("/DCIM/Camera/"); //?????? ?????? (File Type??? ??????)



        if (!uploadFolder.exists()) { //?????? ????????? ????????? ?????????
            uploadFolder.mkdir(); //?????? ??????
        }

        /* ?????? ?????? */
        String Str_Path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/"; //?????? ?????? (String Type ??????)
        String adress = Str_Path+title+".jpg";

        try{
            fos = new FileOutputStream(Str_Path+title+".jpg"); // ?????? + ?????? + .jpg??? FileOutputStream Setting
            bitmap.compress(Bitmap.CompressFormat.JPEG,80,fos);
        }catch (Exception e){
            e.printStackTrace();
        }

        //?????? ?????? ????????? ?????? (https://hongdroid.tistory.com/7)

        MediaScanner ms = MediaScanner.newInstance(getActivity().getApplicationContext());


        try { // TODO : ????????? ??????
//            ms.mediaScanning(Str_Path + title + ".jpg",1);
            Uri uri = FileProvider.getUriForFile(getContext(), "com.sandburg.aicandover2", new File(adress));
            Intent shareintent = new Intent(Intent.ACTION_SEND);

            shareintent.putExtra(Intent.EXTRA_STREAM,uri);
            shareintent.setType("image/*");
            startActivity(Intent.createChooser(shareintent,"??????"));
            view.setDrawingCacheEnabled(false);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("::::ERROR:::: "+e);
        }

    }//End Function


}