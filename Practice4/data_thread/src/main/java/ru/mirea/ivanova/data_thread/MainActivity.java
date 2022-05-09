package ru.mirea.ivanova.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener((view) -> {
            Thread thread = new Thread(() -> {
                // Запускается задачу в потоке пользовательского
                // интерфейса (в главном потоке в данном случае).
                // Если текущий поток им и является, то задача сразу же и выполняется,
                // но если происходит вызов из другого потока, то задача помещается в очередь
                runOnUiThread(() -> textView.setText("from runOnUiThread"));
            });
            thread.start();
        });
        button2.setOnClickListener((view) -> {
            Thread thread = new Thread(() -> {
                // Добавляет задачу в очередь для запуска (задача запустится как можно скорее)
                textView.post(() -> textView.setText("from post"));
            });
            thread.start();
        });
        button3.setOnClickListener((view) -> {
            Thread thread = new Thread(() -> {
                // Добавляет задачу в очередь сообщений для запуска
                // по истечении указанного количества времени
                textView.postDelayed(() -> textView.setText("from postDelayed"), 2000);
            });
            thread.start();
        });
    }
}