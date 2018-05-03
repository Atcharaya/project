package com.example.asus.project.pages;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.adapter.SchAdapter;
import com.example.asus.project.model.ProjectDao;
import com.example.asus.project.service.HttpManager;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SendReportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SendReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SendReportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    Button nextButton;
    private List<ProjectDao> projectDaos;
    Spinner spinner_schname;
    public SendReportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SendReportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SendReportFragment newInstance(String param1, String param2) {
        SendReportFragment fragment = new SendReportFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_report, container, false);
        nextButton = view.findViewById(R.id.next_button);
        spinner_schname = view.findViewById(R.id.Sch_Name);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SendReport2Fragment();
                ((MainActivity) getActivity()).changePage(fragment);
            }
        });
       // spinner_schname.setPrompt("กรุณาเลือกโครงการ");
        getSchName();
        return view;
    }

    private void getSchName() {
        retrofit2.Call<List<ProjectDao>> call = HttpManager.getInstance().getService().get_sch();
        call.enqueue(new Callback<List<ProjectDao>>() {
            @Override
            public void onResponse(retrofit2.Call<List<ProjectDao>> call, Response<List<ProjectDao>> response) {
                if(response.isSuccessful()){
                    Log.d("sch_name","if :: => "+response.message());
                    List<ProjectDao> res = response.body();
                    projectDaos = res;
                    if(res.size() > 0 ){
                        SchAdapter adapter = new SchAdapter(getActivity(), res);
                        spinner_schname.setAdapter(adapter);
                    }

                }else{
                    try{
                        Log.d("sch_name","else :: => "+response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<ProjectDao>> call, Throwable t) {
                    Log.d("onFailure","else "+t);
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

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
}
