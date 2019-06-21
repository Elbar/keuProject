package kg.keu.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView = findViewById(R.id.nav_view);
        setupNavigationView();
    }


    private void setupNavigationView() {
        if (mBottomNavigationView != null) {

            Menu menu = mBottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            mBottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }


    protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.navigation_contacts:
                replaceFragment(new ContactsFragment());
                break;

            case R.id.navigation_email:
                replaceFragment(new EmailFragment());
                break;

            case R.id.navigation_location:
                replaceFragment(new LocationFragment());
                break;
        }
    }


    private void replaceFragment(Fragment newFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.rootLayout, newFragment).commit();
    }


}
