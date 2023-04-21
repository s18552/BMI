package com.example.bmi;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;

public class Graph extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 22.3),
                new DataPoint(1, 23),
                new DataPoint(2, 22),
                new DataPoint(3, 21.5),

        });
        graph.addSeries(series);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"01-01-2020", "01-01-2023", "01-03-2023"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        series.setColor(Color.rgb(0, 80, 100));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(5);
        series.setThickness(5);
        graph.addSeries(series);
        graph.setTitle("BMI");
        graph.setTitleTextSize(50);
        graph.setTitleColor(Color.BLACK);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("czas");
        gridLabel.setVerticalAxisTitle("BMI");

    }

}
