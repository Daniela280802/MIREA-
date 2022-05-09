package ru.mirea.ivanova.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {
    private EditText universityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        universityInput = (EditText) findViewById(R.id.universityName);
    }

    public void onSendButtonClick(View view){
        String university = universityInput.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name", university);
        setResult(RESULT_OK, intent);
        finish();
    }
}