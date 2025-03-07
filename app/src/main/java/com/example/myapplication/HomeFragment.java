package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_EMAIL = "email";

    // TODO: Rename and change types of parameters
    private String mName;
    private String mEmail;
    private String mUsername;
    private String mPassword;

    GridView gridView;
    ArrayList<DataClass> dataList;
    MyAdapter adapter;
    DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name   Parameter 1.
     *      * @param email   Parameter 2.
     *      * @param username
     *      * @param password
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String name, String email) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_EMAIL, email);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
            mEmail = getArguments().getString(ARG_EMAIL);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = rootView.findViewById(R.id.grideView);

        dataList = new ArrayList<>();

        // Correcting the arguments passed to MyAdapter constructor
        adapter = new MyAdapter(dataList, requireContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the click event for the grid item at position
                DataClass clickedItem = dataList.get(position);

                Toast.makeText(requireContext(), "Clicked: " + clickedItem.getCaption(), Toast.LENGTH_SHORT).show();
            }
        });

        eventsRef.child("Cultural Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String imageUrl = eventSnapshot.child("imageUrl").getValue(String.class);
                    String caption = eventSnapshot.child("caption").getValue(String.class);
                    String eventType = eventSnapshot.child("eventType").getValue(String.class);
                    String date = eventSnapshot.child("date").getValue(String.class);
                    String eventName = eventSnapshot.child("eventName").getValue(String.class); // Get event name
                    String coordinatorName = eventSnapshot.child("coordinatorName").getValue(String.class); // Get coordinator name
                    String eventTime = eventSnapshot.child("eventTime").getValue(String.class); // Get event time
                    String cordineterNumber = eventSnapshot.child("cordineterNumber").getValue(String.class); // Get coordinator number
                    String registrationLink = eventSnapshot.child("registrationLink").getValue(String.class); // Get registration link

                    // Add the retrieved properties to your dataList
                    DataClass data = new DataClass(imageUrl, caption, eventType, date, eventName, coordinatorName, eventTime, cordineterNumber, registrationLink);
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        eventsRef.child("Entertainment Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String imageUrl = eventSnapshot.child("imageUrl").getValue(String.class);
                    String caption = eventSnapshot.child("caption").getValue(String.class);
                    String eventType = eventSnapshot.child("eventType").getValue(String.class);
                    String date = eventSnapshot.child("date").getValue(String.class);
                    String eventName = eventSnapshot.child("eventName").getValue(String.class); // Get event name
                    String coordinatorName = eventSnapshot.child("coordinatorName").getValue(String.class); // Get coordinator name
                    String eventTime = eventSnapshot.child("eventTime").getValue(String.class); // Get event time
                    String cordineterNumber = eventSnapshot.child("cordineterNumber").getValue(String.class); // Get coordinator number
                    String registrationLink = eventSnapshot.child("registrationLink").getValue(String.class); // Get registration link

                    // Add the retrieved properties to your dataList
                    DataClass data = new DataClass(imageUrl, caption, eventType, date, eventName, coordinatorName, eventTime, cordineterNumber, registrationLink);
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        eventsRef.child("Academic Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String imageUrl = eventSnapshot.child("imageUrl").getValue(String.class);
                    String caption = eventSnapshot.child("caption").getValue(String.class);
                    String eventType = eventSnapshot.child("eventType").getValue(String.class);
                    String date = eventSnapshot.child("date").getValue(String.class);
                    String eventName = eventSnapshot.child("eventName").getValue(String.class); // Get event name
                    String coordinatorName = eventSnapshot.child("coordinatorName").getValue(String.class); // Get coordinator name
                    String eventTime = eventSnapshot.child("eventTime").getValue(String.class); // Get event time
                    String cordineterNumber = eventSnapshot.child("cordineterNumber").getValue(String.class); // Get coordinator number
                    String registrationLink = eventSnapshot.child("registrationLink").getValue(String.class); // Get registration link

                    // Add the retrieved properties to your dataList
                    DataClass data = new DataClass(imageUrl, caption, eventType, date, eventName, coordinatorName, eventTime, cordineterNumber, registrationLink);
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        eventsRef.child("Sports Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                    String imageUrl = eventSnapshot.child("imageUrl").getValue(String.class);
                    String caption = eventSnapshot.child("caption").getValue(String.class);
                    String eventType = eventSnapshot.child("eventType").getValue(String.class);
                    String date = eventSnapshot.child("date").getValue(String.class);
                    String eventName = eventSnapshot.child("eventName").getValue(String.class); // Get event name
                    String coordinatorName = eventSnapshot.child("coordinatorName").getValue(String.class); // Get coordinator name
                    String eventTime = eventSnapshot.child("eventTime").getValue(String.class); // Get event time
                    String cordineterNumber = eventSnapshot.child("cordineterNumber").getValue(String.class); // Get coordinator number
                    String registrationLink = eventSnapshot.child("registrationLink").getValue(String.class); // Get registration link

                    // Add the retrieved properties to your dataList
                    DataClass data = new DataClass(imageUrl, caption, eventType, date, eventName, coordinatorName, eventTime, cordineterNumber, registrationLink);
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        CardView EntertainmentCardView = rootView.findViewById(R.id.Entertainment_Card);

        // Set OnClickListener to the CardView
        EntertainmentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(requireContext(), "Clicked:Enternaiment Event ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),Entertainment_Event.class);
                startActivity(intent);
            }
        });

        CardView AcademicCardView = rootView.findViewById(R.id.Academic_Card);

        // Set OnClickListener to the CardView
        AcademicCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Academic_Event.class);
                startActivity(intent);

                Toast.makeText(requireContext(), "Clicked:Academic Event ", Toast.LENGTH_SHORT).show();
            }
        });

        CardView CulturalCardView = rootView.findViewById(R.id.Cultural_Card);

        // Set OnClickListener to the CardView
        CulturalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Cultural_Event.class);
                startActivity(intent);

                Toast.makeText(requireContext(), "Clicked:Cultural Event ", Toast.LENGTH_SHORT).show();
            }
        });

        CardView SportsCardView = rootView.findViewById(R.id.Sports_Card);

        // Set OnClickListener to the CardView
        SportsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Sports_Event.class);
                startActivity(intent);

                Toast.makeText(requireContext(), "Clicked:Sports Event ", Toast.LENGTH_SHORT).show();
            }
        });
        // Return the inflated rootView
        return rootView;


    }
}

