package com.example.gui_f.view.noctua.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.model.noctua.MainScreen.VitalResponse;
import com.example.gui_f.noctua.R;
import com.example.gui_f.viewmodel.noctua.MainScreen.MainScreen;
import com.example.gui_f.viewmodel.noctua.MainScreen.MainScreenImpl;

import java.util.Calendar;

public class MainScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView user;
    private TextView heartbeats;
    private TextView bloodpression;
    private Button diary;

    private VitalResponse vital = new VitalResponse();

    private MainScreen mainScreen = new MainScreenImpl();

    private UserDTO dto = new UserDTO();

    private Intent intent;

    private Intent list;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(intent != null)
            intent = getIntent();

        if (savedInstanceState != null) {
            dto = savedInstanceState.getParcelable("user");
        } else{
            dto = (UserDTO) intent.getParcelableExtra("user");
        }

        vital = mainScreen.searchLast(dto.getName(), context);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        user = (TextView) findViewById(R.id.textUserName);
        heartbeats = (TextView) findViewById(R.id.textHearbeat);
        bloodpression = (TextView) findViewById(R.id.textBloodPrss);
        diary = (Button) findViewById(R.id.btnDiary);

        user.setText(dto.getName());
        heartbeats.setText(vital.getHeartbeats());
        bloodpression.setText(vital.getPression());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("user", dto);
    }

    @Override
    protected void onStart() {
        super.onStart();
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), DiaryActivity.class);
                intent1.putExtra("user", dto.getName());
                startActivity(intent1);
            }
        });

        if(heartbeats.equals("-") || bloodpression.equals("-"))
            showNoDataDialog();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.putExtra("user", dto);
            startActivity(intent);

        } else if (id == R.id.navlog_daily) {
            list = new Intent(this, RecordActivity.class);

            list.putExtra("Method", "Daily");
            list.putExtra("Day", Calendar.DAY_OF_MONTH);
            list.putExtra("user", dto.getEmail());

            startActivity(list);
        } else if (id == R.id.navlog_monthly) {
            Intent intent = new Intent(this, RecordActivity.class);
            intent.putExtra("user", dto);
            intent.putExtra("Method", "Monthly");
            intent.putExtra("Weekly", Calendar.WEEK_OF_MONTH);
            intent.putExtra("Month", Calendar.MONTH);
            startActivity(intent);

        } else if(id == R.id.navlog_weekly){
            Intent intent = new Intent(this, RecordActivity.class);
            intent.putExtra("Method", "Weekly");
            intent.putExtra("user", dto);
            intent.putExtra("Monthly", Calendar.MONTH);
            try {
                startActivity(intent);
            }catch (Exception e) {
                Log.d("error", e.getMessage());
            }
        } else if(id == R.id.nav_firstAid){
            Intent intent = new Intent(this, FirstAidActivity.class);
            startActivity(intent);
        } else if(id == R.id.logout){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showNoDataDialog(){
        new AlertDialog.Builder(MainScreenActivity.this)
                .setMessage(R.string.NoData)
                .setNeutralButton(R.string.Okay, null)
                .show();
    }
}
