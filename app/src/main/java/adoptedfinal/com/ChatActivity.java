package adoptedfinal.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import adoptedfinal.com.fragmentsChat.chatt1Fragment;
import adoptedfinal.com.fragmentsChat.chatt2Fragment;

public class ChatActivity extends AppCompatActivity {
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        navigationView = findViewById(R.id.navigation_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new chatt1Fragment()).commit();
        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.icon1:
                    selectedFragment = new chatt1Fragment();
                    break;
                case R.id.icon2:
                    selectedFragment = new chatt2Fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }
}