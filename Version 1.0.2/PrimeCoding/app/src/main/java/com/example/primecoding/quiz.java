package com.example.primecoding;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class quiz extends AppCompatActivity {
    ImageView quiz1;
    public  static  final  String SHARED_PREFS = "sharedPrefs";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.notepad) {
            Intent intent = new Intent(getApplicationContext(), editor.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.compiler) {
            Intent intent1 = new Intent(getApplicationContext(), c_compiler.class);
            startActivity(intent1);
            return true;
        }
        if (item.getItemId() == R.id.about) {
            Intent intent2 = new Intent(getApplicationContext(), about.class);
            startActivity(intent2);
            return true;
        }
        if (item.getItemId() == R.id.setting) {
            Intent intent3 = new Intent(getApplicationContext(), settings.class);
            startActivity(intent3);
            return true;
        }
        if (item.getItemId() == R.id.e_book) {
            Intent intent4 = new Intent(getApplicationContext(), E_books.class);
            startActivity(intent4);
            return true;
        }
        if (item.getItemId() == R.id.logout) {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", "");
            editor.apply();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("EXIT", true);
            startActivity(i);
            finish();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setTitle("Quiz");
        quiz1 = (ImageView) findViewById(R.id.quiz1);
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.quiz);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.quiz:
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quiz.this , quiz1.class);
                startActivity(intent);
            }
        });
    }
}
