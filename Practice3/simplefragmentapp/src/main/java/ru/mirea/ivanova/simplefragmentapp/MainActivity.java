package ru.mirea.ivanova.simplefragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment1, fragment2;
    private final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new BlankFragment();
        fragment2 = new BlankFragment2();
    }

    public void onShowFragment1Click(View view){
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment1).commit();
    }

    public void onShowFragment2Click(View view){
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment2).commit();
    }
}