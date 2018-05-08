package com.example.asus.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.ContactDao;

import java.util.List;

/**
 * Created by computer on 5/5/2561.
 */

public class ConAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ContactDao> mData;

    public ConAdapter(Context context, List<ContactDao> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new ConAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.spinner_list,parent,false);
            holder.name = (TextView)convertView.findViewById(R.id.name);

        }else{
            holder = (ConAdapter.ViewHolder) convertView.getTag();
        }
        holder.name.setText(mData.get(position).getCttName());
        convertView.setTag(holder);
        return convertView;
    }
    public class ViewHolder {
        TextView name;
    }
}
