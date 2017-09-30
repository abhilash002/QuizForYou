package metrowebz.com.quizforyou.Activity.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import metrowebz.com.quizforyou.Activity.MainActivity;
import metrowebz.com.quizforyou.Extras.Intents;
import metrowebz.com.quizforyou.OnCompleteListener;
import metrowebz.com.quizforyou.R;

/**
 * Created by Abhilash on 24-04-2017.
 */

public class PauseDialog extends DialogFragment {
    private OnCompleteListener mCompleteListener;
    private AlertDialog.Builder alertDBuilder;
    private AlertDialog dialog;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        alertDBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.back_pressed_dialog, null);
        alertDBuilder.setView(view);
        alertDBuilder.setCancelable(false);

        mCompleteListener = (OnCompleteListener) getActivity();

        Button yesB = (Button) view.findViewById(R.id.pause_yes);
        Button noB = (Button) view.findViewById(R.id.pause_no);

        yesB.setOnClickListener(YesNoListener);
        noB.setOnClickListener(YesNoListener);

        dialog = alertDBuilder.create();
        return dialog;
    }

    private View.OnClickListener YesNoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.pause_yes:
                    takeToHome(getContext());
                    break;
                case R.id.pause_no:
                    mCompleteListener.onComplete();
                    dialog.dismiss();
                    break;
            }
        }
    };

    private void takeToHome(Context context){
        Intents.takeToHomeActivity(context);
        getActivity().finish();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {super.onDismiss(dialog);}
}
