package com.sandburg.aicandover2.view.scene4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.pdf;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Scene4_0_3 extends Fragment {
    private int val;

    public Scene4_0_3(int val) {this.val = val;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene4_0_3, container, false);

        TextView txt1 = (TextView) v.findViewById(R.id.txt1);
        TextView txt2 = (TextView) v.findViewById(R.id.txt2);
        TextView txt3 = (TextView) v.findViewById(R.id.txt3);
        ImageButton pdf1 = (ImageButton) v.findViewById ( R.id.s5_btn2);
        ImageButton pdf2 = (ImageButton) v.findViewById ( R.id.s5_btn1);
        ImageButton pdf3 = (ImageButton) v.findViewById ( R.id.s5_btn3);
        pdf1.setVisibility(View.INVISIBLE);
        pdf2.setVisibility(View.INVISIBLE);
        pdf3.setVisibility(View.INVISIBLE);


        switch (val) {
            case 41:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf1);
                pdf2.setImageResource(R.drawable.pdf2);
                pdf3.setImageResource(R.drawable.pdf3);
                pdf1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), pdf.class);
                        intent.putExtra("key", "https://drive.google.com/file/d/1mgusYEb22wDtVNB6BPkz6CFs9hQu8uUD/view?usp=sharing");
                        startActivity(intent);
                    }
                });
            break;
            case 42:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf1);
                pdf2.setImageResource(R.drawable.pdf2);
                pdf3.setImageResource(R.drawable.pdf3);
                break;
            case 43:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf1);
                pdf2.setImageResource(R.drawable.pdf2);
                pdf3.setImageResource(R.drawable.pdf3);
                break;
            case 44:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf1);
                pdf2.setImageResource(R.drawable.pdf2);
                pdf3.setImageResource(R.drawable.pdf3);
                break;
            case 45:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf1);
                pdf2.setImageResource(R.drawable.pdf2);
                pdf3.setImageResource(R.drawable.pdf3);
                break;

            case 51:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf7);
                pdf2.setImageResource(R.drawable.pdf8);
                pdf3.setImageResource(R.drawable.pdf9);
                break;
            case 52:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf7);
                pdf2.setImageResource(R.drawable.pdf8);
                pdf3.setImageResource(R.drawable.pdf9);
                break;
            case 53:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf7);
                pdf2.setImageResource(R.drawable.pdf8);
                pdf3.setImageResource(R.drawable.pdf9);
                break;
            case 61:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf4);
                pdf2.setImageResource(R.drawable.pdf5);
                pdf3.setImageResource(R.drawable.pdf6);
                break;
            case 62:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf4);
                pdf2.setImageResource(R.drawable.pdf5);
                pdf3.setImageResource(R.drawable.pdf6);
                break;
            case 63:
                txt1.setText("- 학습 자료가 준비 중입니다.");
                txt2.setText("- 학습 자료가 준비 중입니다.");
                txt3.setText("- 학습 자료가 준비 중입니다.");
                pdf1.setImageResource(R.drawable.pdf4);
                pdf2.setImageResource(R.drawable.pdf5);
                pdf3.setImageResource(R.drawable.pdf6);
                break;
        }


        return v;
    }

}
