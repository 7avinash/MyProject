package com.metis.avinash;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.metis.avinash.Adapters.PostAdapter;
import com.metis.avinash.Models.GroupModel;
import com.metis.avinash.Models.PostModel;
import com.metis.avinash.WebUtils.RestClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    RecyclerView postView;
    Menu menu;
    String token = "Token ";
    int count;
    List<PostModel> postModels;
    ArrayList<String> arrayList=new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Will be Changing to Make a New Post.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        token = token.concat(SharedPref.getAccessToken(getBaseContext()));
        postModels = new Select().from(PostModel.class).orderBy("id DESC").execute();
        count = postModels.size();
        System.out.println(count);
        for (PostModel postModel: postModels){
            arrayList.add(0,postModel.title);
        }
        new getPost().execute();
        postView = (RecyclerView) findViewById(R.id.rv_posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        postView.setHasFixedSize(true);
        postView.setLayoutManager(layoutManager);
        postAdapter = new PostAdapter(postModels, new PostAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(PostModel item, int position) {
                Intent i = new Intent(getBaseContext(), PostDetailActivity.class);
                i.putExtra("item",item.toString());
                startActivity(i);
                Toast.makeText(getBaseContext(), "Item Clicked", Toast.LENGTH_LONG).show();
            }
        });
        postView.setAdapter(postAdapter);
//        menu = navigationView.getMenu();
//        SubMenu subMenu = menu.addSubMenu("Groups");
//        MenuItem group1 = subMenu.add(listView);

    }

    private class getPost extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {


            RestClient.get().getGroups(token, new Callback<List<GroupModel>>() {
                @Override
                public void success(List<GroupModel> groupModels, Response response) {
                    listView = (ListView) findViewById(R.id.navigationmenu);
                    ArrayList arrayList = new ArrayList();
                    for (GroupModel groupModel : groupModels) {
                        arrayList.add(groupModel.name);

                    }
                    ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, arrayList);
                    listView.setAdapter(adapter);
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });


          return null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        RestClient.get().getPosts(token, 1, 4, count, new Callback<List<PostModel>>() {
            @Override
            public void success(List<PostModel> mpostModels, Response response) {
                Collections.reverse(mpostModels);
                postModels.addAll(0, mpostModels);
                postAdapter.notifyDataSetChanged();
                count+=mpostModels.size();
                System.out.println(count);

            }

            @Override
            public void failure(RetrofitError error) {

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

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
