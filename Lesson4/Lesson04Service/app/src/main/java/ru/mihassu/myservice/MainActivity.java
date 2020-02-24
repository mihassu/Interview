package ru.mihassu.myservice;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String VALUE_EXTRA = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = findViewById(R.id.button_play);
        Button buttonStop = findViewById(R.id.button_stop);
        EditText editText = findViewById(R.id.ed_value);
        Button buttonCalc = findViewById(R.id.button_calculate);

        buttonPlay.setOnClickListener(v ->
                startService(new Intent(this, PlayerService.class))
        );

        buttonStop.setOnClickListener(v ->
                stopService(new Intent(this, PlayerService.class))
        );


        Intent intent = new Intent(this, MyService.class);
        buttonCalc.setOnClickListener(v -> {
            intent.putExtra(VALUE_EXTRA, editText.getText().toString());
            startService(intent);
        });
    }
}
