package com.example.asus.project.pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.project.R;
import com.example.asus.project.adapter.SiteAdapter;
import com.example.asus.project.model.SiteDao;
import com.example.asus.project.service.HttpManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackRqFragment extends Fragment {

    RecyclerView recyclerView;

    public TrackRqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_track_rq, container, false);
        recyclerView = view.findViewById(R.id.rvSiteList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        getSelectSiteList();

        return view;
    }

    public void getSelectSiteList() {
        Call<List<SiteDao>> call = HttpManager.getInstance().getService().getSelectSite();
        call.enqueue(new Callback<List<SiteDao>>() {
            @Override
            public void onResponse(Call<List<SiteDao>> call, Response<List<SiteDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("service", "if :: " + response.message());
                    List<SiteDao> res = response.body();
                    Log.d("service", "if :: " + res.size());
                    SiteAdapter adapter = new SiteAdapter(res, getContext());
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.d("service", "else :: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<SiteDao>> call, Throwable t) {
                Log.d("onFailure", "else :: " + t);
            }
        });
    }

}
