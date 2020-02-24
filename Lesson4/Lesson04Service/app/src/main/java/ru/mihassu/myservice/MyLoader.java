package ru.mihassu.myservice;

import android.os.AsyncTask;

import java.util.concurrent.TimeUnit;

public class MyLoader extends AsyncTask<Integer, String, Integer> {

    private ProgressListener progressListener;

    public MyLoader(ProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        progressListener.onStatusChanged(values[0]);
    }

    @Override
    protected Integer doInBackground(Integer... data) {
        publishProgress("Начало расчета");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publishProgress("Конец расчета");

        return data[0] * 100;
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        progressListener.onComplete(result);
    }
}
