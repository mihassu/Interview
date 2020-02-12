package ru.geekbrains.converter;


public class ConvertToMetrPerSecond implements ConvertTo {

    @Override
    public float Do(float sourceValue) {
        return (float) (sourceValue * 1000 / 3600);
    }
}
