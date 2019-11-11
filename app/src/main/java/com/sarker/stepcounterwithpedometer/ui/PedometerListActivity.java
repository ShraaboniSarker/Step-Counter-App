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


public class PedometerListActivity extends AppCompatActivity {
    private RecyclerView mSensorListView;
    private TextView tvStepsCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer_list);
        tvStepsCount = findViewById(R.id.tv_steps_count);
//        mSensorListView = findViewById(R.id.recycler_view);
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("StepsCountHistory"));
    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        private SensorEvent steps;

        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String message = intent.getStringExtra("Status");
            Bundle b = intent.getBundleExtra("Steps");
            steps =  b.getParcelable("Steps");
            if (steps != null) {
                tvStepsCount.setText(String.valueOf(steps.values[0]));
                Toast.makeText(context, String.valueOf(steps.values[0]), Toast.LENGTH_SHORT).show();
            }
        }
    };
}
