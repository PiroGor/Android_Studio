package com.nudha.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;

    public CustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;       //returns the numbers of items in your data source
    }

    @Override
    public Object getItem(int position) {
        return items[position];            //returns the data items at the given position
    }

    @Override
    public long getItemId(int position) {
        return position;           // return a unique ID for the item at the given position
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            //convertView: is a recycled View that you can reuse
            // to improve the performance of your list
            convertView = LayoutInflater.from(context)
                            .inflate(R.layout.my_custom_layout, parent, false);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        }else{
            //Reusing the View (that's recycled)
            holder = (ViewHolder) convertView.getTag();
        }

        //Set the datat to the view
        holder.textView.setText(items[position]);

        return convertView;            //displays the data at a position in the data set
    }

    static class ViewHolder{
        //Holds references to the views within an item layout
        TextView textView;

    }
}
