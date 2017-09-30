package metrowebz.com.quizforyou.Activity.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.Extras.Constants;
import metrowebz.com.quizforyou.R;


public class SettingDialogFragment extends DialogFragment {
    Button cancel, save;
    SwitchCompat sound;
    static boolean checked;
    private static SharedPrefManager prefManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder setting_dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        setting_dialog.setCancelable(false);
        prefManager = new SharedPrefManager(getContext());
        View view = inflater.inflate(R.layout.setting_dialog_layout,null);
        setting_dialog.setView(view);

        cancel = (Button) view.findViewById(R.id.cancel_action);
        save = (Button) view.findViewById(R.id.save_action);
        sound = (SwitchCompat) view.findViewById(R.id.sound_action);
        sound.setChecked(prefManager.getData(Constants.SAVE_SOUND_SETTING));

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.setChecked(checked);
                prefManager.saveData(Constants.SAVE_SOUND_SETTING, checked);
                dismiss();
            }
        });
        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    //Log.d("Test", String.valueOf(b)+"same");
                    checked = b;
                }
                 else {
                    //Log.d("Test", String.valueOf(b)+"mute");
                    checked = b;
                }
            }
        });
        return setting_dialog.create();
    }


}
