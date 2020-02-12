package ru.geekbrains.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ConvertActivity extends AppCompatActivity {

    private EditText sourceText;    // Элемент с входным значением, которое надо сконвертировать
    private EditText destText;      // Элемент с результирующим значением

    private EditText sourceKilometrPerHour;
    private EditText destMetrPerSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        sourceText = (EditText) findViewById(R.id.celsiusValue);
        destText = (EditText) findViewById(R.id.fahrenheitValue);
        sourceKilometrPerHour = findViewById(R.id.kilometersValue);
        destMetrPerSec = findViewById(R.id.metrValue);
    }

    // обработка нажатия
    public void onToFahrenheitClick(View view) {
        // получить входное значение
        float sourceValue = Float.parseFloat(sourceText.getText().toString());
        // инстанцировать конвертер
        Converter converter = new Converter(sourceValue);
        // преобразовать, обратите внимание на параметр ConvertToFahrenheit
        float destValue = converter.Convert(new ConvertToFahrenheit()).GetResult();
        // записать результат в элемент
        destText.setText(String.format("%.02f", destValue));
    }

    public void onToMetrPerSecondClick(View view) {
        float sourceValue = Float.parseFloat(sourceKilometrPerHour.getText().toString());
        Converter converter = new Converter(sourceValue);
        float destValue = converter.Convert(new ConvertToMetrPerSecond()).GetResult();
        destMetrPerSec.setText(String.format("%.02f", destValue));
    }
}
