package com.example.asus.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.ProjectDao;

import java.util.List;

/**
 * Created by computer on 3/5/2561.
 */

public class SchAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ProjectDao> mData;

    public SchAdapter(Context context, List<ProjectDao> mData) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
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
        SchAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new SchAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.spinner_list,parent,false);
            holder.name = (TextView)convertView.findViewById(R.id.name);

        }else{
            holder = (SchAdapter.ViewHolder)convertView.getTag();
        }
        holder.name.setText(mData.get(position).getSchName());
        convertView.setTag(holder);
        return convertView;
    }

    public class ViewHolder {
        TextView name;
    }
}
