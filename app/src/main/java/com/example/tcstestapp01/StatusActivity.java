package com.example.tcstestapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {

    private BarChart mBarChart;
    private PieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        mBarChart = findViewById(R.id.barchart);
        mPieChart = findViewById(R.id.piechart);

        final ArrayList<BarEntry> defaultValues = new ArrayList<>();
        defaultValues.add(new BarEntry(-1, 50f));
        defaultValues.add(new BarEntry(0, 25f));
        defaultValues.add(new BarEntry(1, 35f));
        defaultValues.add(new BarEntry(2,45f));
        drawBarChart(defaultValues, mBarChart);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(45f, "A"));
        yValues.add(new PieEntry(35f, "B"));
        yValues.add(new PieEntry(50f, "C"));
        yValues.add(new PieEntry(15f, "D"));
        yValues.add(new PieEntry(65f, "E"));
        drawPieChart(yValues, mPieChart);

    }

    //Method to be used to draw all BarCharts
    public void drawBarChart(ArrayList<BarEntry> yValues, BarChart barChart) {

        BarDataSet bardataset = new BarDataSet(yValues, "% of work");

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);//getResources().getColor(R.color.colorPrimary),
                //getResources().getColor(R.color.statusActivity_barColor_grey));
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(bardataset);

        BarData data = new BarData(dataSets);

        // if more than 0 entries are displayed in the chart, no values will be
        // drawn
//        barChart.setMaxVisibleValueCount(0);
        barChart.setDrawValueAboveBar(true);
        data.setValueTextSize(0.5f);
        data.setBarWidth(0.8f);

        barChart.setTouchEnabled(false);

        barChart.getAxisLeft().setDrawGridLines(true);
        barChart.getXAxis().setDrawGridLines(true);
        barChart.getAxisRight().setDrawGridLines(false);
//        barChart.setDrawBorders(false);
//        barChart.setDrawGridBackground(false);
        barChart.getLegend().setEnabled(false);
//        Legend legend = barChart.getLegend();
//        legend.setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setEnabled(true);

        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setEnabled(true);

        YAxis yAxis2 = barChart.getAxisRight();
        yAxis2.setEnabled(false);

        barChart.setData(data); // set the data and list of lables into chart

        barChart.getDescription().setEnabled(false);  // disable the description

        barChart.getAxisLeft().setDrawLabels(true);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getXAxis().setDrawLabels(true);

        barChart.animateY(5000);
    }

    public void drawPieChart(ArrayList<PieEntry> yValues, PieChart pieChart){
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);//to set the speed of the rotation

        pieChart.setDrawHoleEnabled(true);//if true, there will be hole or void at the center of the
        //piechart
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        PieDataSet dataSet = new PieDataSet(yValues, "Sections");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(getResources().getColor(R.color.colorPrimary));

        pieChart.setData(data );
        pieChart.animateXY(3000, 3000);
    }
}
