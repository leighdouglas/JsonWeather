package com.ekc.c4q.jsonweather.model;

import java.util.ArrayList;
import java.util.List;

public class FiveDayForecast {
  City city;
  String cod;
  float message;
  int cnt;
  List<Forecast> list;

  public List<Weather> getWeather() {
    List<Weather> weatherList = new ArrayList<>();
    for (Forecast forecast : list) {
      weatherList.addAll(forecast.weather);
    }

    return weatherList;
  }
}
