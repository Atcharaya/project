package com.example.asus.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.LevelDao;
import com.example.asus.project.model.SystemDao;

import java.util.List;

/**
 * Created by computer on 5/5/2561.
 */

public class LvAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<LevelDao> mData;

    public LvAdapter(Context context, List<LevelDao> mData) {
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
        LvAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new LvAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.spinner_list,parent,false);
            holder.name = (TextView)convertView.findViewById(R.id.name);

        }else{
            holder = (LvAdapter.ViewHolder) convertView.getTag();
        }
        holder.name.setText(mData.get(position).getLvName());
        convertView.setTag(holder);
        return convertView;
    }
    public class ViewHolder {
        TextView name;
    }
}
