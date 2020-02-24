package ru.mihassu.lesson04interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button showButton;
    private Button hideButton;
    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment fragmentLifecycle = FragmentLifecycle.getInstance();
        showButton = findViewById(R.id.button_show_fragment);
        hideButton = findViewById(R.id.button_hide_fragment);

        showButton.setOnClickListener(v -> {
            ft = fm.beginTransaction();
            if (!fragmentLifecycle.isAdded()) {
                ft.add(R.id.container_main, fragmentLifecycle);
            }
            ft.commit();
        });

        hideButton.setOnClickListener(v -> {
            ft = fm.beginTransaction();
            if (fragmentLifecycle.isAdded()) {
                ft.remove(fragmentLifecycle);
            }
            ft.commit();
        });
    }


}
