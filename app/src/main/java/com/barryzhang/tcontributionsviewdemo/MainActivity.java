package com.barryzhang.tcontributionsviewdemo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.barryzhang.tcontributionsview.TContributionsView;
import com.barryzhang.tcontributionsview.adapter.AbstractArraysContributionsViewAdapter;
import com.barryzhang.tcontributionsview.adapter.DateContributionsAdapter;
import com.barryzhang.tcontributionsview.adapter.IntArraysContributionsViewAdapter;
import com.barryzhang.tcontributionsview.adapter.PositionContributionsViewAdapter;
import com.barryzhang.tcontributionsview.adapter.TestContributionAdapter;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TContributionsView contributionsView = (TContributionsView) findViewById(R.id.contributionsView);
        TContributionsView contributionsView1s = (TContributionsView) findViewById(R.id.contributionsView1s);
        TContributionsView contributionsView2 = (TContributionsView) findViewById(R.id.contributionsView2);
        TContributionsView contributionsView3 = (TContributionsView) findViewById(R.id.contributionsView3);
        TContributionsView contributionsView4 = (TContributionsView) findViewById(R.id.contributionsView4);
        TContributionsView contributionsView5 = (TContributionsView) findViewById(R.id.contributionsView5);
        TContributionsView contributionsView6 = (TContributionsView) findViewById(R.id.contributionsView6);
        TContributionsView contributionsView7 = (TContributionsView) findViewById(R.id.contributionsView7);
        TContributionsView contributionsView8 = (TContributionsView) findViewById(R.id.contributionsView8);
        TContributionsView contributionsView9 = (TContributionsView) findViewById(R.id.contributionsView9);


        useTestAdapter(contributionsView);
        useTestAdapter(contributionsView1s);
        usePositionAdapter(contributionsView2);
        useDateContributionsAdapter(contributionsView3);
        useIntegerArraysContributionsAdapter(contributionsView4);
        useMyArraysContributionsAdapter(contributionsView5);
    }

    private void useIntegerArraysContributionsAdapter(TContributionsView contributionsView) {
        IntArraysContributionsViewAdapter adapter = new IntArraysContributionsViewAdapter();
        Integer arrays[][] = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 3, 1, 0, 0},
                {0, 1, 2, 4, 2, 1, 0},
                {0, 0, 1, 3, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
        };
        adapter.setArrays(arrays);
        contributionsView.setAdapter(adapter);
    }

    private void useMyArraysContributionsAdapter(TContributionsView contributionsView) {
        AbstractArraysContributionsViewAdapter<String> adapter = new AbstractArraysContributionsViewAdapter<String>() {

            @Override
            protected int mapLevel(String from) {
                if (TextUtils.isEmpty(from)) {
                    return 0;
                }
                switch (from) {
                    case "A":
                        return 0;
                    case "B":
                        return 2;
                    case "S":
                        return 4;
                    default:
                        return 0;
                }
            }
        };
        String arrays[][] = {
                {"A", "A", "B", "A", "A",},
                {"A", "A", "S", "A", "A",},
                {"B", "B", "S", "B", "B",},
                {"A", "A", "S", "A", "A",},
                {"A", "A", "B", "A", "A",},
        };
        adapter.setArrays(arrays);
        contributionsView.setAdapter(adapter);
    }


    private void useDateContributionsAdapter(TContributionsView contributionsView) {
        DateContributionsAdapter adapter = new DateContributionsAdapter() {
            @Override
            protected String mapDate(String date) {
                if (date.contains("T")) {
                    return date.split("T")[0];
                }
                return date;
            }
        };
        adapter.setWeekCount(10);
        adapter.setEndDay("2016-11-20");
        adapter.put("2016-10-17", 1);
        adapter.put("2016-10-18", 2);
        adapter.put("2016-10-19", 3);
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
        TestContributionAdapter adapter = new TestContributionAdapter();
        contributionsView.setAdapter(adapter);
    }


    private void usePositionAdapter(TContributionsView contributionsView) {
        PositionContributionsViewAdapter adapter =
                new PositionContributionsViewAdapter(8, 17);
        adapter.put(0, 4, 4);
        adapter.put(1, 4, 4);
        adapter.put(1, 5, 4);
        adapter.put(2, 5, 4);

        adapter.put(0, 10, 4);
        adapter.put(1, 10, 4);
        adapter.put(1, 9, 4);
        adapter.put(2, 9, 4);

        adapter.put(4, 7, 4);

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
