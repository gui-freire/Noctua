package com.example.gui_f.view.noctua.Activity;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.Activity.Fragment.FirstAidDetailFragmen;
import com.example.gui_f.view.noctua.Activity.Fragment.FirstAidListFragment;

public class FirstAidActivity extends AppCompatActivity implements FirstAidListFragment.FirstAidListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
    }


    @Override
    public void itemClicked(long id) {
        FirstAidDetailFragmen detail = new FirstAidDetailFragmen();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        detail.setFirstAidId(id);
        transaction.replace(R.id.fragment_container, detail);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}
