package metrowebz.com.quizforyou.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import metrowebz.com.quizforyou.R;


public class LoadingPage extends AppCompatActivity {
    private Drawable draw;
    private ProgressBar bar;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_loading_page);

        bar = (ProgressBar) findViewById(R.id.pro_bar);
        draw = getDrawable(R.drawable.progress_bar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                bar.setProgressDrawable(draw);
                for(int progress=1; progress <=100; progress+=1){
                    try{
                        Thread.sleep(50);
                        bar.setProgress(progress);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nextAct();
                finish();
            }
        }).start();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private void nextAct() {
        Intent i = new Intent(LoadingPage.this, Category_Page.class);
        startActivity(i);
    }

}
