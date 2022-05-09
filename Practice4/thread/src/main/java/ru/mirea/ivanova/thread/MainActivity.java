package ru.mirea.ivanova.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText lessonsCountInput;
    private EditText daysCountInput;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lessonsCountInput = (EditText) findViewById(R.id.lessons_count);
        daysCountInput = (EditText) findViewById(R.id.days_count);
        resultTextView = (TextView) findViewById(R.id.result_textview);

        Button showResultsButton = (Button) findViewById(R.id.show_results_button);
        showResultsButton.setOnClickListener((view) -> {
            Thread thread = new Thread(() -> {
                double lessonsCount = Double.parseDouble(lessonsCountInput.getText().toString());
                double daysCount = Double.parseDouble(daysCountInput.getText().toString());
                double lessonsPerDay = lessonsCount / daysCount;
                runOnUiThread(() -> resultTextView.setText(String.valueOf(lessonsPerDay)));
            });
            thread.start();
        });
    }


}