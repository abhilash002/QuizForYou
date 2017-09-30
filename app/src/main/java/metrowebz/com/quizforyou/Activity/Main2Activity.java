package metrowebz.com.quizforyou.Activity;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.R;

public class Main2Activity extends AppCompatActivity {

    private Button rateUs, share, toHome;
    private TextView scoreText, won_line;
    private ImageView img;
    private static  String s1 = "Gold";
    private static  String s2 = "Silver";
    private static  String s3 = "Bronze";
    private SharedPrefManager prefManager;
    AdView bannerAdView;
    InterstitialAd interstitialAd;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prefManager = new SharedPrefManager(this);

        scoreText = (TextView) findViewById(R.id.score_textView);
        rateUs = (Button) findViewById(R.id.rateus_button);
        share = (Button) findViewById(R.id.share_button);
        toHome = (Button) findViewById(R.id.home_button);
        img = (ImageView) findViewById(R.id.medal);
        won_line = (TextView) findViewById(R.id.won_line);

        bannerAdView = (AdView) findViewById(R.id.banner_id3);
        AdRequest request = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.TestDeviceId)).build();
        bannerAdView.loadAd(request);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        float perc = (score*10);
//        int timeTaken = b.getInt("total_time");

        interstitialAd = new InterstitialAd(Main2Activity.this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.banner_inter_result));
        AdRequest request1 = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.TestDeviceId)).build();
        interstitialAd.loadAd(request1);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }
        });

        prefManager.saveLastScore(score);
        prefManager.saveCorrectAns(score);
//        prefManager.saveTotalTime(timeTaken);

       // System.out.print(score + " and"+perc);
        int resource_silver = getResources().getIdentifier("@drawable/silver_medal",null, getPackageName());
        int resource_gold = getResources().getIdentifier("@drawable/gold_medal",null, getPackageName());
        int resource_bronze = getResources().getIdentifier("@drawable/bronze_medal",null, getPackageName());
        int resourse_sad = getResources().getIdentifier("@drawable/sad_boy",null,getPackageName());

        Drawable res1 = getResources().getDrawable(resource_gold,null);
        Drawable res2 = getResources().getDrawable(resource_silver,null);
        Drawable res3 = getResources().getDrawable(resource_bronze,null);
        Drawable res4 = getResources().getDrawable(resourse_sad,null);

        scoreText.setText("Score: "+ score);

        if(perc <= 40 && perc>0){
            img.setImageDrawable(res3);
            won_line.setText(getString(R.string.string_prize_won_line)+s3);
        }
        else if(perc <= 75 && perc>40){
            img.setImageDrawable(res2);
            won_line.setText(getString(R.string.string_prize_won_line)+s2);
        }
        else if (perc <= 100 && perc >75){
            img.setImageDrawable(res1);
            won_line.setText(getString(R.string.string_prize_won_line)+s1);
        }
        else if(perc == 0){
            img.setImageDrawable(res4);
            won_line.setText(R.string.string_try_again);
        }


        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Main2Activity.this,MenuPage.class);
                startActivity(intent);
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Please download this Quiz App.");
                sendIntent.setType("text/plain");
                sendIntent.createChooser(sendIntent, "Share App");
                startActivity(sendIntent);
            }
        });

        rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMarket();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bannerAdView!=null)
            bannerAdView.resume();
    }

    @Override
    protected void onPause() {
        if (bannerAdView!=null)
            bannerAdView.pause();
        super.onPause();
    }

    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id="+ getPackageName());
        Intent toMarket = new Intent(Intent.ACTION_VIEW, uri);
        try{
            startActivity(toMarket);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Unable to Market place",Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onDestroy() {
        if (bannerAdView!=null)
            bannerAdView.destroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed(){

    }

}
