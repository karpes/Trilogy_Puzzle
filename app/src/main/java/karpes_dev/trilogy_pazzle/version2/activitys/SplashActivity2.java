package karpes_dev.trilogy_pazzle.version2.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import io.paperdb.Paper;
import karpes_dev.trilogy_pazzle.R;

public class SplashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Paper.init(this);




        //Splash Screen
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(SplashActivity2.this, CategoryActivity.class);
            startActivity(homeIntent);
            finish();
        }, 500); //Sleep
    }


}
