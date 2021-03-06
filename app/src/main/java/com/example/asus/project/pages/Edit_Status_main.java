package com.example.asus.project.pages;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Edit_Status_main.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Edit_Status_main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Edit_Status_main extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private Edit_Status_main.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private OnFragmentInteractionListener mListener;

    public Edit_Status_main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Edit_Status_main.
     */
    // TODO: Rename and change types and number of parameters
    public static Edit_Status_main newInstance(String param1) {
        Edit_Status_main fragment = new Edit_Status_main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit__status_main, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new Edit_Status_main.SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        Log.d("param", "onCreateView: " + mParam1);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            Log.d("param", "getItem: " + mParam1);
            switch (position) {
                case 0:
                    Edit_Status_Quest tabQuest = new Edit_Status_Quest().newInstance(mParam1);
                    return tabQuest;
                case 1:
                    Edit_Status_Analysis tabAnalysis = new Edit_Status_Analysis().newInstance(mParam1);
                    return tabAnalysis;
                case 2:
                    Edit_Status_Edit tabEdit = new Edit_Status_Edit().newInstance(mParam1);
                    return tabEdit;
                case 3:
                    Edit_Status_Test tabReport = new Edit_Status_Test().newInstance(mParam1);
                    return tabReport;
                case 4:
                  Edit_Status_Report tabTest = new Edit_Status_Report().newInstance(mParam1);
                  return tabTest;
                case 5:
                    Edit_Status_Done tabDone = new Edit_Status_Done().newInstance(mParam1);
                    return tabDone;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "รับเรื่อง";
                case 1:
                    return "วิเคราะห์";
                case 2:
                    return "ดำเนินการ";
                case 3:
                    return "ทดสอบ";
                case 4:
                    return "รายงานผล";
                case 5:
                    return "สำเร็จ";
            }
            return null;
        }

    }
}
