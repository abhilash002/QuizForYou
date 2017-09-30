package metrowebz.com.quizforyou.Extras;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import metrowebz.com.quizforyou.R;

/**
 * Created by Abhilash on 06-11-2016.
 */
public class CounterClass extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    private static TextView timer ;
    private static String s;
    private Context context;

    public CounterClass(Context context ,long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.context = context;
    }

    long millis;
    @Override
    public void onTick(long millisUntilFinished) {
        millis = millisUntilFinished;
        timer = (TextView) ((Activity)context).findViewById(R.id.timers);
        //String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),TimeUnit.MILLISECONDS.toMinutes(millis)-
        //                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),TimeUnit.MILLISECONDS.toSeconds(millis)
        //                -TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        s = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis)-TimeUnit.MINUTES.toSeconds
                    (TimeUnit.MILLISECONDS.toMinutes(millis)));
        //System.out.println(s);
        timer.setTextColor(Color.BLACK);
        timer.setText(s);
    }

    @Override
    public void onFinish() {
        timer.setText("00");
        timer.setTextColor(Color.RED);
    }

    public void pause(){
        timer.setText(s);
        cancel();
    }
}
