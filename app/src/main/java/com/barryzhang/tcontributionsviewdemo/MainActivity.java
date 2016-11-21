package com.barryzhang.tcontributionsviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

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
        useDateContributionsAdapter(contributionsView3);


    }


    private void useDateContributionsAdapter(TContributionsView contributionsView) {
        DateContributionsAdapter adapter = new DateContributionsAdapter(contributionsView){
            @Override
            protected String map(String date) {
                if(date.contains("T")){
                    return date.split("T")[0];
                }
                return date;
            }
        };
        adapter.setWeekCount(10);
        adapter.setEndDay("2016-11-20");
        adapter.put("2016-10-20", 4);
        adapter.put("2016-10-21T00:00:00", 3);
        adapter.put("2016-10-22", 3);
        adapter.put("2016-10-27", 1);
        adapter.put("2016-10-28", 1);
        adapter.put("2016-10-20", 1);
        adapter.put("2016-11-19", 2);
        adapter.put("2016-11-18", 4);
        contributionsView.setAdapter(adapter);
    }


    private void useTestAdapter(TContributionsView contributionsView) {
        TestContributionAdapter adapter = new TestContributionAdapter(contributionsView);
        contributionsView.setAdapter(adapter);
    }


    private void usePositionAdapter(TContributionsView contributionsView) {
        PositionContributionsViewAdapter adapter =
                new PositionContributionsViewAdapter(contributionsView, 8, 17);
        adapter.put(0, 4, 1);
        adapter.put(1, 4, 2);
        adapter.put(1, 5, 3);
        adapter.put(2, 5, 4);

        adapter.put(0, 10, 1);
        adapter.put(1, 10, 2);
        adapter.put(1, 9, 3);
        adapter.put(2, 9, 4);

        adapter.put(4, 7, 2);

        adapter.put(4, 3, 1);
        adapter.put(5, 4, 2);
        adapter.put(6, 5, 3);
        adapter.put(6, 6, 4);
        adapter.put(6, 7, 4);
        adapter.put(6, 8, 4);
        adapter.put(6, 9, 3);
        adapter.put(5, 10, 2);
        adapter.put(4, 11, 1);
        contributionsView.setAdapter(adapter);
    }
}
