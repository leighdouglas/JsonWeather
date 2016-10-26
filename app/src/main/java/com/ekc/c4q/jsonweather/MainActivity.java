package com.ekc.c4q.jsonweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ekc.c4q.jsonweather.internal.WeatherHelper;
import com.ekc.c4q.jsonweather.model.Weather;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  MyAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // You will probably need this
    List<Weather> weatherList = WeatherHelper.getWeather(this);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.weather_recycler_view);

    recyclerView.setLayoutManager(new LinearLayoutManager(this)); //determines how content shows up
    recyclerView.setAdapter(adapter = new MyAdapter(weatherList));
   // MyAdapter adapter = new MyAdapter(weatherList);
    /**
     * RecyclerView exercise: Add a RecyclerView to MainActivity and display a list of weather
     * items, showing the icon, title, and description.
     *
     * Hint: You will probably need to look inside the five_day_forecast.json file to figure out
     * how to intelligently key off the icons
     *
     * The icons you should use are under drawable-dpi/ic_*
     */
  }
}
