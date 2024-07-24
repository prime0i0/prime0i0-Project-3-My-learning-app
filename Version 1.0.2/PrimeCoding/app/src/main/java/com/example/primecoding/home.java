package com.example.primecoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    TextView t3;
    ImageButton introduction,keywords,variable,data,input,comments,operators,introduction_example;
    LinearLayout l2;
    RelativeLayout l1;
    Animation uptodown,downtoup;
    Dialog dialog;
    FirebaseAuth firebaseAuth;

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
            firebaseAuth.signOut();
            Intent intent5 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent5);
            finish();
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("🏡 Home");
        l1 = (RelativeLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        t3=(TextView) findViewById(R.id.textView3);
        introduction=(ImageButton)findViewById(R.id.introduction);
        keywords=(ImageButton)findViewById(R.id.keywords);
        variable=(ImageButton)findViewById(R.id.variable);
        data=(ImageButton)findViewById(R.id.data);
        input=(ImageButton)findViewById(R.id.input);
        comments=(ImageButton)findViewById(R.id.comments);
        operators=(ImageButton)findViewById(R.id.operators);
        introduction_example=(ImageButton)findViewById(R.id.introduction_example);
        dialog = new Dialog(this);





        introduction_example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , example.class);
                startActivity(intent);
            }
        });
        operators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , operators.class);
                startActivity(intent);
            }
        });
        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , comments.class);
                startActivity(intent);
            }
        });
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , input.class);
                startActivity(intent);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , data.class);
                startActivity(intent);
            }
        });
        variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , variable.class);
                startActivity(intent);
            }
        });
        keywords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , keywords.class);
                startActivity(intent);
            }
        });
        introduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , introduction.class);
                startActivity(intent);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(home.this, t3);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        Toast.makeText(home.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.quiz:
                        startActivity(new Intent(getApplicationContext(),quiz.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(downtoup);
        l2.setAnimation(downtoup);
    }
    public void ShowPopup(View v) {
        TextView txtclose;
        ImageView instagram , facebook , youtube;
        dialog.setContentView(R.layout.welcome_popup);
        txtclose =(TextView) dialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        facebook = (ImageView) dialog.findViewById(R.id.facebook);
        instagram = (ImageView) dialog.findViewById(R.id.instagram);
        youtube = (ImageView) dialog.findViewById(R.id.youtube);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link_open("https://www.instagram.com/prime0i0/");
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link_open("https://www.youtube.com/@prime0i0");
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link_open("https://www.facebook.com/prime0i0");
            }
        });
        dialog.findViewById(R.id.main);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    public  void link_open(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}