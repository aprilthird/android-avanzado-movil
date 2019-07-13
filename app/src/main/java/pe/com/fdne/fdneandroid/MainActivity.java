package pe.com.fdne.fdneandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import pe.com.fdne.fdneandroid.fragments.EventsFragment;
import pe.com.fdne.fdneandroid.fragments.HomeFragment;
import pe.com.fdne.fdneandroid.fragments.RankingsFragment;
import pe.com.fdne.fdneandroid.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAccordingTo(item.getItemId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        String appName = getResources().getString(R.string.app_name);
        getSupportActionBar().setTitle("    " + appName);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_fdne_icon_light_36dp);
        navigateAccordingTo(R.id.navigation_home);
    }

    private Fragment getFragmentFor(int id) {
        String fragmentTitle = "";
        switch (id) {
            case R.id.navigation_home:
                fragmentTitle = getString(R.string.title_home);
                getSupportActionBar().setSubtitle("     " + fragmentTitle);
                return new HomeFragment();
            case R.id.navigation_ranking:
                fragmentTitle = getString(R.string.title_ranking);
                getSupportActionBar().setSubtitle("     " + fragmentTitle);
                return new RankingsFragment();
            case R.id.navigation_events:
                fragmentTitle = getString(R.string.title_events);
                getSupportActionBar().setSubtitle("     " + fragmentTitle);
                return new EventsFragment();
            case R.id.navigation_settings:
                fragmentTitle = getString(R.string.title_settings);
                getSupportActionBar().setSubtitle("     " + fragmentTitle);
                return new SettingsFragment();
        }
        return null;
    }

    private boolean navigateAccordingTo(int id) {
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, getFragmentFor(id))
                    .commit();
            return true;
        }
        catch (NullPointerException e) {
            return false;
        }
    }
}
