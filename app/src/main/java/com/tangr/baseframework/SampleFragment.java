package com.tangr.baseframework;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends LazyFragment {
    private TextView tv;
    private int page = -1;
    private int param = -1;

    public static Fragment newInstance(int position) {
        SampleFragment fragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        page = getArguments().getInt("page");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tv = new TextView(getContext());
        tv.setText("page:" + page);
        return tv;
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("param", param);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        if (savedInstanceState != null) {
//            param = savedInstanceState.getInt("param");
//        }
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    @Override
    public String toString() {
        return "-------page : " + page;
    }

    @Override
    protected void setData() {
        tv.append("load data:" + param);
    }

    @Override
    protected void loadData() {
        if(param==-1)
            param = new Random().nextInt(10);
    }
}
