package com.example.asus.project.pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.project.R;
import com.example.asus.project.adapter.ReqAdapter;
import com.example.asus.project.adapter.SiteAdapter;
import com.example.asus.project.model.ReqDao;
import com.example.asus.project.model.SiteDao;
import com.example.asus.project.service.HttpManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectRqFragment extends Fragment {

    RecyclerView recyclerView;

    public SelectRqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_rq, container, false);
        recyclerView = view.findViewById(R.id.rvRqList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        getSelectReqList();

        return view;
    }

    public void getSelectReqList() {
        Call<List<ReqDao>> call = HttpManager.getInstance().getService().getReqAll();
        call.enqueue(new Callback<List<ReqDao>>() {
            @Override
            public void onResponse(Call<List<ReqDao>> call, Response<List<ReqDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("service", "if :: " + response.message());
                    List<ReqDao> res = response.body();
                    Log.d("service", "if :: " + res.size());
                    ReqAdapter adapter = new ReqAdapter(res, getContext());
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.d("service", "else :: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<ReqDao>> call, Throwable t) {
                Log.d("onFailure", "else :: " + t);
            }
        });
    }

}
