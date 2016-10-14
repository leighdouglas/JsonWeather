package com.ekc.c4q.jsonweather.model;

import java.util.List;

public class Forecast {
  int dt;
  Main main;
  List<Weather> weather;
  Clouds clouds;
  Wind wind;
  Rain rain;
  Sys sys;
  String dt_txt;
}
