package driss.moussa.moodtracker.component;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import driss.moussa.moodtracker.controller.MainActivity;

/**
 * Created by Driss on 04/03/2019.
 */


public class SwipeGestureDetector extends GestureDetector {


    private final static int DELTA_WIN = 50;

    public SwipeGestureDetector(final MainActivity context) {


        super(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.i("DEBUG", e1 + "-" + e2);

                float deltaX = e2.getX() - e1.getX();
                float deltaY = e2.getY() - e1.getY();

                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    if (Math.abs(deltaX) >= DELTA_WIN) {
                        if (deltaX < 0) {
                            context.onSwipe(SwipeDirection.RIGHT_TO_LEFT);
                            return true;
                        } else {
                            context.onSwipe(SwipeDirection.LEFT_TO_RIGHT);
                            return true;
                        }
                    }
                } else {
                    if (Math.abs(deltaY) >= DELTA_WIN) {
                        if (deltaY < 0) {
                            context.onSwipe(SwipeDirection.BOTTOM_TO_TOP);
                            return true;
                        } else {
                            context.onSwipe(SwipeDirection.TOP_TO_BOTTOM);
                            return true;
                        }
                    }
                }

                return false;

            }

            // TENTATIVE D'AJOUT DU CLIC

            @Override
            public boolean onDown(MotionEvent e){
                return true;
            }

        });



    }

    public static enum SwipeDirection {
        LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_TO_TOP,
    }
}
