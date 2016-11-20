package com.barryzhang.tcontributionsviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.barryzhang.tcontributionsview.TContributionsView;
import com.barryzhang.tcontributionsview.adapter.DateContributionsAdapter;
import com.barryzhang.tcontributionsview.adapter.PositionContributionsViewAdapter;
import com.barryzhang.tcontributionsview.adapter.TestContributionAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TContributionsView contributionsView = (TContributionsView) findViewById(R.id.contributionsView);
        TContributionsView contributionsView2 = (TContributionsView) findViewById(R.id.contributionsView2);
        TContributionsView contributionsView3 = (TContributionsView) findViewById(R.id.contributionsView3);


        useTestAdapter(contributionsView);
        usePositionAdapter(contributionsView2);
        useDateContributionsAdapter(contributionsView);


    }


    private void useDateContributionsAdapter(TContributionsView contributionsView) {
        DateContributionsAdapter adapter = new DateContributionsAdapter(contributionsView);
        adapter.setWeekCount(10);
        adapter.setEndDay("2016-11-20");
        adapter.put("2016-10-20", 4);
        adapter.put("2016-10-21", 3);
        adapter.put("2016-10-22", 3);
        adapter.put("2016-10-27", 1);
        adapter.put("2016-10-20", 1);
        adapter.put("2016-11-19", 2);
        adapter.put("2016-11-18", 4);
        contributionsView.setAdapter(adapter);
    }


    private void useTestAdapter(TContributionsView contributionsView) {
        contributionsView.setAdapter(new TestContributionAdapter(contributionsView));
    }


    private void usePositionAdapter(TContributionsView contributionsView) {
        PositionContributionsViewAdapter adapter = new PositionContributionsViewAdapter(contributionsView, 13, 7);
        adapter.put(0, 0, 1);
        adapter.put(1, 1, 1);
        adapter.put(2, 2, 2);
        adapter.put(3, 3, 2);
        adapter.put(4, 4, 3);
        adapter.put(5, 5, 3);
        adapter.put(6, 6, 4);
        adapter.put(7, 5, 3);
        adapter.put(8, 4, 3);
        adapter.put(9, 3, 2);
        adapter.put(10, 2, 2);
        adapter.put(11, 1, 1);
        adapter.put(12, 0, 1);

        contributionsView.setAdapter(adapter);
    }
}
