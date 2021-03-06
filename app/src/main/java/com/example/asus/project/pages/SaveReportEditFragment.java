package com.example.asus.project.pages;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.project.R;
import com.example.asus.project.adapter.EditAndSaveStatusAdapter;
import com.example.asus.project.model.EditAndSaveStatusDao;
import com.example.asus.project.service.HttpManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SaveReportEditFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SaveReportEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaveReportEditFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

    public SaveReportEditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaveReportEditFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaveReportEditFragment newInstance(String param1, String param2) {
        SaveReportEditFragment fragment = new SaveReportEditFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_report_edit, container, false);
        recyclerView = view.findViewById(R.id.rv_save_edit);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        getSaveList();
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
//            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void getSaveList() {
        Call<List<EditAndSaveStatusDao>> call = HttpManager.getInstance().getService().getSaveReportEdit();
        call.enqueue(new Callback<List<EditAndSaveStatusDao>>() {
            @Override
            public void onResponse(retrofit2.Call<List<EditAndSaveStatusDao>> call, Response<List<EditAndSaveStatusDao>> response) {
                if (response.isSuccessful()){
                    Log.d("service", "if :: " + response.message());
                    List<EditAndSaveStatusDao> res = response.body();
                    Log.d("service", "if :: " + res.size());
                    EditAndSaveStatusAdapter adapter = new EditAndSaveStatusAdapter(res, getActivity());
                    recyclerView.setAdapter(adapter);
                }else {
                    Log.d("service", "else :: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<EditAndSaveStatusDao>> call, Throwable t) {
                Log.d("onFailure", "else :: " + t);
            }
        });
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
