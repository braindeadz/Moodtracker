package driss.moussa.moodtracker.controller;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Calendar;

import driss.moussa.moodtracker.R;
import driss.moussa.moodtracker.model.Mood;
import driss.moussa.moodtracker.utils.Utils;

public class History extends AppCompatActivity {


    int[] arraySmileys = new int[]{
            R.drawable.smiley_super_happy,
            R.drawable.smiley_happy,
            R.drawable.smiley_normal,
            R.drawable.smiley_disappointed,
            R.drawable.smiley_sad,
    };

    int[] arrayBackgroundColors = new int[]{
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

    public MediaPlayer mplayer = new MediaPlayer();

    boolean noHistory = true;

    SharedPreferences mPreferences;
    Gson gson = new Gson();

//////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FrameLayout past1_1 = (FrameLayout) findViewById(R.id.past1_1);
        FrameLayout past2_1 = (FrameLayout) findViewById(R.id.past2_1);
        FrameLayout past3_1 = (FrameLayout) findViewById(R.id.past3_1);
        FrameLayout past4_1 = (FrameLayout) findViewById(R.id.past4_1);
        FrameLayout past5_1 = (FrameLayout) findViewById(R.id.past5_1);
        FrameLayout past6_1 = (FrameLayout) findViewById(R.id.past6_1);
        FrameLayout past7_1 = (FrameLayout) findViewById(R.id.past7_1);

        FrameLayout past1_2 = (FrameLayout) findViewById(R.id.past1_2);
        FrameLayout past2_2 = (FrameLayout) findViewById(R.id.past2_2);
        FrameLayout past3_2 = (FrameLayout) findViewById(R.id.past3_2);
        FrameLayout past4_2 = (FrameLayout) findViewById(R.id.past4_2);
        FrameLayout past5_2 = (FrameLayout) findViewById(R.id.past5_2);
        FrameLayout past6_2 = (FrameLayout) findViewById(R.id.past6_2);
        FrameLayout past7_2 = (FrameLayout) findViewById(R.id.past7_2);

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


        mplayer = MediaPlayer.create(this, R.raw.catmaou);


        FrameLayout framegif = (FrameLayout) findViewById(R.id.framegif);

        findViewById(R.id.framegif).setVisibility(View.GONE);


        mPreferences = getSharedPreferences(getString(R.string.key_shared_preferences), MODE_PRIVATE);



        /////////////////
        //  1 DAY AGO  //
        /////////////////

        mtreatment(Utils.YESTERDAY, past1_1, past1_2, icon1);

        //////////////////
        //  2 DAYS AGO  //
        //////////////////

        mtreatment(Utils.TWODAYSAGO, past2_1, past2_2, icon2);

        //////////////////
        //  3 DAYS AGO  //
        //////////////////

        mtreatment(Utils.TREEDAYSAGO, past3_1, past3_2, icon3);

        //////////////////
        //  4 DAYS AGO  //
        //////////////////

        mtreatment(Utils.FOURDAYSAGO, past4_1, past4_2, icon4);

        //////////////////
        //  5 DAYS AGO  //
        //////////////////

        mtreatment(Utils.FIVEDAYSAGO, past5_1, past5_2, icon5);

        //////////////////
        //  6 DAYS AGO  //
        //////////////////

        mtreatment(Utils.SIXDAYSAGO, past6_1, past6_2, icon6);

        //////////////////
        //  7 DAYS AGO  //
        //////////////////

        mtreatment(Utils.SEVENDAYSAGO, past7_1, past7_2, icon7);

        if (noHistory) {
            findViewById(R.id.framegif).setVisibility(View.VISIBLE);
            mplayer.setLooping(true);
            mplayer.start();


        }

    }

    public void mtreatment(int day, FrameLayout past1, FrameLayout past2, ImageView icon) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        String json = mPreferences.getString(currentDate, "");
        Mood mood = gson.fromJson(json, Mood.class);

        if (mood != null) {

            noHistory = false;

            int oldMood = mood.getSelectedMood();

            past1.setBackgroundResource(arrayBackgroundColors[oldMood]);

            switch (oldMood) {
                case 0:
                    past1.setLayoutParams(w100);
                    past2.setLayoutParams(w0);
                    break;

                case 1:
                    past1.setLayoutParams(w80);
                    past2.setLayoutParams(w20);
                    break;

                case 2:
                    past1.setLayoutParams(w60);
                    past2.setLayoutParams(w40);
                    break;

                case 3:
                    past1.setLayoutParams(w40);
                    past2.setLayoutParams(w60);
                    break;

                case 4:
                    past1.setLayoutParams(w20);
                    past2.setLayoutParams(w80);
                    break;

                default:
                    break;
            }

            if (mood.getUserComment().isEmpty()) {
                icon.setVisibility(View.INVISIBLE);
            } else {

                final String oldComment1 = mood.getUserComment();
                icon.setVisibility(View.VISIBLE);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), oldComment1, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }
    }

    @Override
    public void onBackPressed() {

        mplayer.setLooping(false);
        mplayer.stop();

        super.onBackPressed();
    }
}
