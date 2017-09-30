
package metrowebz.com.quizforyou.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import metrowebz.com.quizforyou.Activity.Fragment.FirstFragment;
import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.Extras.Constants;
import metrowebz.com.quizforyou.R;

public class MenuPage extends AppCompatActivity {
    private TextView playerName, score;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ProgressBar mProgressBar;

    SharedPrefManager prefManager ;
    private String user;
    private boolean updatereq = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.translate_rl, R.anim.translate_lr);
        setContentView(R.layout.activity_menu_page);

        prefManager = new SharedPrefManager(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.slider);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        playerName = (TextView) findViewById(R.id.username);
        score = (TextView) findViewById(R.id.score);
        user = prefManager.getStringData(Constants.CREATE_USERNAME);
        score.setText(String.valueOf(getScore()+"pts "));
        playerName.setText(user);
    }

    public int getScore(){
        return prefManager.getSavedScienceScore()+prefManager.getSavedMathScore()+prefManager.getSavedGeographyScore()
                +prefManager.getSavedHistoryScore()+prefManager.getSavedSportScore()+prefManager.getSavedRandomScore();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }catch (Exception e){
            Log.e("NullError", e.getLocalizedMessage());
        }
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager pager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, Category_Page.class);
        startActivity(i);
        finish();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0: return FirstFragment.newInstance();
//                case 1: return SecondFragment.newInstance();
                default: return FirstFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0: return "Subjects";
//                case 1: return "Rankings";
                default: return "Subjects";
            }
        }
    }
}

