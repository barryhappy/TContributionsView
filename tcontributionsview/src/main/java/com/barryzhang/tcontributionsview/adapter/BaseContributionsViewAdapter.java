package com.barryzhang.tcontributionsview.adapter;

import com.barryzhang.tcontributionsview.TContributionsView;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/19
 */

public abstract class BaseContributionsViewAdapter {

    TContributionsView mContributionsView;

    public BaseContributionsViewAdapter(TContributionsView mContributionsView) {
        this.mContributionsView = mContributionsView;
    }

    public abstract int getRowCount();

    public abstract int getColumnCount();

    public abstract int getLevel(int row, int column);

    public void notifyDataSetChanged(){
        mContributionsView.invalidate();
    }
}
