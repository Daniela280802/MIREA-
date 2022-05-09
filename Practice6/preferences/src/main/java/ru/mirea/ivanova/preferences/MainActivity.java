package ru.mirea.ivanova.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userNameInput;
    private EditText userInstitutionInput;
    private TextView userName;
    private TextView userInstitution;
    private SharedPreferences preferences;
    final String SAVED_NAME = "saved_name";
    final String SAVED_INSTITUTION = "saved_institution";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.user_name);
        userInstitution = findViewById(R.id.user_institution);
        userNameInput = findViewById(R.id.user_name_input);
        userInstitutionInput = findViewById(R.id.user_institution_input);
        findViewById(R.id.saveButton).setOnClickListener(this::onSaveText);
        findViewById(R.id.loadButton).setOnClickListener(this::onLoadText);
        preferences = getPreferences(MODE_PRIVATE);
    }
    public void onSaveText(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_NAME, userNameInput.getText().toString());
        editor.putString(SAVED_INSTITUTION, userInstitutionInput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    public void onLoadText(View view) {
        String name = preferences.getString(SAVED_NAME, "Empty");
        String institution = preferences.getString(SAVED_INSTITUTION, "Empty");
        userName.setText(name);
        userInstitution.setText(institution);
    }
}