package metrowebz.com.quizforyou.Activity.Fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import metrowebz.com.quizforyou.Database.QuestionDB;
import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
//    private TextView categ_pl, score, incorr, corr;
    private ProgressBar progressBarScience, progressBarGeography, progressBarMath,
                        progressBarRandom, progressBarHistory, progressBarSport;
    private TextView textViewScience, textViewGeography, textViewMath, textViewRandom, textViewHistory, textViewSport;
    private static LinearLayout b_sc,b_geo,b_ra,b_ma,b_hi,b_sp;
    private static SharedPrefManager prefManager;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.stat_window_1, container, false);

        QuestionDB qdb = new QuestionDB(getContext());
            // Initilaizing the view and elements.
        initElements(v);

        prefManager = new SharedPrefManager(getContext());
//          progress bar data will be filled-updated with the latest data
        fillProgressBarData(qdb);

        final PreGameDialog dialog = new PreGameDialog();
        bundle = new Bundle();

        //Toast.makeText(getApplicationContext(),"Last Score is: "+sc+" Time taken: "+time, Toast.LENGTH_SHORT).show();
        //time_st.append(" "+time);

        b_sc.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                System.out.println("          science            ");
                bundle.putInt("type",1);
                bundle.putCharSequence("Science","title");
                showPreGameDialog(dialog);
            }
        });
        b_ra.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                System .out.println("          random               ");
                bundle.putInt("type",2);
                bundle.putCharSequence("Random","title");
                showPreGameDialog(dialog);
            }
        });
        b_geo.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                System.out.println("           geography              ");
                bundle.putInt("type",5);
                bundle.putCharSequence("Geography","title");
                showPreGameDialog(dialog);

            }
        });
        b_hi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                System.out.println("          history                ");
                bundle.putInt("type",4);
                bundle.putCharSequence("History","title");
                showPreGameDialog(dialog);

            }
        });
        b_ma.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                System.out.println("          math               ");
                bundle.putInt("type",3);
                bundle.putCharSequence("Maths","title");
                showPreGameDialog(dialog);
            }
        });
        b_sp.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                bundle.putInt("type",6);
                bundle.putCharSequence("Sports","title");
                showPreGameDialog(dialog);

            }
        });

        return v;
    }

    private void fillProgressBarData(QuestionDB qdb) {
        int i =10;
        progressBarScience.setMax(i);
        textViewScience.setText("Last Score: "+prefManager.getSavedScienceScore()+"/"+i);
//        i = qdb.getRowCount(qdb.getTableName(5));
        progressBarGeography.setMax(i);
        textViewGeography.setText("Last Score: "+prefManager.getSavedGeographyScore()+"/"+i);
//        i = qdb.getRowCount(qdb.getTableName(3));
        progressBarMath.setMax(i);
        textViewMath.setText("Last Score: "+prefManager.getSavedMathScore()+"/"+i);
//        i = qdb.getRowCount(qdb.getTableName(2));
        progressBarRandom.setMax(i);
        textViewRandom.setText("Last Score: "+prefManager.getSavedRandomScore()+"/"+i);
//        i = qdb.getRowCount(qdb.getTableName(4));
        progressBarHistory.setMax(i);
        textViewHistory.setText("Last Score: "+prefManager.getSavedHistoryScore()+"/"+i);
//        i = qdb.getRowCount(qdb.getTableName(6));
        progressBarSport.setMax(i);
        textViewSport.setText("Last Score: "+prefManager.getSavedSportScore()+"/"+ i );
        bundle = new Bundle();
        progressBarScience.setProgress(prefManager.getSavedScienceScore());
        progressBarGeography.setProgress(prefManager.getSavedGeographyScore());
        progressBarMath.setProgress(prefManager.getSavedMathScore());
        progressBarRandom.setProgress(prefManager.getSavedRandomScore());
        progressBarSport.setProgress(prefManager.getSavedSportScore());
        progressBarHistory.setProgress(prefManager.getSavedHistoryScore());
    }

    private void initElements(View v) {
        b_sc = (LinearLayout) v.findViewById(R.id.b_science);
        b_ra = (LinearLayout) v.findViewById(R.id.b_random);
        b_ma = (LinearLayout) v.findViewById(R.id.b_math);
        b_hi = (LinearLayout) v.findViewById(R.id.b_history);
        b_geo = (LinearLayout) v.findViewById(R.id.b_geography);
        b_sp = (LinearLayout) v.findViewById(R.id.b_sport);

        textViewScience = (TextView) v.findViewById(R.id.tv_sc_completed);
        textViewGeography = (TextView) v.findViewById(R.id.tv_geo_completed);
        textViewMath = (TextView) v.findViewById(R.id.tv_mat_completed);
        textViewRandom = (TextView) v.findViewById(R.id.tv_ran_completed);
        textViewHistory = (TextView) v.findViewById(R.id.tv_his_completed);
        textViewSport = (TextView) v.findViewById(R.id.tv_spo_completed);

        progressBarScience = (ProgressBar) v.findViewById(R.id.tv_sc_progressbar);
        progressBarGeography = (ProgressBar) v.findViewById(R.id.tv_geo_progressbar);
        progressBarMath = (ProgressBar) v.findViewById(R.id.tv_math_progressbar);
        progressBarRandom = (ProgressBar) v.findViewById(R.id.tv_ran_progressbar);
        progressBarHistory = (ProgressBar) v.findViewById(R.id.tv_his_progressbar);
        progressBarSport = (ProgressBar) v.findViewById(R.id.tv_spo_progressbar);

    }

    private void showPreGameDialog(PreGameDialog dialog){
        dialog.setArguments(bundle);
        dialog.show(getFragmentManager(), "Dialog");
    }

    public static FirstFragment newInstance() {
        FirstFragment f = new FirstFragment();
        return f;
    }

}
