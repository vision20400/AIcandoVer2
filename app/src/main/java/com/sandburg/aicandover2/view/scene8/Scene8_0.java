package com.sandburg.aicandover2.view.scene8;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.R;
import com.sandburg.aicandover2.view.intro.Scene8_intro;

public class Scene8_0 extends Fragment {

    public Scene8_0() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.scene8_0, container, false);

        ImageButton btn8_1 = (ImageButton) v.findViewById(R.id.btn8_1);
        ImageButton btn8_2 = (ImageButton) v.findViewById(R.id.btn8_2);
        //ImageButton btn8_3 = (ImageButton) v.findViewById(R.id.btn8_3);
        ImageButton btn8_4 = (ImageButton) v.findViewById(R.id.btn8_4);
        ImageButton btn8_5 = (ImageButton) v.findViewById(R.id.btn8_5);
        ImageButton btn8_6 = (ImageButton) v.findViewById(R.id.btn8_6);
        ImageButton btn8_7 = (ImageButton) v.findViewById(R.id.btn8_7);

        btn8_1.setOnClickListener ( new Scene8_0.introMenuClickListener() );
        btn8_2.setOnClickListener ( new Scene8_0.introMenuClickListener() );
        //btn8_3.setOnClickListener ( new Scene8_0.introMenuClickListener() );
        btn8_4.setOnClickListener ( new Scene8_0.introMenuClickListener() );
        btn8_5.setOnClickListener ( new Scene8_0.introMenuClickListener() );
        btn8_6.setOnClickListener ( new Scene8_0.introMenuClickListener() );
        btn8_7.setOnClickListener ( new Scene8_0.introMenuClickListener() );

        return v;
    }

    public class introMenuClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int val = 0;
            Intent intent = new Intent(v.getContext(), Scene8_intro.class);
            switch (v.getId ()){
                case R.id.btn8_1:val = 81;break;
                case R.id.btn8_2:val = 82;break;
                //case R.id.btn8_3:val = 83;break;
                case R.id.btn8_4:val = 84;break;
                case R.id.btn8_5:val = 85;break;
                case R.id.btn8_6:val = 86;break;
                case R.id.btn8_7:val = 87;break;
            }
            intent.putExtra ( "val", val );
            startActivity(intent);
            getActivity().finish();
        }
    };
}
