package driss.moussa.moodtracker.model;

import android.nfc.Tag;
import android.util.Log;

/**
 * Created by Driss on 22/02/2019.
 */


public class Mood {

    private int selectedMood;
    private String userComment;



    public Mood(int selectedMood, String userComment) {
        this.selectedMood = selectedMood;
        this.userComment = userComment;
    }

    public int getSelectedMood() {
        return selectedMood;
    }

    public void setSelectedMood(int selectedMood) {
        this.selectedMood = selectedMood;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }


}
