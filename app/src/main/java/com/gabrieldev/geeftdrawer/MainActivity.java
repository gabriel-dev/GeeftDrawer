package com.gabrieldev.geeftdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gabrieldev.geeftdrawer.activities.AddGeeft;
import com.gabrieldev.geeftdrawer.adapter.GeeftAdapter;
import com.gabrieldev.geeftdrawer.model.GeeftManager;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.card_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // i define the Adapter that provide to organize in list , a RecycleView list,
        // each CardView Object in the dataset.
        mAdapter = new GeeftAdapter(GeeftManager.getInstance().getCountries(), R.layout.new_geeft_card, this);
        mRecyclerView.setAdapter(mAdapter);


        //This is the floating menu button section; the button , when clicked, open a submenu
        // that give the possibility to select the action that the user wat to do (the action button)
        // clicked will start the associated activity.
        FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.floating_menu);
        FloatingActionButton actionNewGeeft = (FloatingActionButton) findViewById(R.id.add_geeft_button);
        actionNewGeeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Activity to 'Add Geeft' started", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddGeeft.class);
                startActivity(intent);
            }
        });
        FloatingActionButton actionGeeftAroundMe = (FloatingActionButton) findViewById(R.id.geeft_around_me_button);
        actionGeeftAroundMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Activity to 'Geeft around me' started", Toast.LENGTH_SHORT).show();
            }
        });
//        floatingActionMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Snackbar.make(view, "We will add the action selector", Snackbar.LENGTH_SHORT)
//                        .setAction("Action", null).show();
//            }
//        });


        //Image Buttons///////////////
//        ImageButton likeReservation = (ImageButton) findViewById(R.id.like_reservation);
//        likeReservation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Reservation button to set", Toast.LENGTH_SHORT).show();
//            }
//        });
        //////////////////////////////


        //Navigation Drawer part/////
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
