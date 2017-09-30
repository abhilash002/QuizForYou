package metrowebz.com.quizforyou.Database;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Abhilash on 16-01-2017.
 */

public class SharedPrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    private static final String SCORE_KEY = "score";
    private static final String SCORE_LAST_KEY = "last_score";
    private static final String LAST_CATEGORY_PLAYED = "category_name";
    private static final String INCORRECT_ANSWER = "incorrect_ans";
    private static final String PREF_KEY = "pref";
    private static final int PRIVATE_MODE = 0;
    private static final String CORRECT_ANS = "correct_ans";
    private static final String SAVE_TOTAL_TIME= "total_time";
    private static final String SAVE_MAX_QUESTION_PLAYED = "maxquestion";
    private static final String SAVE_SCIENCE_SCORE = "SC_SCORE";
    private static final String SAVE_GEOGRAPHY_SCORE = "GEO_SCORE";
    private static final String SAVE_MATH_SCORE = "MA_SCORE";
    private static final String SAVE_RANDOM_SCORE = "RAN_SCORE";
    private static final String SAVE_HISTORY_SCORE = "HIS_SCORE";
    private static final String SAVE_SPORT_SCORE = "SP_SCORE";

    public SharedPrefManager(Context c){
        this.context = c;
        sharedPreferences = c.getSharedPreferences( PREF_KEY , PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }


    public void saveCurrentCategoryScore(String category,int score){
        editor.putInt(category, score);
        editor.commit();
    }

    public int getSavedScienceScore() {
        return sharedPreferences.getInt(SAVE_SCIENCE_SCORE, 0);
    }

    public int getSavedGeographyScore() {
        return sharedPreferences.getInt(SAVE_GEOGRAPHY_SCORE, 0);
    }

    public   int getSavedMathScore() {
        return sharedPreferences.getInt(SAVE_MATH_SCORE, 0);

    }

    public   int getSavedRandomScore() {
        return sharedPreferences.getInt(SAVE_RANDOM_SCORE, 0);
    }

    public   int getSavedHistoryScore() {
        return sharedPreferences.getInt(SAVE_HISTORY_SCORE, 0);
    }

    public   int getSavedSportScore() {
        return sharedPreferences.getInt(SAVE_SPORT_SCORE, 0);
    }


    public void saveLastScore(int lastScore){
        editor.putInt(SCORE_LAST_KEY, lastScore);
        editor.commit();
    }


    public void saveCorrectAns(int i){
        editor.putInt(CORRECT_ANS,i);
        editor.commit();
    }

    public void saveTotalTime(int i){
        editor.putInt(SAVE_TOTAL_TIME,i);
        editor.commit();
    }


    public void saveOnPauseData(String Key, int value){
        editor.putInt(Key, value);
        editor.commit();
    }

    public void saveData(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public void saveData(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(String key, boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void userCreated(String key, boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean checkUserCreated(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public void removeUser(String key){
        editor.remove(key);
        editor.commit();
    }

    public String getStringData(String key){
        return sharedPreferences.getString(key, "Guest");
    }

    public boolean getData(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public int getOnPauseData(String key){
        return sharedPreferences.getInt(key, 30);
    }

    public int getLastCategorySavedScore(String category){return sharedPreferences.getInt(category, 0); }

}
