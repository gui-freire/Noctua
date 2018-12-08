package com.example.gui_f.Record.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.gui_f.Home.Domain.VitalResponse;
import com.example.gui_f.noctua.R;
import com.example.gui_f.utils.JsonCallback;
import com.example.gui_f.Record.Presenter.Adapter.RecordAdapter;
import com.example.gui_f.Home.ViewModel.MainScreen;
import com.example.gui_f.Home.ViewModel.MainScreenImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends AppCompatActivity {

    private Intent intent;
    private String method;
    private MainScreen mainScreen = new MainScreenImpl();

    private int id;
    private int day;
    private int week;
    private int month;
    private boolean mock;

    private Context context = this;

    private final String DAILY = "Relatório Diário";
    private final String WEEKLY = "Relatório Semanal";
    private final String MONTHLY = "Reatório Mensal";

    private List<VitalResponse> listVital;

    private RecyclerView recyclerView;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        setUp();
        receiveIntent();

        //Makes list for the records of the day
        if(mock){
            VitalResponse vitalResponse = new VitalResponse();
            vitalResponse.setPression("12/5");
            vitalResponse.setHeartbeats("55");
            listVital.add(vitalResponse);

            vitalResponse.setHeartbeats("66");
            vitalResponse.setPression("11/7");
            listVital.add(vitalResponse);

            vitalResponse.setPression("12/5");
            vitalResponse.setHeartbeats("55");
            listVital.add(vitalResponse);

            vitalResponse.setHeartbeats("66");
            vitalResponse.setPression("11/7");
            listVital.add(vitalResponse);
        } else {
        if (method.equals("Daily")) {
            title.setText(DAILY);

            mainScreen.searchDaily(id, day, context, new JsonCallback() {
                @Override
                public void onSuccess(JSONObject jsonObject) {
                    listVital = parseToList(jsonObject);
                }

                @Override
                public void onError() {

                }
            });


        } else if (method.equals("Weekly")) {
            title.setText(WEEKLY);

            mainScreen.searchWeekly(id, week, month, context, new JsonCallback() {
                @Override
                public void onSuccess(JSONObject jsonObject) {
                    listVital = parseToList(jsonObject);
                }

                @Override
                public void onError() {
                    VitalResponse vitalResponse = new VitalResponse();
                    vitalResponse.setPression("12/5");
                    vitalResponse.setHeartbeats("55");
                    listVital.add(vitalResponse);

                    vitalResponse.setHeartbeats("66");
                    vitalResponse.setPression("11/7");
                    listVital.add(vitalResponse);

                    vitalResponse.setPression("12/5");
                    vitalResponse.setHeartbeats("55");
                    listVital.add(vitalResponse);

                    vitalResponse.setHeartbeats("66");
                    vitalResponse.setPression("11/7");
                    listVital.add(vitalResponse);
                }
            });


        } else if (method.equals("Monthly")) {
            title.setText(MONTHLY);

            mainScreen.searchMonthly(id, month, context, new JsonCallback() {
                @Override
                public void onSuccess(JSONObject jsonObject) {
                    listVital = parseToList(jsonObject);
                }

                @Override
                public void onError() {
                    VitalResponse vitalResponse = new VitalResponse();
                    vitalResponse.setPression("12/5");
                    vitalResponse.setHeartbeats("55");
                    listVital.add(vitalResponse);

                    vitalResponse.setHeartbeats("66");
                    vitalResponse.setPression("11/7");
                    listVital.add(vitalResponse);

                    vitalResponse.setPression("12/5");
                    vitalResponse.setHeartbeats("55");
                    listVital.add(vitalResponse);

                    vitalResponse.setHeartbeats("66");
                    vitalResponse.setPression("11/7");
                    listVital.add(vitalResponse);
                }
            });
        }
        }
        populateCards();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void setUp(){
        recyclerView = (RecyclerView) findViewById(R.id.frgRecord);
        title = (TextView) findViewById(R.id.recordToolbarTitle);
        listVital = new ArrayList<>();
        mock = false;
    }

    private void receiveIntent(){
        intent = getIntent();
        method = intent.getStringExtra("Method");
        id = intent.getIntExtra("user", 0);
        day = intent.getIntExtra("day", 0);
        week = intent.getIntExtra("week", 0);
        month = intent.getIntExtra("month", 0);
        mock = intent.getBooleanExtra("mock", false);
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

    private void populateCards(){
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecordAdapter adapter = new RecordAdapter(listVital);
        recyclerView.setAdapter(adapter);
    }
}
