package karpes_dev.trilogy_pazzle.version1.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import karpes_dev.trilogy_pazzle.R;


public class Privacy extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacypolicy);

    }

    public void end(View view) {
        Intent intent = new Intent(this, FigureListActivity.class);
        startActivity(intent);
        finish();

    }
    public void end() {
        Intent intent = new Intent(this, FigureListActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        end();
    }
}
