package driss.moussa.moodtracker.component;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import driss.moussa.moodtracker.R;

/**
 * Created by Driss on 21/02/2019.
 */

public class DialogComment extends AppCompatDialogFragment {

    private EditText editTextComment;

    //    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        editTextComment = view.findViewById(R.id.commentline);


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

//                        editTextComment.getText();
//                        Toast.makeText(this, String.valueOf(ed))
                    }

                });




        return builder.create();








    }
}
