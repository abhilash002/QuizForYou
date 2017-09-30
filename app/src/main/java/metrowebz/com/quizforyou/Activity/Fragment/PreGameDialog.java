package metrowebz.com.quizforyou.Activity.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import metrowebz.com.quizforyou.Activity.MainActivity;
import metrowebz.com.quizforyou.R;


/**
 * Created by Abhilash on 14-03-2017.
 */

public class PreGameDialog extends DialogFragment {
    private TextView title;
    private Button start;
//    private Spinner gameMode, noOfQues;
//    private ArrayAdapter adapter1, adapter2;
//    private static String mode = "Easy";
//    private static int noQues = 10;
    private static int subjectCode;

    private Bundle bundle;

    @NonNull
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        final AlertDialog.Builder pregame_dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        pregame_dialog.setCancelable(false);
        View view = inflater.inflate(R.layout.pregame_dialoglayout,null);
        pregame_dialog.setView(view);
        bundle = getArguments();
        subjectCode = bundle.getInt("type");
        Log.e("Test", "Subject code: "+ subjectCode);

        title = (TextView) view.findViewById(R.id.title);
        start = (Button) view.findViewById(R.id.start);
//        gameMode = (Spinner) view.findViewById(R.id.gamemode);
//        noOfQues = (Spinner) view.findViewById(R.id.no_of_ques);

        title.setText(bundle.getCharSequence("title","Quiz Game"));

//        adapter1 = ArrayAdapter.createFromResource(getContext(),R.array.game_mode,android.R.layout.simple_list_item_1);
//        adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.no_of_ques,android.R.layout.simple_list_item_1);
//
//        gameMode.setAdapter(adapter1);
//        noOfQues.setAdapter(adapter2);
//        gameMode.setSelection(0);
//        noOfQues.setSelection(1);
//
//        gameMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                switch(i){
//                    case 0:
//                        mode = "Easy";
//                        break;
//                    case 1:
//                        mode = "Medium";
//                        break;
//                    case 2:
//                        mode = "Pro";
//                        break;
//                    default:
//                        mode = "Easy";
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                adapterView.setSelection(0);
//                mode = "Easy";
//            }
//        });
//
//
//        noOfQues.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                switch(i){
//                    case 0:
//                        noQues = 5;
//                        break;
//                    case 1:
//                        noQues = 10;
//                        break;
//                    case 2:
//                        noQues = 20;
//                        break;
//                    default:
//                        noQues = 10;
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                adapterView.setSelection(1);
//                noQues = 10;
//            }
//        });



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                bundle.putInt("type", subjectCode);
             //   bundle.putInt("NOOFQUESTION", noQues);
             //   bundle.putString("MODE",mode);
                Intent i = new Intent(getActivity(),MainActivity.class);
                i.putExtra("type",subjectCode);
                startActivity(i);
                getActivity().finish();
            }
        });

        return pregame_dialog.create();
    }
}
