package com.nudha.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //Using Custom Layouts --> MyCustomAdapter
    //Using Custom Objects --> extends ArrayAdapter<Planet>

    private ArrayList<Planet>  planetArrayList;
    Context context;

    public MyCustomAdapter( Context context, ArrayList<Planet> planetArrayList) {
        super(context, R.layout.item_list_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    // View Holder Class: used to cache references to the views within
    //                    an item layout, so that they don't need to be
    //                    repeatedly looked up during scrolling

    private static class MyHolderView{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;


    }

    //getView(): used to create and return a view
    //           for a specific item in the list.

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        //1 - Get the planet object for the current position
        Planet planet = getItem(position);

        // 2 - Inflate Layout
        MyHolderView myHolderView;
        final View result;

        if(convertView == null){
            myHolderView = new MyHolderView();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            //Finding Views
            myHolderView.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myHolderView.moonCount = (TextView) convertView.findViewById(R.id.text_moon);
            myHolderView.planetImg = (ImageView) convertView.findViewById(R.id.image_view);

            result = convertView;

            convertView.setTag(myHolderView);
        }else{
            // the view is recycled
            myHolderView = (MyHolderView) convertView.getTag();
            result = convertView;
        }

        //Getting the data from model class (Planet)
        myHolderView.planetName.setText(planet.getPlanetName());
        myHolderView.moonCount.setText(planet.getMoonCount());
        myHolderView.planetImg.setImageResource(planet.getPlanetImage());

        return result;
    }
}
