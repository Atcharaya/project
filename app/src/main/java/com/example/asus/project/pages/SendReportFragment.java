package com.example.asus.project.pages;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.asus.project.MainActivity;
import com.example.asus.project.R;
import com.example.asus.project.adapter.SchAdapter;
import com.example.asus.project.adapter.SysSiteAdapter;
import com.example.asus.project.model.ProjectDao;
import com.example.asus.project.model.SysDao;
import com.example.asus.project.service.HttpManager;

import java.io.IOException;
import java.util.ArrayList;
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

    // TODO: Rename and change types of parameters
    private ArrayList<String> param;


    private OnFragmentInteractionListener mListener;

    Button nextButton;
    private List<ProjectDao> projectDaos;
    private List<SysDao> systemDaos;
    Spinner spinner_schname, spinner_sys;
    EditText problem, detail;
    String Schid, sysid, topic, content;

    public SendReportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SendReportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SendReportFragment newInstance(ArrayList<String> param1) {
        SendReportFragment fragment = new SendReportFragment();
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
        View view = inflater.inflate(R.layout.fragment_send_report, container, false);
        nextButton = view.findViewById(R.id.next_button);
        spinner_schname = view.findViewById(R.id.Sch_Name);
        spinner_sys = view.findViewById(R.id.Sch_System);
        problem = view.findViewById(R.id.problem);
        detail = view.findViewById(R.id.detail);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = new ArrayList<String>();
                if (param != null) {
                    data = param;
                } else {
                    data.add(0, Schid);
                    data.add(1, sysid);
                    data.add(2, problem.getText().toString());
                    data.add(3, detail.getText().toString());
                }
                data.set(0, Schid);
                data.set(1, sysid);
                data.set(2, problem.getText().toString());
                data.set(3, detail.getText().toString());
                Fragment fragment = new SendReport2Fragment().newInstance(data);
                ((MainActivity) getActivity()).changePage(fragment);
            }
        });
        // spinner_schname.setPrompt("กรุณาเลือกโครงการ");
        getSchName();

        if (param != null) {
            problem.setText(param.get(2));
            detail.setText(param.get(3));
        }
        return view;
    }

    private void getSchName() {
        retrofit2.Call<List<ProjectDao>> call = HttpManager.getInstance().getService().get_sch();
        call.enqueue(new Callback<List<ProjectDao>>() {
            @Override
            public void onResponse(retrofit2.Call<List<ProjectDao>> call, Response<List<ProjectDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("sch_name", "if :: => " + response.message());
                    List<ProjectDao> res = response.body();
                    projectDaos = res;
                    if (projectDaos.size() > 0) {
                        SchAdapter adapter = new SchAdapter(getActivity(), projectDaos);
                        spinner_schname.setAdapter(adapter);
                        if (param != null) {
                            if (param.size() > 0) {
                                int ps = 0;
                                for (ProjectDao rs : projectDaos) {
                                    if (rs.getSchId().equals(param.get(0))) {
                                        spinner_schname.setSelection(ps);
                                        break;
                                    }
                                    ps++;
                                }
                            }
                        }
                        spinner_schname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                Log.d("getSchName", "onItemSelected: " + projectDaos.get(i).getSchId());
                                //sendschname(projectDaos.get(i).getSchId());
                                Schid = projectDaos.get(i).getSchId();
                                getSystem();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        getSystem();
                    }

                } else {
                    try {
                        Log.d("sch_name", "else :: => " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<ProjectDao>> call, Throwable t) {
                Log.d("onFailure Schname", "else " + t);
            }
        });

    }

    private void getSystem() {
        String id = projectDaos.get(spinner_schname.getSelectedItemPosition()).getSchId();
        retrofit2.Call<List<SysDao>> call = HttpManager.getInstance().getService().get_sys(id);
        call.enqueue(new Callback<List<SysDao>>() {
            @Override
            public void onResponse(retrofit2.Call<List<SysDao>> call, Response<List<SysDao>> response) {
                if (response.isSuccessful()){
                    Log.d("sendschname", "onResponse: "+response.body().size());
                    List<SysDao> res = response.body();
                    systemDaos = res;
                    if (systemDaos.size() > 0){
                        SysSiteAdapter adapter = new SysSiteAdapter(getActivity(),systemDaos);
                        spinner_sys.setAdapter(adapter);
                        if (param != null) {
                            if (param.size() > 0) {
                                int ps = 0;
                                for (SysDao rs : systemDaos) {
                                    if (rs.getSysId().equals(param.get(1))) {
                                        spinner_sys.setSelection(ps);
                                        break;
                                    }
                                    ps++;
                                }
                            }
                        }
                        spinner_sys.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                sysid = systemDaos.get(i).getSysId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<SysDao>> call, Throwable t) {
                Log.d("onFailure System", "else " + t);
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
