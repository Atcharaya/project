package com.example.asus.project.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.model.SiteEditDao;
import com.example.asus.project.pages.Edit_Status_Rq;
import com.example.asus.project.pages.Edit_Status_main;

import java.util.List;

/**
 * Created by PREDATOR on 21/5/2561.
 */

public class SiteEditAdapter extends RecyclerView.Adapter<SiteEditAdapter.Site_Edit_ViewHolder>{

    private List<SiteEditDao> site_edit_daos;
    private Context mContext;

    public SiteEditAdapter(List<SiteEditDao> site_edit_daos, Context mContext){
        this.site_edit_daos = site_edit_daos;
        this.mContext = mContext;
    }

    @Override
    public Site_Edit_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.site_edit_card, parent, false);
        Site_Edit_ViewHolder site_Edit_ViewHolder = new Site_Edit_ViewHolder(view);
        return site_Edit_ViewHolder;
    }

    @Override
    public void onBindViewHolder(Site_Edit_ViewHolder holder, final int position) {
        holder.rq_date.setText(site_edit_daos.get(position).getRq_date());
        holder.rq_detail.setText(site_edit_daos.get(position).getRq_detail());
        holder.sys_name.setText(site_edit_daos.get(position).getSys_name());
        holder.btn_site_edit_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Edit_Status_Rq();
                ((MainActivity) mContext).changePage(fragment);
            }
        });
    }

    @Override
    public int getItemCount() {
       return site_edit_daos.size();
    }


    public class Site_Edit_ViewHolder extends RecyclerView.ViewHolder {
        TextView rq_date;
        TextView rq_detail;
        TextView sys_name;
        Button btn_site_edit_send;
        public Site_Edit_ViewHolder(View itemView) {
            super(itemView);
            rq_date = itemView.findViewById(R.id.txt_rq_date);
            rq_detail = itemView.findViewById(R.id.txt_rq_detail);
            sys_name = itemView.findViewById(R.id.txt_sys_name);
            btn_site_edit_send = itemView.findViewById(R.id.btn_site_edit_send);
        }
    }
}
