package ru.mirea.ivanova.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvtOut;
    private Button btOK;
    private Button btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvtOut = (TextView) findViewById(R.id.tvtOut);
        btOK = (Button) findViewById(R.id.btOk);
        btCancel = (Button) findViewById(R.id.btCancel);
        View.OnClickListener oclbtOk = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvtOut.setText("нажата кнопка ок.");
            }
        };
        btOK.setOnClickListener(oclbtOk);
        View.OnClickListener oclbtCancel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvtOut.setText("нажата кнопка cancel.");
            }
        };
        btCancel.setOnClickListener(oclbtCancel);
    }
}