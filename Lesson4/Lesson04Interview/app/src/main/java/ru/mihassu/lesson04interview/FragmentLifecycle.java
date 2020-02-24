package ru.mihassu.lesson04interview;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLifecycle extends Fragment {

    private final String TAG = "FragmentLifecycle";

    public static FragmentLifecycle getInstance() {
        FragmentLifecycle fragment = new FragmentLifecycle();
        return fragment;
    }

    //Создание
    //1
    @Override
    public void onAttach(@NonNull Context context) {
        showToast("onAttach");
        logIt("onAttach");
        super.onAttach(context);
    }

    //2
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        showToast("onCreateView");
        logIt("onCreateView");
        return view;
    }

    //3
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        showToast("onViewCreated");
        logIt("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    //4
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        showToast("onActivityCreated");
        logIt("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    //5
    @Override
    public void onStart() {
        showToast("onStart");
        logIt("onStart");
        super.onStart();
    }

    //6
    @Override
    public void onResume() {
        showToast("onResume");
        logIt("onResume");
        super.onResume();
    }

    //Уничтожение
    //1
    @Override
    public void onPause() {
        showToast("onPause");
        logIt("onPause");
        super.onPause();
    }

    //2
    @Override
    public void onStop() {
        showToast("onStop");
        logIt("onStop");
        super.onStop();
    }

    //3
    @Override
    public void onDestroy() {
        showToast("onDestroy");
        logIt("onDestroy");
        super.onDestroy();
    }

    //4
    @Override
    public void onDetach() {
        showToast("onDetach");
        logIt("onDetach");
        super.onDetach();
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void logIt(String message) {
        Log.d(TAG, message);
    }
}
