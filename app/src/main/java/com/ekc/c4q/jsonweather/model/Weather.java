package com.ekc.c4q.jsonweather.model;

public class Weather {
  int id;
  String main;
  String description;
  String icon;

  public String getMain(){
    return this.main;
  }

  public String getDescription(){
    return this.description;
  }
}
