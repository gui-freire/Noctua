package com.example.gui_f.view.noctua;

import android.content.Intent;
import android.os.Bundle;
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

import com.example.gui_f.ObjectWrapperForBinder;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.model.noctua.MainScreen.VitalResponse;
import com.example.gui_f.noctua.R;
import com.example.gui_f.viewmodel.noctua.MainScreen;
import com.example.gui_f.viewmodel.noctua.MainScreenImpl;

import java.util.Calendar;

public class MainScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView user;
    private TextView heartbeats;
    private TextView bloodpression;
    private Button diary;

    private VitalResponse vital = new VitalResponse();

    private MainScreen mainScreen = new MainScreenImpl();

    final UserDTO userReceived = ((ObjectWrapperForBinder)getIntent().getBundleExtra("user").getBinder("user")).getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Checks if it needs to get the latest data or if it needs to get a day/week/month data
        if(intent.getBundleExtra("Daily") != null){
            int day = intent.getIntExtra("Daily", 0);
            vital = mainScreen.searchDaily(userReceived.getName(), day);

        } else if(intent.getBundleExtra("Weekly") != null){
            int week = intent.getIntExtra("Weekly", 0);
            int month = intent.getIntExtra("Month", 0);
            vital = mainScreen.searchWeekly(userReceived.getName(), week, month);

        } else if(intent.getBundleExtra("Monthly") != null){
            int month = intent.getIntExtra("Monthly", 0);
            vital = mainScreen.searchMonthly(userReceived.getName(), month);

        } else{
            vital = mainScreen.searchLast(userReceived.getName());
        }

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

        user.setText(userReceived.getName());
        heartbeats.setText(vital.getHeartbeats());
        bloodpression.setText(vital.getPression());



    }

    @Override
    protected void onStart() {
        super.onStart();
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), DiaryActivity.class);
                intent1.putExtra("user", userReceived.getName());
                startActivity(intent1);
            }
        });
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

        if (id == R.id.nav_firstAid) {
            // Handle the camera action
        } else if (id == R.id.nav_logOut) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.putExtra("Email", userReceived.getEmail());
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.navlog_daily) {
            //TODO: refazer chamada que consulta dados e criar uma nova intância dessa tela com os novos valores
            UserDTO newUser = new UserDTO();
            final Bundle bundle = new Bundle();
            Intent intent = new Intent(this, MainScreenActivity.class);
            intent.putExtra("user", bundle);
            intent.putExtra("Daily", Calendar.DAY_OF_MONTH);
            startActivity(intent);

        } else if (id == R.id.navlog_monthly) {
            UserDTO newUser = new UserDTO();
            final Bundle bundle = new Bundle();
            bundle.putBinder("user", new ObjectWrapperForBinder(newUser));
            Intent intent = new Intent(this, MainScreenActivity.class);
            intent.putExtra("user", bundle);
            intent.putExtra("Weekly", Calendar.WEEK_OF_MONTH);
            intent.putExtra("Month", Calendar.MONTH);
            startActivity(intent);

        } else if(id == R.id.navlog_weekly){
            UserDTO newUser = new UserDTO();
            final Bundle bundle = new Bundle();
            bundle.putBinder("user", new ObjectWrapperForBinder(newUser));
            Intent intent = new Intent(this, MainScreenActivity.class);
            intent.putExtra("user", bundle);
            intent.putExtra("Monthly", Calendar.MONTH);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
