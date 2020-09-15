package edu.uncc.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import edu.uncc.midterm.utils.Data;
import edu.uncc.midterm.utils.User;

import static edu.uncc.midterm.FilterByGroup.GROUP_KEY;

public class UsersActivity extends AppCompatActivity {

    ArrayList<User> user;
    ArrayList<User> filteredUser = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layout;
    ImageButton filterButton;
    ImageButton femaleButton;
    ImageButton maleButton;
    ImageButton refreshButton;
    String groupName;

    public final String TAG = "demo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Log.d(TAG, "onCreate: " + Data.users);
        setTitle("Users");
        user = Data.users;

        if(getIntent() != null && getIntent().getExtras() != null){
            groupName = getIntent().getStringExtra(GROUP_KEY);
            for(User a : user){
                if(a.group.equals(groupName)){
                    filteredUser.add(a);
                }
            }
            user = filteredUser;
        }
        recyclerView = findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        filterButton = findViewById(R.id.filterButton);
        femaleButton = findViewById(R.id.femaleButton);
        maleButton = findViewById(R.id.maleButton);
        refreshButton = findViewById(R.id.refreshButton);

        adapter = new categoryAdapter(user);
        recyclerView.setAdapter(adapter);

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsersActivity.this, FilterByGroup.class);
                startActivity(intent);
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filteredUser = new ArrayList<>();
                for(User a : user){
                    if(a.gender.equals("Female")){
                        filteredUser.add(a);
                    }
                }
                user = filteredUser;
                adapter = new categoryAdapter(user);
                recyclerView.setAdapter(adapter);
            }
        });
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filteredUser = new ArrayList<>();
                for(User a : user){
                    if(a.gender.equals("Male")){
                        filteredUser.add(a);
                    }
                }
                user = filteredUser;
                adapter = new categoryAdapter(user);
                recyclerView.setAdapter(adapter);
            }
        });
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Data.users;
                adapter = new categoryAdapter(user);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}