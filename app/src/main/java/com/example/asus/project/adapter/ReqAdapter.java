package com.example.asus.project.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.model.ReqDao;
import com.example.asus.project.pages.SelectRqFragment;

import java.util.List;

/**
 * Created by MarnusFrank on 23/5/2561.
 */

public class ReqAdapter extends RecyclerView.Adapter<ReqAdapter.ReqViewHolder> {

    private List<ReqDao> reqDao;
    private Context mContext;

    public ReqAdapter(List<ReqDao> reqDao, Context mContext) {
        this.reqDao = reqDao;
        this.mContext = mContext;
    }

    @Override
    public ReqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.card_request, parent, false);
        ReqViewHolder selectEditViewHolder = new ReqViewHolder(view);
        return selectEditViewHolder;
    }

    @Override
    public void onBindViewHolder(ReqViewHolder holder, int position) {

        holder.rq_sub.setText(reqDao.get(position).getRq_subject());
        holder.rq_date.setText(reqDao.get(position).getRq_date());
        holder.rq_reply.setText(reqDao.get(position).getRq_name_reply());

        holder.cvRqItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SelectRqFragment();
                ((MainActivity) mContext).changePage(fragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reqDao.size();
    }

    public class ReqViewHolder extends RecyclerView.ViewHolder {
        TextView rq_sub;
        TextView rq_date;
        TextView rq_reply;
        CardView cvRqItem;

        public ReqViewHolder(View itemView) {
            super(itemView);
            rq_sub = itemView.findViewById(R.id.rq_subject);
            rq_date = itemView.findViewById(R.id.rq_date);
            rq_reply = itemView.findViewById(R.id.rq_reply);
            cvRqItem = itemView.findViewById(R.id.cvRqItem);
        }
    }
}
