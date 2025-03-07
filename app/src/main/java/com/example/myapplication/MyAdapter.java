package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<DataClass> dataList;
    private Context context;

    public MyAdapter(ArrayList<DataClass> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClass> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.gridImage = convertView.findViewById(R.id.gridImage);
            viewHolder.gridCaption = convertView.findViewById(R.id.gridCaption);
            viewHolder.gridId = convertView.findViewById(R.id.gridId);
            viewHolder.gridDate = convertView.findViewById(R.id.gridDate);
            viewHolder.gridTime = convertView.findViewById(R.id.gridTime);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set data to views
        DataClass data = dataList.get(position);
        Glide.with(context).load(data.getImageUrl()).into(viewHolder.gridImage);
        viewHolder.gridCaption.setText(data.getCaption());
        viewHolder.gridId.setText(data.getEventType());
        viewHolder.gridDate.setText(data.getDate());
        viewHolder.gridTime.setText(data.getEventTime());

        return convertView;
    }

    static class ViewHolder {
        ImageView gridImage;
        TextView gridCaption;
        TextView gridId;
        TextView gridDate;
        TextView gridTime;
        TextView gridEventName;
        TextView CoName;
    }
}
