package com.example.asus.project.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.model.EditAndSaveStatusDao;
import com.example.asus.project.model.SiteDao;
import com.example.asus.project.pages.Edit_Status_main;
import com.example.asus.project.pages.SelectEdit;
import com.example.asus.project.pages.SelectRqFragment;
import com.example.asus.project.pages.TrackRqFragment;


import java.util.List;

/**
 * Created by PREDATOR on 21/5/2561.
 */

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.SelectEditViewHolder> {

    private List<SiteDao> siteDao;
    private Context mContext;

    public SiteAdapter(List<SiteDao> siteDao, Context mContext) {
        this.siteDao = siteDao;
        this.mContext = mContext;
    }


    @Override
    public SelectEditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.card_college, parent, false);
        SelectEditViewHolder selectEditViewHolder = new SelectEditViewHolder(view);
        return selectEditViewHolder;
    }

    @Override
    public void onBindViewHolder(SelectEditViewHolder holder, final int position) {
        Integer siteId = null;

        holder.name.setText(siteDao.get(position).getSite_name());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new SelectRqFragment();
                ((MainActivity) mContext).changePage(fragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return siteDao.size();
    }


    public class SelectEditViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView cvItem;

        public SelectEditViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_site_name2);
            cvItem = itemView.findViewById(R.id.cvItem);
        }
    }
}
