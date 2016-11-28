package com.barryzhang.tcontributionsview.adapter;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/22
 */

public class IntArraysContributionsViewAdapter extends AbstractArraysContributionsViewAdapter<Integer> {
    public IntArraysContributionsViewAdapter() {
        super();
    }

    public IntArraysContributionsViewAdapter(Integer[][] mArrays) {
        super(mArrays);
    }

    @Override
    protected int mapLevel(Integer from) {
        return from;
    }
}
