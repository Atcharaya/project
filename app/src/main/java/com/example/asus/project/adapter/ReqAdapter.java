package com.example.asus.project.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.ReqDao;
import com.example.asus.project.model.SiteDao;

import java.util.List;

/**
 * Created by MarnusFrank on 22/5/2561.
 */

public class ReqAdapter extends RecyclerView.Adapter<ReqAdapter.SelectEditViewHolder>{
    private List<ReqDao> reqDao;
    private Context mContext;

    public ReqAdapter(List<ReqDao> siteDao, Context mContext) {
        this.reqDao = reqDao;
        this.mContext = mContext;
    }

    @Override
    public SelectEditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SelectEditViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class SelectEditViewHolder extends RecyclerView.ViewHolder {
//        TextView name;
//        CardView cvItem;

        public SelectEditViewHolder(View itemView) {
            super(itemView);
//            name = itemView.findViewById(R.id.txt_site_name2);
//            cvItem = itemView.findViewById(R.id.cvItem);
        }
    }
}
