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
import com.example.gui_f.noctua.Login;
import com.example.gui_f.noctua.R;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView user;
    private TextView heartbeats;
    private TextView bloodpression;
    private Button diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final UserDTO userReceived = ((ObjectWrapperForBinder)getIntent().getExtras().getBinder("user")).getData();


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
        heartbeats.setText(userReceived.getHeartbeats());
        bloodpression.setText(userReceived.getPression());


        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), Diary.class);
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
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

        } else if (id == R.id.nav_register) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.navlog_daily) {
            //TODO: refazer chamada que consulta dados e criar uma nova intância dessa tela com os novos valores
            UserDTO newUser = new UserDTO();
            newUser.setName("Guilherme");
            newUser.setPression("10/7");
            newUser.setHeartbeats("72");
            final Bundle bundle = new Bundle();
            bundle.putBinder("user", new ObjectWrapperForBinder(newUser));
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("user", bundle);
            startActivity(intent);

        } else if (id == R.id.navlog_monthly) {
            UserDTO newUser = new UserDTO();
            newUser.setName("Guilherme");
            newUser.setPression("12/9");
            newUser.setHeartbeats("69");
            final Bundle bundle = new Bundle();
            bundle.putBinder("user", new ObjectWrapperForBinder(newUser));
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("user", bundle);
            startActivity(intent);

        } else if(id == R.id.navlog_weekly){
            UserDTO newUser = new UserDTO();
            newUser.setName("Guilherme");
            newUser.setPression("11/7");
            newUser.setHeartbeats("70");
            final Bundle bundle = new Bundle();
            bundle.putBinder("user", new ObjectWrapperForBinder(newUser));
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("user", bundle);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
