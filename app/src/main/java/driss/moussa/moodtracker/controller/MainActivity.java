package driss.moussa.moodtracker.controller;



import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import driss.moussa.moodtracker.R;
import driss.moussa.moodtracker.component.DialogComment;
import driss.moussa.moodtracker.component.SwipeGestureDetector;
import driss.moussa.moodtracker.model.Mood;

import android.media.MediaPlayer;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity  {

    private MediaPlayer mediaPlayer;
    private int counter = 1;
    private View view;
    private View decorView;
    private SwipeGestureDetector gestureDetector;
    private Mood mood;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Date date = new Date();

        mood = new Mood(counter, "");

        view = this.getWindow().getDecorView();

        gestureDetector = new SwipeGestureDetector(this);

        mPreferences = getPreferences(MODE_PRIVATE);

        ImageView addnote_clic = (ImageView) findViewById(R.id.addnote_clic);
        ImageView history_clic = (ImageView) findViewById(R.id.history_clic);
        addnote_clic.setImageResource(R.drawable.ic_note_add_black);
        history_clic.setImageResource(R.drawable.ic_history_black);
        TextView tv = (TextView) findViewById(R.id.fsdfsfsfsdf);

//        final Toast toast = Toast.makeText(this, "Test du clic", Toast.LENGTH_SHORT);

        ImageView imagePic;
        imagePic = findViewById(R.id.imageView);
        imagePic.setImageResource(R.drawable.smiley_happy);
        view.setBackgroundResource(R.color.light_sage);


        addnote_clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
//                toast.show();
            }
        });

        history_clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                setContentView(R.layout.activity_history);
            }
        });

    }



    @Override
    public boolean onTouchEvent (MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }



    public void onSwipe(SwipeGestureDetector.SwipeDirection direction) {

        ImageView imagePic = (ImageView) findViewById(R.id.imageView);





        // ARRAY OF SMILEYS LIST

        int[] arraySmileys = new int[]{
                R.drawable.smiley_super_happy,
                R.drawable.smiley_happy,
                R.drawable.smiley_normal,
                R.drawable.smiley_disappointed,
                R.drawable.smiley_sad,
        };

        // ARRAY OF SONGS LIST

        int[] arraySongs = new int[] {
                R.raw.do_piano,
                R.raw.re_piano,
                R.raw.mi_piano,
                R.raw.fa_piano,
                R.raw.sol_piano,
        };

        // ARRAY OF BACKGROUND COLORS LIST

        int[] arrayBackgroundColors = new int[] {
                R.color.banana_yellow,
                R.color.light_sage,
                R.color.cornflower_blue_65,
                R.color.warm_grey,
                R.color.faded_red,
        };

//        String message = "";



        mediaPlayer = MediaPlayer.create(this, arraySongs[counter]);



        switch (direction) {


            case BOTTOM_TO_TOP:

                mood.setSelectedMood(counter);

                if (counter > 0) {
                    counter--;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
//                    message = String.valueOf(counter);

                } else {
                    counter = 4;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
//                    message = String.valueOf(counter);
                }
                break;


            case TOP_TO_BOTTOM:

                mood.setSelectedMood(counter);

                if (counter < 4) {
                    counter++;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
//                    message = String.valueOf(counter);

                } else {
                    counter = 0;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
//                    message = String.valueOf(counter);
                }
                break;
        }
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void Dialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        final EditText inputEditText = (EditText) view.findViewById(R.id.editText);


        builder.setView(view)
                .setTitle("Commentaire")
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String inputComment = inputEditText.getText().toString();

                        mood.setUserComment(inputComment);
                        mood.setSelectedMood(counter);

                        Toast.makeText(getBaseContext(),inputComment,Toast.LENGTH_SHORT).show();
                    }

                });

        builder.show();
    }
}