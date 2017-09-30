package metrowebz.com.quizforyou.Activity;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import metrowebz.com.quizforyou.Activity.Fragment.PlayerDialog;
import metrowebz.com.quizforyou.Activity.Fragment.SettingDialogFragment;
import metrowebz.com.quizforyou.Database.SharedPrefManager;
import metrowebz.com.quizforyou.Extras.Constants;
import metrowebz.com.quizforyou.R;


public class Category_Page extends AppCompatActivity {
    private static final String ITEM_SKU = "remove_game_ads";
    private Button play_b, setting_b, share_b;
    private static AlertDialog.Builder alertForExit;
    private boolean userCreated;
    private SharedPrefManager prefManager;
    private AdView mAdView;
    private ImageView ivNoAdsButton;

    IInAppBillingService mService;
    ServiceConnection mServiceConn ;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.translate_rl, R.anim.translate_lr);
        setContentView(R.layout.activity_category__page);

        mAdView = (AdView) findViewById(R.id.banner_id);
        AdRequest request = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.TestDeviceId)).build();
        mAdView.loadAd(request);

        play_b = (Button) findViewById(R.id.play_button);
        setting_b = (Button) findViewById(R.id.setting_but);
        share_b = (Button) findViewById(R.id.share_button);
        ivNoAdsButton = (ImageView) findViewById(R.id.noads);

        prefManager = new SharedPrefManager(this);
        userCreated = prefManager.checkUserCreated(Constants.CREATE_PLAYER);

        play_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!userCreated) {
                    PlayerDialog makePlayer = new PlayerDialog();
                    makePlayer.show(getSupportFragmentManager(), "MakeUser");
                }
                else{
                    takeToMenuPage();
                }
            }
        });

        setting_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment s = new SettingDialogFragment();
                s.show(getSupportFragmentManager(), "settings");
            }
        });

        share_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Hey check out this awesome quiz app at: https://play.google.com/store/apps/details?"+
                        "id=com.metrowebz.data.quizforyou");
                //i.putExtra(Intent.EXTRA_TEXT, image);
                startActivity(i);
            }
        });

        ivNoAdsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Test", "clicked");
                makePayment();
            }
        });

        alertForExit = new AlertDialog.Builder(this);
        alertForExit.setMessage(R.string.exit_message);
        alertForExit.setCancelable(false);
        alertForExit.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        alertForExit.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    public void takeToMenuPage(){
        Intent i = new Intent(Category_Page.this, MenuPage.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed(){

        AlertDialog dialog = alertForExit.create();
        dialog.show();

    }

    @Override
    protected void onPause() {
        if (mAdView != null){
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null)
            mAdView.resume();
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    private void makePayment(/*int response*/) {
        mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = IInAppBillingService.Stub.asInterface(service);

            }
        };
        serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
        ArrayList<String> skuList = new ArrayList<String>();
        skuList.add(ITEM_SKU);

        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
        Bundle skuDetails = null;
        try {
            if (mService != null)
                skuDetails = mService.getSkuDetails(3,
                        getPackageName(), "inapp", querySkus);
        } catch (RemoteException e) {
            Log.d("Error", "Error: " + e);
        }

        /*int response = 0;
        if (skuDetails != null) {
            response = skuDetails.getInt("RESPONSE_CODE");
        }*/
        //region *If you want to get the purchase info then write here*
        /*if (response == 0) {

            if (mService != null) {
                ArrayList<String> responseList
                        = skuDetails.getStringArrayList("DETAILS_LIST");

                for (String thisResponse : responseList) {
                    JSONObject object = null;
                    try {
                        object = new JSONObject(thisResponse);
                        String sku = object.getString("productId");
                        String price = object.getString("price");
                        if (sku.equals(ITEM_SKU)) {
                            mButtonPurchase.setText("Buy Item for Rs. " + price + "");
                        }

                    } catch (JSONException e) {
                        Log.d("Error", "Error: " + e);
                        e.printStackTrace();
                    }
                }
                responseList.clear();
            }
        }*///endregion

        //launch the purchase flow for an in-app item by providing a SKU
        Bundle buyIntentBundle = null;
        try {
            if (mService != null)
                buyIntentBundle = mService.getBuyIntent(3, getPackageName(),
                        ITEM_SKU, "inapp", null);
        } catch (RemoteException e) {
            Log.d("Error", "Error: " + e);
        }
        if (buyIntentBundle != null) {
            PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(),
                        1001, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
                Log.d("Error", "Error: " + e);
            }
        }
    }
}
