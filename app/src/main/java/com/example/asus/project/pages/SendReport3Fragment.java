package com.example.asus.project.pages;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.adapter.SysAdapter;
import com.example.asus.project.model.Success;
import com.example.asus.project.model.SystemDao;
import com.example.asus.project.service.HttpManager;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SendReport3Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SendReport3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SendReport3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    //datepicker


    private EditText date_picker;
    // TODO: Rename and change types of parameters
    private ArrayList<String> param;

    private OnFragmentInteractionListener mListener;
    int day,month,year;
    java.util.Calendar calendar;
    EditText ed,problem2;
    String date, TeamId;

    static  final int DILOG_ID = 0;
    List<SystemDao> systemDaos;
    Button prevButton,submitButton;
    Spinner spinner_team;

    public SendReport3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SendReport3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SendReport3Fragment newInstance(ArrayList<String> param1) {
        SendReport3Fragment fragment = new SendReport3Fragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param = getArguments().getStringArrayList(ARG_PARAM1);
        }
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_report3, container, false);
        ed = view.findViewById(R.id.date);
        submitButton = view.findViewById(R.id.submit_button);
        calendar = calendar.getInstance();
        problem2 = view.findViewById(R.id.problem2);
        spinner_team = view.findViewById(R.id.Sch_Team);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = new ArrayList<String>();
                if (param != null){
                    data = param;
                    if (param.size() == 8) {
                        data.add(8, problem2.getText().toString());
                        data.add(9, date);
                        data.add(10, TeamId);
                    }
                }
                data.set(8, problem2.getText().toString());
                data.set(9, date);
                data.set(10, TeamId);

                save(data);
                Fragment fragment = new MainFragment();
                ((MainActivity) getActivity()).changePage(fragment);
            }
        });
        prevButton = view.findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = new ArrayList<String>();
                if (param != null){
                    data = param;
                    if (param.size() == 8) {
                        data.add(8, problem2.getText().toString());
                        data.add(9, date);
                        data.add(10, TeamId);
                    }
                }
                data.set(8, problem2.getText().toString());
                data.set(9, date);
                data.set(10, TeamId);
                Fragment fragment = new SendReport2Fragment().newInstance(data);
                ((MainActivity) getActivity()).changePage(fragment);
            }
        });
        //day = calendar.get(Calendar.DAY_OF_MONTH);
        //month = calendar.get(Calendar.MONTH);
        //year = calendar.get(Calendar.YEAR);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        month = calendar.get(java.util.Calendar.MONTH);
        year = calendar.get(java.util.Calendar.YEAR);
        month = month+1;
        if (param != null){
            if (param.size()>8){
                problem2.setText(param.get(8));
                String[] temp = param.get(9).split("-");
                ed.setText(temp[2]+"/"+temp[1]+"/"+temp[0]);
            }
        }else{
            ed.setText(day+"/"+month+"/"+year);
        }
        date = year+"-"+month+"-"+day;
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofYear, int dayofMonth) {
                        monthofYear = monthofYear+1;
                        ed.setText(dayofMonth+"/"+month+"/"+year);
                        date = year+"-"+month+"-"+dayofMonth;
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        getTeam();

        return view;
    }

    private void save(ArrayList<String> data) {
        data.get(0);
       // retrofit2.Call<Success> call = HttpManager.getInstance().getService().insert(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6),data.get(7),data.get(8),data.get(9),data.get(10));
    }

    private void getTeam() {
        retrofit2.Call<List<SystemDao>> call = HttpManager.getInstance().getService().get_team();
        call.enqueue(new Callback<List<SystemDao>>() {
            @Override
            public void onResponse(retrofit2.Call<List<SystemDao>> call, Response<List<SystemDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("sch_name", "if :: => " + response.message());
                    List<SystemDao> res = response.body();
                    systemDaos = res;
                    Log.d("sizeteam","=> "+systemDaos.size());
                    if (systemDaos.size() >= 4) {

                        SysAdapter adapter = new SysAdapter(getActivity(), systemDaos);
                        spinner_team.setAdapter(adapter);
                        if (param != null) {
                            if (param.size() > 8) {
                                int ps = 0;
                                for (SystemDao rs : systemDaos) {
                                    if (rs.getTeamId().equals(param.get(10))) {
                                        spinner_team.setSelection(ps);
                                        break;
                                    }
                                    ps++;
                                }
                            }
                        }
                        spinner_team.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                TeamId = systemDaos.get(i).getTeamId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
                } else {
                    try {
                        Log.d("TeamName", "else :: => " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<SystemDao>> call, Throwable t) {
                Log.d("onFailure_team", "else " + t);
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
