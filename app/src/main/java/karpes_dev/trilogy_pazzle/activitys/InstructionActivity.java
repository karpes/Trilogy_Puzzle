package karpes_dev.trilogy_pazzle.activitys;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import karpes_dev.trilogy_pazzle.R;
import karpes_dev.trilogy_pazzle.adapters.InstructionAdapter;


public class InstructionActivity extends AppCompatActivity {

    ViewPager viewPager;
    InstructionAdapter adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction_layout);

        adapter = new InstructionAdapter(this);
        viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(adapter);

        DotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
    }
}
