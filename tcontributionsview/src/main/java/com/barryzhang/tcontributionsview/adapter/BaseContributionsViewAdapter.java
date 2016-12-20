package com.barryzhang.tcontributionsview.adapter;

import com.barryzhang.tcontributionsview.TContributionsView;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/19
 */

public abstract class BaseContributionsViewAdapter {

    TContributionsView.OnDrawItemListener mOnDrawItemListener;
    TContributionsView.OnItemClickListener mOnItemClickListener;

    private TContributionsView mContributionsView;

    public BaseContributionsViewAdapter() {
    }

    public void onReceiveItemClick(int row, int col, int level){
        if(mOnItemClickListener != null){
            mOnItemClickListener.onItemClick( row,col,level);
        }
    }

    public abstract int getRowCount();

    public abstract int getColumnCount();

    public abstract int getLevel(int row, int column);

    public void notifyDataSetChanged() {
        mContributionsView.invalidate();
    }

    public void setContributionsView(TContributionsView mContributionsView) {
        this.mContributionsView = mContributionsView;
    }

    public void setOnDrawItemListener(TContributionsView.OnDrawItemListener onDrawItemListener) {
        this.mOnDrawItemListener = onDrawItemListener;
    }

    public void setOnItemClickListenerListener(TContributionsView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public TContributionsView.OnDrawItemListener getOnDrawItemListener() {
        return mOnDrawItemListener;
    }
    public TContributionsView.OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }
}
