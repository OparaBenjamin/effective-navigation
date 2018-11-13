package courses.pluralsight.com.tabiandating;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import courses.pluralsight.com.tabiandating.util.PreferenceKeys;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isFirstLogin();
        init();
    }

    private void init(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame,homeFragment,"Home");
        transaction.commit();
    }
    
    private void isFirstLogin(){
        Log.d(TAG, "isFirstLogin: checking if first login");

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstLogin = sharedPreferences.getBoolean(PreferenceKeys.FIRST_TIME_LOGIN,true);

        if (isFirstLogin){
            Log.d(TAG, "isFirstLogin: launching alert dialog");

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage(getString(R.string.first_time_user_message));
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(PreferenceKeys.FIRST_TIME_LOGIN,false);
                    editor.commit();
                    dialog.dismiss();
                }
            });
            //alertDialog.setIcon(R.drawable.logo);
            alertDialog.setTitle(" ");
            alertDialog.create();
            alertDialog.show();
        }
    }
}
