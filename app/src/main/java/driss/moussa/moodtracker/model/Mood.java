package driss.moussa.moodtracker.model;

/**
 * Created by Driss on 22/02/2019.
 */


public class Mood {

    private int selectedMood;
    private String userComment;
//    private String commentDate;


    public Mood(int selectedMood, String userComment) {
        this.selectedMood = selectedMood;
        this.userComment = userComment;
//        this.commentDate = commentDate;
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

//    public String getCommentDate() {
//        return commentDate;
//    }
//
//    public void setCommentDate(String commentDate) {
//        this.commentDate = commentDate;
//    }
}
