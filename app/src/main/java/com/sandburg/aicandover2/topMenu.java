package com.sandburg.aicandover2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.view.intro.Scene4_intro;
import com.sandburg.aicandover2.view.intro.Scene5_intro;
import com.sandburg.aicandover2.view.intro.Scene6_intro;
import com.sandburg.aicandover2.view.intro.Scene7_intro;
import com.sandburg.aicandover2.view.intro.Scene8_intro;
import com.sandburg.aicandover2.view.intro.Scene9_intro;

public class topMenu extends Fragment {

    private int val;

    public topMenu(int val) {
        this.val = val;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {

        View root = inflater.inflate ( R.layout.fragment_top_menu , container , false );

        ImageButton home = (ImageButton) root.findViewById ( R.id.home );
        ImageButton menu = (ImageButton) root.findViewById ( R.id.menu );

        ImageView menuNameImg = root.findViewById ( R.id.menuNameImg );

        switch (val) {

            case 40:
                menuNameImg.setImageResource(R.drawable.menu_name_40);
                break;
            case 41:
                menuNameImg.setImageResource(R.drawable.menu_name_41);
                break;
            case 42:
                menuNameImg.setImageResource(R.drawable.menu_name_42);
                break;
            case 43:
                menuNameImg.setImageResource(R.drawable.menu_name_43);
                break;
            case 44:
                menuNameImg.setImageResource(R.drawable.menu_name_44);
                break;
            case 45:
                menuNameImg.setImageResource(R.drawable.menu_name_45);
                break;
            case 50:
                menuNameImg.setImageResource(R.drawable.menu_name_50);
                break;
            case 51 :
                menuNameImg.setImageResource(R.drawable.menu_name_51);
                break;
            case 52 :
                menuNameImg.setImageResource(R.drawable.menu_name_52);
                break;
            case 53 :
                menuNameImg.setImageResource(R.drawable.menu_name_53);
                break;
            case 60:
                menuNameImg.setImageResource(R.drawable.menu_name_60);
                break;
            case 61:
                menuNameImg.setImageResource(R.drawable.menu_name_61);
                break;
            case 62:
                menuNameImg.setImageResource(R.drawable.menu_name_62);
                break;
            case 63:
                menuNameImg.setImageResource(R.drawable.menu_name_63);
                break;
            case 70:
                menuNameImg.setImageResource(R.drawable.menu_name_70);
                break;
            case 90:
                menuNameImg.setImageResource(R.drawable.menu_name_90);
                break;
        }

        Dialog menu_dialog = new Dialog ( getActivity () , R.style.Theme_TransparentBackground );       // Dialog 초기화
        menu_dialog.requestWindowFeature ( Window.FEATURE_NO_TITLE ); // 타이틀 제거
        menu_dialog.setContentView ( R.layout.menu );             // xml 레이아웃 파일과 연결
        menu_dialog.getWindow ().setGravity ( Gravity.RIGHT );

        home.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity () , MainActivity.class ) );
                getActivity ().finish ();
            }
        } );

        //menu
        menu.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                menu_dialog.show (); // 다이얼로그 띄우기

                ImageButton menu1 = menu_dialog.findViewById ( R.id.menu1 );
                menu1.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        startActivity ( new Intent ( getActivity () , Scene4_intro.class ) );
                        getActivity ().finish ();

                        menu_dialog.dismiss ();
                    }
                } );

                ImageButton menu2 = menu_dialog.findViewById ( R.id.menu2 );
                menu2.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        startActivity ( new Intent ( getActivity () , Scene5_intro.class ) );
                        getActivity ().finish ();

                        menu_dialog.dismiss ();
                    }
                } );

                ImageButton menu3 = menu_dialog.findViewById ( R.id.menu3 );
                menu3.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        startActivity ( new Intent ( getActivity () , Scene6_intro.class ) );
                        getActivity ().finish ();

                        menu_dialog.dismiss ();
                    }
                } );

                ImageButton menu4 = menu_dialog.findViewById ( R.id.menu4 );
                menu4.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        startActivity ( new Intent ( getActivity () , Scene7_intro.class ) );
                        getActivity ().finish ();

                        menu_dialog.dismiss ();
                    }
                } );

                ImageButton menu5 = menu_dialog.findViewById ( R.id.menu5 );
                menu5.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        startActivity ( new Intent ( getActivity () , Scene8_intro.class ) );
                        getActivity ().finish ();

                        menu_dialog.dismiss ();
                    }
                } );

                ImageButton menu6 = menu_dialog.findViewById ( R.id.menu6 );
                menu6.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        startActivity ( new Intent ( getActivity () , Scene9_intro.class ) );
                        getActivity ().finish ();

                        menu_dialog.dismiss ();
                    }
                } );

            }
        } );

        return root;
    }

    @Override
    public void onStart() {
        super.onStart ();

    }
}