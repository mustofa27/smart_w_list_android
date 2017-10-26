package igs.smartwlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import igs.smartwlist.fragment.Home;
import igs.smartwlist.fragment.InstansiList;
import igs.smartwlist.fragment.Profile;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.findViewById(R.id.nav_home).setOnClickListener(this);
        navigationView.findViewById(R.id.nav_instansi).setOnClickListener(this);
        navigationView.findViewById(R.id.nav_bantuan).setOnClickListener(this);
        navigationView.findViewById(R.id.nav_riwayat).setOnClickListener(this);
        navigationView.findViewById(R.id.nav_keluar).setOnClickListener(this);
        navigationView.getHeaderView(0).findViewById(R.id.user_photo_drawer).setOnClickListener(this);
        onClick(navigationView.findViewById(R.id.nav_home));
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            return true;
        } else if (id == R.id.action_notifikasi) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_home:
                Home home = new Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_utama,home).commit();
                break;
            case R.id.nav_instansi:
                InstansiList instansiList = new InstansiList();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_utama,instansiList).commit();
                break;
            case R.id.nav_bantuan:
                break;
            case R.id.nav_riwayat:
                break;
            case R.id.nav_keluar:
                startActivity(new Intent(this,Login.class));
                finish();
                break;
            case R.id.user_photo_drawer:
                Profile profile = new Profile();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_utama,profile).commit();
                break;
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_utama,fragment).commit();
    }
}
