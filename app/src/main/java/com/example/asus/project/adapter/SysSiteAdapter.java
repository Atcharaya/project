package com.example.asus.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.CatagoryDao;
import com.example.asus.project.model.SysDao;

import java.util.List;

/**
 * Created by computer on 6/5/2561.
 */

public class SysSiteAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<SysDao> mData;

    public SysSiteAdapter(Context context, List<SysDao> mData) {
        this.inflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SchAdapter.ViewHolder holder;
        if(view == null){
            holder = new SchAdapter.ViewHolder();
            view = inflater.inflate(R.layout.spinner_list,viewGroup,false);
            holder.name = (TextView)view.findViewById(R.id.name);

        }else{
            holder = (SchAdapter.ViewHolder)view.getTag();
        }
        holder.name.setText(mData.get(i).getSysName());
        view.setTag(holder);
        return view;

    }

    public class ViewHolder {
        TextView name;
    }
}
