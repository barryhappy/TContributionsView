package com.barryzhang.tcontributionsview.adapter;

import android.graphics.Point;
import android.util.SparseIntArray;

import com.barryzhang.tcontributionsview.TContributionsView;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/20
 */

public class PositionContributionsViewAdapter extends BaseContributionsViewAdapter {

    private SparseIntArray list = new SparseIntArray();

    private int row;
    private int column;

    public PositionContributionsViewAdapter(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    @Override
    public final int getRowCount() {
        return this.row;
    }

    @Override
    public final int getColumnCount() {
        return this.column;
    }

    @Override
    public final int getLevel(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalStateException("row or column must be >= 0 ！");
        }
        if ((row & 0xffff0000) != 0 || (column & 0xffff0000) != 0) {
            throw new IllegalStateException("row or column must be <= 0xffff ！");
        }
        return list.get((row << 16) + column, 0);
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public void put(Point point, int level) {
        put(point.x, point.y, level);
    }

    public void put(int x, int y, int level) {
        if (x < 0 || y < 0) {
            throw new IllegalStateException("row or column must be >= 0 ！");
        }
        if ((x & 0xffff0000) != 0 || (y & 0xffff0000) != 0) {
            throw new IllegalStateException("row or column must be <= 0xffff ！");
        }
        list.put((x << 16) + y, level);
    }
}
