package com.example.ludvig.hellosensor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ludvig on 2016-03-22.
 */
public class Kompass extends Activity implements SensorEventListener {


        // define the display assembly compass picture
        private ImageView image;

        // record the compass picture angle turned
        private float currentDegree = 0f;

        // device sensor manager
        private SensorManager mSensorManager;

        private TextView direction;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.kompass);

            // our compass image
            image = (ImageView) findViewById(R.id.imageViewCompass);

            // TextView that will tell the user what degree is he heading
            direction = (TextView) findViewById(R.id.tvHeading);

            // initialize your android device sensor capabilities
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        }

        @Override
        protected void onResume() {
            super.onResume();

            // for the system's orientation sensor registered listeners
            mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                    SensorManager.SENSOR_DELAY_GAME);
        }

        @Override
        protected void onPause() {
            super.onPause();

            // to stop the listener and save battery
            mSensorManager.unregisterListener(this);
        }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float degree = Math.round(sensorEvent.values[0]);

        direction.setText("Heading: " + Float.toString(degree) + " degrees");

        // create a rotation animation (reverse turn degree degrees)
        RotateAnimation ra = new RotateAnimation(
                currentDegree,
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);

        // how long the animation will take place
        ra.setDuration(210);

        // set the animation after the end of the reservation status
        ra.setFillAfter(true);

        // Start the animation
        image.startAnimation(ra);
        currentDegree = -degree;
    }

            @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // not in use
        }

        public void onBackPressed(){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            this.finish();
        }
    }