package com.sarker.stepcounterwithpedometer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.Toast;

import com.sarker.stepcounterwithpedometer.R;
import com.sarker.stepcounterwithpedometer.adapter.StepCountAdapter;
import com.sarker.stepcounterwithpedometer.service.StepService;


public class PedometerListActivity extends AppCompatActivity {
    private RecyclerView mSensorListView;
    private TextView tvStepsCount;
    private StepCountAdapter mListAdapter;
    float steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer_list);
        tvStepsCount = findViewById(R.id.tv_steps_count);
        Intent mStepsIntent = new Intent(getApplicationContext(), StepService.class);
        startService(mStepsIntent);
//        mSensorListView = findViewById(R.id.recycler_view);
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("StepsCountHistory"));
    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            float stepCount = intent.getFloatExtra("Status",0);

            if (stepCount != 0.0) {
                steps = steps+stepCount;
                tvStepsCount.setText(String.valueOf(steps));
                Toast.makeText(context, String.valueOf(steps), Toast.LENGTH_SHORT).show();
            }
        }
    };


    }

