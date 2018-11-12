package courses.pluralsight.com.tabiandating;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    }
    
    private void isFirstLogin(){
        Log.d(TAG, "isFirstLogin: checking if first login");

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstLogin = sharedPreferences.getBoolean(PreferenceKeys.FIRST_TIME_LOGIN,true);

        if (isFirstLogin){

        }
    }
}
