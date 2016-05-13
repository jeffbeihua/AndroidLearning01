package com.example.zhangbeihua.patientcase.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.zhangbeihua.patientcase.R;
import android.view.View.OnClickListener;
import java.util.Calendar;


/**
 * Created by zhangbeihua on 12/05/16.
 */
public class DiseasehistoryActivity extends AppCompatActivity {

    private Button btnAddHistory;
    private ListView lvHistoryList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseasehistory);

        btnAddHistory = (Button)findViewById(R.id.btnAddHistory);

        btnAddHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiseasehistoryActivity.this, DiseasehistorydetailActivity.class);
                startActivity(intent);
            }
        });

        String [] foods = {"Bacon", "banana", "apple", "pear","Bacon", "banana", "apple", "pear","Bacon", "banana", "apple", "pear","Bacon", "banana", "apple", "pear"};
        ListAdapter historyListAdapter = new DiseasehistoryrowAdapter(this, foods);
        lvHistoryList = (ListView)findViewById(R.id.lvHistoryList);
        lvHistoryList.setAdapter(historyListAdapter);

        lvHistoryList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(DiseasehistoryActivity.this, "Clicked at " + food, Toast.LENGTH_SHORT).show();
                    }
                }
        );


        /*OnItemClickListener myListViewClicked = new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DiseasehistoryActivity.this, "Clicked at positon = " + position, Toast.LENGTH_SHORT).show();

            }
        };

        lvHistoryList.setOnItemClickListener(  myListViewClicked );*/

    }

}
