package metrowebz.com.quizforyou.Activity.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import metrowebz.com.quizforyou.R;

/**
 * Created by Abhilash on 29-09-2017.
 */

public class MakePurchaseDialog extends DialogFragment {
    private AlertDialog.Builder alertDBuilder;
    private AlertDialog dialog;
    private Button mBuyButton;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        alertDBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.make_purchase_fragment_dialog, null);
        mBuyButton = (Button) view.findViewById(R.id.ok_button_mpd);
        alertDBuilder.setView(view);
        alertDBuilder.setCancelable(true);

        mBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LOG","Make Skip purchase");
                dismiss();
            }
        });

        dialog = alertDBuilder.create();
        return dialog;
    }
}
