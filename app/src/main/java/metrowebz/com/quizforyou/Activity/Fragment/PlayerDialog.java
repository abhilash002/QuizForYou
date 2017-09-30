package metrowebz.com.quizforyou.Activity.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.Extras.Constants;
import metrowebz.com.quizforyou.Extras.Intents;
import metrowebz.com.quizforyou.Model.User;
import metrowebz.com.quizforyou.R;

/**
 * Created by Abhilash on 16-03-2017.
 */

public class PlayerDialog extends DialogFragment {
    EditText playername;
    Button submit, guestPlay, close;
    User newUser;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.player_dialog,null);
        dialog.setView(view);
        playername = (EditText) view.findViewById(R.id.playername);
        submit = (Button) view.findViewById(R.id.submit);
        guestPlay = (Button) view.findViewById(R.id.guest_play);
        close = (Button) view.findViewById(R.id.close);
        if(newUser!= null) {
            newUser = new User();
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newUser.setUsername(playername.getText().toString());
                if(newUser.getUsername().equals("")){
                    playername.requestFocus();
                }else {
                    new SharedPrefManager(getContext()).saveData(Constants.CREATE_USERNAME, newUser.getUsername());
                    new SharedPrefManager(getContext()).userCreated(Constants.CREATE_PLAYER,true);
                    Intents.takeToMenuPage(getContext());
                }
                dismiss();
            }
        });

        guestPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPrefManager(getContext()).saveData(Constants.CREATE_USERNAME, "Guest");
                new SharedPrefManager(getContext()).userCreated(Constants.CREATE_PLAYER,true);
                Intents.takeToMenuPage(getContext());
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                });
            }
        });

        return dialog.create();
    }
}
