package com.ekc.c4q.jsonweather;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by leighdouglas on 10/15/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView title;
    TextView description;

    public MyViewHolder(View itemView) {
        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.weather_image);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
