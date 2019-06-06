package karpes_dev.trilogy_pazzle.version1.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.version1.abstractions.IAdapter;
import karpes_dev.trilogy_pazzle.version1.managers.RecyclerAdapterManager;

public class FigureListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;
    private IAdapter firebaseAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_list);

        firebaseAdapter = new RecyclerAdapterManager();
        initToolbar();
        initRecyclerView();

    }

    private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.image_list_parent);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        firebaseAdapter.startListening();
        recyclerView.setAdapter(firebaseAdapter.getRecyclerAdapter());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_setting) {
            Intent intent = new Intent(FigureListActivity.this, SettingActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.nav_instruction) {
            Intent intent = new Intent(FigureListActivity.this, InstructionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else  if (id == R.id.nav_privacy) {
            Intent intent = new Intent(FigureListActivity.this, Privacy.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!");
            startActivity(shareIntent);
        }

        DrawerLayout drawer = findViewById(R.id.image_list_parent);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_setting) {
            Intent intent = new Intent(FigureListActivity.this, SettingActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else  if (id == R.id.nav_instruction) {
            Intent intent = new Intent(FigureListActivity.this, InstructionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }else if (id == R.id.action_policy) {

            Intent intent = new Intent(FigureListActivity.this, Privacy.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (firebaseAdapter.getRecyclerAdapter() != null)
            firebaseAdapter.startListening();
    }

    @Override
    protected void onDestroy() {
        recyclerView.setAdapter(null);
        super.onDestroy();

    }

    @Override
    public void onStop() {
        super.onStop();
        if (firebaseAdapter.getRecyclerAdapter() != null)
            firebaseAdapter.stopListening();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (firebaseAdapter.getRecyclerAdapter() != null)
            firebaseAdapter.startListening();
    }


}