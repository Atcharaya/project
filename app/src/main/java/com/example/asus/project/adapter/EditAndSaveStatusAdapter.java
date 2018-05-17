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
import com.example.asus.project.model.EditAndSaveStatusDao;

import java.util.List;

/**
 * Created by PREDATOR on 12/5/2561.
 */

public class EditAndSaveStatusAdapter extends RecyclerView.Adapter<EditAndSaveStatusAdapter.EditStatusViewHolder>{
    private List<EditAndSaveStatusDao> editAndSaveStatusDaos;
    private Context mContext;
    public EditAndSaveStatusAdapter(List<EditAndSaveStatusDao> editAndSaveStatusDaos, Context mContext) {
        this.editAndSaveStatusDaos = editAndSaveStatusDaos;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public EditStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.edit_card_view, parent, false);
        EditStatusViewHolder editStatusViewHolder = new EditStatusViewHolder(view);
        return editStatusViewHolder;
    }

    @Override
    public void onBindViewHolder(EditStatusViewHolder holder, int position) {
        holder.save_request_date.setText(editAndSaveStatusDaos.get(position).getRqDate());
        holder.save_request_site.setText(editAndSaveStatusDaos.get(position).getRqSubject());
        holder.save_request_system.setText(editAndSaveStatusDaos.get(position).getSysName());
    }

    @Override
    public int getItemCount() {
        return editAndSaveStatusDaos.size();
    }

    public class EditStatusViewHolder extends RecyclerView.ViewHolder {
        TextView save_request_date;
        TextView save_request_site;
        TextView save_request_system;
        Button save_request_edit;

        public EditStatusViewHolder(View itemView) {
            super(itemView);
            save_request_date = itemView.findViewById(R.id.txt_save_request_date);
            save_request_site = itemView.findViewById(R.id.txt_save_request_site);
            save_request_system = itemView.findViewById(R.id.txt_save_request_system);
            save_request_edit = itemView.findViewById(R.id.btn_save_request_edit);
        }
    }
}
