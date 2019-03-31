package driss.moussa.moodtracker.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.Calendar;

import driss.moussa.moodtracker.R;
import driss.moussa.moodtracker.model.Mood;

public class History extends AppCompatActivity {



    int[] arraySmileys = new int[]{
            R.drawable.smiley_super_happy,
            R.drawable.smiley_happy,
            R.drawable.smiley_normal,
            R.drawable.smiley_disappointed,
            R.drawable.smiley_sad,
    };

    int[] arrayBackgroundColors = new int[] {
            R.color.banana_yellow,
            R.color.light_sage,
            R.color.cornflower_blue_65,
            R.color.warm_grey,
            R.color.faded_red,
    };

    LinearLayout.LayoutParams w100 = new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 100);
    LinearLayout.LayoutParams w80 = new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 80);
    LinearLayout.LayoutParams w60 = new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 60);
    LinearLayout.LayoutParams w40 = new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 40);
    LinearLayout.LayoutParams w20 = new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 20);
    LinearLayout.LayoutParams w0 = new LinearLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT, 0);



    //////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FrameLayout past1_1 = (FrameLayout)findViewById(R.id.past1_1);
        FrameLayout past2_1 = (FrameLayout)findViewById(R.id.past2_1);
        FrameLayout past3_1 = (FrameLayout)findViewById(R.id.past3_1);
        FrameLayout past4_1 = (FrameLayout)findViewById(R.id.past4_1);
        FrameLayout past5_1 = (FrameLayout)findViewById(R.id.past5_1);
        FrameLayout past6_1 = (FrameLayout)findViewById(R.id.past6_1);
        FrameLayout past7_1 = (FrameLayout)findViewById(R.id.past7_1);

        FrameLayout past1_2 = (FrameLayout)findViewById(R.id.past1_2);
        FrameLayout past2_2 = (FrameLayout)findViewById(R.id.past2_2);
        FrameLayout past3_2 = (FrameLayout)findViewById(R.id.past3_2);
        FrameLayout past4_2 = (FrameLayout)findViewById(R.id.past4_2);
        FrameLayout past5_2 = (FrameLayout)findViewById(R.id.past5_2);
        FrameLayout past6_2 = (FrameLayout)findViewById(R.id.past6_2);
        FrameLayout past7_2 = (FrameLayout)findViewById(R.id.past7_2);

        ImageView icon1 = (ImageView) findViewById(R.id.icon1);
        ImageView icon2 = (ImageView) findViewById(R.id.icon2);
        ImageView icon3 = (ImageView) findViewById(R.id.icon3);
        ImageView icon4 = (ImageView) findViewById(R.id.icon4);
        ImageView icon5 = (ImageView) findViewById(R.id.icon5);
        ImageView icon6 = (ImageView) findViewById(R.id.icon6);
        ImageView icon7 = (ImageView) findViewById(R.id.icon7);

        icon1.setVisibility(View.INVISIBLE);
        icon2.setVisibility(View.INVISIBLE);
        icon3.setVisibility(View.INVISIBLE);
        icon4.setVisibility(View.INVISIBLE);
        icon5.setVisibility(View.INVISIBLE);
        icon6.setVisibility(View.INVISIBLE);
        icon7.setVisibility(View.INVISIBLE);

        LinearLayout test1 = (LinearLayout)findViewById(R.id.test1);

        SharedPreferences mPreferences;
        mPreferences = getSharedPreferences(getString(R.string.key_shared_preferences), MODE_PRIVATE);
        Gson gson = new Gson();


           /////////////////
          //  1 DAY AGO  //
         /////////////////

        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_MONTH, -1);
        String currentDate1 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar1.getTime());

        String json1 = mPreferences.getString(currentDate1 , "");
        Mood obj1 = gson.fromJson(json1, Mood.class);



        if (obj1 == null) {
            return;
        }

        final String oldComment1 = obj1.getUserComment();

        if (obj1 != null) {
            int oldMood1 = obj1.getSelectedMood();
            past1_1.setBackgroundResource(arrayBackgroundColors[oldMood1]);
            if (oldMood1 == 0) {
                past1_1.setLayoutParams(w100);
                past1_2.setLayoutParams(w0);
            }
                if (oldMood1 == 1) {
                    past1_1.setLayoutParams(w80);
                    past1_2.setLayoutParams(w20);
                }
                if (oldMood1 == 2) {
                    past1_1.setLayoutParams(w60);
                    past1_2.setLayoutParams(w40);
                }
                if (oldMood1 == 3) {
                    past1_1.setLayoutParams(w40);
                    past1_2.setLayoutParams(w60);
                }
                if (oldMood1 == 4) {
                    past1_1.setLayoutParams(w20);
                    past1_2.setLayoutParams(w80);
                }

        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment1 != null) {
            icon1.setVisibility(View.VISIBLE);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), oldComment1, Toast.LENGTH_SHORT).show();
                }
            });
        }

          //////////////////
         //  2 DAYS AGO  //
        //////////////////

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_MONTH, -2);
        String currentDate2 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar2.getTime());

        String json2 = mPreferences.getString(currentDate2 , "");
        Mood obj2 = gson.fromJson(json2, Mood.class);

        if (obj2 == null) {
            return;
        }

        final String oldComment2 = obj2.getUserComment();

        if (obj2 != null) {
            int oldMood2 = obj2.getSelectedMood();
            past2_1.setBackgroundResource(arrayBackgroundColors[oldMood2]);
            if (oldMood2 == 0) {
                past2_1.setLayoutParams(w100);
                past2_2.setLayoutParams(w0);
            }
                if (oldMood2 == 1) {
                    past2_1.setLayoutParams(w80);
                    past2_2.setLayoutParams(w20);
                }
                if (oldMood2 == 2) {
                    past2_1.setLayoutParams(w60);
                    past2_2.setLayoutParams(w40);
                }
                if (oldMood2 == 3) {
                    past2_1.setLayoutParams(w40);
                    past2_2.setLayoutParams(w60);
                }
                if (oldMood2 == 4) {
                    past2_1.setLayoutParams(w20);
                    past2_2.setLayoutParams(w80);
                }

        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment2 != null) {
            icon2.setVisibility(View.VISIBLE);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), oldComment2, Toast.LENGTH_SHORT).show();
                }
            });
        }

           //////////////////
          //  3 DAYS AGO  //
         //////////////////

        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.DAY_OF_MONTH, -3);
        String currentDate3 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar3.getTime());

        String json3 = mPreferences.getString(currentDate3 , "");
        Mood obj3 = gson.fromJson(json3, Mood.class);

        if (obj3 == null) {
            return;
        }

        final String oldComment3 = obj3.getUserComment();

        if (obj3 != null) {
            int oldMood3 = obj3.getSelectedMood();
            past3_1.setBackgroundResource(arrayBackgroundColors[oldMood3]);
            if (oldMood3 == 0) {
                past3_1.setLayoutParams(w100);
                past3_2.setLayoutParams(w0);
            }
                if (oldMood3 == 1) {
                    past3_1.setLayoutParams(w80);
                    past3_2.setLayoutParams(w20);
                }
                if (oldMood3 == 2) {
                    past3_1.setLayoutParams(w60);
                    past3_2.setLayoutParams(w40);
                }
                if (oldMood3 == 3) {
                    past3_1.setLayoutParams(w40);
                    past3_2.setLayoutParams(w60);
                }
                if (oldMood3 == 4) {
                    past3_1.setLayoutParams(w20);
                    past3_2.setLayoutParams(w80);
                }

        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment2 != null) {
            icon3.setVisibility(View.VISIBLE);
            icon3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), oldComment3, Toast.LENGTH_SHORT).show();
                }
            });
        }

          //////////////////
         //  4 DAYS AGO  //
        //////////////////

        Calendar calendar4 = Calendar.getInstance();
        calendar4.add(Calendar.DAY_OF_MONTH, -4);
        String currentDate4 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar4.getTime());

        String json4 = mPreferences.getString(currentDate4 , "");
        Mood obj4 = gson.fromJson(json4, Mood.class);

        if (obj4 == null) {
            return;
        }

        final String oldComment4 = obj4.getUserComment();

        if (obj4 != null) {

                int oldMood4 = obj4.getSelectedMood();
                past4_1.setBackgroundResource(arrayBackgroundColors[oldMood4]);

                if (oldMood4 == 0) {
                past4_1.setLayoutParams(w100);
                past4_2.setLayoutParams(w0);
                }
                if (oldMood4 == 1) {
                    past4_1.setLayoutParams(w80);
                    past4_2.setLayoutParams(w20);
                }
                if (oldMood4 == 2) {
                    past4_1.setLayoutParams(w60);
                    past4_2.setLayoutParams(w40);
                }
                if (oldMood4 == 3) {
                    past4_1.setLayoutParams(w40);
                    past4_2.setLayoutParams(w60);
                }
                if (oldMood4 == 4) {
                    past4_1.setLayoutParams(w20);
                    past4_2.setLayoutParams(w80);
                }
        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment4 != null) {
            icon4.setVisibility(View.VISIBLE);
            icon4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), oldComment4, Toast.LENGTH_SHORT).show();
                }
            });
        }

           //////////////////
          //  5 DAYS AGO  //
         //////////////////

        Calendar calendar5 = Calendar.getInstance();
        calendar5.add(Calendar.DAY_OF_MONTH, -5);
        String currentDate5 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar5.getTime());

        String json5 = mPreferences.getString(currentDate5 , "");
        Mood obj5 = gson.fromJson(json5, Mood.class);

        if (obj5 == null) {
            return;
        }

        final String oldComment5 = obj5.getUserComment();

        if (obj5 != null) {

                int oldMood5 = obj5.getSelectedMood();
                past5_1.setBackgroundResource(arrayBackgroundColors[oldMood5]);

                if (oldMood5 == 0) {
                past5_1.setLayoutParams(w100);
                past5_2.setLayoutParams(w0);
                }
                if (oldMood5 == 1) {
                    past5_1.setLayoutParams(w80);
                    past5_2.setLayoutParams(w20);
                }
                if (oldMood5 == 2) {
                    past5_1.setLayoutParams(w60);
                    past5_2.setLayoutParams(w40);
                }
                if (oldMood5 == 3) {
                    past5_1.setLayoutParams(w40);
                    past5_2.setLayoutParams(w60);
                }
                if (oldMood5 == 4) {
                    past5_1.setLayoutParams(w20);
                    past5_2.setLayoutParams(w80);
                }
        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment5 != null) {
                icon5.setVisibility(View.VISIBLE);
                icon5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), oldComment5, Toast.LENGTH_SHORT).show();
                    }
                });
        }

           //////////////////
          //  6 DAYS AGO  //
         //////////////////

        Calendar calendar6 = Calendar.getInstance();
        calendar6.add(Calendar.DAY_OF_MONTH, -6);
        String currentDate6 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar6.getTime());

        String json6 = mPreferences.getString(currentDate6 , "");
        Mood obj6 = gson.fromJson(json6, Mood.class);

        if (obj6 == null) {
            return;
        }

        final String oldComment6 = obj6.getUserComment();

        if (obj6 != null) {

                int oldMood6 = obj6.getSelectedMood();
                past6_1.setBackgroundResource(arrayBackgroundColors[oldMood6]);

                if (oldMood6 == 0) {
                past6_1.setLayoutParams(w100);
                past6_2.setLayoutParams(w0);
                }
                if (oldMood6 == 1) {
                    past6_1.setLayoutParams(w80);
                    past6_2.setLayoutParams(w20);
                }
                if (oldMood6 == 2) {
                    past6_1.setLayoutParams(w60);
                    past6_2.setLayoutParams(w40);
                }
                if (oldMood6 == 3) {
                    past6_1.setLayoutParams(w40);
                    past6_2.setLayoutParams(w60);
                }
                if (oldMood6 == 4) {
                    past6_1.setLayoutParams(w20);
                    past6_2.setLayoutParams(w80);
                }
        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment6 != null) {
            icon6.setVisibility(View.VISIBLE);
            icon6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), oldComment6, Toast.LENGTH_SHORT).show();
                }
            });
        }

           //////////////////
          //  7 DAYS AGO  //
         //////////////////

        Calendar calendar7 = Calendar.getInstance();
        calendar7.add(Calendar.DAY_OF_MONTH, -7);
        String currentDate7 = DateFormat.getDateInstance(DateFormat.FULL).format(calendar7.getTime());

        String json7 = mPreferences.getString(currentDate7 , "");
        Mood obj7 = gson.fromJson(json7, Mood.class);

        if (obj7 == null) {
            return;
        }

        final String oldComment7 = obj7.getUserComment();

        if (obj7 != null) {

                int oldMood7 = obj7.getSelectedMood();
                past7_1.setBackgroundResource(arrayBackgroundColors[oldMood7]);

                if (oldMood7 == 0) {
                past7_1.setLayoutParams(w100);
                past7_2.setLayoutParams(w0);
                }

                if (oldMood7 == 1) {
                    past7_1.setLayoutParams(w80);
                    past7_2.setLayoutParams(w20);
                }

                if (oldMood7 == 2) {
                    past7_1.setLayoutParams(w60);
                    past7_2.setLayoutParams(w40);
                }
                if (oldMood7 == 3) {
                    past7_1.setLayoutParams(w40);
                    past7_2.setLayoutParams(w60);
                }
                if (oldMood7 == 4) {
                    past7_1.setLayoutParams(w20);
                    past7_2.setLayoutParams(w80);
                }
        }

        if (oldComment1.isEmpty()) {
            icon1.setVisibility(View.INVISIBLE);
        }


        if (oldComment7 != null) {
            icon7.setVisibility(View.VISIBLE);
            icon7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), oldComment7, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
