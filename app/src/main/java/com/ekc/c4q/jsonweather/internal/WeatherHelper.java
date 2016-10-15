package com.ekc.c4q.jsonweather.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.ekc.c4q.jsonweather.model.FiveDayForecast;
import com.ekc.c4q.jsonweather.model.Weather;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import static com.ekc.c4q.jsonweather.internal.JsonValidator.GSON;

/**
 * INTERNAL USE ONLY. If you are a student, don't modify this class. Used to deserialize json
 * and extract the inner weather list chocolatey goodness inside.
 */
public class WeatherHelper {
  /**
   * Returns a list of Weather objects.
   *
   * @param context the context to obtain assets from.
   * @return the list of Weather.
   */
  @NonNull public static List<Weather> getWeather(Context context) {
    try {
      final InputStream inputStream = context.getAssets().open("five_day_forecast.json");
      final InputStreamReader reader = new InputStreamReader(inputStream);
      final FiveDayForecast fiveDayForecast = GSON.fromJson(reader, FiveDayForecast.class);

      return fiveDayForecast.getWeather();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return Collections.emptyList();
  }
}
