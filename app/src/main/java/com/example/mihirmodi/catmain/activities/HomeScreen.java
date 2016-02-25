package com.example.mihirmodi.catmain.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.mihirmodi.catmain.adapters.DrawerListAdapter;
import com.example.mihirmodi.catmain.models.Categories;
import com.example.mihirmodi.catmain.models.DrawerItem;
import com.example.mihirmodi.catmain.R;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

        private static String TAG = IntroductionScreen.class.getSimpleName();
    ViewPager viewPager1;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
        ListView mDrawerList;
        RelativeLayout mDrawerPane;
        private ActionBarDrawerToggle mDrawerToggle;
        private DrawerLayout mDrawerLayout;
        ImageView imageView_drawerToggle;
        ArrayList<DrawerItem> mNavItems = new ArrayList<DrawerItem>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.homescreen);
           // viewPager1= (ViewPager) findViewById(R.id.pager1);
            imageView_drawerToggle=(ImageView)findViewById(R.id.iv_drawerToggle);

            mNavItems.add(new DrawerItem("What is CAT?", "", R.drawable.ic_info_black_24dp));
            mNavItems.add(new DrawerItem("Important Dates. ", "", R.drawable.ic_date_range_black_24dp));
            mNavItems.add(new DrawerItem("About IIM collages", "", R.drawable.ic_info_black_24dp));
            mNavItems.add(new DrawerItem("Institutes", "", R.drawable.ic_location_city_black_24dp));
            mNavItems.add(new DrawerItem("Imporatant Docouments", "", R.drawable.ic_description_black_24dp));
            mNavItems.add(new DrawerItem("Official IIM collages Contacts", "", R.drawable.ic_settings_phone_black_24dp));
            mNavItems.add(new DrawerItem("FAQ", "", R.drawable.ic_help_black_24dp));

            // DrawerLayout
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

            // Populate the Navigtion Drawer with options
            mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
            mDrawerList = (ListView) findViewById(R.id.navList);
            DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
            mDrawerList.setAdapter(adapter);

            // Drawer Item click listeners
            mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectItemFromDrawer(position);
                }
            });
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_top);
            drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
            setSupportActionBar(toolbar);
            actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
            drawerLayout.setDrawerListener(actionBarDrawerToggle);
            setToggleClick();
        }

    private void setToggleClick() {
        imageView_drawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0, 0, 0, "androidDemo").setIcon(R.drawable.ic_launcher);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the homescreen/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void practise(View v)
    {
        Intent intent=new Intent(this,CategoriesListmain.class);
        startActivity(intent);
    }
    public void solution(View v)
    {
        Intent intent=new Intent(this,QuizPlayer.class);
        startActivity(intent);
    }
    public void quicktest(View v)
    {
        Intent intent=new Intent(this,Testsmain.class);
        startActivity(intent);
    }
    private void selectItemFromDrawer(int position) {

        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(HomeScreen.this, AboutCat.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
            case 1:
                intent = new Intent(HomeScreen.this, ImportantDate.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
            case 2:
                intent = new Intent(HomeScreen.this, AboutIim.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
           // case 3:
               // intent = new Intent(homescreen.this, Iimcollageslist.class);
               // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               // this.startActivity(intent);
               // break;
            case 3:
                intent = new Intent(HomeScreen.this,InstitutesHome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
            case 4:
                intent = new Intent(HomeScreen.this,ImportantDocument.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
            case 5:
                intent = new Intent(HomeScreen.this, OfficialContact.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
            case 6:
                intent = new Intent(HomeScreen.this, FaqCat.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;



        }

        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).mTitle);

        // Close the drawer
        mDrawerLayout.closeDrawer(mDrawerPane);
    }


}


