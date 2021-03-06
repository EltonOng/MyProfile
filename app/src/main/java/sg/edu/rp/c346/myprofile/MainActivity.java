package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        String strGpa = etGPA.getText().toString();
        int intGender = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name",strName);
        prefEdit.putFloat("GPA",Float.parseFloat(strGpa));
        prefEdit.putInt("Gender",intGender);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("Name","");
        //String gpa = prefs.getString("GPA",strGpa);
        Float gpa = prefs.getFloat("GPA",0.0f);
        int gender = prefs.getInt("Gender",0);
        etName.setText(name);
        etGPA.setText(Float.toString(gpa));
        rgGender.check(gender);
    }


}
