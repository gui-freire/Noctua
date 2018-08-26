package com.example.gui_f.view.noctua.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gui_f.model.noctua.FirstAid;
import com.example.gui_f.noctua.R;

public class FirstAidDetail extends AppCompatActivity {

    private TextView title;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_detail);
        setUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        int id = intent.getIntExtra("Id", 0);
        FirstAid firstAid = FirstAid.firstAids[(int) id];
        loadData(firstAid);
    }

    private void setUp(){
        title = (TextView) findViewById(R.id.firstAidDetailTitle);
        text = (TextView) findViewById(R.id.firstAidDetailText);
    }

    private void loadData(FirstAid firstAid){
        title.setText(firstAid.getTitleId());
        text.setText(firstAid.getTextId());
    }
}
