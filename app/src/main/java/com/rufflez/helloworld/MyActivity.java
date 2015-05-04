package com.rufflez.helloworld;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
public class MyActivity extends ActionBarActivity implements OnChildClickListener,OnFragmentInteractionListener {

    DrawerLayout mDrawerLayout;
    ExpandableListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    String[] mDrawerListItems;
RelativeLayout drawerRel;
    @Override
    public void onFragmentInteraction(Uri uri){

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("GHJ");

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mDrawerList = (ExpandableListView)findViewById(R.id.left_drawer);
        drawerRel=(RelativeLayout)findViewById(R.id.drawerrel);
        Display newDisplay = getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();
        mDrawerList.setIndicatorBounds(width-50,width);
        setGroupData();
        setChildGroupData();
        mDrawerList.setAdapter(new NewAdapter(this, groupItem, childItem));

        mDrawerList.setOnChildClickListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close){
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
                invalidateOptionsMenu();
                syncState();
            }
            public void onDrawerOpened(View v){
                super.onDrawerOpened(v);
                invalidateOptionsMenu();
                syncState();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
        //Fragment fragment = new ProductsFragment();
        Fragment fragment = new Checkout_Fragment_Confirmation();


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();



        mDrawerLayout.closeDrawer(drawerRel);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home: {
                if (mDrawerLayout.isDrawerOpen(drawerRel)){
                    mDrawerLayout.closeDrawer(drawerRel);
                } else {
                    mDrawerLayout.openDrawer(drawerRel);
                }
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }
    public void setGroupData() {
        groupItem.add("Food & Beverages");
        groupItem.add("Beauty");
        groupItem.add("IT Gadgets");
        groupItem.add("Health Care");
    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    public void setChildGroupData() {
        /**
         * Add Data For Food & Beverages
         */
        ArrayList<String> child = new ArrayList<String>();
        child.add("Sauces");
        child.add("Gifts");
        child.add("Soups");
        child.add("Canned Food");
        childItem.add(child);

        /**
         * Add Data For Beauty
         */
        child = new ArrayList<String>();
        child.add("Soap");
        child.add("Fairness Cream");
        child.add("Shampoo");
        childItem.add(child);
        /**
         * Add Data For IT Gadgets
         */
        child = new ArrayList<String>();
        child.add("Laptop");
        child.add("Mobile");
        child.add("Camera");
        child.add("Laptop Peripherals");
        childItem.add(child);
        /**
         * Add Data For Health Care
         */
        child = new ArrayList<String>();
        child.add("Ayurvedic");
        child.add("Diabetics");
        child.add("Allergy");

        childItem.add(child);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {
        Toast.makeText(this, "Clicked On Child" + v.getTag(),
                Toast.LENGTH_SHORT).show();
        return true;
    }

}
