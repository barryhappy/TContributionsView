package com.barryzhang.tcontributionsview.adapter;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * https://github.com/barryhappy
 * Created by Barry on 2016/11/20
 */

public class DateContributionsAdapter extends BaseContributionsViewAdapter {


    private static final long TIME_OF_DAY = 24 * 60 * 60 * 1000L;

    private int mWeekCount = 15;
    private Calendar mEndDay = Calendar.getInstance(getLocale());
    private Map<String, Integer> map = new HashMap<>();

    public DateContributionsAdapter() {
        super();
    }

    @Override
    public final int getRowCount() {
        return 7;
    }

    @Override
    public final int getColumnCount() {
        return getWeekCount();
    }

    @Override
    public int getLevel(int row, int column) {
        Calendar calendar = computeDay(row, column);
        if (calendar.getTimeInMillis() > mEndDay.getTimeInMillis() &&
                calendar.get(Calendar.DAY_OF_YEAR) != mEndDay.get(Calendar.DAY_OF_YEAR)) {
            // This day is after endDay;
            return -1;
        }
        String dateKey = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        Log.d("dateKey", dateKey);
        if (map.containsKey(dateKey)) {
            return map.get(dateKey);
        }
        return 0;
    }

    public void clear() {
        this.map.clear();
    }

    public void put(String date, int level) {
        map.put(mapDate(date), level);
    }

    protected String mapDate(String date) {
        return date;
    }

    protected Locale getLocale() {
        return Locale.getDefault();
    }

    private Calendar computeDay(int row, int column) {
        Calendar startDay = computeStartDay();
        startDay.set(Calendar.DAY_OF_YEAR, startDay.get(Calendar.DAY_OF_YEAR) + column * 7 + row);
        return startDay;
    }

    private Calendar computeStartDay() {
        Calendar startDay = Calendar.getInstance(getLocale());
        startDay.setTime(mEndDay.getTime());
        int dayToNextSunDay = 0;
        switch (startDay.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                dayToNextSunDay = 7;
                break;
            case Calendar.MONDAY:
                dayToNextSunDay = 6;
                break;
            case Calendar.TUESDAY:
                dayToNextSunDay = 5;
                break;
            case Calendar.WEDNESDAY:
                dayToNextSunDay = 4;
                break;
            case Calendar.THURSDAY:
                dayToNextSunDay = 3;
                break;
            case Calendar.FRIDAY:
                dayToNextSunDay = 2;
                break;
            case Calendar.SATURDAY:
                dayToNextSunDay = 1;
                break;
        }
        startDay.setTimeInMillis(getEndDay().getTimeInMillis() - (getWeekCount() * 7 - dayToNextSunDay) * TIME_OF_DAY);
        return startDay;
    }

    public int getWeekCount() {
        return mWeekCount;
    }

    public void setWeekCount(int mWeekCount) {
        this.mWeekCount = mWeekCount;
    }

    public Calendar getEndDay() {
        return mEndDay;
    }

    public void setEndDay(Calendar mEndDay) {
        this.mEndDay = mEndDay;
    }

    public boolean setEndDay(String mEndDayString) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            this.mEndDay.setTime(df.parse(mEndDayString));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
