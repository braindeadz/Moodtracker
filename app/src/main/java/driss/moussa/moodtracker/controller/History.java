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

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.Calendar;

import driss.moussa.moodtracker.R;
import driss.moussa.moodtracker.model.Mood;

public class History extends AppCompatActivity {

    SharedPreferences mPreferences;

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

    // STRING CURRENTDATE

    Calendar calendar = Calendar.getInstance();
    final String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());




    //////////////////////////////////////////////////////////
    ///////////////////////////////
    /////////////////////
    /////////////
    ////////
    /////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mPreferences = getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPreferences.getString(currentDate, "");
        Mood obj = gson.fromJson(json, Mood.class);



        // Fait planter l'écran historique

        int counter = 1;
       // obj.getSelectedMood();

        //////////////////////////////////////////


        ImageView iconPast1 = (ImageView) findViewById(R.id.iconPast1);

        iconPast1.setImageResource(R.drawable.ic_comment_black_48px);



        FrameLayout past1 = (FrameLayout)findViewById(R.id.past1);
        past1.setBackgroundColor(getResources().getColor(arrayBackgroundColors[counter]));



    }

}
