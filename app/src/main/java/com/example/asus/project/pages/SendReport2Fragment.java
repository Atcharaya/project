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
import com.example.asus.project.adapter.CaAdapter;
import com.example.asus.project.adapter.ConAdapter;
import com.example.asus.project.adapter.LvAdapter;
import com.example.asus.project.model.CatagoryDao;
import com.example.asus.project.model.ContactDao;
import com.example.asus.project.model.LevelDao;
import com.example.asus.project.service.HttpManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SendReport2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SendReport2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SendReport2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private ArrayList<String> param;

    private OnFragmentInteractionListener mListener;
    private List<CatagoryDao> catagoryDaos;
    private List<LevelDao> levelDaos;
    private List<ContactDao> contactDaos;
    EditText problem1;
    String type, lv, ctt;

    Button prevButton, nextButton;

    Spinner spinner_lv, spinner_kn, spinner_ctt, spinner_type;

    public SendReport2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SendReport2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SendReport2Fragment newInstance(ArrayList<String> param1) {
        SendReport2Fragment fragment = new SendReport2Fragment();
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
        View view = inflater.inflate(R.layout.fragment_send_report2, container, false);
        Log.d("data", "onCreateView: " + param.size());
        nextButton = view.findViewById(R.id.next_button);
        spinner_type = view.findViewById(R.id.Sch_Type);
        spinner_lv = view.findViewById(R.id.Sch_Priority);
        spinner_ctt = view.findViewById(R.id.Sch_Contact);
        problem1 = view.findViewById(R.id.problem1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = new ArrayList<String>();
                if (param != null) {
                    data = param;
                    if (param.size() == 4) {
                        data.add(4, problem1.getText().toString());
                        data.add(5, type);
                        data.add(6, lv);
                        data.add(7, ctt);
                    }
                }
                data.set(4, problem1.getText().toString());
                data.set(5, type);
                data.set(6, lv);
                data.set(7, ctt);
                Fragment fragment = new SendReport3Fragment().newInstance(data);
                ((MainActivity) getActivity()).changePage(fragment);
            }
        });
        prevButton = view.findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = new ArrayList<String>();
                if (param != null) {
                    data = param;
                    if (param.size() == 4){
                        data.add(4, problem1.getText().toString());
                        data.add(5, type);
                        data.add(6, lv);
                        data.add(7, ctt);
                    }
                }
                data.set(4, problem1.getText().toString());
                data.set(5, type);
                data.set(6, lv);
                data.set(7, ctt);
                Fragment fragment = new SendReportFragment().newInstance(data);
                ((MainActivity) getActivity()).changePage(fragment);
            }
        });
        if (param != null) {
            if (param.size() > 4)
                problem1.setText(param.get(4));
            for (String s : param) {
                Log.d("data", "onCreateView: " + s);
            }
        }
        getSchType();
        getLavel();
        getContact();

        return view;
    }

    private void getSchType() {
        Call<List<CatagoryDao>> call = HttpManager.getInstance().getService().get_ct_kn();
        call.enqueue(new Callback<List<CatagoryDao>>() {
            @Override
            public void onResponse(Call<List<CatagoryDao>> call, Response<List<CatagoryDao>> response) {
                if (response.isSuccessful()) {
                    List<CatagoryDao> res = response.body();
                    catagoryDaos = res;
                    if (catagoryDaos.size() > 0) {
                        CaAdapter adapter = new CaAdapter(getActivity(), catagoryDaos);
                        spinner_type.setAdapter(adapter);
                        if (param != null) {
                            if (param.size() > 4) {
                                int ps = 0;
                                for (CatagoryDao rs : catagoryDaos) {
                                    if (rs.getCtId().equals(param.get(5))) {
                                        spinner_type.setSelection(ps);
                                        break;
                                    }
                                    ps++;
                                }
                            }
                        }
                        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                type = catagoryDaos.get(i).getCtId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    } else {
                        try {
                            Log.d("TeamName", "else :: => " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CatagoryDao>> call, Throwable t) {
                Log.d("onFailure_type", "else " + t);
            }
        });
    }

    private void getLavel() {
        Call<List<LevelDao>> call = HttpManager.getInstance().getService().get_lv();
        call.enqueue(new Callback<List<LevelDao>>() {
            @Override
            public void onResponse(Call<List<LevelDao>> call, Response<List<LevelDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("Sch_Priority", "if :: => " + response.message());
                    List<LevelDao> res = response.body();
                    levelDaos = res;
                    if (levelDaos.size() > 0) {
                        LvAdapter adapter = new LvAdapter(getActivity(), levelDaos);
                        spinner_lv.setAdapter(adapter);
                        if (param != null) {
                            if (param.size() > 4) {
                                int ps = 0;
                                for (LevelDao rs : levelDaos) {
                                    if (rs.getLvId().equals(param.get(6))) {
                                        spinner_lv.setSelection(ps);
                                        break;
                                    }
                                    ps++;
                                }
                            }
                        }
                        spinner_lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                lv = levelDaos.get(i).getLvId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    } else {
                        try {
                            Log.d("Lv", "else :: => " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<LevelDao>> call, Throwable t) {
                Log.d("onFailure_lv", "else " + t);
            }
        });
    }

    private void getContact() {
        Call<List<ContactDao>> call = HttpManager.getInstance().getService().get_ctt();
        call.enqueue(new Callback<List<ContactDao>>() {
            @Override
            public void onResponse(Call<List<ContactDao>> call, Response<List<ContactDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("Sch_Type", "if :: => " + response.message());
                    List<ContactDao> res = response.body();
                    contactDaos = res;
                    if (contactDaos.size() > 0) {
                        ConAdapter adapter = new ConAdapter(getActivity(), contactDaos);
                        spinner_ctt.setAdapter(adapter);
                        if (param != null) {
                            if (param.size() > 4) {
                                int ps = 0;
                                for (ContactDao rs : contactDaos) {
                                    if (rs.getCttId().equals(param.get(7))) {
                                        spinner_ctt.setSelection(ps);
                                        break;
                                    }
                                    ps++;
                                }
                            }
                        }
                        spinner_ctt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                ctt = contactDaos.get(i).getCttId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
                } else {
                    try {
                        Log.d("Contact", "else :: => " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ContactDao>> call, Throwable t) {
                Log.d("onFailure_contact", "else " + t);
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
