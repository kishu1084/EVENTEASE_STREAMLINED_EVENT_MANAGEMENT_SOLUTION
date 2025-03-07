package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.net.Uri;

import android.util.Log;

import android.widget.CalendarView;
import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import android.widget.ImageView;
import android.widget.Toast;

public class Event_Detail extends AppCompatActivity {


    ImageView imageView; // Declare ImageView as a class member

    ImageButton back,registrationLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        // Retrieve data from the intent
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("imageUrl");
        String caption = intent.getStringExtra("caption");
        String type = intent.getStringExtra("type");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("Time");
        String CoName = intent.getStringExtra("CoName");
        String EventName = intent.getStringExtra("EventName");
        String registrationLink = getIntent().getStringExtra("registration_link");
        String Contact = getIntent().getStringExtra("Contact");
        // Inside your DetailActivity
        final String previousClassName = intent.getStringExtra("previousClassName");
        final String str_Cultural = "Cultural";
        final String str_Academic = "Academic";
        final String str_Entertainment = "Entertainment";
        final String str_Sports = "Sports";

        Toast.makeText(Event_Detail.this,previousClassName,Toast.LENGTH_SHORT).show();




        // Initialize views
        imageView = findViewById(R.id.image_DetailView);
        TextView captionTextView = findViewById(R.id.captionTextView);
        TextView typeTextView = findViewById(R.id.typeTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TextView CoNameTextView = findViewById(R.id.CoNameTextView);
        TextView EventNameTextView = findViewById(R.id.EventNameTextView);
        TextView CoNumberTextView = findViewById(R.id.CoNumberTextView);
        ImageButton back = findViewById(R.id.back);
        Button registrationLinkButton = findViewById(R.id.registrationLink);

        // Load image using Glide and set other text views
        Glide.with(this)
                .load(imageUrl)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView);
        captionTextView.setText(caption);
        typeTextView.setText(type);
        dateTextView.setText(date);
        timeTextView.setText(time);
        CoNameTextView.setText(CoName);
        CoNumberTextView.setText(Contact);
        EventNameTextView.setText(EventName);

        registrationLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(registrationLink));
                startActivity(browserIntent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (str_Cultural.equals(previousClassName)){

                    Intent intent = new Intent(Event_Detail.this, Cultural_Event.class);
                    startActivity(intent);

                }
                else if (str_Academic.equals(previousClassName)){

                    Intent intent = new Intent(Event_Detail.this, Academic_Event.class);
                    startActivity(intent);

                }
                else if (str_Entertainment.equals(previousClassName)){

                    Intent intent = new Intent(Event_Detail.this, Entertainment_Event.class);
                    startActivity(intent);

                }
                else if (str_Sports.equals(previousClassName)){

                    Intent intent = new Intent(Event_Detail.this, Sports_Event.class);
                    startActivity(intent);

                }

            }
        });

    }
}