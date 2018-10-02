package mx.iteso.tarea4;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class ActivityMain extends AppCompatActivity {
    private ViewPager viewPager;
    FragmentTechnology fragmentTechnology = null;
    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                fragmentTechnology.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {super(fm);}
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                default:
                    if(fragmentTechnology == null) {
                        fragmentTechnology = new FragmentTechnology();
                    }
                    return fragmentTechnology;
            }
        }
        @Override
        public int getCount() {
            return 1;
        }
    }
}
