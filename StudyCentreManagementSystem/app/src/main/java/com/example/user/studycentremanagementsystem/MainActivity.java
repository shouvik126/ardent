package com.example.user.studycentremanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    ExpandableListView expandableListView;
    List<String> accounts;
    Map<String,List<String>> types;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=(ExpandableListView)findViewById(R.id.expandableListView);
        fillData();
        listAdapter=new MyExListAdapter(this,accounts,types);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(MainActivity.this,accounts.get(groupPosition)+": "+types.get(accounts.get(groupPosition)).get(childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }///on create method end
    public void fillData()
    {
        accounts=new ArrayList<>();
        types=new HashMap<>();
        accounts.add("ADMINISTRATOR");
        accounts.add("STUDENT");
        List<String> administrator=new ArrayList<>();
        List<String> student=new ArrayList<>();

        administrator.add("Sign Up");
        administrator.add("Log In");

        student.add("Sign Up");
        student.add("Log In");

        types.put(accounts.get(0),administrator);
        types.put(accounts.get(1),student);
    }

}
