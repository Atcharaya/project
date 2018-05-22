package com.example.asus.project.pages;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Edit_Status_Rq extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public Edit_Status_Rq() {
        // Required empty public constructor
    }

    public static Edit_Status_Rq newInstance(String param1) {
        Edit_Status_Rq fragment = new Edit_Status_Rq();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit__status__rq, container, false);


        return view;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
