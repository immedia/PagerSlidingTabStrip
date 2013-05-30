package com.astuetz.viewpager.extensions;

import android.database.DataSetObserver;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: James Smith <james@immedia.co.za>
 * Date: 2013/05/29
 * Time: 1:01 PM
 */
public abstract class IndicatorAdapter {
    private ArrayList<DataSetObserver> mDataSetObservers = new ArrayList<DataSetObserver>();
    private int mCurrent = 0;

    public abstract int getCount();

    public abstract String getTitle(int position);

    public int getCurrent() {
        return mCurrent;
    }

    public void setCurrent(int current) {
        if (mCurrent != current) {
            mCurrent = current;
            notifyDataSetChanged();
        }
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservers.add(observer);
    }

    public void notifyDataSetChanged() {
        for (DataSetObserver observer : mDataSetObservers) {
            observer.onChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        for (DataSetObserver observer : mDataSetObservers) {
            observer.onInvalidated();
        }
    }
}
