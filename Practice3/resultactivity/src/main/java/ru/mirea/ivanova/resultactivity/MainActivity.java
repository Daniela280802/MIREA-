package ru.mirea.ivanova.resultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView universityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        universityName = (TextView) findViewById(R.id.universityName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            String university = data.getStringExtra("name");
            universityName.setText(university);
        }
    }

    public void onEnterAnswerClick(View view){
        Intent intent = new Intent(this, DataActivity.class);
        startActivityForResult(intent, 0);
    }
}