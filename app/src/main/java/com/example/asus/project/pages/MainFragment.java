package com.example.asus.project.pages;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.project.R;
import com.example.asus.project.model.HomeDao;
import com.example.asus.project.service.HttpManager;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    PieChart pieChart;
    TextView txt2, per2, txt4, per4, txt6, per6, txt8, per8;

    public MainFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        pieChart = view.findViewById(R.id.piechart);
        txt2 = view.findViewById(R.id.txt2);
        per2 = view.findViewById(R.id.per2);
        txt4 = view.findViewById(R.id.txt4);
        per4 = view.findViewById(R.id.per4);
        txt6 = view.findViewById(R.id.txt6);
        per6 = view.findViewById(R.id.per6);
        txt8 = view.findViewById(R.id.txt8);
        per8 = view.findViewById(R.id.per8);

        Call<HomeDao> call = HttpManager.getInstance().getService().getHome();
        call.enqueue(new Callback<HomeDao>() {
            @Override
            public void onResponse(Call<HomeDao> call, Response<HomeDao> response) {
                if (response.isSuccessful()) {
                    HomeDao home = response.body();
                    setData(home);
                } else {

                }
            }

            @Override
            public void onFailure(Call<HomeDao> call, Throwable t) {

            }
        });
        return view;
    }

    private void setData(HomeDao res) {
        // set graph
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(31f);

        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(res.getDone(), "DONE"));
        yValues.add(new PieEntry(res.getDelay(), "DELAYED"));

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yValues, "Overview");
        dataSet.setSliceSpace(1f);
        dataSet.setSelectionShift(2f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);


        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
        Log.d("data", "setData: " + res.getPercent());
        //set data
        txt2.setText(res.getCount_num().get(0)); //num
        per2.setText(res.getPercent().get(0)); //percent
        txt4.setText(res.getCount_num().get(1));
        per4.setText(res.getPercent().get(1).toString());
        txt6.setText(res.getCount_num().get(2));
        per6.setText(res.getPercent().get(2).toString());
        txt8.setText(res.getCount_num().get(3));
        per8.setText(res.getPercent().get(3).toString());
    }


}
