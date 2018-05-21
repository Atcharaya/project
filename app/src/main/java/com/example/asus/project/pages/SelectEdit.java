package com.example.asus.project.pages;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.adapter.EditAndSaveStatusAdapter;
import com.example.asus.project.adapter.SiteAdapter;
import com.example.asus.project.model.EditAndSaveStatusDao;
import com.example.asus.project.model.SiteDao;
import com.example.asus.project.service.HttpManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectEdit extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    RecyclerView recyclerView;
    private String mParam1;
    private Button btnSelectSite;

    public SelectEdit() {
        // Required empty public constructor
    }

    public static SelectEdit newInstance(String param1) {
        SelectEdit fragment = new SelectEdit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_edit, container, false);
        recyclerView = view.findViewById(R.id.rv_site_select);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        getSelectSiteList();


        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
