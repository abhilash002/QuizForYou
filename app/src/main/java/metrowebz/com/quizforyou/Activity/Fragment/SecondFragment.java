package metrowebz.com.quizforyou.Activity.Fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import metrowebz.com.quizforyou.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.stat_window_2, container, false);

        return v;
    }

    public static SecondFragment newInstance() {
        SecondFragment f = new SecondFragment();
        return f;
    }
}