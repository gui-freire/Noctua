package com.example.gui_f.Percentage.Presenter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;

import com.example.gui_f.noctua.R;
import com.example.gui_f.Percentage.Presenter.Fragment.PercentageFragment;

public class PercentageActivity extends Activity {

    private PercentageFragment percentageFragment;

    private int percentage = 60;

    private int max = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage);
        createFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void createFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        percentageFragment = PercentageFragment.newInstance(percentage, max, 0);
        fragmentTransaction.add(R.id.frgPercentage, percentageFragment);
    }
}
