package com.example.asus.project.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.CatagoryDao;

import java.util.List;

/**
 * Created by computer on 5/5/2561.
 */

public class CaAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<CatagoryDao> mData;

    public CaAdapter(Context context, List<CatagoryDao> mData) {
        this.inflater =  LayoutInflater.from(context);;
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
        CaAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new CaAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.spinner_list,parent,false);
            holder.name = (TextView)convertView.findViewById(R.id.name);
        }else{
            holder = (CaAdapter.ViewHolder)convertView.getTag();
        }
        holder.name.setText(mData.get(position).getCtName());
        convertView.setTag(holder);
        return convertView;
    }

    public class ViewHolder {
        TextView name;
    }
}
