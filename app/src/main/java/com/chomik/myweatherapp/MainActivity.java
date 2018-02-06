package com.chomik.myweatherapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ShakeListener chomikShake;
    public String name;
    public Double lon;
    public Double lat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }

    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;

    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        SearchView simpleSearchView = (SearchView) findViewById(R.id.chomik_search);
        CharSequence query = simpleSearchView.getQuery();

        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
                    public void processFinish(String weather_city, Double lon, Double lat, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                        cityField.setText(weather_city);
                        setName(weather_city);
                        setLat(lat);
                        setLon(lon);
                        updatedField.setText(weather_updatedOn);
                        detailsField.setText(weather_description);
                        currentTemperatureField.setText(weather_temperature);
                        humidity_field.setText("Humidity: " + weather_humidity);
                        pressure_field.setText("Pressure: " + weather_pressure);
                        weatherIcon.setText(Html.fromHtml(weather_iconText));

                    }
                });
                asyncTask.execute(query.toString()); //  asyncTask.execute("name")
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);

        chomikShake = new ShakeListener(this);
        chomikShake.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake()
            {
                Intent in = new Intent(getApplicationContext(), MapsActivity.class);
                in.putExtra("lon", getLon());
                in.putExtra("lat", getLat());
                in.putExtra("name", getName());
                startActivity(in);
            }

        });
    }
    @Override
    public void onResume()
    {
        chomikShake.resume();
        super.onResume();
    }
    @Override
    public void onPause()
    {
        chomikShake.pause();
        super.onPause();
    }


}
