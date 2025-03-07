package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Context;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cultural_Event extends AppCompatActivity {

    GridView gridView;
    ArrayList<DataClass> dataList;
    MyAdapter adapter;
    DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");

    BottomNavigationView bottomNavigationView;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_event);

        fab = findViewById(R.id.fab);

        gridView = findViewById(R.id.grideView_cultual);

        dataList = new ArrayList<>();

        // Correcting the arguments passed to MyAdapter constructor
        adapter = new MyAdapter(dataList, Cultural_Event.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the click event for the grid item at position

                final String previousClassName = "Cultural";
                DataClass clickedItem = dataList.get(position);
                Context context = Cultural_Event.this;
                Intent intent = new Intent(context, Event_Detail.class);
                intent.putExtra("imageUrl", clickedItem.getImageUrl());
                intent.putExtra("caption", clickedItem.getCaption());
                intent.putExtra("type", clickedItem.getEventType());
                intent.putExtra("date", clickedItem.getDate());
                intent.putExtra("Time",clickedItem.getEventTime());
                intent.putExtra("CoName",clickedItem.getCoordinatorName());
                intent.putExtra("EventName",clickedItem.getEventName());
                intent.putExtra("Contact",clickedItem.getCordineterNumber());
                intent.putExtra("registration_link",clickedItem.getRegistrationLink());
                intent.putExtra("previousClassName", previousClassName);
                startActivity(intent);

                Toast.makeText(Cultural_Event.this, "Clicked: " + clickedItem.getCaption(), Toast.LENGTH_SHORT).show();
            }
        });

        eventsRef.child("Cultural Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear(); // Clear existing data
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String imageUrl = eventSnapshot.child("imageUrl").getValue(String.class);
                    String caption = eventSnapshot.child("caption").getValue(String.class);
                    String eventType = eventSnapshot.child("eventType").getValue(String.class);
                    String date = eventSnapshot.child("date").getValue(String.class);
                    String eventName = eventSnapshot.child("eventName").getValue(String.class); // Get event name
                    String coordinatorName = eventSnapshot.child("coordinatorName").getValue(String.class); // Get coordinator name
                    String eventTime = eventSnapshot.child("eventTime").getValue(String.class); // Get event time
                    // Add the retrieved properties to your dataList
                    String cordineterNumber = eventSnapshot.child("cordineterNumber").getValue(String.class); // Get coordinator number
                    String registrationLink = eventSnapshot.child("registrationLink").getValue(String.class); // Get registration link

                    // Add the retrieved properties to your dataList
                    DataClass data = new DataClass(imageUrl, caption, eventType, date, eventName, coordinatorName, eventTime, cordineterNumber, registrationLink);
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged(); // Notify adapter of data change
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
                Toast.makeText(Cultural_Event.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cultural_Event.this, UploadActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    openFragment(HomeFragment.newInstance("", ""));
                } else if (item.getItemId() == R.id.nav_about) {
                    openFragment(AboutFragment.newInstance("", ""));
                } else if (item.getItemId() == R.id.nav_search) {
                    openFragment(SearchFragment.newInstance("", ""));
                } else if (item.getItemId() == R.id.nav_event) {
                    openFragment(EventFragment.newInstance("", ""));
                }
                return true;
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cultural_event_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
