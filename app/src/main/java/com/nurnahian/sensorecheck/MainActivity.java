package com.nurnahian.sensorecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView viewText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE) ;
        
        
        if(sensorManager!= null){
            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(lightSensor !=null){
                sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
            }

        }else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }

//        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        viewText = findViewById(R.id.viewData);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_LIGHT){
            ((TextView)findViewById(R.id.viewData)).setText("Values: " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}