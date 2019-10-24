package com.sarker.stepcounterwithpedometer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sarker.stepcounterwithpedometer.R;
import com.sarker.stepcounterwithpedometer.adapter.StepCountAdapter;

public class PedometerListActivity extends AppCompatActivity {
    private RecyclerView mSensorListView;
    private StepCountAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer_list);
        mSensorListView = findViewById(R.id.recycler_view);
    }
}
