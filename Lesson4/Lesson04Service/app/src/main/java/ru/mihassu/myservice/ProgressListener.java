package ru.mihassu.myservice;

public interface ProgressListener {

    void onStatusChanged(String status);
    void onComplete(Integer result);
}
