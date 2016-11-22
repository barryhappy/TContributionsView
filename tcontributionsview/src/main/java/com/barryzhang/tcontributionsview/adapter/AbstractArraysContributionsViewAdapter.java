package com.barryzhang.tcontributionsview.adapter;

import com.barryzhang.tcontributionsview.TContributionsView;

import java.util.Objects;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/22
 */

public abstract class AbstractArraysContributionsViewAdapter<T> extends BaseContributionsViewAdapter {

    private T[][] mArrays;
    private int row = 0;
    private int column = 0;

    public AbstractArraysContributionsViewAdapter() {
        super();
    }

    public AbstractArraysContributionsViewAdapter(T[][] mArrays) {
        super();
        this.mArrays = mArrays;
    }

    @Override
    public final int getRowCount() {
        if (row <= 0 && mArrays != null) {
            computeRow();
        }
        return row;
    }

    @Override
    public final int getColumnCount() {
        if (column <= 0 && mArrays != null) {
            computeColumn();
        }
        return column;
    }

    @Override
    public int getLevel(int row, int column) {
        try {
            return mapLevel(mArrays[row][column]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    protected abstract int mapLevel(T from);


    private void computeRow() {
        row = mArrays == null ? 0 : mArrays.length;
    }

    private void computeColumn() {
        if (mArrays != null) {
            for (T[] sub : mArrays) {
                if (sub != null && column < sub.length) {
                    column = sub.length;
                }
            }
        } else {
            column = 0;
        }
    }

    public T[][] getArrays() {
        return mArrays;
    }

    public void setArrays(T[][] mArrays) {
        this.mArrays = mArrays;
        computeRow();
        computeColumn();
    }
}
