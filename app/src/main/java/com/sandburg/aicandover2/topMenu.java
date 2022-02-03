package com.sandburg.aicandover2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sandburg.aicandover2.view.intro.Scene4_intro;
import com.sandburg.aicandover2.view.intro.Scene5_intro;
import com.sandburg.aicandover2.view.intro.Scene6_intro;
import com.sandburg.aicandover2.view.intro.Scene7_intro;
import com.sandburg.aicandover2.view.intro.Scene8_intro;
import com.sandburg.aicandover2.view.intro.Scene9_intro;

public class topMenu extends Fragment {

    private int val;
    Dialog dialog01; // 씬 7
    Dialog dialog02; // 씬 5
    Dialog dialog03; // 씬 5_3


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
        ImageButton help = (ImageButton) root.findViewById ( R.id.top_help );

        dialog01 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog01.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog01.setContentView(R.layout.scene7_dialog_help);             // xml 레이아웃 파일과 연결

        dialog02 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog02.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog02.setContentView(R.layout.scene5_dialog0_help);             // xml 레이아웃 파일과 연결

        dialog03 = new Dialog(getActivity(),R.style.Theme_TransparentBackground);       // Dialog 초기화
        dialog03.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog03.setContentView(R.layout.scene5_3_dialog_help);             // xml 레이아웃 파일과 연결
        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog01.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window = dialog01.getWindow();
        window.setAttributes(lp);

        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp1 = new WindowManager.LayoutParams();
        lp1.copyFrom(dialog02.getWindow().getAttributes());
        lp1.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp1.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window1 = dialog02.getWindow();
        window1.setAttributes(lp1);

        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp3 = new WindowManager.LayoutParams();
        lp3.copyFrom(dialog02.getWindow().getAttributes());
        lp3.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp3.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window3 = dialog03.getWindow();
        window3.setAttributes(lp3);

        ImageView imageView19 = dialog01.findViewById(R.id.imageView19);
        ImageButton dialog_cl = dialog01.findViewById(R.id.dialog_cl);
        dialog_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog01.dismiss();
            }
        });

        ImageButton dialog_cl1 = dialog02.findViewById(R.id.dialog_cl);
        dialog_cl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog02.dismiss();
            }
        });

        ImageButton dialog_cl2 = dialog03.findViewById(R.id.dialog_cl);
        dialog_cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog03.dismiss();
            }
        });

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
                help.setVisibility(View.VISIBLE);
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog02.show();
                    }
                });
                break;
            case 52 :
                menuNameImg.setImageResource(R.drawable.menu_name_52);
                break;
            case 53 :
                menuNameImg.setImageResource(R.drawable.menu_name_53);
                help.setVisibility(View.VISIBLE);
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog03.show();
                    }
                });
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
            case 71:
                menuNameImg.setImageResource(R.drawable.menu_name_71);
                help.setVisibility(View.VISIBLE);
                imageView19.setImageResource(R.drawable.scene7_help_img);
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog01.show();
                    }
                });
                break;
            case 72:
                menuNameImg.setImageResource(R.drawable.menu_name_72);
                help.setVisibility(View.VISIBLE);
                imageView19.setImageResource(R.drawable.scene7_help_img2);
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog01.show();
                    }
                });
                break;
            case 73:
                menuNameImg.setImageResource(R.drawable.menu_name_73);
                help.setVisibility(View.VISIBLE);
                imageView19.setImageResource(R.drawable.scene7_help_img3);
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog01.show();
                    }
                });
                break;
            case 80:
                menuNameImg.setImageResource(R.drawable.menu_name_80);
                break;
            case 81:
                menuNameImg.setImageResource(R.drawable.menu_name_81);
                break;
            case 82:
                menuNameImg.setImageResource(R.drawable.menu_name_82);
                break;
            case 83:
                menuNameImg.setImageResource(R.drawable.menu_name_83);
                break;
            case 84:
                menuNameImg.setImageResource(R.drawable.menu_name_84);
                break;
            case 85:
                menuNameImg.setImageResource(R.drawable.menu_name_85);
                break;
            case 86:
                menuNameImg.setImageResource(R.drawable.menu_name_86);
                break;
            case 87:
                menuNameImg.setImageResource(R.drawable.menu_name_87);
                break;
            case 90:
                menuNameImg.setImageResource(R.drawable.menu_name_90);
                break;
            case 94:
                menuNameImg.setImageResource(R.drawable.menu_name_94);
                break;
        }

        Dialog menu_dialog = new Dialog ( getActivity () , R.style.Theme_TransparentBackground );       // Dialog 초기화
        menu_dialog.requestWindowFeature ( Window.FEATURE_NO_TITLE ); // 타이틀 제거
        menu_dialog.setContentView ( R.layout.menu );             // xml 레이아웃 파일과 연결
        //menu_dialog.getWindow ().setGravity ( Gravity.RIGHT );

        //다이얼로그 사이즈 full
        WindowManager.LayoutParams lp2 = new WindowManager.LayoutParams();
        lp2.copyFrom(menu_dialog.getWindow().getAttributes());
        lp2.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp2.height = WindowManager.LayoutParams.MATCH_PARENT;
        Window window2 = menu_dialog.getWindow();
        window2.setAttributes(lp2);

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
                        int val = 80;
                        Intent intent = new Intent(v.getContext(), Scene8_intro.class);
                        intent.putExtra ( "val", val );
                        startActivity(intent);
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