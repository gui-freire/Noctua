package com.example.gui_f.view.noctua.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.gui_f.model.noctua.FirstAid;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.Activity.Adapter.FirstAidAdapter;

public class FirstAidActivity extends AppCompatActivity implements FirstAidListFragment.FirstAidListListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        setUp();
        populateCards();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, FirstAidDetail.class);
        intent.putExtra("Id", id);

        startActivity(intent);
    }

    private void setUp(){
        recyclerView = (RecyclerView) findViewById(R.id.fragmentFirstAid);
        TextView title = (TextView) findViewById(R.id.listName);
    }

    private void populateCards(){
        String[] titles = new String[FirstAid.firstAids.length];
        for(int i = 0; i < titles.length; i++){
            titles[i] = getResources().getString(FirstAid.firstAids[i].getTitleId());
        }

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FirstAidAdapter adapter = new FirstAidAdapter(titles);
        recyclerView.setAdapter(adapter);
    }
}
