package metrowebz.com.quizforyou.Extras;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import metrowebz.com.quizforyou.Activity.Category_Page;
import metrowebz.com.quizforyou.Activity.Main2Activity;
import metrowebz.com.quizforyou.Activity.MenuPage;


/**
 * Created by Abhilash on 28-04-2017.
 */

public class Intents {

    public static void takeToResultActivity(Context c, Bundle b){
        Intent intent;
        intent = new Intent(c.getApplicationContext(), Main2Activity.class);
        intent.putExtras(b);
        c.startActivity(intent);
    }

    public static void takeToHomeActivity(Context c){
        Intent intent;
        intent = new Intent(c.getApplicationContext(), Category_Page.class);
        c.startActivity(intent);
    }
    public static void takeToMenuPage(Context c){
        Intent i = new Intent(c.getApplicationContext(), MenuPage.class);
        c.startActivity(i);
    }

    public static void takeToHome(Activity activity){
        Intent intent = new Intent(activity, Category_Page.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
