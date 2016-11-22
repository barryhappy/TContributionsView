package com.barryzhang.tcontributionsview.adapter;

import com.barryzhang.tcontributionsview.TContributionsView;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/19
 */

public class TestContributionAdapter extends BaseContributionsViewAdapter {

    public TestContributionAdapter() {
        super();
    }

    @Override
    public int getRowCount() {
        return 7;
    }

    @Override
    public int getColumnCount() {
        return 30;
    }

    @Override
    public int getLevel(int row, int column) {
        return (int)(Math.random()*100) % 10 ;
    }
}
