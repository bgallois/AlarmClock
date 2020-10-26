package com.better.alarm.alert;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;


public class LuminositySensor implements SensorEventListener {

    private SensorManager mSensorManager = null;
    private Sensor mLightSensor = null;
    public float mlux = 0;

    public LuminositySensor(Context context){
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            Log.d("SensorTest", "" + sensorEvent.values[0]);
            mlux = sensorEvent.values[0];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void register(){
        mSensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregister(){
        mSensorManager.unregisterListener(this);
    }

    public float getLux(){
        return mlux;
    }
}