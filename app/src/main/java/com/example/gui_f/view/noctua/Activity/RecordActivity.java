package com.example.gui_f.view.noctua.Activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gui_f.model.noctua.MainScreen.VitalResponse;
import com.example.gui_f.noctua.R;
import com.example.gui_f.viewmodel.noctua.MainScreen;
import com.example.gui_f.viewmodel.noctua.MainScreenImpl;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends ListActivity {

    private ArrayAdapter<String> listAdapter;
    private Intent intent;
    private String method;
    private MainScreen mainScreen = new MainScreenImpl();
    private String email;
    private int day;
    private int week;
    private int month;

    private Context context = this;

    private final String DAILY = "Relatório Diário";
    private final String WEEKLY = "Relatório Semanal";
    private final String MONTHLY = "Reatório Mensal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        method = intent.getStringExtra("Method");
        email = intent.getStringExtra("user");
        day = intent.getIntExtra("day", 0);
        week = intent.getIntExtra("week", 0);
        month = intent.getIntExtra("month", 0);

        ListView listView = getListView();

        //Makes list for the records of the day
        if(method.equals("Daily")){
            TextView title = new TextView(this);
            title.setText(DAILY);
            title.setTextSize(30);
            title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            listView.addHeaderView(title);
            List<String> list = listToString(mainScreen.searchDaily(email, day, context));

            listAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1, //Android pre made list
                    list);
            listView.setAdapter(listAdapter);

        } else if(method.equals("Weekly")){
            TextView title = new TextView(this);
            title.setText(WEEKLY);
            title.setTextSize(30);
            title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            listView.addHeaderView(title);
            List<String> list = listToString(mainScreen.searchWeekly(email, week, month, context));

            listAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    list
            );
        } else if(method.equals("Monthly")){
            TextView title = new TextView(this);
            title.setText(MONTHLY);
            title.setTextSize(30);
            title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            listView.addHeaderView(title);
            List<String> list = listToString(mainScreen.searchMonthly(email, month, context));

            listAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    list
            );
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private List<String> listToString(List<VitalResponse> vitalList){
        List<String> converted = new ArrayList<>();
        StringBuilder item;

        for(VitalResponse l: vitalList){
            item = new StringBuilder();
//            item.append(horaData + "    ");

            item.append("BPM:   ");
            item.append(l.getHeartbeats() + "\n");

            item.append("Pressão:    ");
            item.append(l.getPression());

            converted.add(item.toString());
        }

        return converted;
    }
}
