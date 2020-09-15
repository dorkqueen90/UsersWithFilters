package edu.uncc.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.uncc.midterm.utils.Data;
import edu.uncc.midterm.utils.User;

public class FilterByGroup extends AppCompatActivity {

    ListView listView;
    ArrayList<String> group = new ArrayList<>();
    ArrayAdapter adapter;
    ArrayList<User> user;
    static String GROUP_KEY = "GROUP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_by_group);
        setTitle("Filter By Group");

        listView = findViewById(R.id.listView);
        user = Data.users;

        for(User a : user){
            if(group.contains(a.group)){
                //nothing
            } else {
                group.add(a.group);
            }
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, group);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FilterByGroup.this, UsersActivity.class);
                intent.putExtra(GROUP_KEY, group.get(position));
                startActivity(intent);
            }
        });
    }
}