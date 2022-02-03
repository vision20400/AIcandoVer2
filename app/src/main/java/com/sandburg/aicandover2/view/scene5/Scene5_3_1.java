package com.sandburg.aicandover2.view.scene5;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Scene5_3_1 extends Fragment {

    class Point{
        float x;
        float y;
        boolean check;
        int color;

        public Point(float x, float y, boolean check, int color){
            this.x = x;
            this.y = y;
            this.check = check;
            this.color = color;
        }
    }

    class MyView extends View{
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            Paint p = new Paint();
            p.setStrokeWidth(15);
            for(int i=1; i<points.size();i++){
                p.setColor(points.get(i).color);
                if(!points.get(i).check)
                    continue;
                canvas.drawLine(points.get(i-1).x,points.get(i-1).y,points.get(i).x,points.get(i).y,p);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    points.add(new Point(x,y,false,color));
                case MotionEvent.ACTION_MOVE:
                    points.add(new Point(x,y,true,color));
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            invalidate();
            return true;
        }
    }

    ArrayList<Point> points = new ArrayList<Point>();
    Button btn_white,btn_gray,btn_black,btn_red,btn_orange,btn_yellow,btn_green,btn_blue,btn_Indigo,btn_purple,btn_clear,add_picture;
    LinearLayout drawlinear;
    int color = Color.BLACK;
    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageView;
    public MyView m;

    public Scene5_3_1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene5_3_1, container, false);

        m = new MyView(getContext());
        imageView = (ImageView)v.findViewById(R.id.paint_imgView);

        //컬러 선택
        v.findViewById(R.id.btn_white).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.WHITE;
            }
        });
        v.findViewById(R.id.btn_gray).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.GRAY;
            }
        });
        v.findViewById(R.id.btn_black).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.BLACK;
            }
        });
        v.findViewById(R.id.btn_red).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.RED;
            }
        });
        v.findViewById(R.id.btn_orange).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.parseColor("#FF7700");
            }
        });
        v.findViewById(R.id.btn_yellow).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.parseColor("#FEF200");
            }
        });
        v.findViewById(R.id.btn_green).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.parseColor("#00D620");
            }
        });
        v.findViewById(R.id.btn_blue).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.parseColor("#00A8F9");
            }
        });
        v.findViewById(R.id.btn_Indigo).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.parseColor("#4242D4");
            }
        });
        v.findViewById(R.id.btn_purple).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                color = Color.parseColor("#C728C0");
            }
        });
        //clear
        v.findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                points.clear();
                m.invalidate();
            }
        });
        //add picture
        v.findViewById(R.id.add_picture).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
        drawlinear = v.findViewById(R.id.draw_linear);

        //capture
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss"); //년,월,일,시간 포멧 설정
        Date time = new Date(); //파일명 중복 방지를 위해 사용될 현재시간
        String current_time = sdf.format(time); //String형 변수에 저장

        v.findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Request_Capture(drawlinear,current_time + "_capture"); //지정한 Layout 영역 사진첩 저장 요청
            }
        });

        //share
        v.findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request_Share(drawlinear,current_time + "_capture"); //지정한 Layout 영역 사진첩 저장 요청
            }
        });

        drawlinear.addView(m);
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            imageView.setImageURI(selectedImageUri);
            drawlinear.setBackground(imageView.getDrawable());

            //Bitmap bm = BitmapFactory.decodeFile(uri2path(getContext(),selectedImageUri));

            //Bitmap bm = BitmapFactory.decodeResource(imageView.getResources(),0);
            //Bitmap modifiable_bitmap = bm.copy(Bitmap.Config.ARGB_8888, true);
//            m.draw(new Canvas(modifiable_bitmap));
//            drawlinear.removeAllViews();
//            drawlinear.addView(m);
        }

    }
    public static String uri2path(Context context, Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };

        Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        cursor.moveToNext();
        @SuppressLint("Range") String path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
        Uri uri = Uri.fromFile(new File(path));

        cursor.close();
        return path;
    }

    //캡쳐
    public void Request_Capture(View view, String title){
        if(view==null){ //Null Point Exception ERROR 방지
            System.out.println("::::ERROR:::: view == NULL");
            return;
        }

        /* 캡쳐 파일 저장 */
        view.buildDrawingCache(); //캐시 비트 맵 만들기
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
        view.buildDrawingCache(); //캐시 비트 맵 만들기
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
            ms.mediaScanning(Str_Path + title + ".jpg",1);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("::::ERROR:::: "+e);
        }

    }//End Function

}