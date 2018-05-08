package com.example.asus.project.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.SaveReportDao;

import java.util.List;

/**
 * Created by Pongsapat on 06-May-18.
 */

public class SaveReportAdapter extends RecyclerView.Adapter<SaveReportAdapter.SaveReportViewHolder> {
    private List<SaveReportDao> saveReportDaos;
    private Context mContext;
    public SaveReportAdapter(List<SaveReportDao> saveReportDaos,Context mContext){
        this.saveReportDaos = saveReportDaos;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public SaveReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.save_card_view,parent,false);
        SaveReportViewHolder saveReportViewHolder = new SaveReportViewHolder(view);
        return saveReportViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SaveReportViewHolder holder, int position) {
        holder.save_request_date.setText(saveReportDaos.get(position).getRqDate());
        holder.save_request_site.setText(saveReportDaos.get(position).getRqSubject());
        holder.save_request_system.setText(saveReportDaos.get(position).getSysName());
    }

    @Override
    public int getItemCount() {
        return saveReportDaos.size();
    }

    public class SaveReportViewHolder extends RecyclerView.ViewHolder {
        TextView save_request_date;
        TextView save_request_site;
        TextView save_request_system;
        Button save_request_edit;

        public SaveReportViewHolder(View itemView) {
            super(itemView);
            save_request_date = itemView.findViewById(R.id.txt_save_request_date);
            save_request_site = itemView.findViewById(R.id.txt_save_request_site);
            save_request_system = itemView.findViewById(R.id.txt_save_request_system);
            save_request_edit = itemView.findViewById(R.id.btn_save_request_edit);
        }
    }
}
