package metrowebz.com.quizforyou.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import java.util.List;

import metrowebz.com.quizforyou.Activity.Fragment.MakePurchaseDialog;
import metrowebz.com.quizforyou.Activity.Fragment.PauseDialog;
import metrowebz.com.quizforyou.Activity.Fragment.SkipQuestionDilaog;
import metrowebz.com.quizforyou.Database.QuestionDB;
import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.Extras.Constants;
import metrowebz.com.quizforyou.Extras.CounterClass;
import metrowebz.com.quizforyou.Model.Question;
import metrowebz.com.quizforyou.OnCompleteListener;
import metrowebz.com.quizforyou.R;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity implements OnCompleteListener{
    private List<Question> questions ;
    private TextView ques_text,  timer, quesNo ;
    private Button opt_a,opt_b,opt_c,opt_d,skip_button, next_button ;
    private TextView scores;
    private Question currentQ;
    private boolean answered;
    private int qid ;
    public static int gscore=0 ;
    public static float perc = 0;
    private String CURRENT_CATEGORY_PLAYED ;
    private int questionno =0;
    private CounterClass time ,nextQuesTimer;
    private int clock_sound;
    private int success_sound;
    private int failed_sound;
    private int total_question=0;
    private Drawable correct_Option,wrong_option;
    private static final int TIMER_TIME = 30000;
    byte SKIP_LIVES = 3;
    private boolean paused ;
    private String correctOption;
    private Animation animAlpha,animAlpha2;
    private SharedPrefManager prefManager;
    private int rowCount, skipLivesUsed;
    private SoundPool soundPool;
    private PauseDialog dialog;
                //  CONSTANT_KEYS  //
    private final String SAVE_SCIENCE_SCORE = "SC_SCORE";
    private final String SAVE_GEOGRAPHY_SCORE = "GEO_SCORE";
    private final String SAVE_MATH_SCORE = "MA_SCORE";
    private final String SAVE_RANDOM_SCORE = "RAN_SCORE";
    private final String SAVE_HISTORY_SCORE = "HIS_SCORE";
    private final String SAVE_SPORT_SCORE = "SP_SCORE";
    private final String SAVE_PAUSE_TIME = "ONPAUSETIME";
    private final String SAVE_SOUND_SETTING = "SOUNDSETTING";

    private AdView mAdView;
    private InterstitialAd mAdViewInterS;

    Bundle b;
    private boolean soundLoaded = false;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        prefManager = new SharedPrefManager(this);

        quesNo = (TextView)findViewById(R.id.qno);
        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        animAlpha2 = AnimationUtils.loadAnimation(this, R.anim.anim_alpha2);

        paused = false;

        int i = getIntent().getExtras().getInt("type");
        initViews();

        mAdView = (AdView) findViewById(R.id.banner_id2);
        AdRequest request = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.TestDeviceId)).build();
        mAdView.loadAd(request);

        mAdViewInterS = new InterstitialAd(MainActivity.this);
        mAdViewInterS.setAdUnitId(getResources().getString(R.string.banner_inter_ad_1));

        getSelectedSubject( new QuestionDB(this), i);

        int MAX_STREAM = 5;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attributes)
                    .setMaxStreams(MAX_STREAM)
                    .build();
        } else {
            soundPool = new SoundPool(MAX_STREAM, AudioManager.STREAM_MUSIC, 0);
        }
        int priority = 1;
        clock_sound = soundPool.load(this, R.raw.tick, priority);
        failed_sound = soundPool.load(this, R.raw.failed, priority);
        success_sound = soundPool.load(this, R.raw.success, priority);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int soundId, int status) {
                if(status == 0) {
                    soundLoaded = true;
                }
                if(prefManager.getData(Constants.SAVE_SOUND_SETTING)&& soundId == clock_sound){
                    playSound(clock_sound,-1);
                }
            }
        });

        total_question = rowCount;
        skipLivesUsed = 0;
        questionno=1;
        currentQ = questions.get(qid);
        correctOption = currentQ.getANSWER().toString();
    }

    public void showInterstitialAd(){
        AdRequest request1 = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.TestDeviceId)).build();
        mAdViewInterS.loadAd(request1);
        mAdViewInterS.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                    mAdViewInterS.show();

                super.onAdLoaded();

            }

            @Override
            public void onAdFailedToLoad(int i) {
                Log.e("Test", "Failed to load: code- "+i);
                super.onAdFailedToLoad(i);
            }
        });
    }

    public void getSelectedSubject(QuestionDB qdb , int i){
        if (i == 1) {
            questions = qdb.getAllScienceQuestions();
            CURRENT_CATEGORY_PLAYED = SAVE_SCIENCE_SCORE;
        }
        else if (i == 2) {
            questions = qdb.getAllRandomQuestions();
            CURRENT_CATEGORY_PLAYED = SAVE_RANDOM_SCORE;
        }
        else if (i == 3)
        {
            questions = qdb.getAllMathQuestions();
            CURRENT_CATEGORY_PLAYED = SAVE_MATH_SCORE;
        }
        else if (i ==4 )
        {
            questions = qdb.getAllHistoryQuestions();
            CURRENT_CATEGORY_PLAYED = SAVE_HISTORY_SCORE;
        }
        else if (i == 5)
        {
            questions = qdb.getAllGeographyQuestions();
            CURRENT_CATEGORY_PLAYED = SAVE_GEOGRAPHY_SCORE;
        }
        else if(i== 6){
            questions = qdb.getAllSportQuestions();
            CURRENT_CATEGORY_PLAYED = SAVE_SPORT_SCORE;
        }
        rowCount = questions.size();
    }

    public void initViews(){
        int resource_cor_opt = getResources().getIdentifier("@drawable/correct_option_layout",null,getPackageName());
        int resource_wrong_opt = getResources().getIdentifier("@drawable/wrong_option_layout",null,getPackageName());
        correct_Option = getDrawable(resource_cor_opt);
        wrong_option = getDrawable(resource_wrong_opt);

        scores = (TextView) findViewById(R.id.score1);
        ques_text = (TextView) findViewById(R.id.ques_text);
        timer = (TextView) findViewById(R.id.timers);
        opt_a = (Button) findViewById(R.id.opt_a);
        opt_b = (Button) findViewById(R.id.opt_b);
        opt_c = (Button) findViewById(R.id.opt_c);
        opt_d = (Button) findViewById(R.id.opt_d);

        next_button = (Button) findViewById(R.id.next_qbut);
        skip_button = (Button) findViewById(R.id.skip_qbut);
        skip_button.setText("SKIP(3)");

        gscore = 0;

    }

    @Override
    protected void onResume() {
        super.onResume();
        dialog = new PauseDialog();
        dialog.setArguments(b);

        if (!paused){
            setQuestionView();
        }
        if(paused) {
            time.start();
            dialog.show(getSupportFragmentManager(),"pause");
        }
        opt_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered = true;
                getAnswer(opt_a.getText().toString(),1);
            }
        });
        opt_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered = true;
                getAnswer(opt_b.getText().toString(),2);
            }
        });
        opt_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered = true;
                getAnswer(opt_c.getText().toString(),3);
            }
        });
        opt_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered = true;
                getAnswer(opt_d.getText().toString(),4);
            }
        });

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });
        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipQuestion();
            }
        });
        if (mAdView!=null)
        mAdView.resume();

    }

    @Override
    public void onBackPressed(){
        pauseSound(clock_sound);
        saveBestHighScore(gscore, CURRENT_CATEGORY_PLAYED);
        dialog.show(getSupportFragmentManager(),"pause");
        dialog.setCancelable(false);
    }

    @Override
    protected void onPause() {
        paused = true;
            pauseSound(clock_sound);
        if (mAdView!=null)
            mAdView.pause();
        super.onPause();
    }

    private void getAnswer(String s,int option) {
        if(answered){
            if(soundLoaded)
            pauseSound(clock_sound);
            time.pause();
            opt_a.setEnabled(false);
            opt_b.setEnabled(false);
            opt_c.setEnabled(false);
            opt_d.setEnabled(false);
            setCorrectAnswer(option);
            timer.setText("00");
        }
        int s_loop = 0;
        nextQuesTimer = new CounterClass(this, 5000, 1000);
        nextQuesTimer.onTick(0);

        if(currentQ.getANSWER().equals(s)) {
            playSound(success_sound, s_loop);
            gscore++;

            scores.setText(String.valueOf(gscore));

            if (qid < total_question) {
                currentQ = questions.get(qid);
            } else {
                perc = ((float) gscore / questionno) * 100;
                saveBestHighScore(gscore, CURRENT_CATEGORY_PLAYED);

                takeToGameActivity(gscore);
            }
        }else {
            playSound(failed_sound, s_loop);
        }if (qid == total_question && answered){
            saveBestHighScore(gscore, CURRENT_CATEGORY_PLAYED);
            takeToGameActivity(gscore);
        }

    }

    public void setCorrectAnswer(int i){
        switch (i){
            case 1:
                if(!opt_a.getText().toString().equals(correctOption)){
                    opt_a.setBackgroundDrawable(wrong_option);
                    opt_a.startAnimation(animAlpha2);
                }
                break;
            case 2:
                if(!opt_b.getText().toString().equals(correctOption)){
                    opt_b.setBackgroundDrawable(wrong_option);
                    opt_b.startAnimation(animAlpha2);
                }
                break;
            case 3:
                if(!opt_c.getText().toString().equals(correctOption)){
                    opt_c.setBackgroundDrawable(wrong_option);
                    opt_c.startAnimation(animAlpha2);
                }
                break;
            case 4:
                if(!opt_d.getText().toString().equals(correctOption)){
                    opt_d.setBackgroundDrawable(wrong_option);
                    opt_d.startAnimation(animAlpha2);
                }
                break;
        }

        //Setting the right Answer
        if(opt_a.getText().toString().equals(correctOption)){
            opt_a.setBackgroundDrawable(correct_Option);
            opt_a.startAnimation(animAlpha);
        }
        if(opt_b.getText().toString().equals(correctOption)){
            opt_b.setBackgroundDrawable(correct_Option);
            opt_b.startAnimation(animAlpha);
        }
        if(opt_c.getText().toString().equals(correctOption)){
            opt_c.setBackgroundDrawable(correct_Option);
            opt_c.startAnimation(animAlpha);
        }
        if(opt_d.getText().toString().equals(correctOption)){
            opt_d.setBackgroundDrawable(correct_Option);
            opt_d.startAnimation(animAlpha);
        }
    }

    private void saveBestHighScore(int score, String category){
        if(score > prefManager.getLastCategorySavedScore(category)){
            prefManager.saveCurrentCategoryScore(category, score);
        }

    }

    private void takeToGameActivity(int gscore){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle b = new Bundle();
        b.putInt("score", gscore);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setQuestionView() {
        if(soundLoaded){
            pauseSound(success_sound);
            pauseSound(failed_sound);
        }
        resetAnimation();
        if(time!= null) {
            time.cancel();
        }
        if(questionno==total_question){
            next_button.setText("Finish");
        }
        time = new CounterClass(this, TIMER_TIME, 1000);
        ques_text.setText(currentQ.getQUESTION());
        opt_a.setBackgroundResource(R.drawable.ans_box);
        opt_b.setBackgroundResource(R.drawable.ans_box);
        opt_c.setBackgroundResource(R.drawable.ans_box);
        opt_d.setBackgroundResource(R.drawable.ans_box);
        quesNo.setText("Question: "+questionno+"/"+ total_question);
        opt_a.setText(currentQ.getOPT_A());
        opt_b.setText(currentQ.getOPT_B());
        opt_c.setText(currentQ.getOPT_C());
        opt_d.setText(currentQ.getOPT_D());
        opt_a.setEnabled(true);
        opt_b.setEnabled(true);
        opt_c.setEnabled(true);
        opt_d.setEnabled(true);
        time.start();
        pauseSound(clock_sound);
        resumeSound(clock_sound);
        answered = false;
        qid++;
        correctOption = currentQ.getANSWER().toString();
        byte adPeriod = 5;
        if(qid% adPeriod ==0){
            showInterstitialAd();
        }
    }

    private void resetAnimation(){
        animAlpha.cancel();
        animAlpha2.cancel();
        animAlpha.reset();
        animAlpha2.reset();
    }

    private void pauseSound(int sID){
        if (soundPool!=null)
            soundPool.pause(sID);
    }

    private void resumeSound(int sID){
        soundPool.resume(sID);
    }

    private void playSound(int sId,int loop){
        Log.e("Test", "Sound played");
        int  i = soundPool.play(sId, 0.9f,0.9f,1,loop,1.0f);
        if(i==0){
            Log.e("Test", "Sound playing failed");
        }else {
            Log.e("Test", "Sound playing Success");
        }
    }

    private void skipQuestion() {
        if (qid < rowCount-1){
            if(skipLivesUsed++ < SKIP_LIVES) {
                SkipQuestionDilaog skipQuestionDialog = new SkipQuestionDilaog();
                skipQuestionDialog.show(getSupportFragmentManager() , "null");
                skipQuestionDialog.setSkipDialogClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        skip_button.setText("SKIP("+(SKIP_LIVES-skipLivesUsed)+")");
                        paused = false;
                        questionno++;
                        currentQ = questions.get(qid);
                        setQuestionView();
                    }
                });
            }
            else{
                MakePurchaseDialog dialog = new MakePurchaseDialog();
                dialog.show(getSupportFragmentManager(),"skip_purchase");
                skip_button.setText("SKIP(0)");
                skip_button.setActivated(false);
            }
        }
    }

    long mLastClickTime = 0;

    private void nextQuestion() {
        if(answered) {
            if (qid < rowCount) {
                paused = false;
                questionno++;
                currentQ = questions.get(qid);
                setQuestionView();
            }
        }
        else if (SystemClock.elapsedRealtime() - mLastClickTime > 2000) {
            mLastClickTime = SystemClock.elapsedRealtime();
        }
        else{
            Toast.makeText(this,"Please select an option.",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (mAdView!=null)
            mAdView.destroy();
        if(soundPool!=null){
            soundPool.release();
            soundPool = null;
        }
        super.onDestroy();
    }

    @Override
    public void onComplete() {
        if (!answered) {
            resumeSound(clock_sound);
        }
    }
}
