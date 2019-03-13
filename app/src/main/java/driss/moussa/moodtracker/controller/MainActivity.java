package driss.moussa.moodtracker.controller;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import driss.moussa.moodtracker.R;
import driss.moussa.moodtracker.component.DialogComment;
import driss.moussa.moodtracker.component.SwipeGestureDetector;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity  {



    MediaPlayer mediaPlayer;
    int counter = 0;
    View view;
    private SwipeGestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new SwipeGestureDetector(this);


        ImageView addnote_clic = (ImageView) findViewById(R.id.addnote_clic);
        ImageView history_clic = (ImageView) findViewById(R.id.history_clic);
        addnote_clic.setImageResource(R.drawable.ic_note_add_black);
        history_clic.setImageResource(R.drawable.ic_history_black);
        TextView tv = (TextView) findViewById(R.id.fsdfsfsfsdf);





        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.banana_yellow);

        final Toast toast = Toast.makeText(this, "Test du clic", Toast.LENGTH_SHORT);

        ImageView imagePic;
        imagePic = findViewById(R.id.imageView);
        imagePic.setImageResource(R.drawable.smiley_super_happy);




        addnote_clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
                toast.show();
            }
        });
    }


    public void openDialog() {
        DialogComment dialogComment = new DialogComment();
        dialogComment.show(getSupportFragmentManager(),"dialog comment");
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

        String message = "";

        // mediaPlayer = [counter] = Arraysongs piano sounds

        mediaPlayer = MediaPlayer.create(this, arraySongs[counter]);



        switch (direction) {


            case BOTTOM_TO_TOP:
                if (counter > 0) {
                    counter--;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
                    message = String.valueOf(counter);

                } else {
                    counter = 4;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
                    message = String.valueOf(counter);
                }
                break;


            case TOP_TO_BOTTOM:
                if (counter < 4) {
                    counter++;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
                    message = String.valueOf(counter);

                } else {
                    counter = 0;
                    mediaPlayer.start();
                    imagePic.setImageResource(arraySmileys[counter]);
                    view.setBackgroundResource(arrayBackgroundColors[counter]);
                    message = String.valueOf(counter);
                }
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}