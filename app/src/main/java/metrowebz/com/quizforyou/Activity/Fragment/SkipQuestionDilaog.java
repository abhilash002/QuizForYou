package metrowebz.com.quizforyou.Activity.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import metrowebz.com.quizforyou.R;

/**
 * Created by Abhilash on 30-09-2017.
 */

public class SkipQuestionDilaog extends DialogFragment implements View.OnClickListener {
    private View.OnClickListener listener;
    private AlertDialog.Builder alertDBuilder;
    private AlertDialog dialog;
    private Button mDenyButton, mAcceptButton;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        alertDBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.skip_question_dialog, null);
        mDenyButton = (Button) view.findViewById(R.id.deny);
        mAcceptButton = (Button) view.findViewById(R.id.accept);
        alertDBuilder.setView(view);
        alertDBuilder.setCancelable(false);

        mDenyButton.setOnClickListener(this);
        mAcceptButton.setOnClickListener(this);

        dialog = alertDBuilder.create();
        return dialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deny:
                dismiss();
                break;
            case R.id.accept:
                this.onClick(v);
                break;
        }
    }

    public void setSkipDialogClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
}
