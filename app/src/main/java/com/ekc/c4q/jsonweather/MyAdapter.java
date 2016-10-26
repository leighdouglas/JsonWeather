package com.ekc.c4q.jsonweather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ekc.c4q.jsonweather.model.Weather;

import java.util.List;

/**
 * Created by leighdouglas on 10/15/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    //i need a view holder

    private List<Weather> mWeather;

    public MyAdapter(List<Weather> weather){
        this.mWeather = weather;
    }

//    public void setmWeather(List<Weather> weatherList){
//        this.mWeather.clear();
//        this.mWeather.addAll(weatherList);
//        notifyDataSetChanged();
//    }

    public int getSize(){
        return mWeather.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_recyclerview, parent, false);

        return new MyViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Weather weath = mWeather.get(position); //getting the object at that position in the list and saving it
        //now we reference the components of that object and set the info in our view based on what is in our object

        if(weath.getMain().equalsIgnoreCase("Clear")){
            //sets images to clear skys image is the title says clear
            holder.image.setImageResource(R.drawable.art_clear);
        } else if (weath.getDescription().equalsIgnoreCase("Light rain")) {
            //sets image to light rain if description says light rain
            holder.image.setImageResource(R.drawable.art_light_rain);
        } else if(weath.getDescription().equalsIgnoreCase("moderate rain")) {
            //sets image to heavy rain if description says moderate rain
            holder.image.setImageResource(R.drawable.art_rain);
        } else if(weath.getDescription().equalsIgnoreCase("broken clouds") || weath.getDescription().equalsIgnoreCase("scattered clouds") || weath.getDescription().equalsIgnoreCase("few clouds")) {
            holder.image.setImageResource(R.drawable.art_light_clouds);
        } else if(weath.getDescription().equalsIgnoreCase("overcast clouds")){
            holder.image.setImageResource(R.drawable.art_clouds);
        } else {
            //sets everything else to snow (for now)
            holder.image.setImageResource(R.drawable.art_snow);
        }

      //  holder.image.setImageResource(R.drawable.art_clouds);
        holder.title.setText(weath.getMain());
        holder.description.setText(weath.getDescription());
    }

    @Override
    public int getItemCount() {
        return mWeather.size();
    }
}
