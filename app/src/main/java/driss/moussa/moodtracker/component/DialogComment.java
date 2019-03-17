package driss.moussa.moodtracker.component;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import driss.moussa.moodtracker.R;

/**
 * Created by Driss on 21/02/2019.
 */

public class DialogComment extends AppCompatDialogFragment {

    String recupCommentaire = "text";



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
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

                        recupCommentaire = inputEditText.getText().toString();



                        Toast.makeText(getContext(), recupCommentaire,Toast.LENGTH_SHORT).show();

                    }

                });


        return builder.create();


    }

}