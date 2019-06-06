package karpes_dev.trilogy_pazzle.version1.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import karpes_dev.trilogy_pazzle.R;
import io.paperdb.Paper;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //Инициализация библеотеки для сохранения промежуточного прогресса
        //в JSON и обратно
        Paper.init(this);


        //Splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, FigureListActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, 5500); //Sleep
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
