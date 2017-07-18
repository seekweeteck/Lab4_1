package my.edu.tarc.www.lab4_1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserID, editTextPassword;
    private static String USER_ID = "user_id";
    private static String USER_PWD = "user_pwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserID = (EditText)findViewById(R.id.editTextUserID);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        //Loading share preference file
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        //Retrieve share preference value(s)
        String user_id = sharedPreferences.getString(USER_ID, "");
        String user_pwd = sharedPreferences.getString(USER_PWD, "");

        editTextUserID.setText(user_id);
        editTextPassword.setText(user_pwd);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Loading share preference file
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        String user_id, user_pwd;
        user_id = editTextUserID.getText().toString();
        user_pwd = editTextPassword.getText().toString();

        SharedPreferences.Editor editor =
                sharedPreferences.edit();
        editor.putString(USER_ID, user_id);
        editor.putString(USER_PWD, user_pwd);
        editor.commit();
    }
}
