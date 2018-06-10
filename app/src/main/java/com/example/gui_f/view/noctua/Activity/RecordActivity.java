package com.example.gui_f.view.noctua.Activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gui_f.model.noctua.MainScreen.VitalResponse;
import com.example.gui_f.noctua.R;
import com.example.gui_f.utils.JsonCallback;
import com.example.gui_f.viewmodel.noctua.MainScreen.MainScreen;
import com.example.gui_f.viewmodel.noctua.MainScreen.MainScreenImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends ListActivity {

    private ArrayAdapter<String> listAdapter;
    private Intent intent;
    private String method;
    private MainScreen mainScreen = new MainScreenImpl();
    private int id;
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
        id = intent.getIntExtra("user", 0);
        day = intent.getIntExtra("day", 0);
        week = intent.getIntExtra("week", 0);
        month = intent.getIntExtra("month", 0);

        final ListView listView = getListView();

        //Makes list for the records of the day
        if (method.equals("Daily")) {
            TextView title = new TextView(this);
            title.setText(DAILY);
            title.setTextSize(30);
            title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            listView.addHeaderView(title);
            listView.setBackgroundColor(getResources().getColor(R.color.backgroundColour));

            mainScreen.searchDaily(id, day, context, new JsonCallback() {
                @Override
                public void onSuccess(JSONObject jsonObject) {
                    List<VitalResponse> listVital = new ArrayList<>();
                    listVital = parseToList(jsonObject);
                    List<String> list = listToString(listVital);
                    listAdapter = new ArrayAdapter<String>(
                            context,
                            android.R.layout.simple_list_item_1, //Android pre made list
                            list);
                    listView.setAdapter(listAdapter);
                }
            });


        } else if (method.equals("Weekly")) {
            TextView title = new TextView(this);
            title.setText(WEEKLY);
            title.setTextSize(30);
            title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            listView.addHeaderView(title);
            listView.setBackgroundColor(getResources().getColor(R.color.backgroundColour));
            mainScreen.searchWeekly(id, week, month, context, new JsonCallback() {
                @Override
                public void onSuccess(JSONObject jsonObject) {
                    List<VitalResponse> listVital = new ArrayList<>();
                    listVital = parseToList(jsonObject);
                    List<String> list = listToString(listVital);
                    listAdapter = new ArrayAdapter<String>(
                            context,
                            android.R.layout.simple_list_item_1,
                            list
                    );
                    listView.setAdapter(listAdapter);
                }
            });


        } else if (method.equals("Monthly")) {
            TextView title = new TextView(this);
            title.setText(MONTHLY);
            title.setTextSize(30);
            title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            listView.addHeaderView(title);
            listView.setBackgroundColor(getResources().getColor(R.color.backgroundColour));
            mainScreen.searchMonthly(id, month, context, new JsonCallback() {
                @Override
                public void onSuccess(JSONObject jsonObject) {
                    List<VitalResponse> listVital = new ArrayList<>();
                    listVital = parseToList(jsonObject);
                    List<String> list = listToString(listVital);
                    listAdapter = new ArrayAdapter<String>(
                            context,
                            android.R.layout.simple_list_item_1,
                            list
                    );
                    listView.setAdapter(listAdapter);
                }
            });

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    //Converts the object to a string to be showed on the list
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

    private List<VitalResponse> parseToList(JSONObject jsonObject){
        List<VitalResponse> list = new ArrayList<>();
        try {
            JSONArray array = jsonObject.getJSONArray("vital");
            if(array.length() == 0){
                VitalResponse vital = new VitalResponse();
                vital.setPression("-");
                vital.setHeartbeats("-");
                list.add(vital);
            }
            for(int i = 0; i < array.length(); i++){
                VitalResponse vital = new VitalResponse();
                vital.setPression(array.getJSONObject(i).getString("pression"));
                vital.setHeartbeats(array.getJSONObject(i).getString("heartbeat"));
                list.add(vital);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
